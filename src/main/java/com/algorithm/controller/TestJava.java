package com.algorithm.controller;

import com.algorithm.dao.PhotoMapper;
import com.algorithm.dao.UserDao;
import com.algorithm.entity.*;
import com.algorithm.service.*;
import com.algorithm.service.Ipml.Algorithm;
import com.alibaba.druid.sql.visitor.functions.Char;
import net.sf.json.JSONArray;
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
    @Scheduled(fixedRate = 1000 * 60 * 60)
    public void getJson() throws IOException, ParseException {
        System.out.println("star------------");
//        TreeNode root = new TreeNode(3);
//        TreeNode a1 = new TreeNode(5);
//        TreeNode a2 = new TreeNode(1);
//        TreeNode a3 = new TreeNode(6);
//        TreeNode a4 = new TreeNode(2);
//        TreeNode a5 = new TreeNode(0);
//        TreeNode a6 = new TreeNode(8);
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
//        int[][] intervals = new int[][]{{1,4},{9,12},{0,5},{3,6},{7,8},{2,6}};
        ListNode head1 = new ListNode(3);
//        head1.next = new ListNode(4);
//        head1.next.next = new ListNode(5);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(6);
        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);
        ListNode[] lists = new ListNode[3];
        lists[0] = head1;
        lists[1] = head2;
        lists[2] = head3;
        long startTime = System.nanoTime();
        Algorithm alg = new Algorithm();
        ListNode head = lists[0];
        int i=1;
        while (head==null && i<lists.length) {
            head=lists[i];
            i++;
        }
        if(head==null){

        }
        ListNode left;
        for (int k = i; k < lists.length; k++) {
            left = head;
            ListNode right = lists[k];
            if(right==null)
                continue;
            ListNode last = null;
            while (left != null && right != null) {
                if (left.val >= right.val) {
                    ListNode node = new ListNode(left.val);
                    left.val = right.val;
                    node.next = left.next;
                    left.next = node;
                    left = node;
                    right = right.next;
                } else {
                    if(left.next==null){
                        last=left;
                    }
                    left = left.next;
                }
            }
            if (right != null) {
                last.next = right;
            }
        }
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
//        System.out.println(list);
        long endTime = System.nanoTime();
        System.out.println("程序运行时间： " + (endTime - startTime) / 1000 + "us");
    }

//    public List<List<Integer>> lists = new LinkedList<>();

    public List<List<Integer>> backtrackLists = new LinkedList<>();

    private void backtrack(int[] nums, List<Integer> list, int[] dp) {
        if (list.size() == nums.length) {
            backtrackLists.add(new ArrayList<>(list));  //数组、列表等只有单实例，需要创建新实例来存储每种情况
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == 1) continue;
            dp[i] = 1;
            list.add(nums[i]);
            backtrack(nums, list, dp);
            dp[i] = 0;
            list.remove(list.size() - 1);
        }
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
