
import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int sum = triangle.get(i - 1).get(j - 1)
                            + triangle.get(i - 1).get(j);
                    row.add(sum);
                }
            }

            triangle.add(row);
        }

        return triangle.get(rowIndex);
    }
}
