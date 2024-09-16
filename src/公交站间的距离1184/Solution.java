package 公交站间的距离1184;

public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int[] temp = new int[2];
        for (int i = 0; i < distance.length; i++) {
            if ((i >= start && i < destination) || (i < start && i >= destination)) {
                temp[0] += distance[i];
            }else {
                temp[1] += distance[i];
            }
        }
        return Math.min(temp[0], temp[1]);
    }
}
