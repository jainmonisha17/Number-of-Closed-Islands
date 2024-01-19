# Number-of-Closed-Islands
Find the number of closed islands
We will traverse the matrix linearly to find islands. We can use the Depth First Search (DFS) or Breadth First Search (BFS) to traverse an island i.e., to find all of its connected land cells.

How do we decide if an island is a closed island?

To find that out, while traversing an island we need to ensure two things:

The island does not touch an edge.

Outside the boundary of the island are water cells.

For the first condition, whenever we go outside the boundary of the matrix during DFS or BFS, it means that one of the cells of the island is touching an edge; so, the island is not closed. The following code will cover this condition:

if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
     return false; // returning false since the island is touching an edge
For the second condition, we need to ensure that all the boundary cells of the island are water. Following code will take care of that:

if (matrix[x][y] == 0 || visited[x][y])
     return true; // returning true as the island is surrounded by water
