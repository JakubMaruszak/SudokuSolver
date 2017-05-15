import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Solver extends JButton implements ActionListener
	{
		
		private static final long serialVersionUID = 1L;
		private BigSquare sudoku;
		
		
		Solver()
		{
			super();
			this.setText("Solver");
			addActionListener(this);
		}

	

		@Override
		public void actionPerformed(ActionEvent e) {
			this.sudoku=Window.sudoku;
			Checking checking = new Checking();
			if (checking.lookForErrors(BigSquare.textFieldToCrisscross())==0)
			{
				new Calculations(BigSquare.textFieldToCrisscross());
				Window.square=Calculations.getTemp();
				
				JFrame resultwindow = new JFrame();
				JPanel results = new JPanel();
				results.setLayout(Window.gridlayout);
				JPanel A = new Grid();
				JPanel B = new Grid();
				JPanel C = new Grid();
				JPanel D = new Grid();
				JPanel E = new Grid();
				JPanel F = new Grid();
				JPanel G = new Grid();
				JPanel H = new Grid();
				JPanel I = new Grid();
				
				
				results.add(A);
				results.add(B);
				results.add(C);
				results.add(D);
				results.add(E);
				results.add(F);
				results.add(G);
				results.add(H);
				results.add(I);
				resultwindow.setPreferredSize(new Dimension(300,300));
				resultwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				resultwindow.setVisible(true);
				resultwindow.add(results);
				resultwindow.pack();
				for(int i=0; i<BigSquare.table.length; i++)
				{			
					for (int j=0; j<BigSquare.table.length; j++)
					{
						
						sudoku.dialoglist.put(BigSquare.table[i]+BigSquare.table[j], new Label(Integer.toString(Window.square[i][j])));				
						
						if(i<3)
						{
							if(j<3) A.add(sudoku.dialoglist.get(BigSquare.table[i]+BigSquare.table[j]));
							else if(j<6) B.add(sudoku.dialoglist.get(BigSquare.table[i]+BigSquare.table[j]));
							else C.add(sudoku.dialoglist.get(BigSquare.table[i]+BigSquare.table[j]));
						}
						else if(i<6)
						{
							if(j<3) D.add(sudoku.dialoglist.get(BigSquare.table[i]+BigSquare.table[j]));
							else if(j<6) E.add(sudoku.dialoglist.get(BigSquare.table[i]+BigSquare.table[j]));
								else F.add(sudoku.dialoglist.get(BigSquare.table[i]+BigSquare.table[j]));
						}
						else
						{
							if(j<3) G.add(sudoku.dialoglist.get(BigSquare.table[i]+BigSquare.table[j]));
							else if(j<6) H.add(sudoku.dialoglist.get(BigSquare.table[i]+BigSquare.table[j]));
							else I.add(sudoku.dialoglist.get(BigSquare.table[i]+BigSquare.table[j]));
						}	
						
					}
				}
			}
			else
			{
				new Dialog("Written sudoku have some errors");
			}
			
		}
	}