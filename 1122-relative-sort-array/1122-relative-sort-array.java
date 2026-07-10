class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();

        // Count frequency of each element in arr1
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[arr1.length];
        int index = 0;

        // Place elements according to arr2
        for (int num : arr2) {
            int count = map.get(num);
            while (count-- > 0) {
                result[index++] = num;
            }
            map.remove(num);
        }

        // Store remaining elements
        List<Integer> remaining = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            while (count-- > 0) {
                remaining.add(num);
            }
        }

        // Sort remaining elements
        Collections.sort(remaining);

        // Add remaining elements
        for (int num : remaining) {
            result[index++] = num;
        }

        return result;
    }
}