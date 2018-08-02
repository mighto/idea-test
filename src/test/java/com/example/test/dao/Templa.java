//package com.example.test.dao;
//
//import org.junit.Test;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.util.CollectionUtils;
//
//import java.util.List;
//import java.util.Map;
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
//    @Test
//    public void init(){
//        DriverManagerDataSource dmds = new DriverManagerDataSource();
//        dmds.setDriverClassName("com.mysql.jdbc.Driver");
//        dmds.setUrl("jdbc:mysql://localhost:3306/test");
//        dmds.setUsername("root");
//        dmds.setPassword("");
//
//        //生成JdbcTemplate实例
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(dmds);
//
//        String SQL = "SELECT * FROM f_user";
//        List<Map<String, Object>> list = jdbcTemplate.queryForList(SQL);
//
//        if(CollectionUtils.isEmpty(list)){
//            System.out.println("empty");
//        }else{
//            for(Map<String, Object> map : list){
//                for(Map.Entry<String, Object> entry : map.entrySet()){
//                    System.out.println(entry.getKey());
//                    System.out.println(entry.getValue());
//                }
//            }
//        }
//
//    }
//
//}
