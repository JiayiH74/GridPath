public class GridPath {
   
    private int[][] grid;
    public GridPath (int[][]values)
    {
        grid = values;
    }
   
    public Location getNextLoc(int row, int col)           //depending on if there are more neighbors below or to the right, it prints based on the amount
    {
        int below = Integer.MAX_VALUE;
        if(row < grid.length - 1) below = grid[row + 1][col];   
        int right = Integer.MAX_VALUE;
        if(col < grid[0].length - 1) right = grid[row][col + 1];    //if there are more neighbors to the right than there are below, it returns the neighbor to the right
        if (below < right) return new Location(row + 1, col);
        else return new Location(row, col + 1);                     //else, it returns the neightbor below
    }

    public int sumPath(int row, int col) //compares the value to the right and bottom of chosen value and chooses the smaller one
    {
        int sum = grid[row][col];
        while(row < grid.length - 1 || col < grid[0].length - 1)
        {
            Location loc = getNextLoc(row, col);
            row = loc.getRow();
            col = loc.getCol();
            sum += grid[row][col];
        }
        return sum;
    }

    public String toString()
    {
        String s = "";
        for (int row = 0; row < grid.length; row++) // traversing each row
        {
            for (int col = 0; col < grid[0].length; col++) //traversing each column, incrementing
            {
                s += grid[row][col] + " "; // access the array at the column and row
            }
            s += "\n"; //after each column is checked for each row it breaks a new line
        }
        return s;
    }
}