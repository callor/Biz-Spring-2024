package com.callor.gallery.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan(basePackages = {"com.callor.gallery.dao"})
public class MyBatisContextConfig {

	@Bean
	public DataSource ds() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/galleryDB2");
		ds.setUsername("root");
		ds.setPassword("!Biz8080");
		return ds;
	}

	@Bean
	public SqlSessionFactoryBean sessionFactoryBean() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(this.ds());
		bean.setTypeAliasesPackage("com.callor.gallery.models");
		return bean;
	}
	
	
	
	
}
