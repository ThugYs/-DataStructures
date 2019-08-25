package sort;

/***
 * left child 2n+1
 * right child 2n+2
 * define arry.length = all tree Node and
 *
 */
public class HeapSort {
    public void heapSort(int [] arr){
        int length = arr.length;
        if (arr == null || arr.length < 2) {
            return;
        }

        for(int i = 0; i < length-1; i++){

            heapify(arr, length-i);
            swap(arr, 0, --length);
        }

    }
    public void swap(int [] arr, int value1, int value2){

    }
    public void heapInsert(int [] arr, int newNode){


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



    public void heapify(int [] arr, int last) {
        int cur = 0;
        while (true){
            int left = 2 * cur + 1;
            int right = 2 * cur + 2;
            int max = 0;
            if (right <= last) {
                max = arr[left] > arr[right] ? left : right;
            } else if (left == last) {
                max = left;
            } else if(cur ==last){
                max = cur;
            }
            if (arr[cur] < arr[max]) {
                swap(arr, cur, max);
                cur = max;
            }
        }
    }

}

