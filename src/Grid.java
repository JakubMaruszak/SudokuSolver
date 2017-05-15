import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Grid extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Grid()
	{
		super();
		this.setForeground(Color.black);
		this.setBackground(Color.white);
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		this.setLayout(Window.gridlayout);
		this.setSize(new Dimension(80,80));
	}

}
