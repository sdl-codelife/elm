package com.sdl.elm.service.impl;

import com.sdl.elm.entity.ProductInfo;
import com.sdl.elm.dao.ProductInfoDao;
import com.sdl.elm.service.ProductInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品表(ProductInfo)表服务实现类
 *
 * @author sdl
 * @since 2020-04-08 20:42:44
 */
@Service("productInfoService")
public class ProductInfoServiceImpl implements ProductInfoService {
    @Resource
    private ProductInfoDao productInfoDao;

    @Override
    public List<ProductInfo> queryAll(ProductInfo productInfo) {
        return productInfoDao.queryAll(productInfo);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param productId 主键
     * @return 实例对象
     */
    @Override
    public ProductInfo queryById(Integer productId) {
        return this.productInfoDao.queryById(productId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProductInfo> queryAllByLimit(int offset, int limit) {
        return this.productInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param productInfo 实例对象
     * @return 实例对象
     */
    @Override
    public ProductInfo insert(ProductInfo productInfo) {
        this.productInfoDao.insert(productInfo);
        return productInfo;
    }

    /**
     * 修改数据
     *
     * @param productInfo 实例对象
     * @return 实例对象
     */
    @Override
    public ProductInfo update(ProductInfo productInfo) {
        this.productInfoDao.update(productInfo);
        return this.queryById(productInfo.getProductId());
    }

    /**
     * 通过主键删除数据
     *
     * @param productId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer productId) {
        return this.productInfoDao.deleteById(productId) > 0;
    }
}