package com.youkeda.application.ebusiness.dao;

import com.youkeda.application.ebusiness.dataobject.ProductDO;
import com.youkeda.application.ebusiness.param.BasePageParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘铭垚
 * @version 1.0
 */
@Mapper
public interface ProductDAO {
    /**
     * 新增商品
     * @param productDO
     * @return
     */
    int insert (ProductDO productDO);

    /**
     * 根据名字查询商品
     * @param name
     * @return
     */
    ProductDO selectByName (@Param("name") String name);

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    ProductDO selectById (@Param("id") Long id);

    /**
     * 更新库存
     * @param productDO
     * @return
     */
    int updateStock (ProductDO productDO);

    /**
     * 查询所有记录条数
     * @return
     */
    int selectAllCounts();

    /**
     * 分页查询
     * @param param
     * @return
     */
    List<ProductDO> pageQuery(BasePageParam param);
}
