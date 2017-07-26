package com.lcc.lccshot.core.map2sql.board;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.lcc.lccshot.core.map2sql.Where;

public interface IRealationBoard<T> {
	/**
	 * sql 动态查询条件拼接
	 * @param root
	 * @param query
	 * @param cb
	 * @param where
	 * @return
	 */
	List<Predicate> conditionHandler(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb,Where where);
}
