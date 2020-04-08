package com.sdl.elm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdl.elm.config.ProjectConfig;
import com.sdl.elm.config.ServerConfig;
import com.sdl.elm.entity.ProductInfo;
import com.sdl.elm.model.Result;
import com.sdl.elm.service.ProductInfoService;
import com.sdl.elm.utils.FieUtil;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.util.List;

/**
 * 商品表(ProductInfo)表控制层
 *
 * @author sdl
 * @since 2020-04-07 16:54:26
 */
@RestController
@RequestMapping("/product")
@Api(tags = "商品信息")
public class ProductInfoController {
    /**
     * 服务对象
     */
    @Resource
    private ProductInfoService productInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询商品", notes = "这种类型的查询是精确查询,其结果只有一条数据", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品id", required = true,
                    dataType = "int", paramType = "path", defaultValue = "1")
    })
    @GetMapping("{id}")
    public Result selectOne(@PathVariable Integer id) {
        System.out.println(ServerConfig.getUrl());
        return Result.success(this.productInfoService.queryById(id));
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = false,dataType = "int", paramType = "path", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false,dataType = "int", paramType = "path", defaultValue = "6"),
            @ApiImplicitParam(name = "productName", value = "商品名", required = false,dataType = "String", paramType = "path"),
    })
    @ApiOperation(value = "获取所有商品", notes = "可选参数pageNum:当前页码，默认为1，可选参数pageSize:页面大小，默认为6;" +
            "返回参数data.toatal:总记录数;total.list:记录列表;可选参数productName:商品名")
    @GetMapping("/getall")
    public Result getall(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                         @RequestParam(required = false,defaultValue = "6") Integer pageSize,
                         String productName) {
        PageHelper.startPage(pageNum,pageSize);
        ProductInfo productInfo = new ProductInfo();
        if(productName!=null||productName!=""){
            productInfo.setProductName(productName);
        }
        List<ProductInfo> list = productInfoService.queryAll(productInfo);
        PageInfo<ProductInfo> pageInfo = new PageInfo<>(list);
        return Result.success(pageInfo);
    }
    @ApiOperation(value = "添加商品图片", notes = "参数imgfile:类型multipart/form-data；上传成功返回图片url")
    @PostMapping("/uploadimg")
    public Result uploadimg(MultipartFile imgfile){
        if(!imgfile.isEmpty()){
            String url = FieUtil.upload(imgfile, ProjectConfig.getPath()+"product/");
            return Result.success("上传成功",url);
        }else {
            return Result.error("上传错误！");
        }
    }
    @ApiOperation(value = "添加商品", notes = "参数productInfo:json格式，id为可选参数且不可重复")
    @PostMapping("/addone")
    public Result addpro(@RequestBody ProductInfo productInfo){
       productInfoService.insert(productInfo);
       return Result.success();
    }
    @ApiOperation(value = "修改商品", notes = "参数productInfo:json格式，id为必选参数,其他为可选参数")
    @PutMapping("/updateproduce")
    public Result updatepro(@RequestBody ProductInfo productInfo){
        productInfoService.update(productInfo);
        return Result.success();
    }
}