import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private Solver solve;
	private Check check;
	private JPanel buttonPanel;
	private JPanel parentPanel;
	static int[][] square;
	static GridLayout gridlayout = new GridLayout(3,3);
	public static BigSquare sudoku;
	static JPanel ccPanel;
	Clear clear;
	JPanel a;
	JPanel b;
	JPanel c;
	JPanel d;
	JPanel e;
	JPanel f;
	JPanel g;
	JPanel h;
	JPanel k;

	public Window() {
		super("Sudoku Solver");

		sudoku = new BigSquare();
		ccPanel = new JPanel();
		
		a = new Grid();
		b = new Grid();
		c = new Grid();
		d = new Grid();
		e = new Grid();
		f = new Grid();
		g = new Grid();
		h = new Grid();
		k = new Grid();
		
		
		
		loadTiles();
		ccPanel.add(a);
		ccPanel.add(b);
		ccPanel.add(c);
		ccPanel.add(d);
		ccPanel.add(e);
		ccPanel.add(f);
		ccPanel.add(g);
		ccPanel.add(h);
		ccPanel.add(k);
		
			
		
		
		ccPanel.setLayout(new GridLayout(3, 3));
		clear = new Clear();
		check = new Check();
		solve = new Solver();
		parentPanel = new JPanel();
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 3));
		buttonPanel.add(clear);
		buttonPanel.add(check);
		buttonPanel.add(solve);
		parentPanel.setLayout(new FlowLayout());
		ccPanel.setPreferredSize(new Dimension(300,300));
		buttonPanel.setPreferredSize(new Dimension(250,20));
		parentPanel.add(ccPanel);
		
		parentPanel.add(buttonPanel);

		this.add(parentPanel);
	}
	
	public class Clear extends JButton implements ActionListener
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		Clear()
		{
			super();
			this.setText("Clear");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			loadTiles();
		}
	}
		void loadTiles()
		{
			a.removeAll();
			b.removeAll();
			c.removeAll();
			d.removeAll();
			e.removeAll();
			f.removeAll();
			g.removeAll();
			h.removeAll();
			k.removeAll();
			for (int i = 0; i < BigSquare.table.length; i++) {
				for (int j = 0; j < BigSquare.table.length; j++) {
					BigSquare.list.put(BigSquare.table[i] + BigSquare.table[j], new TextField("0"));
				}
			}
			for (int i = 0; i < BigSquare.table.length; i++) {
				for (int j = 0; j < BigSquare.table.length; j++) {
					if(i<3)
					{
						if(j<3) a.add(BigSquare.list.get(BigSquare.table[i] + BigSquare.table[j]));
						else if	(j<6) b.add(BigSquare.list.get(BigSquare.table[i] + BigSquare.table[j]));
						else c.add(BigSquare.list.get(BigSquare.table[i] + BigSquare.table[j]));
					}
					else if(i<6)
					{
						if(j<3) d.add(BigSquare.list.get(BigSquare.table[i] + BigSquare.table[j]));
						else if	(j<6) e.add(BigSquare.list.get(BigSquare.table[i] + BigSquare.table[j]));
						else f.add(BigSquare.list.get(BigSquare.table[i] + BigSquare.table[j]));
					}
					else 
					{
						if(j<3) g.add(BigSquare.list.get(BigSquare.table[i] + BigSquare.table[j]));
						else if	(j<6) h.add(BigSquare.list.get(BigSquare.table[i] + BigSquare.table[j]));
						else k.add(BigSquare.list.get(BigSquare.table[i] + BigSquare.table[j]));
					}
					
				
				}
			}	
			a.revalidate();
			repaint();
			a.repaint();
			ccPanel.repaint();
			
			b.revalidate();
			revalidate();
			ccPanel.revalidate();
		}
	
		public  class Check extends JButton implements ActionListener {
			
			private static final long serialVersionUID = 1L;
			BigSquare sudoku;
			int[][] temp;
			int error;
			int empty;
			
			Check()
			{
				super();
				this.setText("Check");
				addActionListener(this);
				
			}

			@Override
			public void actionPerformed(ActionEvent arg0) {
					Checking checking = new Checking();
					new Dialog(checking.getMessage());
					
			}
}
}
