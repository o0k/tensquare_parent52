package com.tensquare.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * JpaRepository<Label, String>
 *     <Label, String>
 *         String 是Id的类型
 * 如果要做复杂的条件查询，排序，分页查询，还要继承：JpaSpecificationExecutor<Label>
 *
 */
public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {

}
