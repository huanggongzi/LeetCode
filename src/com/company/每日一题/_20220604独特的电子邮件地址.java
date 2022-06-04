package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/06/04/23:25
 * @Description:
 */
public class _20220604独特的电子邮件地址 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for(int i = 0; i < emails.length; i++){
            set.add(getNewString(emails[i]));
        }

        return set.size();
    }

    public String getNewString(String oldString){
        StringBuffer sb = new StringBuffer();
        String[] strs = oldString.split("@");
        for(int i = 0; i < strs[0].length(); i++){
            if(oldString.charAt(i) == '+'){
                break;
            }else if(oldString.charAt(i) == '@'){
                sb.append(oldString.charAt(i));
            }else if(oldString.charAt(i) == '.'){
                continue;
            }else{
                sb.append(oldString.charAt(i));
            }
        }
        sb.append("@" + strs[1]);
        //System.out.println(sb.toString());
        return sb.toString();
    }
}
