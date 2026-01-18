package Array_Java;

public class WaveArray {
    public static void convert(int[] arr){
        int n = arr.length;

        for(int i =0; i<n;i+=2){
            if(i>0 && arr[i] < arr[i-1]){
                swap(arr,i,i-1);
            }
            if(i<n-1 && arr[i] < arr[i+1]){
                swap(arr, i,i+1);
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        int[] arr = {1, 3, 5, 7, 9, 11};
        convert(arr);
        for(int num: arr){
            System.out.print(num+" ");
        }
    }
}
