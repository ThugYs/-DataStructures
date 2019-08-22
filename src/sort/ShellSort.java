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
    public static void shellSort2(int [] arr){
        //outer loop with cal gap, gap begin with arr.length/2
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            // i = gap, i++, compare arr[i] with arr[i-gap]
            for(int i = gap; i < arr.length; i++) {
                int point = i;
                //
                int temp = arr[i];
                //check whether arr[i] > arr[i-gap], else inital insert sort process until next loop
                if (arr[i] < arr[i - gap]) {
                    //check point = point - gap and temp(min) < arr [point-gap]
                    while(point - gap >= 0 && temp < arr[point - gap]) {
                       // if temp(min) < arr [point-gap]
                        //swap point and point - gap. cuz point already swap with point + gap,. but temp already keep min
                        arr[point] = arr[point - gap];
                        point -= gap;
                    }
                    //finaly, temp >  arr[point - gap], swap with its next one point - gap +gap( same as insert)
                    arr[point] = temp;
                }
            }
        }

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
        shellSort2(a);
        System.out.println(Arrays.toString(a));
    }
}
