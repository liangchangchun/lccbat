package com.lcc.lccshot.core.map2sql.board;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.lcc.lccshot.core.map2sql.Condition;
import com.lcc.lccshot.core.map2sql.Where;
import com.lcc.lccshot.core.map2sql.enums.ActType;
import com.lcc.lccshot.core.map2sql.enums.ConditionType;

public class SqlBoard<T> implements IRealationBoard<T> {

	/**
	 * 
	 */
	@Override
	public List<Predicate> conditionHandler(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb,
			Where where) {
		List<Predicate> predicates = new ArrayList<Predicate>(); 
		List<Condition> conditions = where.getListSql();
		Iterator<Condition> iterator =conditions.iterator();
		while(iterator.hasNext()){
			Condition condition=iterator.next();
			Path path = root.get(condition.getColumn());
			switch (condition.getAct()) {
			case LIKE:
				predicates.add(cb.like(path, "%"+condition.getValue()+"%"));
			break;
			case NOT_LIKE:
				predicates.add(cb.notLike(path, "%"+condition.getValue()+"%"));
				break;
			case EQ:
				predicates.add(cb.equal(path, condition.getValue()));
				break;
			case NOT_EQ:
				predicates.add(cb.notEqual(path, condition.getValue()));
			    break;
			case BETWEEN:
				if (condition.getCondition().equals(ConditionType.DATE)){
					 //处理时间  
	                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	                Date startDate;  
	                Date endDate = null;  
	                try {  
	                    startDate = format.parse(condition.getValue().toString());  
	                    endDate = format.parse(condition.getValue2().toString());  
	                } catch (ParseException e) {  
	                    startDate = new Date(946656000000L);//2000 01 01  
	                }  
	                
					predicates.add(cb.between(root.<Date>get(condition.getColumn()), startDate, endDate));
				}else {
					predicates.add(cb.between(path, condition.getValue().toString(), condition.getValue2().toString()));
				}
				break;
			default:
				break;
			}
			
		}
		return predicates;
	}


	private Predicate logic(Path path,CriteriaBuilder cb,Condition condition){
		return cb.like(path, "%"+condition.getValue()+"%");
	}
}
