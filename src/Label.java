import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Label extends JLabel {
	
	private static final long serialVersionUID = 1L;

	public Label (String string)
	{
		super(string);
		this.setHorizontalAlignment(CENTER);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}

	
}
