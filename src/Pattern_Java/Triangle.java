package Pattern_Java;


import java.util.Scanner;

public class Triangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of n: ");
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
//            for(int j=1;j<=i;j++){
//                //System.out.print("* ");
//                System.out.print((char)(j+64)+" ");
//            }
//            for(int j=n;j>=i;j--){
//                //System.out.print("* ");
//                System.out.print(j+" ");
//                //System.out.print((char)(i+64)+" ");
//            }
            for(int j =1; j<=n+1-i;j++){
                //System.out.print(j+" ");
                System.out.print((char)(j+96)+ " ");
            }
            System.out.println();
        }
    }
}
