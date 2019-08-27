
public class BubbleArray {

    Validator v = new Validator();

    public int[] inputArray() {
        System.out.println("====Input Element====");
        //get array sizw
        int length = v.checkInt("");
        int[] arr = new int[length];

        //get array value
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Enter number %d:", i + 1);
            arr[i] = v.checkInt("");
            System.out.println();
        }
        return arr;
    }

    //BUBBLESORT ASC
    public int[] bubbleSortAsc(int[] a) {
        try {
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] > a[j]) { //check if the before number is bigger than the after
                        int temp = a[j];
                        a[j] = a[i];
                        a[i] = temp;
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("There is no value to sort");
        }
        return a;
    }
    //BUBBLESORT DESC

    public int[] bubbleSortDesc(int[] a) {
        try {
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] < a[j]) { //check if the after number is bigger than the before
                        int temp = a[j];
                        a[j] = a[i];
                        a[i] = temp;
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("There is no value to sort");
        }
        return a;
    }

    //DISPLAY THE ARRAY
    public void displayArray(int[] a) {
        try {
            System.out.printf("[%d]", a[0]);
            for (int i = 1; i < a.length; i++) {
                System.out.printf("->[%d]", a[i]);
            }
            System.out.println();
        } catch (NullPointerException e) {

        }
    }
}
