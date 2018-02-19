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
private int korekta_Y_przycisk = 220;


	public UstawienieStrony(JFrame owner)
	{
		super(owner, "Ustawienie strony", true);//  okno dialogowe pierwszy parametr okresla przez ktróre okno jest wywo³ywane, 
											//2.nazawa okna 3.blokowanie apki do czasu zamkniecie okna dialogowego
		setSize(500,300);
		setLayout(null);
		
		
		bOk = new JButton("OK");
		bAnuluj = new JButton("Anuluj");
		
		bOk.setBounds(getX()+250, getY()+korekta_Y_przycisk, 100, 20);
		bAnuluj.setBounds(getX()+370, getY()+korekta_Y_przycisk, 100, 20);
		
		bOk.addActionListener(this);
		bAnuluj.addActionListener(this);
		
		add(bOk);
		add(bAnuluj);
		//labele marginesów 
		
		add(lMarginesLewy = new JLabel("Lewy"));
		add(lMarginesPrawy = new JLabel("Prawy"));
		add(lMarginesGorny = new JLabel("Góra"));
		add(lMarginesDolny = new JLabel("Dó³"));
		
		lMarginesLewy.setBounds(5, 30, 40, 20);
		lMarginesPrawy.setBounds(80, 30, 40, 20);
		
		
		//pola tekstowe marginesów 
		add(tfMarginesLewy = new JTextField());
		add(tfMarginesPrawy = new JTextField());
		
		tfMarginesLewy.setBounds(40, 30, 30, 20);
		tfMarginesPrawy.setBounds(130, 30, 30, 20);
		
		
		
		
		
	
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
	public void setMarginesy(int lewy, int prawy)
	{
		tfMarginesLewy.setText(String.format("%d", lewy));
		tfMarginesPrawy.setText(String.format("%d", prawy));
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
