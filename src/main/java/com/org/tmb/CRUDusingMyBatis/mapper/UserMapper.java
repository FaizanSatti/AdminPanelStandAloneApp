package com.org.tmb.CRUDusingMyBatis.mapper;

import com.org.tmb.CRUDusingMyBatis.model.Admin;
import com.org.tmb.CRUDusingMyBatis.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface UserMapper {

     @Select("select email from admin")
     String findAdminEmail();

     @Select("select password from admin")
     String findAdminPassword();

    @Select("select * from product")
    List<Product> findAll();

    @Select("select * from product where id = #{id}")
    List<Product> findOne(int id);

    @Insert("INSERT INTO product(name,img_src,price,category_id,description) VALUES (#{name},#{img_src},#{price},#{category_id},#{description})")
    int insertOne(Product product);

    @Delete("DELETE FROM product WHERE id = #{id}")
    int deleteOne(int id);

    @Update("UPDATE product SET price = 10499 WHERE id=#{id}")
    int update(int id);


}
