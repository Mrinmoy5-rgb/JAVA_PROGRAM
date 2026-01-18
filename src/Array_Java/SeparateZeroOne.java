package Array_Java;

import java.util.Arrays;

public class SeparateZeroOne {
    static void separate(int[] arr){
        int count = 0;
        for(int num: arr){
            if (num == 0){
                count++;
            }
        }
        for(int i=0; i<arr.length;i++){
            if(i <count ){
                arr[i] = 0;
            } else{
                arr[i] = 1;
            }
        }
    }
    public static void main(String[] args){
        int[] arr = { 1 , 0 , 0 , 1 , 1 , 1 , 0 , 1 , 0, 1 , 1 , 0};
        separate(arr);
        for(int s: arr){
            System.out.print(s+" ");
        }
    }
}
