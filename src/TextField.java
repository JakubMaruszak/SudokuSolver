import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.UIManager;

public class TextField extends JTextField implements FocusListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font label = UIManager.getFont("Label.font");
	Font doubledigit = new Font("Arial", Font.ITALIC, 10);

	public TextField(String string)
	{
		super(string);
		this.setHorizontalAlignment(CENTER);
		this.setFont(label);
		this.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		this.setText("");
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(this.getText().isEmpty()) this.setText("0");
		else if (this.getText().length()>1) this.setFont(doubledigit);
		else this.setFont(label);
		
	}

}
