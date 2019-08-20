package sort;

/**
 * @author yangshu
 * @version 5.0.0
 * @created at 2019/8/5-9:51 AM
 * copyright @2019 Beijing Morong Information Techology CO.,Ltd.
 */
public class SelectionSort {
    public static void selectionSort(int [] arr){

        if(arr.length < 2 || arr == null){
            return;
        }
        for( int i = 0; i < arr.length ;i++){
            for(int j =i; j<arr.length-1; j++){
                //i compare with j+1
                if(arr[i] > arr[j+1]){
                    swap(i,j+1, arr);
                }
            }

        }

    }
    static void swap(int a, int b, int [] arr ) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void swapNew(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int [] arr = new int[]{6,5,1,2,4,3};
        print(arr);
        selectionSort(arr);
        System.out.println();
        print(arr);
        System.out.println();
    }
    public static void print(int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+",");
        }

    }

}
