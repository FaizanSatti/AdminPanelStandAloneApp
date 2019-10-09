package com.org.tmb.CRUDusingMyBatis;

import com.org.tmb.CRUDusingMyBatis.model.Product;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(Product.class)
@MapperScan("com.org.tmb.CRUDusingMyBatis.mapper")
@SpringBootApplication

public class CruDusingMyBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruDusingMyBatisApplication.class, args);
    }

}
