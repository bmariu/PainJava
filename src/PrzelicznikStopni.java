import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.xml.transform.TransformerFactoryConfigurationError;

public class PrzelicznikStopni extends JFrame implements ActionListener {
	private JTextField TCelszjusz, TFarnethaj;
	private 	double tempCelsjusza, tempFarenhajta, konwerter;
	private	JButton BPrzelicz;
	private JLabel LCelsjusz, LFarenthajt;
	private JCheckBox chWielkieLitery;
	private ButtonGroup bgRozmiarCzci¹nki;
	private JRadioButton rMa³a, rSrednia, rDu¿a;
	
	private JMenuBar pasekMeni;
	private JMenu  menuOpcje, menuPomoc, menuUstawienia, menuKolory;
	private JMenuItem iUstawRozmiar, iOprogramie, iKolor, iUstawienia, iCzerwony, iNiebieski;
	

	
	public PrzelicznikStopni() {
				
		
		
		setTitle("Przelicznik temperatury");
		setSize(400	,250);
		setLocation(200, 300);
		setLayout(null);
		
		LCelsjusz = new JLabel("Stopnie Celszjusza");
		LCelsjusz.setBounds(20, 20, 200, 50);
		add(LCelsjusz);
		
		LFarenthajt = new JLabel("Farenthajta");
		LFarenthajt.setBounds(20, 70, 200, 50);
		add(LFarenthajt);
		
		TCelszjusz = new JTextField("");
		TCelszjusz.setBounds(180, 40, 100, 20);
		add(TCelszjusz);
		TCelszjusz.addActionListener(this);
		TCelszjusz.setToolTipText("Podaj temperaturê do przelicznia");
		
		TFarnethaj = new JTextField("");
		TFarnethaj.setBounds(180, 90, 100, 20);
		add(TFarnethaj);
		TFarnethaj.addActionListener(this);
		
		BPrzelicz = new JButton("Przelicz");
		BPrzelicz.setBounds(20, 120, 160, 30);
		add(BPrzelicz);
		BPrzelicz.addActionListener(this);
		
		chWielkieLitery = new JCheckBox("Bold");
		chWielkieLitery.setBounds(250, 120, 50, 50);
		add(chWielkieLitery);
		//chWielkieLitery.addActionListener(this);
		
		bgRozmiarCzci¹nki = new ButtonGroup();
		rMa³a = new JRadioButton("Ma³¹",true);
		rMa³a.setBounds(20,150,100,20);
		bgRozmiarCzci¹nki.add(rMa³a);
		add(rMa³a);
		rMa³a.addActionListener(this);
		
		rSrednia= new JRadioButton("Œrednia",false);
		rSrednia.setBounds(20,170,100,20);
		bgRozmiarCzci¹nki.add(rSrednia);
		add(rSrednia);
		rSrednia.addActionListener(this);
		
		rDu¿a = new JRadioButton("Du¿a",false);
		rDu¿a.setBounds(20,190,100,20);
		bgRozmiarCzci¹nki.add(rDu¿a);
		add(rDu¿a);
		rDu¿a.addActionListener(this);
		
		pasekMeni = new JMenuBar();  // dodaje pasek menu
		menuOpcje = new JMenu("Opcje");  // dodajemy opcje do paska 
		
		iUstawRozmiar =  new JMenuItem("Uataw rozmiar okna");   //poszczególne pozycje w menu 
		iKolor =  new JMenuItem("Kolor");
		
		menuOpcje.add(iUstawRozmiar);// komenda dodaje pozycje do menu 
		menuOpcje.addSeparator();
		menuOpcje.add(iKolor);
		
		menuPomoc =  new JMenu("Pomoc");
		menuUstawienia = new JMenu("Ustawienia");
		
		iUstawienia = new JMenuItem("Ustawienia");
		
			menuKolory = new JMenu("Kolory");       //dodawnie pod menu Dodajemy przez utworzenie pozycji menu
			iCzerwony = new  JMenuItem("Czerwony");// do tej pozycji dodajemy itemy a potem ca³oœæ dodajemy do 
			iNiebieski = new JMenuItem("Niebiski"); // menu 
			
			menuKolory.add(iCzerwony);
			menuKolory.add(iNiebieski);
		
		menuUstawienia.add(iUstawienia);
		menuUstawienia.add(menuKolory);
		
		
		
		
		setJMenuBar(pasekMeni);   // komenda dodaje pasek menu do okna 
		pasekMeni.add(menuOpcje);    //jak mamy pasek menu dodajem do niego poszczególene pozycje 
		pasekMeni.add(menuUstawienia);
		pasekMeni.add(menuPomoc);
		
		
		
		
		
		
		
		
	}

	
	public static void main(String[] args) {
		
PrzelicznikStopni okno = new PrzelicznikStopni();
okno.setVisible(true);
okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object akcja = e.getSource();
	
	//tempFarenhajta = Double.parseDouble(TFarnethaj.getText());
	
	
	//tempCelsjusza = (9.0/5.0)*tempFarenhajta-32;
	
	
	if (akcja == BPrzelicz || akcja==TCelszjusz)
	{
		if (chWielkieLitery.isSelected())
		{
		TFarnethaj.setFont(new Font("",Font.BOLD,16));
		}
		else
		{
			TFarnethaj.setFont(new Font("",Font.PLAIN,12));
		}
		
		//TCelszjusz.setText(String.valueOf(tempCelsjusza));
		tempCelsjusza= Double.parseDouble(TCelszjusz.getText());
		tempFarenhajta = (9.0/5.0)*tempCelsjusza+32;
		TFarnethaj.setText(String.valueOf(tempFarenhajta));
		
	}
	else if (akcja == rMa³a)
	{
		TFarnethaj.setFont(new Font("",Font.PLAIN,8));
		
	}
	else if (akcja== rSrednia)
	{
		TFarnethaj.setFont(new Font("",Font.PLAIN,12));
		
		
	}
	else if (akcja == rDu¿a) 
	{
		
		TFarnethaj.setFont(new Font("",Font.PLAIN,18));
	}
	
		}

		
	
	
	
	
	
	
	
	
		
	
	
		
	
		
	}
