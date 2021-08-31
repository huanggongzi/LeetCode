package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 你的名字
 * @Date: 2021/09/01/0:48
 * @Description:
 */
public class 比较版本号0901 {
    public static void main(String[] args) {
        比较版本号0901 test = new 比较版本号0901();
        test.compareVersion("1.0.1", "1");
    }
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");

        int left = 0;
        int right = 0;
        while(left < str1.length && right < str2.length){
            int num1 = Integer.valueOf(getNewTargetString(str1[left]));
            int num2 = Integer.valueOf(getNewTargetString(str2[right]));
            if(num1 > num2){
                return 1;
            }else if(num1 == num2){
                left++;
                right++;
            }else{
                return 0;
            }
        }
        if(left < str1.length){
            int num1 = Integer.valueOf(getNewTargetString(str1[left]));
            left++;
            if(num1 > 0){
                return 1;
            }
        }
        if(right < str2.length){
            int num1 = Integer.valueOf(getNewTargetString(str2[right]));
            right++;
            if(num1 > 0){
                return -1;
            }
        }
        return 0;
    }

    public String getNewTargetString(String str){
        int index = 0;
        while(index < str.length() && str.charAt(index) == '0'){
            index++;
        }
        if(index == str.length()){
            return "0";
        }
        return str.substring(index, str.length());
    }
}
