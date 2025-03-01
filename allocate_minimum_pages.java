package geeks.searching;

public class allocate_minimum_pages {
    public static long findPages(int n, int[] arr, int m) {
        if (m > n) {
            return -1;
        }
        int sum = 0, mx = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            mx = Math.max(mx, arr[i]);
        }
        int low = mx, high = sum, res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isFeasible(arr, n, m, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
    public static boolean isFeasible(int arr[], int n, int m, int ans) {
        int req = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > ans) {
                req++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        return (req <= m);
    }
}
