package com.lcc.lccshot.core.map2sql;

import java.io.Serializable;

import com.lcc.lccshot.core.map2sql.enums.ActType;
import com.lcc.lccshot.core.map2sql.enums.ConditionType;
import com.lcc.lccshot.core.map2sql.enums.FuncType;
import com.lcc.lccshot.core.map2sql.enums.RelationType;

public class Condition implements Serializable{

	private static final long serialVersionUID = 6515149666316327353L;
	
	/**
	 * 字段名称
	 */
	private String column;
	/**
	 * 值
	 */
	private Object value;
	/**
	 * 多值条件
	 */
	private Object value2;
	
	/**
	 * 字段类型
	 */
	private ConditionType condition = ConditionType.STRING;
	/**
	 * 逻辑类型   or   and
	 */
	private RelationType relation = RelationType.AND;
	/**
	 * sql 执行动作
	 */
	private ActType act;
	
	private FuncType func;
	
	public Condition and(){
		this.setRelation(RelationType.AND);
		return this;
	}
	
	public Condition or(){
		this.setRelation(RelationType.OR);
		return this;
	}
	/**
	 * 关键字 查询
	 * @param column
	 * @param value
	 * @param act
	 * @return
	 */
	public Condition act(String column,Object value,ActType act){
		this.act = act;
		this.column = column;
		this.value = value;
		return this;
	}
	
	public Condition act(String column,Object value,ActType act,ConditionType condition){
		this.condition = condition;
		act(column,value,act);
		return this;
	}
	
	public Condition act(String column,Object value,Object value2,ActType act,ConditionType condition){
		this.condition = condition;
		act(column,value,value2,act);
		return this;
	}
	
	public Condition act(String column,Object value,Object value2,ActType act){
		this.act = act;
		this.column = column;
		this.value = value;
		this.value2 = value2;
		return this;
	}
	
	
	
	
	/**
	 * 创建查询条件
	 * @param column
	 * @param value
	 * @return
	 */
	public Condition create(String column,String value){
		this.column = column;
		this.value = value;
		return this;
	}
	
	public Condition(){

	}
	public Condition(ConditionType condition){
		this.condition = condition;
	}
	
	public Condition(RelationType relation){
		this.relation = relation;
	}
	
	public Condition(ActType act){
		this.act = act;
	}
	
	public Condition(String column,String value){
		this.column = column;
		this.value = value;
	}
	
	public Condition(String column,String value,ConditionType condition){
		this.column = column;
		this.value = value;
		this.condition = condition;
	}
	public Condition(String column,String value,RelationType relation){
		this.column = column;
		this.value = value;
		this.relation = relation;
	}
	public Condition(String column,String value,ActType act){
		this.column = column;
		this.value = value;
		this.act = act;
	}
	public Condition(String column,String value,RelationType relation,ActType act){
		this.column = column;
		this.value = value;
		this.relation = relation;
		this.act = act;
	}
	public Condition(String column,String value,RelationType relation,ConditionType condition){
		this.column = column;
		this.value = value;
		this.relation = relation;
		this.condition = condition;
	}


	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public ConditionType getType() {
		return condition;
	}

	public void setType(ConditionType condition) {
		this.condition = condition;
	}

	public RelationType getRelation() {
		return relation;
	}

	public void setRelation(RelationType relation) {
		this.relation = relation;
	}

	public ActType getAct() {
		return act;
	}

	public void setAct(ActType act) {
		this.act = act;
	}

	public Object getValue2() {
		return value2;
	}

	public void setValue2(Object value2) {
		this.value2 = value2;
	}

	public ConditionType getCondition() {
		return condition;
	}

	public void setCondition(ConditionType condition) {
		this.condition = condition;
	}

	public FuncType getFunc() {
		return func;
	}

	public void setFunc(FuncType func) {
		this.func = func;
	}

	

	
}
