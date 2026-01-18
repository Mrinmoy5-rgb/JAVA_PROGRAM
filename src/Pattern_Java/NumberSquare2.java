package Pattern_Java;

import java.util.Scanner;

public class NumberSquare2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n= sc.nextInt();
        for(int i = 1; i<= n;i++){
            for(int j = 1; j<=n;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// FOR ALPHABET SQUARE PRINTING WE HAVE TO ADD 64 WITH J (j+64) AND TYPECAST IT TO (CHAR)
// TO PRINT THE ALPHABET BECAUSE ASCII VALUE OF "A" is 65 and "a" is 97

