package com.algorithm.service.Ipml;

import com.algorithm.service.StringQueryService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StringQueryServiceIpml implements StringQueryService {

    @Override
    public float getSimilarityRatio(String str1, String str2) {
        //计算两个字符串的长度。
        int len1 = str1.length();
        int len2 = str2.length();
        //建立上面说的数组，比字符长度大一个空间
        int[][] dif = new int[len1 + 1][len2 + 1];
        //赋初值，步骤B。
        for (int a = 0; a <= len1; a++) {
            dif[a][0] = a;
        }
        for (int a = 0; a <= len2; a++) {
            dif[0][a] = a;
        }
        //计算两个字符是否一样，计算左上的值
        int temp;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                //取三个值中最小的
                int min;
                if (dif[i - 1][j - 1] + temp < dif[i][j - 1] + 1){
                    min = dif[i - 1][j - 1] + temp;
                    if (dif[i - 1][j] + 1 < min){
                        min = dif[i - 1][j] + 1;
                    }
                }else {
                    min = dif[i][j - 1] + 1;
                    if (dif[i - 1][j] + 1 < min){
                        min = dif[i - 1][j] + 1;
                    }
                }
                dif[i][j] = min;
            }
        }
        System.out.println("字符串\""+str1+"\"与\""+str2+"\"的比较");
        //取数组右下角的值，同样不同位置代表不同字符串的比较
        System.out.println("变化矩阵："+dif[len1][len2]);
        //计算相似度
        float similarity = 1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());
        System.out.println("两串字符相似度为："+similarity);
        return similarity;
    }

    @Override
    public JSONArray fuzzySearch(String name, JSONArray jsonArray, String indexes) {
        JSONArray results = new JSONArray();
        Pattern pattern = Pattern.compile(name);
        for(int i=0; i < jsonArray.size(); i++){
            Matcher matcher = pattern.matcher(jsonArray.getJSONObject(i).getString(indexes));
            if(matcher.find()){
                results.add(jsonArray.get(i));
            }
        }
        return results;
    }
}
