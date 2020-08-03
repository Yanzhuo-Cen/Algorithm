package com.algorithm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringReader;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@RestController
@EnableScheduling
@MapperScan(basePackages = "com.algorithm.dao")
@SpringBootApplication        //包含：@ComponentScan + @Configuration + @EnableAutoConfiguration
@EnableAsync
public class AlgorithmApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlgorithmApplication.class, args);
//        //查询JVM GC类型
        List<GarbageCollectorMXBean> gc = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean b : gc) {
            System.out.println(b.getName());
        }
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] num=new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(num));
//        System.out.println("num= " + Arrays.deepToString(num));
    }

}

