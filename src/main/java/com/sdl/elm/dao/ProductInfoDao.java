package com.sdl.elm.dao;

import com.sdl.elm.entity.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 商品表(ProductInfo)表数据库访问层
 *
 * @author sdl
 * @since 2020-04-08 20:42:43
 */
@Mapper
public interface ProductInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param productId 主键
     * @return 实例对象
     */
    ProductInfo queryById(Integer productId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProductInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param productInfo 实例对象
     * @return 对象列表
     */
    List<ProductInfo> queryAll(ProductInfo productInfo);

    /**
     * 新增数据
     *
     * @param productInfo 实例对象
     * @return 影响行数
     */
    int insert(ProductInfo productInfo);

    /**
     * 修改数据
     *
     * @param productInfo 实例对象
     * @return 影响行数
     */
    int update(ProductInfo productInfo);

    /**
     * 通过主键删除数据
     *
     * @param productId 主键
     * @return 影响行数
     */
    int deleteById(Integer productId);

}