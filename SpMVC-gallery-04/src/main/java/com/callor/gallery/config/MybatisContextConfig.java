package com.callor.gallery.config;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan("com.callor.gallery.dao")
public class MybatisContextConfig {
	
	private final ApplicationContext context;
	public MybatisContextConfig(ApplicationContext context) {
		this.context = context;
	}

	public DataSource ds() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/galleryDB2");
		ds.setUsername("root");
		ds.setPassword("!Biz8080");
		return ds;
	}
	
	public SqlSessionFactoryBean factoryBean() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(ds());
		bean.setTypeAliasesPackage("com.callor.gallery.models");
		// ~src/main/resource 폴더에 mapper/*-mapper.xml 을 찾아라
		Resource resource = context.getResource("classpath:/**/mapper/*-mapper.xml");
		bean.setMapperLocations(resource);
		return bean;
	}
	
	public PlatformTransactionManager transactionManager() {
		PlatformTransactionManager manager 
			= new DataSourceTransactionManager();
		
		/*
		 * manager 객체는 Platfor...Manager 인터페이스를 사용하여 선언하였다
		 * 이 인터페이스는 다양한 Transaction 을 실행하기 위한 설계도 이다
		 * DataSource...Manager 는 Platfor...Manager 인터페이스를 사용하여
		 * 구현된 구현체 클래스이다.
		 * DataSource...Manager 는 platfor... 인터페이스를 implements 하였지만
		 * 자체적으로 코드를 구현하면서
		 * 여러가지 method 를 별도로 가지고 있다
		 * 우리는 DataSource..Manager 에게 DataSource(ds()) 를 알려주고
		 *  DataSource 차원에서 Transaction 을 수행하도록 하려고 한다.
		 *  그런데 Platfor... 에는 DataSource 를 주입하는 method 가 정의도지 않았다
		 *  결국 Plafor... 에는 없지만, DataSou...Manager 에만 있는 
		 *  setDataSource() method 를 사용하여 한다.
		 *  이럴때 Platfor 에는 없지만, DataSour...Manager 에만 있는 setDataSource()
		 *  method 를 사요하기 위해서는 DataSource...Manager type 으로 
		 *  Casting(강제형변환)을 수행해야 한다 
		 */
		((DataSourceTransactionManager)manager).setDataSource(this.ds());
		
		return manager;
	}
	
	
	
	
	

}
