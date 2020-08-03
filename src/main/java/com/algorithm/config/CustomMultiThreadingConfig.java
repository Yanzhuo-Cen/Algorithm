package com.algorithm.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.*;
/**
 * @Description: 配置类实现AsyncConfigurer接口，并重写getAsyncExecutor方法，并返回一个ThreadPoolTaskExecutor，
 * 这样我们就获得一个基于线程池TaskExecutor
 * @ClassName: CustomMultiThreadingConfig
 * @Author: OnlyMate
 * @Date: 2018年9月21日 下午2:50:14
 */
@Configuration
@ComponentScan("com.algorithm")   //自动扫描指定包下的全部标有 @Component注解的类，并注册成bean，包括 @Component下的子注解@Service、@Repository、@Controller
@EnableAsync//利用@EnableAsync注解开启异步任务支持
public class CustomMultiThreadingConfig implements AsyncConfigurer{

    @Override
    public Executor getAsyncExecutor() {  //处理异步方法调用时要使用的实例，Executor
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);         //核心池的大小，即在没有任务需要执行的时候线程池的大小
        taskExecutor.setMaxPoolSize(10);         //线程池中允许的最大线程数，线程池中的当前线程数目不会超过该值
        taskExecutor.setQueueCapacity(25);       //排队机制允许的最大排队任务数
//        taskExecutor.setKeepAliveSeconds(2);   //线程最大空闲时间，默认只有当线程池中的线程数大于corePoolSize时，keepAliveTime才会起作用
        taskExecutor.setThreadNamePrefix("-Thread-number-"); ////指定用于新创建的线程名称的前缀。
        taskExecutor.setRejectedExecutionHandler(
                new ThreadPoolExecutor.CallerRunsPolicy()); //拒绝策略，有四种可选，此处设置为CallerRunsPolicy（由调用线程处理该任务）
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override       //AsyncUncaughtExceptionHandler，在使用void返回类型的异步方法执行期间抛出异常时要使用的实例
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return AsyncConfigurer.super.getAsyncUncaughtExceptionHandler();
    }

}
