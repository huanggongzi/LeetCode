package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/27/23:54
 * @Description:
 */
public class _20220227最优除法 {
    public String optimalDivision(int[] nums) {
        StringBuffer sb = new StringBuffer();
        if(nums.length == 1){
            return nums[0] + "";
        }
        if(nums.length == 2){
            return nums[0] + "" + "/" + nums[1];
        }
        sb.append(nums[0] + "/(");
        for(int i = 1; i < nums.length; i++){
            if(i == 1){
                sb.append(nums[i]);
            }else{
                sb.append("/" + nums[i]);
            }

        }
        sb.append(")");
        return sb.toString();
    }
}
