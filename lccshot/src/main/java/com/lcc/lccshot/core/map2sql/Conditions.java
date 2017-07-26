package com.lcc.lccshot.core.map2sql;

import com.lcc.lccshot.core.map2sql.enums.ActType;
import com.lcc.lccshot.core.map2sql.enums.ConditionType;
import com.lcc.lccshot.core.map2sql.enums.RelationType;

/**
 * 查询条件攻击类
 * @author lcc
 *
 */
public class Conditions {
	private Condition condition;
	

	private Conditions(){
		
	}
	
	public Conditions or(){
		this.condition.or();
		return this;
	}
	
	public  Conditions and(){
		this.condition.and();
		return this;
	}
	
	public  Condition like(String column,String value){
		return this.condition.act(column,value,ActType.LIKE);
	}
	
	public  Condition notLike(String column,String value){
		return this.condition.act(column,value,ActType.NOT_LIKE);
	}
	
	public  Condition eq(String column,String value){
		return this.condition.act(column,value,ActType.EQ);
	}
	public  Condition eq(String column,Integer value){
		return this.condition.act(column,value,ActType.EQ,ConditionType.INTEGER);
	}
	
	public  Condition notEq(String column,String value){
		return this.condition.act(column,value,ActType.NOT_EQ);
	}
	/**
	 * 区间判断
	 * @param column
	 * @param value1 大于第一个值
	 * @param value2 小于第二个值
	 * @return
	 */
	public  Condition between(String column,String value1,String value2){
		return this.condition.act(column,value1,value2,ActType.BETWEEN);
	}
	
	
	/**
	 * 创建查询条件
	 * @param column
	 * @param value
	 * @return
	 */
	public static Conditions create(){
		Conditions cds = new Conditions();
		cds.condition = new Condition();
		return cds;
	}
	
	public static Condition create(String column,String value,RelationType relation,ActType act){
		Condition condition = new Condition(column, value,RelationType.AND,ActType.LIKE);
		return condition;
	}
	

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	

}
