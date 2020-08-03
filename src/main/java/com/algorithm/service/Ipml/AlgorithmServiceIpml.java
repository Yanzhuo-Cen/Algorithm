package com.algorithm.service.Ipml;


//import com.algorithm.entity.RedBlackTree;

import com.algorithm.service.AlgorithmService;
import org.apache.commons.lang.enums.Enum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class AlgorithmServiceIpml implements AlgorithmService {

    public int ROPair = 0;

    @Override
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

    @Override  //快速排序
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

    private int res = 0;  //逆序对数量
    public int[] num;    //目标数组，引用时赋值
    @Override     //归并排序
    public void mergeSort(int left, int right, int mid) {
        if(left>=right)
            return;
        mergeSort(left, mid, (left+mid)/2);
        mergeSort(mid+1, right, (mid+1+right)/2);
        int[] arr = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (num[i] <= num[j]) {
                arr[k] = num[i];
                i++;
                k++;
            } else {
                arr[k] = num[j];
                j++;
                k++;
                res += mid +1 - i;
            }
        }
        while (j <= right) {
            arr[k] = num[j];
            j++;
            k++;
        }
        while (i <= mid) {
            arr[k] = num[i];
            i++;
            k++;
        }
        for(int n=left; n<=right; n++){
            num[n] = arr[n-left];
        }
    }

}
