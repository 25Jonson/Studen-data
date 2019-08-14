
public class FiboArray {

    public static int getNthFiboNumber(int n, int[] arrFibo) {
        if (n < 0) {
            return 0;
        }
        if (arrFibo[n] > 0) {
            return arrFibo[n];
        }

        switch (n) {
            case 0:
                return n;
            case 1:
                arrFibo[n] = 1;
                return 1;
            default:
                arrFibo[n] = getNthFiboNumber(n - 1, arrFibo) + getNthFiboNumber(n - 2, arrFibo);
                return arrFibo[n];
        }
    }

    public static void printOutFiboArray(int[] arrFibo, int length) {
        for (int i = 0; i < length; i++) {
            System.out.printf("Fibo [%d]: %d\n", i + 1, arrFibo[i]);
        }
    }

    public static void main(String[] args) {
        int length = 45;
        int[] arrFibo = new int[length + 1];
        int sequence = FiboArray.getNthFiboNumber(length, arrFibo);

        System.out.println("The 45 sequence fibonacci: ");
        FiboArray.printOutFiboArray(arrFibo, length);
    }
}
