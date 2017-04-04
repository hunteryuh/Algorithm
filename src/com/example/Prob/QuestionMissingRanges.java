package com.example.Prob;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAU on 4/3/2017.
 */
public class QuestionMissingRanges {

    private  static List<String> findMissingRanges(int[] nums, int lower, int upper){
        //Step 1: Define return value
        List<String> rst = new ArrayList<>();
        // Step 2: handle corner cases
        if (nums == null || nums.length == 0){
            rst.add(lower + "->" + upper);
            return rst;
        }
        //Step 3: fill in business logic
        //first, add the range after lower
        addToList(rst,lower,nums[0]-1);
        // second, add all the ranges between lower and upper

        int prev = nums[0];
        int i = 1;
        while (i<nums.length){
            int cur = nums[i];
            if (cur!= prev+1){
                addToList(rst,prev+1,cur-1);
            }
            prev = cur;
            i++;
        }
        //third, add the range before upper

        addToList(rst,nums[nums.length-1],upper);
        return rst;
    }

    // supporting method
    private static void addToList( List<String> rst, int start, int end){
        if ( start == end) {
            rst.add(String.valueOf(start));
        }else if (start < end){
            rst.add(start + "->" + end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 90;
        List<String> rst = findMissingRanges(nums,lower,upper);
        System.out.println(rst.toString());
    }
}
