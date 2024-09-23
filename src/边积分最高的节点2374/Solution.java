package 边积分最高的节点2374;

public class Solution {
    public int edgeScore(int[] edges) {
        long[] arr = new long[edges.length];
        int minIndex = 0;
        for (int i = 0; i < edges.length; i++) {
            arr[edges[i]] += i;
            if (arr[edges[i]] >= arr[minIndex]) {
                minIndex = arr[edges[i]] == arr[minIndex] ? Math.min(edges[i], minIndex) : edges[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        return minIndex;
    }
}
