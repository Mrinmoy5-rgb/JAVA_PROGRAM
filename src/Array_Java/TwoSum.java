package Array_Java;

public class TwoSum {
    public static void main(String[] args){
        int[] arr = {1, 5, 52, 2, 3, 8, 9};
        int target = 13;
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j= i+1;j<n;j++){
                if(arr[i] + arr[j] == target){
                    System.out.print(i +" "+j);
                }
            }
        }
    }
}
