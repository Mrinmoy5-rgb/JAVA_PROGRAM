package Array_Java;

public class AddMultiply {
    public static void main(String[] args){
        int[] arr = {10,20,30,40,50,60};
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(i%2 == 0){
                arr[i] += 10;
            } else{
                arr[i] *= 2;
            }
        }
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
}
