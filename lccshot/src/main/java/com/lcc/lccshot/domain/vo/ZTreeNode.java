package com.lcc.lccshot.domain.vo;

import java.io.Serializable;

import com.lcc.lccshot.domain.view.ZTreeView;

/**
 * 
 * jquery ztree 插件的节点
 * 
 * @author fengshuonan
 * @date 2017年2月17日 下午8:25:14
 */
public class ZTreeNode  implements Serializable{

	private static final long serialVersionUID = -455904840821792171L;

	private Integer id;	//节点id
	
	private Integer pid;//父节点id
	
	private String name;//节点名称
	
	private Boolean open;//是否打开节点
	
	private Boolean checked;//是否被选中
	
	public ZTreeNode(){
		super();
	}
	
	public ZTreeNode(ZTreeView zTreeView){
		this.id = Integer.parseInt(zTreeView.getI1());
		this.pid = Integer.parseInt(zTreeView.getI2());
		this.name = zTreeView.getI3();
		this.open = Boolean.parseBoolean(zTreeView.getI4());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getpid() {
		return pid;
	}

	public void setpid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Boolean getIsOpen() {
		return open;
	}

	public void setIsOpen(Boolean open) {
		this.open = open;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
	public static ZTreeNode createParent(){
		ZTreeNode zTreeNode = new ZTreeNode();
		zTreeNode.setChecked(true);
		zTreeNode.setId(0);
		zTreeNode.setName("顶级");
		zTreeNode.setOpen(true);
		zTreeNode.setpid(0);
		return zTreeNode;
	}
}
