public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        

        int[] sources = new int[5];
        sources[j] = 1;
        return findShortestPathRecersive(m, i, j, sources);



    }


    public static int findShortestPathRecersive(int[][] m, int i, int j, int[] sources)
    {
        if (i == j)
        {
            return 0;
        }

        boolean found_path = false;

        int[] poss_paths = new int[5];
        
        for (int k = 0; k<m[j].length; k++)
        {
            if (sources[k] != 1 && m[k][j] == 1)
            {
                sources[k] = 1;
                poss_paths[k] = 1 + findShortestPathRecersive(m, i, k, sources);
                if (poss_paths[k] != 0)
                {
                    found_path = true;
                }
            }
        }

        
        if (!found_path)
        {
            return  -1;
        }


        return getArrayMin(poss_paths);

    }

    public static int getArrayMin(int[] arr)
    {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i<arr.length; i++)
        {
            if (arr[i] != 0 && arr[i] < min)
            {
                min = arr[i];
            }
        }

        return  min;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}