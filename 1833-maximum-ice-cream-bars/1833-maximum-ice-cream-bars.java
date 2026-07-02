public class Solution {
    public int maxIceCream(int[] costs, int coins) {
       
        int maxCost = 0;
        for (int cost : costs) {
            maxCost = Math.max(maxCost, cost);
        }

        int[] count = new int[maxCost + 1];
        for (int cost : costs) {
            count[cost]++;
        }

        int barsBought = 0;

        for (int cost = 1; cost <= maxCost && coins > 0; cost++) {
            if (count[cost] > 0) {
                // How many bars of this cost can we afford?
                int canAfford = Math.min(count[cost], coins / cost);
                barsBought += canAfford;
                coins -= canAfford * cost;
            }
        }

        return barsBought;
    }
}