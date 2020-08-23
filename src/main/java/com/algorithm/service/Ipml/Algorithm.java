package com.algorithm.service.Ipml;

//import com.algorithm.entity.RedBlackTree;

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
    public int[] quickSort(int[] arr) {
        if (arr.length / 2 == 0) {
            return arr;
        }
        int left = 0;
        int right = arr.length - 1;
        String posi = "r";
        int base = arr[0];
        while (left < right) {
            if (posi.equals("r")) {
                if (arr[right] < base) {
                    arr[left] = arr[right];
                    arr[right] = base;
                    posi = "l";
                } else {
                    right--;
                }
            } else {
                if (arr[left] > base) {
                    arr[right] = arr[left];
                    arr[left] = base;
                    posi = "r";
                } else {
                    left++;
                }
            }
        }
        arr[left] = base;
        int[] leftarr = new int[left + 1];
        int[] rightarr = new int[arr.length - left - 1];
        for (int j = 0; j < arr.length; j++) {
            if (j <= left) {
                leftarr[j] = arr[j];
            } else {
                rightarr[j - left - 1] = arr[j];
            }
        }
        leftarr = quickSort(leftarr);
        rightarr = quickSort(rightarr);
        for (int j = 0; j < arr.length; j++) {
            if (j <= left) {
                arr[j] = leftarr[j];
            } else {
                arr[j] = rightarr[j - left - 1];
            }
        }
        return arr;
    }

    private int ReversePair = 0;  //逆序对数量
    public int[] ReverseNum;    //目标数组，引用时赋值

    //归并排序
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



}
