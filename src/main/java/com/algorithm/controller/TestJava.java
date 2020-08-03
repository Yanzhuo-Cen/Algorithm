package com.algorithm.controller;

import com.algorithm.dao.PhotoMapper;
import com.algorithm.dao.UserDao;
import com.algorithm.entity.*;
import com.algorithm.service.*;
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
    private AlgorithmService algorithmService;
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
        int n = 2;
        int m = 1;
        int t = 4;
        int[][] num1 = new int[][]{{3,1}, {2,1}};
        int[][] num2 = new int[][]{{1,2}};
        long startTime = System.nanoTime();
        if (t == 0) {
            System.out.println(0);
        } else {
            int res = Integer.MAX_VALUE;
            boolean result = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (num1[i][1] >= t) {
                        result = true;
                        res = Math.min(res, num1[i][1]);
                        break;
                    } else if (num2[j][1] >= t) {
                        result = true;
                        res = Math.min(res,num2[j][1]);
                    } else if (num1[i][1] + num2[j][1] >= t) {
                        result = true;
                        res = Math.min(res, (num1[i][0] + num2[j][0]));
                    }
                }
            }
            if (result) {
                System.out.println(res);
            } else {
                System.out.println(-1);
            }
        }
//        List<List<String>> accounts = new LinkedList<>();
//        List<String> account = new LinkedList<>();
//        account.add("John");
//        account.add("johnsmith@mail.com");
//        account.add("john00@mail.com");
//        accounts.add(account);
//        account = new LinkedList<>();
//        account.add("John");
//        account.add("johnnybravo@mail.com");
//        accounts.add(account);
//        account = new LinkedList<>();
//        account.add("John");
//        account.add("johnsmith@mail.com");
//        account.add("john_newyork@mail.com");
//        accounts.add(account);
//        account = new LinkedList<>();
//        account.add("Mary");
//        account.add("mary@mail.com");
//        accounts.add(account);
//        int res = 0;
//        HashMap<String, Integer> email_pep = new HashMap<>();
//        HashMap<String, Integer> email_Id = new HashMap<>();
//        ArrayList<Integer> emailId = new ArrayList<>();
//        ArrayList<String> emailName = new ArrayList<>();
//        for (int i = 0; i < accounts.size(); i++) {
//            for (int j = 1; j < accounts.get(i).size(); j++) {
//                String str = accounts.get(i).get(j);
//                if (email_pep.isEmpty() || !email_pep.containsKey(str)) {
//                    email_pep.put(str, i);
//                    email_Id.put(str, res);
//                    emailId.add(res);
//                    emailName.add(str);
//                    res += 1;
//                }
//            }
//        }
//        UnionFindSet union = new UnionFindSet();
//        union.add(emailId.size());
//        for (int i = 0; i < accounts.size(); i++) {
//            for (int j = 1; j < accounts.get(i).size(); j++) {
//                if (j + 1 < accounts.get(i).size()) {
//                    String str1 = accounts.get(i).get(j);
//                    String str2 = accounts.get(i).get(j + 1);
//                    union.union(email_Id.get(str1), email_Id.get(str2));
//                }
//            }
//        }
//        HashMap<Integer, List<String>> id_emails = new HashMap<>();
//        ArrayList<Integer> arrayList=union.unionRes();
//        for (int i = 0; i < arrayList.size(); i++) {
//            int num = email_pep.get(emailName.get(arrayList.get(i)));
//            List<String> va = new LinkedList<>();
//            if (!id_emails.isEmpty() && id_emails.containsKey(num)) {
//                va = id_emails.get(num);
//            }
//            va.add(emailName.get(i));
//            id_emails.put(num, va);
//        }
//        List<List<String>> lists = new LinkedList<>();
//        List<String> list;
//        for (int id : id_emails.keySet()) {
//            list = id_emails.get(id);
//            Collections.sort(list);  //字符串按字典序排序
//            List<String> people = new LinkedList<>();
//            people.add(accounts.get(id).get(0));
//            people.addAll(list);
//            lists.add(people);
//        }
//        System.out.println("emailId : " + emailId);
//        System.out.println("emailName : " + emailName);
//        System.out.println("email_Id : " + email_Id);
//        System.out.println("email_pep : " + email_pep);
//        System.out.println("union : " + arrayList);
//        System.out.println("id_emails : " + id_emails);
//        System.out.println("lists : " + lists);
//        UnionFindSet set=new UnionFindSet();
//        set.add(nums.length);
//        set.union(1,3);
//        set.union(2,4);
//        set.union(3,5);
//        System.out.println("sets: " +set.arrayList);
//        System.out.println("1 and 5 : " +set.same(1,5));
//        System.out.println("2 and 6 : " +set.same(2,6));
//        System.out.println("sets number: " +set.num);
//        System.out.println("dasfk; 4531 dsaiopw, 489612");
        //读取所有输入数据//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str;
//        while ((str = br.readLine()) != null) {
//            System.out.println("res= " + str);
//        }
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
        long endTime = System.nanoTime();
        System.out.println("程序运行时间： " + (endTime - startTime) / 1000 + "us");
    }

    //在线考试模式
//    import java.util.*;
//    import java.io.*;
//    public class Main{
//        public static void main(String[] args) throws IOException{
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str;
//            while((str=br.readLine())!=null){
//                char[] chArr = str.toCharArray();
//                int[] temp = new int[150];
//                for(int i=0;i<chArr.length;i++){
//                    temp[chArr[i]]++;
//                }
//                int max = 0;
//                for(int j=0;j<temp.length;j++){
//                    if(max<temp[j]){
//                        max = temp[j];
//                    }
//                }
//                StringBuilder sbf = new StringBuilder();
//                while(max!=0){
//                    for(int j=0;j<temp.length;j++){
//                        if(temp[j] == max){
//                            sbf.append((char)j);
//                        }
//                    }
//                    max--;
//                }
//                System.out.println(sbf.toString());
//            }
//        }
//    }

    /**
     * 异步多线程同步控制，数据安全锁
     *
     * @ return CompletableFuture<数据类型>
     */
    private int Concurrency;

//    @Async
//    @RequestMapping(value = "/callback", method = RequestMethod.POST)
////    @Scheduled(fixedRate = 1000 * 60 * 60)
//    public synchronized CompletableFuture<Integer> wxNotify(HttpServletRequest httpServletRequest, Integer n) {
//        System.out.println("session= " + httpServletRequest.getSession());     //获取sessionId
//        System.out.println("cookies= " + Arrays.toString(httpServletRequest.getCookies()));     //获取cookies
//        System.out.println("n= " + n);
//        int m = (int) (Math.random() * 100);
//        Concurrency = 0;
//        for (int i = 0; i < 2; i++) {
//            Concurrency++;
//            System.out.println("currentThread.Name: " + m + "-----currentThread(): " + i + "-----Concurrency= " + Concurrency);
//        }
//        return CompletableFuture.completedFuture(Concurrency);
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
