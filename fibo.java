

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class fibo {

    static int fib(int n, int[] arrFibo) {
        if (n < 0) {
            return 0;
        }
        if (arrFibo[n] > 0) {
            return arrFibo[n];
        }

        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                arrFibo[n] = fib(n - 1, arrFibo) + fib(n - 2, arrFibo);
                return arrFibo[n];
        }
    }

    public static void main(String args[]) {
        int lengh = 45;
        int[] arrFibo = new int[lengh + 1];
        for (int i = 0; i < lengh; i++) {
            int sequence = fib(i, arrFibo);
            System.out.printf("Fibo [%d]: %d\n", i + 1, arrFibo[i]);
        }
    }
}
