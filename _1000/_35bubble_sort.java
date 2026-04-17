package _1000;

public class _35bubble_sort {
    public static void bubble_sort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = i + 1; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        }
    }

    public static void main(String[] args) {

    }
}
