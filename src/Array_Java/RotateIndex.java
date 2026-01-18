package Array_Java;


public class RotateIndex {
    static void rotate(int[] arr,int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    static void rotateIndex(int[] arr, int d){
        int n = arr.length;
        d = d%n;
        rotate(arr, 0, d-1);
        rotate(arr, d, n-1);
        rotate(arr, 0, n-1);

    }
    public static void main(String[] args){
        int[] arr = {6, 8, 1, 2, 4, 9, 7};
        int d = 3;
        rotateIndex(arr, d);
        for(int num: arr){
            System.out.print(num+" ");
        }
    }
}
