package com.lcc.lccshot.core.map2sql;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lcc.lccshot.core.map2sql.board.IRealationBoard;
import com.lcc.lccshot.core.map2sql.board.SqlBoard;

/**
 * 动态查询 api 简化模板
 * @author lcc
 *
 * @param <M>
 * @param <T>
 */
public abstract class BaseServiceTemplate<M extends JpaSpecificationExecutor<T>,T> {
	/**
	 * 查询条件
	 */
	private Where where;
	
	/**
	 * where 逻辑关系转换接口
	 */
	private IRealationBoard<T> board;

	@Autowired
	protected M repository;
	
	public List<T> findAll(){
		Specification<T> specification = new Specification<T>() {  
            @Override  
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {  
            	List<Predicate> predicates = board.conditionHandler(root,query,cb,where);  
                return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }  
        };  
		return repository.findAll(specification);
	}
	
	public Page<T> findAll(Pageable pageable){
		Specification<T> specification = new Specification<T>() {  
            @Override  
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {  
            	List<Predicate> predicates = board.conditionHandler(root,query,cb,where);  
                return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }  
        };  
		return repository.findAll(specification,pageable);
	}
	
	public List<T> findAll(Sort sort){
		Specification<T> specification = new Specification<T>() {  
            @Override  
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {  
            	List<Predicate> predicates = board.conditionHandler(root,query,cb,where);  
                return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }  
        };  
		return (List<T>) repository.findAll(specification,sort);
	}
	
	
	public void initWhere(Where where){
		this.where = where;
		this.board = new SqlBoard<T>();//sql 语句转换模板
	};

	
	public Where getWhere() {
		return where;
	}
	public void setWhere(Where where) {
		this.where = where;
	}

	public IRealationBoard<T> getBoard() {
		return board;
	}

	public void setBoard(IRealationBoard<T> board) {
		this.board = board;
	}
	
	

}
