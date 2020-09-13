package com.algorithm.controller;

import com.algorithm.dao.PhotoMapper;
import com.algorithm.dao.UserDao;
import com.algorithm.entity.*;
import com.algorithm.service.*;
import com.algorithm.service.Ipml.Algorithm;
import com.alibaba.druid.sql.visitor.functions.Char;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.text.StrBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.apache.commons.codec.net.URLCodec;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.*;

@RestController
public class TestJava {

    @Resource           //按名称注入，实现自动注入所依赖的Bean,不需要 new 的方式显示创建bean实例
    private RestTemplate restTemplate;
    @Resource
    private PhotoService photoService;
    @Resource
    UserService userService;
//    private int m = 0;
//    private List<String> list = new LinkedList<>();
//    boolean flag = true;
//    private List<List<Integer>> lists = new LinkedList<>();
//    Queue<Integer> queue = new LinkedList<>();
//    Deque<Integer> deque = new LinkedList<>();

    //        @CrossOrigin(value = "http://localhost:7070", maxAge = 1800, allowedHeaders = "*")    //前后端跨域cors设置（前端域名为: 7070）
//    @RequestMapping(value = "/xxx", method = RequestMethod.POST)   //value 表示的是请求地址
    @Scheduled(fixedRate = 8000 * 60 * 60)
    public void getJson() throws IOException, ParseException {
        System.out.println("star------------");
//        TreeNode root = new TreeNode(5);
//        TreeNode a1 = new TreeNode(3);
//        TreeNode a2 = new TreeNode(8);
//        TreeNode a3 = new TreeNode(1);
//        TreeNode a4 = new TreeNode(4);
//        TreeNode a5 = new TreeNode(6);
//        TreeNode a6 = new TreeNode(9);
//        TreeNode a7 = new TreeNode(7);
//        TreeNode a8 = new TreeNode(4);
//        root.left = a1;
//        root.right = a2;
//        a1.left = a3;
//        a1.right = a4;
//        a4.left = a7;
//        a4.right = a8;
//        a2.left = a5;
//        a2.right = a6;
//        int k=1;
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        list = new LinkedList<>();
//        list.add(3);
//        list.add(4);
//        triangle.add(list);
//        list = new LinkedList<>();
//        list.add(6);
//        list.add(5);
//        list.add(7);
//        triangle.add(list);
//        list = new LinkedList<>();
//        list.add(4);
//        list.add(1);
//        list.add(8);
//        list.add(3);
//        triangle.add(list);
//        int k=3;
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        long startTime = System.nanoTime();
        Algorithm alg = new Algorithm();
        int res = 0;
        
        System.out.println(res);
        long endTime = System.nanoTime();
        System.out.println("程序运行时间： " + (endTime - startTime) / 1000 + "us");
    }

    //    public List<List<Integer>> lists = new LinkedList<>();
    private ListNode root = new ListNode(0);

    private void find(ListNode pre, ListNode node, int sum, int k) {
        if (sum == k) {
            root = pre;
            return;
        }
        root.val = node.val;
        root.next = pre;
        pre = root;
        root = new ListNode(0);
        node = node.next;
        find(pre, node, sum + 1, k);
    }
    //在线考试模式
//    import java.util.*;
//    import java.io.*;
//    public class Main{
//        public static void main(String[] args) throws IOException{
    //读取所有输入数据//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str;
//        while ((str = br.readLine()) != null) {
//            System.out.println("res= " + str);
//        }
    //        String format = new DecimalFormat("0.0").format(res);
    //读取数组
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] num = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            num[i][0] = a;
//            num[i][1] = b;
//        }
//         System.out.println(sbf.toString());
//            }
//        }
//    }


//        JSONObject s = new JSONObject();
//        JSONObject s1 = new JSONObject();
//        String me = URLEncoder.encode(message, "utf-8");
//        s1.put("content", message);
//        s.put("msgtype", "text");
//        s.put("text", s1);
//        String mes = s.toString();
//        System.out.println(mes);
//
//        url1 = "https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2?access_token=" + accessToken + "&agent_id=277466610&userid_list=263630186823547758&msg={mes}";
//        JSONObject sss = restTemplate.getForObject(url1, JSONObject.class, mes);        //发送含中文字符的url
//        System.out.println(sss);

}
