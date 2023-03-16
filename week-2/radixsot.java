public class RadixSort {
    public static int[] radixSort(int[] arr) {
        int maxNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
            }
        }

        int exp = 1;
        while (maxNum / exp > 0) {
            int[] count = new int[10];
            for (int i = 0; i < arr.length; i++) {
                int index = arr[i] / exp;
                count[index % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                count[i] += count[i-1];
            }
            int[] output = new int[arr.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                int index = arr[i] / exp;
                output[count[index % 10] - 1] = arr[i];
                count[index % 10]--;
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = output[i];
            }
            exp *= 10;
        }
        return arr;
    }
}
