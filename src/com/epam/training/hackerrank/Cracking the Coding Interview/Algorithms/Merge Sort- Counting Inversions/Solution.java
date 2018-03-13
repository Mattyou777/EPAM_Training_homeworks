import java.util.Scanner;

public class Solution {
    static long count = 0;

    static long countInversions(int[] arr) {
        count = 0;
        countInversions(arr, new int[arr.length], 0, arr.length - 1);
        return count;
    }

    static void countInversions(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd)
            return;
        else {
            int middle = (rightEnd + leftStart) / 2;
            countInversions(arr, temp, leftStart, middle);
            countInversions(arr, temp, middle + 1, rightEnd);
            merge(arr, temp, leftStart, rightEnd);
        }
    }

    static void merge(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
                count += leftEnd + 1 - left;
            }
            index++;
        }
        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            long result = countInversions(arr);
            System.out.println(result);
        }
        in.close();
    }
}
