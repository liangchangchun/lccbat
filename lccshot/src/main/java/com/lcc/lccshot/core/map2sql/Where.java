package com.lcc.lccshot.core.map2sql;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Strings;

import com.lcc.lccshot.core.map2sql.enums.ActType;
import com.lcc.lccshot.core.map2sql.enums.RelationType;
import com.lcc.lccshot.utils.ToolUtil;

/**
 * sql查询条件
 * @author Administrator
 *
 */
public class Where {
	public List<Condition> listSql = new ArrayList<Condition>();
    
	private Where(){
		
	}
	public static Where create(){
		Where wh = new Where();
		return wh;
	}
	
	/**
	 * 添加查询条件
	 * @param column
	 * @param value
	 * @return
	 */
	public  Where add(Condition condition){
		if(!Strings.isNullOrEmpty(condition.getColumn()) && !ToolUtil.isEmpty(condition.getValue())){
			this.listSql.add(condition);
		}
		return this;
	}
	
	/**
	 * like查询   默认为  and 
	 * @param condition
	 * @return
	 */
	public  Where like(Condition condition){
		condition.setRelation(RelationType.AND);
		return this.add(condition);
	}
	
	/**
	 * like查询   默认为  and 
	 * @param column
	 * @param value
	 * @return
	 */
	public  Where like(String column,String value){
		return this.add(Conditions.create(column, value,RelationType.AND,ActType.LIKE));
	}
	
	/**
	 * like查询   或者  or
	 * @param condition
	 * @return
	 */
	public  Where orLike(Condition condition){
		condition.setRelation(RelationType.OR);
		condition.setAct(ActType.LIKE);
		return this.add(condition);
	}
	
	/**
	 * like查询  或者  or
	 * @param column
	 * @param value
	 * @return
	 */
	public  Where orLike(String column,String value){
		return this.add(Conditions.create(column, value,RelationType.OR,ActType.LIKE));
	}
	
	
	/**
	 * and 条件
	 * @param condition
	 * @return
	 */
	public  Where and(Condition condition){
		return this.add(condition.and());
	}
	
	public Where or(Condition condition){
		return this.add(condition.or());
	}
	public List<Condition> getListSql() {
		return listSql;
	}
	public void setListSql(List<Condition> listSql) {
		this.listSql = listSql;
	}
	
	
}
