import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Dialog extends JDialog implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	Dialog(String message)
	{
		this.message = message;
		this.add(new JLabel(message));
		JButton ok = new JButton("OK");
		ok.addActionListener(this);
		this.add(ok);
		ok.setAlignmentX(CENTER_ALIGNMENT);
		ok.setAlignmentY(BOTTOM_ALIGNMENT);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.setVisible(true);
		this.setPreferredSize(new Dimension(300,100));
		this.pack();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		dispose();
		
	}

}
