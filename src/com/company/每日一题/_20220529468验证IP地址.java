package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/29/23:04
 * @Description:
 */
public class _20220529468验证IP地址 {
    public static void main(String[] args) {
        _20220529468验证IP地址 test = new _20220529468验证IP地址();
        test.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334");
    }

    public String validIPAddress(String queryIP) {
        String[] strs = queryIP.split("\\.");
        // 可能是 IPv4
        if(strs.length == 4 && queryIP.charAt(queryIP.length() - 1) != '.'){
            for(int i = 0; i < strs.length; i++){
                if(!isIPv4(strs[i])){
                    System.out.println(strs[i]);
                    return "Neither";
                }
            }
            return "IPv4";
        }
        strs = queryIP.split(":");

        // 可能是 IPv6
        if(strs.length == 8 && queryIP.charAt(queryIP.length() - 1) != ':'){
            for(int i = 0; i < strs.length; i++){
                if(!isIPv6(strs[i])){
                    return "Neither";
                }
            }
            return "IPv6";
        }

        return "Neither";
    }

    /**
     * 验证是否是IPv4
     */
    public boolean isIPv4(String str){
        if(str == null || str.length() == 0 || str.length() >= 4){
            return false;
        }
        boolean start = true;
        for(int i = 0; i < str.length(); i++){
            // 如果不为数字的话，直接为 false
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                return false;
            }else if(str.charAt(i) == '0' && start){
                if(str.length() > 1){
                    return false;
                }
            }else{
                start = false;
            }
        }
        int num = Integer.valueOf(str);
        if(num >= 0 && num <= 255){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 验证是否是IPv6
     */
    public boolean isIPv6(String str){
        try {
            Integer.valueOf(str,16).toString();
        }catch (Exception e){
            return false;
        }
        if(str == null || str.length() == 0){
            return false;
        }
        int len = str.length();
        if(len < 1 || len > 4){
            return false;
        }

        for(int i = 0; i < len; i++){
            if((str.charAt(i) >= '0' && str.charAt(i) <= '9') || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')){
            }else{
                return false;
            }
        }
        return true;

    }
}
