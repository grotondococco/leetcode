import java.util.Arrays;

public class Solution1921 {

    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] timeToArrive = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            timeToArrive[i] = (double) dist[i] / speed[i];
        }
        Arrays.sort(timeToArrive);
        for (int i = 0; i < dist.length; i++) {
            if (timeToArrive[i] <= i) return i;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] dist = new int[]{4, 8, 6, 8, 2, 7, 4};
        int[] speed = new int[]{1, 3, 3, 1, 10, 1, 1};
        System.out.println(new Solution1921().eliminateMaximum(dist, speed));
    }

}