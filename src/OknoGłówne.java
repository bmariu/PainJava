import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class OknoG��wne extends JFrame implements ActionListener {
	JButton przycisk1, bWyj�cie;
	JLabel Lwy�wietlDate;
	
	OknoG��wne()
	{
		setSize(400, 600);
		setTitle("Paint");
		setLayout(null);
		
		 przycisk1 = new JButton("Przycisk1");
		przycisk1.setBounds(20,50,100,50);
		add(przycisk1);
		przycisk1.addActionListener(this);
		
		 bWyj�cie = new JButton("Wyj�cie");
		bWyj�cie.setBounds(120, 50, 100, 50);
		add(bWyj�cie);
		bWyj�cie.addActionListener(this);
		
		Lwy�wietlDate = new JLabel("Data:");
		Lwy�wietlDate.setBounds(40,150,200,20);
		Lwy�wietlDate.setForeground(Color.BLUE);
		add(Lwy�wietlDate);
	}

	public static void main(String[] args) {
	
		OknoG��wne panel1 = new OknoG��wne();
		panel1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object zr�d�o = e.getSource();
		if (zr�d�o == przycisk1) 
		{
			//System.out.println(new Date());
			Lwy�wietlDate.setText(new Date().toString());
			
		}else if (zr�d�o == bWyj�cie ) {
			dispose();
			
		}
		
	
	
		
	}

	
	
}
