package com.algorithm.service.Ipml;

//import com.algorithm.entity.RedBlackTree;

import com.algorithm.entity.ListNode;

import java.util.*;

public class Algorithm {

    //基数排序法
    public int[] cardinalitySort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (max < arr[i + 1]) {
                max = arr[i + 1];
            }
        }
        System.out.println("max=" + max);
        int maxLength = (max + "").length();  //计算最大值的位数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            List<List<Integer>> tem = new LinkedList<>();  //创建list用于临时存储每次排序后的目标数组
            for (int j = 0; j < 10; j++) {
                List<Integer> nn = new LinkedList<>();
                tem.add(j, nn);                          //list开辟10个内部list存储空间
            }
            System.out.println("tem= " + tem);
            System.out.println("第" + (i + 1) + "次排序");
            for (int value : arr) {
                int ys = value / n % 10;
                tem.get(ys).add(tem.get(ys).size(), value);  //list将不同位数的数据存进对应的内部list存储空间
            }
            System.out.println("tem= " + tem);
            int index = 0;
            //取出list内部数据重新存入目标数组中
            for (List<Integer> list : tem) {
                System.out.println("List<Integer>= " + list);
                System.out.println("List.size()= " + list.size());
                int m = 0;
                while (!list.isEmpty()) {
                    for (int l = 0; l < list.size(); l++) {
                        int li = list.get(l);
                        System.out.println("list.get()= " + li);
                        arr[index] = li;
                        index++;
                        System.out.println("l= " + l);
                        System.out.println("arr= " + Arrays.toString(arr));
                        m++;
                        System.out.println("m= " + m);
                    }
                    if (m > list.size() - 1)
                        break;
                }
            }
            System.out.println("arr= " + Arrays.toString(arr));
        }
        return arr;
    }

    //快速排序
    public void quickSort(int[] arr, int left, int right) {
        int i,j,temp,t;
        if(left>right){
            return;
        }
        i=left;
        j=right;
        //temp就是基准位
        temp = arr[left];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[left] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, left, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, right);
    }


    //归并排序
    private int ReversePair = 0;  //逆序对数量
    public int[] ReverseNum;    //目标数组，引用时赋值

    public void mergeSort(int left, int right, int mid) {
        if (left >= right)
            return;
        mergeSort(left, mid, (left + mid) / 2);
        mergeSort(mid + 1, right, (mid + 1 + right) / 2);
        int[] arr = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (ReverseNum[i] <= ReverseNum[j]) {
                arr[k] = ReverseNum[i];
                i++;
                k++;
            } else {
                arr[k] = ReverseNum[j];
                j++;
                k++;
                ReversePair += mid + 1 - i;
            }
        }
        while (j <= right) {
            arr[k] = ReverseNum[j];
            j++;
            k++;
        }
        while (i <= mid) {
            arr[k] = ReverseNum[i];
            i++;
            k++;
        }
        for (int n = left; n <= right; n++) {
            ReverseNum[n] = arr[n - left];
        }
    }

    //全排序
    public List<List<Integer>> backtrackLists = new LinkedList<>();

    public void backtrack(int[] nums, List<Integer> list, int[] dp) {
        //Arrays.sort(nums) 数组中有重复元素时需要先排序再进入该函数
        if (list.size() == nums.length) {
            backtrackLists.add(new ArrayList<>(list));  //数组、列表等只有单实例，需要创建新实例来存储每种情况
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == 1) continue;
//            if(i>0 && nums[i]==nums[i-1] && dp[i-1]==0) continue;   //数组中有重复元素时
            dp[i] = 1;
            list.add(nums[i]);
            backtrack(nums, list, dp);
            dp[i] = 0;
            list.remove(list.size() - 1);
        }
    }

    //堆排序(大顶堆)/优先队列
    public int[] heap;
    public void heapSort(int[] arr, int index, int root){
        if(index==root) {
            heap = arr;
            return;
        }
        if(arr[index]>arr[(index-1+root)/2]){
            int min=arr[(index-1+root)/2];
            arr[(index-1+root)/2]=arr[index];
            arr[index]=min;
            heapSort(arr,(index-1+root)/2,root);
        }
    }

    //动态规划零钱兑换
    public int coinsExchange(int[] coins, int target) {
        Arrays.sort(coins);
        int[] dp = new int[target + 1];  //dp[i][j]代表前i个***的钱加起来为j最少个数
        Arrays.fill(dp, target + 1);
//        System.out.println(Arrays.toString(dp));
        dp[0] = 0;
        for (int j = 1; j <= target; j++) {
            for (int coin : coins) {
                if (j >= coin)
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[target] == target + 1 ? -1 : dp[target];
    }

    //动态规划完全背包
    public int[] completeBackpack(int[][] nums, int target) {
        //例如nums=int[][]{{2,3,4,5},{3,4,5,6}};
        int[] w=nums[0];
        int[] v=nums[1];
        int[] dp = new int[target + 1];  //dp[i][j]代表前i个***的钱加起来为j最少个数
        for (int j = 1; j <= target; j++) {
            for (int i=0; i<w.length; i++) {
                if (j >= w[i])
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        return dp;
    }

    //动态规划01背包问题
    public int[] backpack01(int[][] nums, int target){
        int[] dp = new int[target + 1];  //dp[i][j]代表前i个***的钱加起来为j最少个数
        int[] w=nums[0];
        int[] v=nums[1];
        for (int i = 0; i < w.length; i++) {
            //反向走可以避免每个位置上重复使用某个物品
            for(int j=target; j>=1; j--){
                if(j>=w[i]){
                    dp[j]=Math.max(dp[j],dp[j-w[i]]+v[i]);
                }
            }
        }
        return dp;
    }

    //二维数组按某列值的大小排序
    public int[][] towDimenSort(int[][] nums, int i) {
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[i] - b[i];
            }
        });
        return nums;
    }

    //查找字符串子序列
    public boolean isSubsequence(String str, String child) {
        int index = -1;
        for (char c : str.toCharArray()){
            index = child.indexOf(c, index+1);
            if (index == -1) return false;
        }
        return true;
    }

    //字符串最长回文子序列
    public int longestPalindromeSubseq(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len-1];
    }

    //从第m个到第n个反转列表
    public ListNode reverseList(ListNode head, int m, int n){
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pre = root;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        head = pre.next;
        for (int i = m; i < n; i++) {
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return root.next;
    }

    //动态规划求最长上升子序列
    public int longestAscSubsequence(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];
        // 自己一定是一个子序列
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            // 看以前的，比它小的，说明可以接在后面形成一个更长的子序列
            // int curMax = Integer.MIN_VALUE; 不能这样写，万一前面没有比自己小的，
            // 这个值就得不到更新
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                System.out.println(Arrays.toString(dp));
            }
        }
        int res = dp[0];
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
