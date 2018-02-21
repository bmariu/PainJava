package Notatnik;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class UstawienieStrony extends JDialog implements ActionListener
{
private boolean okData;
private JButton bOk, bAnuluj;
private JTextField tfMarginesLewy, tfMarginesPrawy, tfMarginesGorny, tfMarginesDolny;
private JLabel lMarginesLewy, lMarginesPrawy, lMarginesGorny, lMarginesDolny;
private int korekta_Y_przycisk = 120;


	public UstawienieStrony(JFrame owner)
	{
		super(owner, "Ustawienie strony", true);//  okno dialogowe pierwszy parametr okresla przez ktróre okno jest wywo³ywane, 
											//2.nazawa okna 3.blokowanie apki do czasu zamkniecie okna dialogowego
		setSize(250,200);
		setLayout(null);
		
		
		bOk = new JButton("OK");
		bAnuluj = new JButton("Anuluj");
		
		bOk.setBounds(getX()+20, getY()+korekta_Y_przycisk, 100, 20);
		bAnuluj.setBounds(getX()+120, getY()+korekta_Y_przycisk, 100, 20);
		
		bOk.addActionListener(this);
		bAnuluj.addActionListener(this);
		
		add(bOk);
		add(bAnuluj);
		//labele marginesów 
		
		add(lMarginesLewy = new JLabel("Lewy:"));
		add(lMarginesPrawy = new JLabel("Prawy:"));
		add(lMarginesGorny = new JLabel("Góra:"));
		add(lMarginesDolny = new JLabel("Dó³:"));
		
		lMarginesLewy.setBounds(5, 30, 40, 20);
		lMarginesPrawy.setBounds(100, 30, 40, 20);
		lMarginesDolny.setBounds(5,60,40,20);
		lMarginesGorny.setBounds(100, 60, 40, 20);
		
		
		//pola tekstowe marginesów 
		add(tfMarginesLewy = new JTextField());
		add(tfMarginesPrawy = new JTextField());
		add(tfMarginesDolny = new JTextField());
		add(tfMarginesGorny = new JTextField());
		
		
		tfMarginesLewy.setBounds(40, 30, 45, 20);
		tfMarginesPrawy.setBounds(150, 30, 45, 20);
		tfMarginesDolny.setBounds(40, 60, 45, 20);
		tfMarginesGorny.setBounds(150, 60, 45, 20);
		
		
		
		
		
	
	}
	
	public boolean isOk() 
	{
		return okData;
	}
	
	public String getMarginesyLewy()
	{
		return tfMarginesLewy.getText();
	}
	public String getMarginesPrawy() 
	{
		return tfMarginesPrawy.getText();
				}
	
	
	public String getlMarginesGorny() {
		return tfMarginesGorny.getText();
	}

	public String getlMarginesDolny() {
		return tfMarginesDolny.getText();
	}

	public void setMarginesy(int lewy, int prawy, int down, int up)
	{
		tfMarginesLewy.setText(String.format("%d", lewy));
		tfMarginesPrawy.setText(String.format("%d", prawy));
		tfMarginesDolny.setText(String.format("%d", down));
		tfMarginesGorny.setText(String.format("%d",up));
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object z  = e.getSource();
		
		if (z==bOk) 
			okData = true;
		else
			okData = false;
	setVisible(false);
	
	
		
	}

	
	
}
