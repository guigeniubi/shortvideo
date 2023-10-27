//package com.example.videoproject;
//
//import com.baomidou.mybatisplus.generator.FastAutoGenerator;
//import com.baomidou.mybatisplus.generator.config.OutputFile;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
//import java.util.Collections;
//
//public class codegenerator {
//    public static void main(String[] args) {
//        String url = "jdbc:mysql:///myvideo";
//        String username = "root";
//        String password = "zengb123";
//        String author = "qiniuteam";
//        String outputDir = "E:\\IdeaProjects\\video-project\\src\\main\\java";
//        String basePackage = "com.example";
//        String moduleName = "sys";
//        String mapperLocation = "E:\\IdeaProjects\\video-project\\src\\main\\resources\\mapper" + moduleName;
//        String tableName = "user_favorite,user_follow,user,video_categorie,video";
//        FastAutoGenerator.create(url, username, password)
//                .globalConfig(builder -> {
//                    builder.author(author) // 设置作者
////                            .enableSwagger() // 开启 swagger 模式
//                            //.fileOverride() // 覆盖已生成文件
//                            .outputDir(outputDir); // 指定输出目录
//                })
//                .packageConfig(builder -> {
//                    builder.parent(basePackage) // 设置父包名
//                            .moduleName(moduleName) // 设置父包模块名
//                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
//                })
//                .strategyConfig(builder -> {
//                    builder.addInclude(tableName); // 设置需要生成的表名
//
//                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
//                .execute();
//
//    }
//}
