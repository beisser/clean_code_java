package com.github.beisser.challenges.array;

class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 24;

        int left = 0;
        int right = arr.length - 1;

        System.out.println(binarySearch(arr, target,left,right));

    }

    public static int binarySearch(int[] arr, int target, int left, int right) {

        if(left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if(arr[mid] == target) {
            return mid;
        } else if(target > arr[mid]) {
            return binarySearch(arr,target,mid + 1, right);
        } else {
            return binarySearch(arr,target,left, mid - 1 );
        }

    }

}
