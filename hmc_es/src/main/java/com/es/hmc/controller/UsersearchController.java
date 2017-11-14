package com.es.hmc.controller;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.elasticsearch.common.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.hmc.base.BaseController;
import com.es.hmc.constant.factory.PageFactory;
import com.es.hmc.core.annotion.Permission;
import com.es.hmc.domain.KbEsUseraskinfo;
import com.es.hmc.repository.KbEsUseraskinfoRepository;
import com.es.hmc.utils.ExcelUtil;

@Controller
@PropertySource("application.properties")
@RequestMapping("/usersearch")
public class UsersearchController extends BaseController {
	private static final Logger logger= LoggerFactory.getLogger("LOGGER.PARTICIPLE");
	
	@Value("${spring.data.elasticsearch.cluster-nodes}")
	private String clusternode;
	   
	private static final String INDEX_NAME = "useraskinfo";
	private static final String TYPE_NAME = "useraskinfo-type";
	//windows 本地
	//private static final String file_path_els = "e:\\askinfo.xls";
	//linux 路径
	public static final String file_path_els = "/data/app/els-file-static/askinfo.xls";
	public static final String file_xls = "askinfo.xls";
	
	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;
	 
	@Autowired
	KbEsUseraskinfoRepository kbEsUseraskinfoRepository;
	 
    private static String PREFIX = "/system/usersearch";

    /**
     * 跳转到角色列表页面
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/askinfo.html";
    }

    /**
     * 获取角色列表
     */
    @Permission
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String info) {
        // List<Role> roles = this.roleService.findAll("name",roleName);
       // List<Role> roles = this.roleDao.findByNameLike(super.getPara("roleName"));
       // return super.warpObject(new RoleWarpper(roles,Role.class));
    	Pageable pageable = new PageFactory().simplePage();
    	SearchQuery searchQuery = null;
    	if (Strings.isNullOrEmpty(info)) {
    		searchQuery = new NativeSearchQueryBuilder().withIndices(INDEX_NAME)
    				.withTypes(TYPE_NAME).withQuery(matchAllQuery()).build();
    	} else {
    		searchQuery = new NativeSearchQueryBuilder().withIndices(INDEX_NAME)
    				.withTypes(TYPE_NAME).withQuery(matchQuery("askerInfo", info)).build();
    	}
    	searchQuery.setPageable(pageable);
		// when
		Page<KbEsUseraskinfo> useraskinfos = elasticsearchTemplate.queryForPage(searchQuery, KbEsUseraskinfo.class);
    	//List<KbEsUseraskinfo> useraskinfos = elasticsearchTemplate.queryForList(searchQuery, KbEsUseraskinfo.class);
    	return super.packForBT(useraskinfos);
    }

    /**
     * 查看角色
     * @throws FileNotFoundException 
     */
    @RequestMapping(value = "/createXls")
    @ResponseBody
    public Object view(@RequestParam(required = false) String info) throws FileNotFoundException {
    	String downloadurl ="http://" + clusternode.substring(0,clusternode.indexOf(":"))+"/"+file_xls;
		System.out.println(downloadurl);
		
    	Long cnt = kbEsUseraskinfoRepository.count();
    	int limit = Integer.parseInt(String.valueOf(cnt));
        int offset = 0;
        int page = (Integer.parseInt(String.valueOf(cnt))/ limit ) ;
        
        Pageable   pageable = null;
        File file = new File(file_path_els);
        if (file.exists()) {
        	file.delete();
        }
        FileOutputStream out = null;
        FileInputStream input = null;
        String[] headers = new String[]{"id","userPhone","askerInfo","searchTime","guid"};
        ExcelUtil<KbEsUseraskinfo> excelUtil = new ExcelUtil<KbEsUseraskinfo>();
        out = new FileOutputStream(file_path_els);
        SearchQuery searchQuery = null;
        
		pageable = new PageRequest(offset, limit);
		searchQuery =new NativeSearchQueryBuilder().withIndices(INDEX_NAME)
			.withTypes(TYPE_NAME).withQuery(matchAllQuery()).build();
		searchQuery.setPageable(pageable);
		List<KbEsUseraskinfo> useraskinfos = elasticsearchTemplate.queryForList(searchQuery, KbEsUseraskinfo.class);
		excelUtil.exportExcel(headers,useraskinfos, out);
		/*  分页读取追加
		 input = new FileInputStream(file);
    	
    	for (offset=1;offset <= page;offset++) {
    		out = new FileOutputStream(file_path_els);
    		pageable = new PageRequest(offset, limit);
    		searchQuery =new NativeSearchQueryBuilder().withIndices(INDEX_NAME)
				.withTypes(TYPE_NAME).withQuery(matchAllQuery()).build();
    		searchQuery.setPageable(pageable);
    		List<KbEsUseraskinfo> useraskinfos2 = elasticsearchTemplate.queryForList(searchQuery, KbEsUseraskinfo.class);
    		excelUtil.exportExcel(headers,useraskinfos2, out,input,offset*limit);
    	}*/
		//System.out.println(clusternode);
		super.SUCCESS_TIP.setContent(downloadurl);
		return super.SUCCESS_TIP;
    }

}