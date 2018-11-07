package com.github.beisser.aud.search.binary_search;

class BinaryTemplateOne {


    public static void main(String[] args) {
        System.out.println(search());
    }

    public static int search() {

        int[] nums = {1, 2, 3, 5};
        int target = 2;

        int left = 0;
        int right = nums.length;

        while(left < right) {

            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }


        }

        if(left != nums.length && nums[left] == target) {
            return left;
        }

        return -1;
    }

}
