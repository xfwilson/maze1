public class Maze1 {
	public static void main (String [] args) {
		String[][] maze = new String[][]{
			//{"","","",""},
			//{"S","X","X",""},
			//{"X","F","",""}
			// {"X","X","","","X","X","","","","X","","X","","","","",""},
			// {"","S","X","","","X","X","","","","X","","X","","X","",""},
			// {"","","X","","","","X","","","X","F","","","","","","X"},
			// {"X","","","","X","X","","","X","X","X","X","","X","","",""},
			// {"X","X","X","","X","X","X","X","X","X","X","X","","X","X","X","X"},
			// {"X","X","","","","","","","","","","X","","X","","",""},
			// {"X","X","","","","","X","X","X","X","X","","","X","","X",""},
			// {"X","X","","","","","","","","","","","","","X","",""}
			
			{"S","","",""},
			{"X","X","","X"},
			{"","","",""},
			{"","","","F"}
		};
		String stepsTaken = "";
		int x=0;
		int y=0;
		for (int i = 0; i < maze.length; i++) {
			String [] row = maze[i];
			for (int j = 0; j < row.length; j++) {
				if (row[j].equals("S")) {
					x = j;
					y = i;
				}
			}
		}
		System.out.println(""+y+""+x);
		System.out.println(maze[y][x]);
		proceed(maze, stepsTaken, x, y, false);
	}
	
	public static boolean proceed(String [][] maze, String stepsTaken, int x, int y, boolean found) {
		boolean done = found;
		
		// Base-case = End of maze found!
		if (done || maze[y][x].equals("F")) {
			System.out.println(stepsTaken);
			done = true;
		}
		else {
			// Stop backtracking, so block once we move on
			maze[y][x]="X";
			
			if (!done && checkStep(maze,x,y-1)) {
				stepsTaken += "\nN";
				System.out.println("path: " + stepsTaken);
				done = proceed(maze, stepsTaken, x, y-1, done);
			}
			if (!done && checkStep(maze,x+1,y)) {
				stepsTaken += "\nE";
				System.out.println("path: " + stepsTaken);
				done = proceed(maze, stepsTaken, x+1, y, done);
			}
			if (!done && checkStep(maze,x,y+1)) {
				stepsTaken += "\nS";
				System.out.println("path: " + stepsTaken);
				done = proceed(maze, stepsTaken, x, y+1, done);
			}
			if (!done && checkStep(maze,x-1,y)) {
				stepsTaken += "\nW";
				System.out.println("path: " + stepsTaken);
				done = proceed(maze, stepsTaken, x-1, y, done);
			}
		}
		System.out.println("Hit dead end at "+x+","+y);
		return false;
	};
	
	public static boolean checkStep(String [][] maze, int x, int y) {
		boolean available = true;
		
		// Shortened version
		//if (x < 0 || y < 0 || x >= maze[0].length || y >= maze.length || maze[y][x].equals("X"))
			//available = false;
		
		// debugging version
		if (x<0) {System.out.println("x less than 0: " + x); available = false;}
		else if (y<0) {System.out.println("y less than 0: " + y); available = false;}
		else if (x >= maze[0].length) {System.out.println("x out of bounds: " + x + " maze[0].length"); available = false;}
		else if (y >= maze.length) {System.out.println("y out of bounds: " + y + " maze.length"); available = false;}
		else if (maze[y][x].equals("X")) {System.out.println("wall at " + x + "," + y + "; " + maze[y][x]); available = false;}
		else
			System.out.println(x+","+y+" is available");
		return available;
	};
}