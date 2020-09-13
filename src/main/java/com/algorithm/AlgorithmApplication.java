package com.algorithm;

import com.algorithm.entity.UnionFindSet;
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
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@RestController
@EnableScheduling
@MapperScan(basePackages = "com.algorithm.dao")
@SpringBootApplication        //包含：@ComponentScan + @Configuration + @EnableAutoConfiguration
@EnableAsync
public class AlgorithmApplication {

//    private double resulut=0;
//    private HashMap map=new HashMap();

    public static void main(String[] args) {
        SpringApplication.run(AlgorithmApplication.class, args);
//        //查询JVM GC类型
        List<GarbageCollectorMXBean> gc = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean b : gc) {
            System.out.println(b.getName());
        }
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            String st = sc.nextLine();
//            int t=Integer.parseInt(st);
//            for(int i=0; i<t; i++) {
//                String str = sc.nextLine();
//                String[] strings = str.split(" ");
//                System.out.println("strings= " + Arrays.toString(strings));
//            }
//        }
    }
}

//class Fin {
//
//    public int count;
//    public void find(int[] arr) {
//        Arrays.sort(arr);
//        boolean result=false;
//        for(int i=1; i<arr.length; i++){
//            if(arr[i-1]==arr[i]){
//                arr[i-1]=0;
//                arr[i]+=1;
//                count+=1;
//                result=true;
//                break;
//            }
//        }
//        if(result){
//            int[] arrn=new int[arr.length-1];
//            int j=0;
//            for(int i=0; i<arr.length; i++){
//                if(arr[i]!=0){
//                    arrn[j]=arr[i];
//                    j+=1;
//                }
//            }
//            find(arrn);
//        }
//    }
//}

