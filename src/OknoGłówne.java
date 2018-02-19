import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class OknoG³ówne extends JFrame implements ActionListener {
	JButton przycisk1, bWyjœcie;
	JLabel LwyœwietlDate;
	
	OknoG³ówne()
	{
		setSize(400, 600);
		setTitle("Paint");
		setLayout(null);
		
		 przycisk1 = new JButton("Przycisk1");
		przycisk1.setBounds(20,50,100,50);
		add(przycisk1);
		przycisk1.addActionListener(this);
		
		 bWyjœcie = new JButton("Wyjœcie");
		bWyjœcie.setBounds(120, 50, 100, 50);
		add(bWyjœcie);
		bWyjœcie.addActionListener(this);
		
		LwyœwietlDate = new JLabel("Data:");
		LwyœwietlDate.setBounds(40,150,200,20);
		LwyœwietlDate.setForeground(Color.BLUE);
		add(LwyœwietlDate);
	}

	public static void main(String[] args) {
	
		OknoG³ówne panel1 = new OknoG³ówne();
		panel1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object zród³o = e.getSource();
		if (zród³o == przycisk1) 
		{
			//System.out.println(new Date());
			LwyœwietlDate.setText(new Date().toString());
			
		}else if (zród³o == bWyjœcie ) {
			dispose();
			
		}
		
	
	
		
	}

	
	
}
