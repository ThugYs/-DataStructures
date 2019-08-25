package sort;

import java.util.Arrays;

/***
 * left child 2n+1
 * right child 2n+2
 * define arry.length = all tree Node and
 *
 */
public class HeapSort {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void comparator(int[] arr) {
       Arrays.sort(arr);
    }
    public static void downAdjust(int [] arr, int parentIndex, int length){
        //temp is save parent node
        int temp = arr[parentIndex];
        //index of left child node
        int child = 2 * parentIndex +1;
        while(child<length){
         if(child + 1< length && arr[child+1] > arr[child]){
             child++;
         }
         if( temp >= arr[child]){
             break;
         }
         arr[parentIndex] = arr[child];
         parentIndex = child;
         child  = child * 2 +1;
        }
        arr[parentIndex] = temp;
    }
    static void heapSort(int [] arr){
        for(int i = (arr.length - 2)/2; i>=0; i--){
            downAdjust(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        for(int i = arr.length -1; i>1; i--){
            swap(arr,0,1);
            downAdjust(arr, 0 ,i);
        }
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



//    public void heapify(int [] arr, int size) {
//    //define the cur node and left && right
//        /***
//         * step 1 get the max of left and right, compare father with max, if father is max, break
//         * step 2 swap father with the max one ( left or right),
//         * step 3 assume it's left, go back step 1 and father = left, start new loop
//         * step 4 loop until last one ( last = length-1), finally, the root will the max of tree
//         * step 5 swap root with last one , and the new heapify( arr, last -1)
//         */
//        //define left, current  , if the max = cur, it will break and heapify is done
//        int cur = 0;
//        int left = 2 * cur + 1;
//        while (left < size){
//            int max = 0;
//            if (right <= last) {
//                max = arr[left] > arr[right] ? left : right;
//            } else if (left == last) {
//                max = left;
//            } else if(cur ==last){
//                max = cur;
//            }
//            if (arr[cur] < arr[max]) {
//                swap(arr, cur, max);
//                cur = max;
//            }
//        }
//    }

}

