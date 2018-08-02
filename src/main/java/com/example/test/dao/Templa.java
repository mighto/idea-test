//package com.example.test.dao;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
///**
// * @author mistaker
// * @description：
// * @create 2018/03/16
// */
//public class Templa {
//
////    @Autowired
////    JdbcTemplate jdbcTemplate;
//
//    public void init(){
//        DriverManagerDataSource dmds = new DriverManagerDataSource();
//        dmds.setDriverClassName("com.mysql.jdbc.Driver");
//        dmds.setUrl("jdbc:mysql://localhost:3306/test");
//        dmds.setUsername("root");
//        dmds.setPassword("000");
//
//        //生成JdbcTemplate实例
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(dmds);
//    }
//
//}
