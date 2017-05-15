


public class Checking {
	/**
	 * 
	 */
	
	BigSquare sudoku;
	int[][] temp;
	int error;
	int empty;
	
	
	String getMessage()
	{
		temp=BigSquare.textFieldToCrisscross();
		return message(lookForErrors(temp),lookForEmpty(temp));	
	}
	
	int lookForEmpty(int[][] sudoku)
	{
		empty=0;
		for(int i=0; i<9; i++)
		{
			for (int j=0; j<9; j++)
			{
				if(sudoku[i][j]==0) return empty=1;
			}
		}
		return empty;
	}
	
	int lookForErrors(int[][] sudoku)
	{
		error=0;
		rowCheck(sudoku);
		columnCheck(sudoku);
		smallSquareCheck(sudoku);
		return error;
		
		
	}
	void rowCheck(int[][] sudoku)
	{
		for(int i=0; i<9; i++)
		{
			for (int j=0; j<9; j++)
			{
				for (int r=0; r<9; r++)
				{
					
					if (r==j) break;
					else if(sudoku[i][j]==0) break;
					else if (sudoku[i][j]==sudoku[i][r]) error=1;
					
					
			
		}
			}}
	}
	
	void columnCheck(int[][] sudoku)
	{
		for(int i=0; i<9; i++)
		{
			for (int j=0; j<9; j++)
			{
				for (int r=0; r<9; r++)
				{
					
					if (r==i) break;
					else if(sudoku[i][j]==0) break;
					else if (sudoku[i][j]==sudoku[r][j]) error=1;
					
					
			
		}
			}}
	}
	
	void smallSquareCheck(int[][] sudoku)

	{
		
		for(int i=0; i<3; i++)
		{
			for (int j=0; j<3; j++)
			{
				int small_x=i/3;
				int small_y=j/3;
				for(int m=0; m<3; m++)
				{
					for (int n=0; n<3; n++)
					{
						if(m==i&&n==j) break;
						else if(sudoku[i][j]==0) break;
						else if(sudoku[small_x*3+m][small_y*3+n]==sudoku[small_x*3+j][small_y*3+i]) error=1;
					}
				}
				
			}
		}
	
		
	}
	
	String message (int error, int empty)
	{
		String message;
		
		if(empty==1)	 
			{
				message="There are some empty spaces";
				if(error==1)
				{
					message+=" and some errors";
				}
			}
		else if(error==1)	message = "Sudoku have some errors";
		else message = "Sudoku is done well";
		return message;
	}

}
