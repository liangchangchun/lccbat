package com.lcc.lccshot.service.impl;

import static com.lcc.lccshot.core.constant.factory.MutiStrFactory.MUTI_STR_KEY;
import static com.lcc.lccshot.core.constant.factory.MutiStrFactory.MUTI_STR_VALUE;
import static com.lcc.lccshot.core.constant.factory.MutiStrFactory.parseKeyValue;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.lcc.lccshot.core.map2sql.BaseServiceTemplate;
import com.lcc.lccshot.core.map2sql.Conditions;
import com.lcc.lccshot.core.map2sql.Where;
import com.lcc.lccshot.domain.Dict;
import com.lcc.lccshot.domain.view.MenuView;
import com.lcc.lccshot.domain.vo.MenuNode;
import com.lcc.lccshot.domain.vo.ZTreeNode;
import com.lcc.lccshot.exception.BizExceptionEnum;
import com.lcc.lccshot.exception.BussinessException;
import com.lcc.lccshot.repository.DictRepository;
import com.lcc.lccshot.service.IDictService;

@Service
@Transactional
public class DictServiceImpl extends BaseServiceTemplate<DictRepository,Dict> implements IDictService {

    //@Resource
   // DictRepository dictDao;

    @Override
    public void addDict(String dictName, String dictValues) {
        //判断有没有该字典
       // List<Dict> dicts = dictMapper.selectList(new EntityWrapper<Dict>().eq("name", dictName).and().eq("pid", 0));
    	List<Dict> dicts = repository.findByNameAndPid(dictName,0);
        if(dicts != null && dicts.size() > 0){
            throw new BussinessException(BizExceptionEnum.DICT_EXISTED);
        }

        //解析dictValues
        List<Map<String, String>> items = parseKeyValue(dictValues);

        //添加字典
        Dict dict = new Dict();
        dict.setName(dictName);
        dict.setNum(0);
        dict.setPid(0);
        this.repository.saveAndFlush(dict);

        //添加字典条目
        for (Map<String, String> item : items) {
            String num = item.get(MUTI_STR_KEY);
            String name = item.get(MUTI_STR_VALUE);
            Dict itemDict = new Dict();
            itemDict.setPid(dict.getId());
            itemDict.setName(name);
            itemDict.setNum(Integer.valueOf(num));
            this.repository.saveAndFlush(itemDict);
        }
    }

    @Override
    public void editDict(Integer dictId, String dictName, String dicts) {
        //删除之前的字典
        this.delteDict(dictId);

        //重新添加新的字典
        this.addDict(dictName,dicts);
    }

    @Override
    public void delteDict(Integer dictId) {
        //删除这个字典的子词典
      //  Wrapper<Dict> dictEntityWrapper = new EntityWrapper<>();
       // dictEntityWrapper = dictEntityWrapper.eq("pid", dictId);
      //  dictMapper.delete(dictEntityWrapper);

        //删除这个词典
    	repository.deleteByPId(dictId);
    }

	@Override
	public List<Dict> list(String condition) {
		Where where = Where.create()
				.add(Conditions.create().eq("pid", "0"))
				.add(Conditions.create().and().like("name", condition));
				this.initWhere(where);
				return this.findAll();
	}
 
}
