import java.util.*;

class p15 {
    public static void main(String[] args) {

        int[] arr = {3, 4, -1, 1};

        // Find first missing positive
        Set<Integer> set = new HashSet<>();
        for (int x : arr) if (x > 0) set.add(x);

        int missing = 1;
        while (set.contains(missing)) missing++;

        System.out.println("Missing Positive: " + missing);

        // Binary search (after sorting)
        Arrays.sort(arr);

        int target = 3;
        int l = 0, r = arr.length - 1, index = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] == target) {
                index = mid;
                break;
            } else if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }

        System.out.println("Index of target: " + index);
    }
}