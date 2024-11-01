package 超级饮料的最大强化能量3259;

public class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        long[][] arr = new long[energyDrinkA.length][2];
        for (int i = 0; i < energyDrinkA.length; i++) {
            if(i == 0) {
                arr[i][0] = energyDrinkA[i];
                arr[i][1] = energyDrinkB[i];
            }else {
                arr[i][0] = Math.max(arr[i - 1][0] + energyDrinkA[i], arr[i - 1][1]);
                arr[i][1] = Math.max(arr[i - 1][1] + energyDrinkB[i], arr[i - 1][0]);
            }
        }
        return Math.max(arr[arr.length - 1][0], arr[arr.length - 1][1]);
    }
}
