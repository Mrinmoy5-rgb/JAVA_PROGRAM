package Array_Java;

public class SecondMaximum {
    public static void main(String[] args){
        int[] arr = {1, 5, 52, 2, 3, 8, 9};
        int max = Integer.MIN_VALUE;
        int sMax = Integer.MIN_VALUE;
        for(int i=0;i< arr.length;i++){
            if (arr[i]>max){
                sMax = max;
                max = arr[i];
            }
            else if (arr[i]> sMax && arr[i] != max){
                sMax = arr[i];
            }
        }
        System.out.println(max);
        System.out.println(sMax);
    }
}
