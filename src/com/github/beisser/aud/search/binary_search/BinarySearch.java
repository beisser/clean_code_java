package com.github.beisser.aud.search.binary_search;

class BinaryTemplateOne {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        System.out.println(recursiveBinarySearch(nums, 0, nums.length, 3));
    }

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }


    public static int recursiveBinarySearch(int[] nums, int left, int right, int x) {
        System.out.println("[" + left + "..." + right + "]");

        if(left > right) {
            return -1;
        } else {

            int mid = left + (right - left) / 2;
            if(nums[mid] == x) {
                return mid;
            } else if(nums[mid] > x) {
                return recursiveBinarySearch(nums, left, mid - 1, x);
            } else {
                return recursiveBinarySearch(nums, mid + 1, right, x);
            }

        }

    }
}
