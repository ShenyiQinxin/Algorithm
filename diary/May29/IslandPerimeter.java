class IslandPerimeter {
    static int islandPerimeter(int[][] grid) {
        int isLands = 0, neighbours = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    isLands++;
                    if ((i < grid.length - 1) && (grid[i + 1][j] == 1)) {
                        neighbours++;
                    }
                    if ((j < grid[i].length - 1) && (grid[i][j + 1] == 1)) {
                        neighbours++;
                    }
                }
            }
        }
        return isLands * 4 - neighbours * 2;
    }

    public static void main(String[] args) {
        //merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
        int[][] array = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(array));
    }
}