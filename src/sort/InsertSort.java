//package sort;
//
///**
// * @author yangshu
// * @version 5.0.0
// * @created at 2019/8/5-3:57 PM
// * copyright @2019 Beijing Morong Information Techology CO.,Ltd.
// */
//
//import static sort.CompatorUtil.*;
//
////1,2,4,1-> 1,2,1,4->1,1,2,4
//public class InsertSort {
//
//    static void insertSort(int [] arr){
//        if (arr == null || arr.length < 2) {
//            return;
//        }
//        for (int i =1; i< arr.length; i++){
//            for(int j=i-1; j>=0 &&arr[j]>arr[j+1];j--){
//               CompatorUtil.swap(arr,j,j+1);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        int testTime = 50000;
//        int maxSize = 100;
//        int maxValue = 100;
//        boolean succeed = true;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            insertSort(arr1);
//            comparator(arr2);
//            if (!isEqual(arr1, arr2)) {
//                succeed = false;
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//        int[] arr = generateRandomArray(maxSize, maxValue);
//        printArray(arr);
//        insertSort(arr);
//        printArray(arr);
//    }
//
//
//}
