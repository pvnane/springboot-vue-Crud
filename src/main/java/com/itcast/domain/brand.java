package com.itcast.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.ConstructorArgs;

//lombok技术
@TableName("tb_brand")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class brand {
    //将属性对应的字段指定为主键，mybatisplus默认主键为id
    @TableId(type = IdType.AUTO)
    private Integer id;
    private  String brandName;
    private  String companyName;
    private  Integer ordered;
    private  String  description;
}
