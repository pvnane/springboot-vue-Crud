package com.itcast.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itcast.domain.brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class brandtest {
    @Autowired
    private BrandMapper brandMapper;
    @Test

    void testByid(){
        System.out.println(brandMapper.selectById(2));
    }
    @Test
    void testsave(){
        brand brand=new brand();
        brand.setBrandName("海尔");
        brand.setCompanyName("海尔集团有限公司");
        brand.setOrdered(200);
        brand.setDescription("海尔品牌就是好，买买买");
        int insert = brandMapper.insert(brand);
        System.out.println("insert==>"+insert);

    }
    @Test
    void testUpdate(){
        brand brand=new brand();
        brand.setId(49);
        brand.setBrandName("海尔");
        brand.setCompanyName("海尔集团有限公司");
        brand.setOrdered(200);
        brand.setDescription("海尔品牌就是好，买买买");
        int i = brandMapper.updateById(brand);

        System.out.println("i==>"+i);
         //组装条件修改 UpdateWrapper
//        UpdateWrapper<brand> wrapper=new UpdateWrapper<>();
//        wrapper.set("brand_name","海信")
//                .set("company_name","海信集团有限公司")
//                        .eq("brand_name","海尔");
//
//        int update = brandMapper.update(brand, wrapper);

    }
    @Test
    void testDelete(){
         QueryWrapper<brand> wrapper=new QueryWrapper<>();
         wrapper.lt("ordered",10);

         int i= brandMapper.delete(wrapper);

         //删除多条数据，集合
        //int i = brandMapper.deleteBatchIds(Arrays.asList(30, 31));
        System.out.println("i==>"+i);

    }
    @Test
    void testGetPage(){
        IPage iPage=new Page(2,5) ;
        brandMapper.selectPage(iPage,null);

        System.out.println(iPage.getCurrent());
        System.out.println(iPage.getPages());
        System.out.println(iPage.getRecords());
        System.out.println(iPage.getTotal());
        System.out.println(iPage.getSize());

    }

    @Test
    void testGetAll(){

        QueryWrapper<brand> wrapper=new QueryWrapper<>();
        wrapper.between("ordered",50,100);
        List<brand> brands = brandMapper.selectList(wrapper);
        for (brand brand : brands) {
            System.out.println(brand);
        }
    }

    @Test
    void testGetby(){
        String company_name="米";
        LambdaQueryWrapper<brand> wrapper=new LambdaQueryWrapper<brand>();
        //wrapper.like(company_name!=null,brand::getCompanyName,company_name);

        wrapper.like(company_name!=null,brand::getCompanyName,company_name);
        List<brand> brands = brandMapper.selectList(wrapper);
        for (brand brand : brands) {
            System.out.println(brand);
        }

    }
}
