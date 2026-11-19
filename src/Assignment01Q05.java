public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) {
            return 0;
        }
        int len = m.length;
        int[] dist = new int[len];
        for (int k = 0; k < len; k++) {
            dist[k] = -1; 
        }
        dist[i] = 0;
        int[] queue = new int[len];
        int start = 0, end = 0;
        queue[end++] = i; 
        while (start < end) {
            int current = queue[start++];

            for (int next = 0; next < len; next++) {
                if (m[current][next] == 1 && dist[next] == -1){ //if we havent checked this node yet
                    dist[next] = dist[current] + 1; //
                    if (next == j) {
                        return dist[next];
                    }
                    queue[end++] = next;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 0, 1)); // -1
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 1, 1)); // 0
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, { 1, 0, 0, 0 } }, 0, 2)); // 2
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } }, 0, 2)); // 2
    }
}