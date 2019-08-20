package sort;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {
    public static void shellSort(int [] arr){
        //被除数 是2
        int addValue = 2;
        //loop with i+gap
        int gap = arr.length/addValue;
        //outer loop with cal gap
        int temp;
        for(;gap >0; gap/= addValue){
            //inner loop i + gap
            for( int i=gap; i < arr.length; i++){
               if( arr[i]> arr[i - gap]){
                   temp = arr[i];
                   int k = i - gap;
                   while ( k>0 && arr[k] > temp){
                       arr[k + gap] = arr[k];
                       k -= gap;
                   }
                   arr[k+gap] = temp;
               }
            }
        }
    }
    public static void shellSort2(){

    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            Random rd = new Random();
            a[i] = rd.nextInt(10);
        }
        System.out.println("random");
        System.out.println(Arrays.toString(a));

        System.out.println("shell sort");
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }
}
