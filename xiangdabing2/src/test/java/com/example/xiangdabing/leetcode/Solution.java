package com.example.xiangdabing.leetcode;


/**
 * @author xiangmin
 * @date 2020/12/1 20:24
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int start = -1, end = -1;
        if(length == 0 || nums[length-1] < target) {
            return new int[]{start, end};
        }
        int i = length - 1;
        //找到第一个小于target的下标
        while(nums[i] >= target && i > 0) {
            i /= 2;
        }
        //找出第一个等于target的左下标
        while(i < length && nums[i] < target) {
            i++;
        }
        //没有找到相等的，说明不存在target
        if(nums[i] != target) {
            return new int[]{start, end};
        }
        start = i;
        //找出右下标
        while(i < length && nums[i] == target) {
            i++;
        }
        end = --i;
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        int [] a = {1,2,2,3,4};
        int t = 2;
        Solution solution=new Solution();
        solution.searchRange(a,t);
    }
}
