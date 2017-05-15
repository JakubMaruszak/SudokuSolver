
public class Calculations {
	int[][] sudoku = new int[9][9];
	static int[][] temp = new int[9][9];
	
	Calculations(int[][] sudoku)
	{
		
		this.sudoku=sudoku;
		temp=rewrite(sudoku);
		findValue(0, 0);
	}

	public static int[][] getTemp() {
		return temp;
	}



	int[][] rewrite(int[][] sudoku)
	{
		for (int i=0; i<9; i++)
		{
			for (int j=0; j<9; j++)
			{
				temp[j][i]=sudoku[j][i];
			}
		}
		return temp;
	}

	boolean nextGrid(int x, int y)
	{
		if((x==8) && (y==8)) return true;
		else if (x==8) return findValue(0, y+1);
		return findValue(x+1, y);
	}
	
	boolean check(int x, int y, int n)
	{
		if(rowCheck(x,n)||columnCheck(y,n)|| smallSquareCheck(x, y, n)) return false;
		else return true;
	}
	
	boolean rowCheck(int x, int n)
	{
		for (int i=0; i<9; i++)
		{
			if (temp[x][i]==n) return true;
			
		}
		return false;
		
	}
	
	boolean columnCheck(int y, int n)
	{
		for (int i=0; i<9; i++)
		{
			if (temp[i][y]==n) return true;
			
		}
		return false;
	}
	
	boolean smallSquareCheck(int x, int y, int n)

	{
		int small_x=x/3;
		int small_y=y/3;
		for(int i=0; i<3; i++)
		{
			for (int j=0; j<3; j++)
			{
				if(temp[small_x*3+j][small_y*3+i]==n ) return true;
			}
		}
		return false;
		
	}
	
	boolean findValue (int x, int y)
	{
		if (temp[x][y]==0)
		{
			for (int i=1; i<=9; i++)
			{
				if(check(x,y,i))
				{
					temp[x][y]=i;
					showTemp();
					if(nextGrid(x, y)) return true;
				}
				
			}
			temp[x][y]=0;
			return false;
		}
		return nextGrid(x, y);
	}
	
	void showTemp()
	{
		 for(int i=0; i<9; i++) {
	         for(int j=0; j<9; j++) {
	             System.out.print(temp[i][j]);
	         } System.out.print("\n");
	     }
		 System.out.print("\n");
	}
}



