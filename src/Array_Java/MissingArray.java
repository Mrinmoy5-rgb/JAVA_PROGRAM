package Array_Java;

public class MissingArray {
    static int missing(int[] arr){
        int n = arr.length + 1;
        int total = n*(n+1) /2;
        int summ = 0;
        for(int num: arr){
            summ += num;
        }
        return total - summ;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 5};
        int miss = missing(arr);
        System.out.println(miss);
    }
}
