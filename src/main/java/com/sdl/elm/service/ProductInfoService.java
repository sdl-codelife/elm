package com.sdl.elm.service;

import com.sdl.elm.entity.ProductInfo;
import java.util.List;

/**
 * 商品表(ProductInfo)表服务接口
 *
 * @author sdl
 * @since 2020-04-08 20:42:43
 */
public interface ProductInfoService {
    /**
     * 查看所有商品
     * @param productInfo
     * @return
     */
    List<ProductInfo> queryAll(ProductInfo productInfo);
    /**
     * 通过ID查询单条数据
     *
     * @param productId 主键
     * @return 实例对象
     */
    ProductInfo queryById(Integer productId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProductInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param productInfo 实例对象
     * @return 实例对象
     */
    ProductInfo insert(ProductInfo productInfo);

    /**
     * 修改数据
     *
     * @param productInfo 实例对象
     * @return 实例对象
     */
    ProductInfo update(ProductInfo productInfo);

    /**
     * 通过主键删除数据
     *
     * @param productId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer productId);

}