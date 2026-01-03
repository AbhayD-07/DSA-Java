public class subarray {
    // Kadane's algorithm: returns maximum subarray sum
    public static int kadane(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    // Kadane with indices: returns {maxSum, startIndex, endIndex}
    public static int[] kadaneWithIndices(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];
        int start = 0, end = 0, s = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxEndingHere + arr[i]) {
                maxEndingHere = arr[i];
                s = i;
            } else {
                maxEndingHere += arr[i];
            }
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }
        }
        return new int[]{maxSoFar, start, end};
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Array: " + java.util.Arrays.toString(arr));

        int max = kadane(arr);
        int[] res = kadaneWithIndices(arr);

        System.out.println("Max subarray sum = " + max); // simple result
        System.out.println("Max subarray sum with indices = sum: " + res[0] + ", start: " + res[1] + ", end: " + res[2]);
        System.out.println("Max subarray: " + java.util.Arrays.toString(java.util.Arrays.copyOfRange(arr, res[1], res[2] + 1)));
    }
}
