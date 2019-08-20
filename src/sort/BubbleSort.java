package sort;


import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {
    static void bubble_sort(int[] unsorted) {
        //improve flag to check if swap happen
        System.out.println("bubble : time+O(n^2), spaceO(1)");
        if(unsorted == null || unsorted.length <2 ){
        return;
        }
        boolean flag = false;
        for (int i = 0; i < unsorted.length; i++) {
            //unsorted.length - i-1 不然j<unsorted.length - 0， j+1=unsorted.length - 0+1+1指针越界
            for (int j = 0; j < unsorted.length - i-1; j++) {
                if (unsorted[j] > unsorted[j+1]) {
//                    int temp =unsorted[j];
//                    unsorted[j] = unsorted[j+1];
//                    unsorted[j+1] = temp;
                    flag = true;
                    swap(j,unsorted);
                }
            }
            if(! flag ){
                break;
            }
            flag = false;
        }
    }
    static void swap(int a, int [] arr  ) {
        int temp = arr[a];
        arr[a] = arr[a+1];
        arr[a+1] = temp;
    }

    public static void print(int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+",");
        }
    }

    public static void main(String[] args) {

        int [] arr = new int[]{6,5,1,2,4,3};
        print(arr);
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
        bubble_sort(arr);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
        print(arr);
        System.out.println();
        }
}

