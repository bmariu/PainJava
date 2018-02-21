package Notatnik;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.undo.UndoManager;


public class Notatnik extends JFrame implements ActionListener
{
	private JMenuBar menuBar;
	private JMenu mPlik, mEdycja, mFormat,mStyl, mPomoc;
	private JMenuItem iNowy,iOtw�rz, iZapisz, iZakoncz, iFormat,iKolor, iCofnij, iPomoc, iZaznaczWszystko, iUsu�, iWytnij, iUstawienieStrony;
	private JMenuItem iWklej, iMetal, iNibus, iWindows;
	private JCheckBoxMenuItem ichZawijaTeks;
	private JTextArea taPoleTekstowe;
	private JScrollPane skrolPanel;
	private boolean StanZapisu= false, StanZawijaniaTekstu=false;
	private Insets margines;
	
	UndoManager zapamietajOperacje = new UndoManager();

	private  UstawienieStrony uStawienieStrony;
	
	
	public Notatnik()
	{
		setTitle("Notatnik");
		setLayout(new GridLayout());// ustawienie stylu okna g��wnego
		setBounds(0, 0, 500, 500);
//Obszar dotyczy menu	
		//
		//
		menuBar = new JMenuBar();
		
		mPlik = new JMenu("Plik");
		mEdycja = new JMenu("Edycja");
		mFormat = new JMenu("Format");
		mStyl = new JMenu("Styl");
		mPomoc = new JMenu("Pomoc");
		
// itemy dotycz�  menu  pliko
			iNowy = new JMenuItem("Nowy");
			iOtw�rz = new JMenuItem("Otw�rz");
			iZapisz = new JMenuItem("Zapisz");
			iUstawienieStrony = new JMenuItem("Ustawienie strony...");
			iZakoncz = new JMenuItem("Zakoncz");
			
			iNowy.addActionListener(this);			
			iOtw�rz.addActionListener(this);
			iZapisz.addActionListener(this);
			iUstawienieStrony.addActionListener(this);
			iZakoncz.addActionListener(this);
			
			iNowy.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));   // polecenie dodaje skr�t klawiszowy do danej opcji 
			iOtw�rz.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
			iZapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
			
			
			mPlik.add(iNowy);  //dodaje poszczeg�lne itemy, w zale�eno�ci od kolejno�ci tutaj dodanej tak b�d� si� wy�wietla� 
			mPlik.add(iOtw�rz);
			mPlik.add(iZapisz);
			mPlik.add(iUstawienieStrony);
			mPlik.addSeparator();
			mPlik.add(iZakoncz);
			
//itemy dotycz� menu Edycja
			iCofnij = new JMenuItem("Cofnij");
			iWytnij = new  JMenuItem("Wytnij");
			iZaznaczWszystko = new JMenuItem("Zanacz wszystko");
			iUsu� = new JMenuItem("Usu�");
			iWklej =new JMenuItem("Wklej");
			
			
			mEdycja.add(iCofnij);
			mEdycja.addSeparator();
			mEdycja.add(iWytnij);
			mEdycja.add(iWklej);
			mEdycja.add(iUsu�);
			mEdycja.addSeparator();
			mEdycja.add(iZaznaczWszystko);
			
			
			iCofnij.addActionListener(this);
			iWytnij.addActionListener(this);
			iZaznaczWszystko.addActionListener(this);
			iUsu�.addActionListener(this);
			iWklej.addActionListener(this);
			
			iZaznaczWszystko.setAccelerator(KeyStroke.getKeyStroke("ctrl A"));
			iUsu�.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0)); //tworz� skr�t z klawiatury samo Delet, jezeli chce dodac np ctrl Zamiast 0 dodaje InputEvent.CRTL_mask
			iWytnij.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
			iWklej.setAccelerator(KeyStroke.getKeyStroke("ctrl V"));
			
// item dotyczy menu Format
			//iFormat = new JMenuItem("Zawijaj tekst");
			ichZawijaTeks = new JCheckBoxMenuItem("Zawijaj tekst");
			iKolor = new JMenuItem("Kolor");
			
		//	mFormat.add(iFormat);
			mFormat.add(ichZawijaTeks);
			mFormat.add(iKolor);
			ichZawijaTeks.addActionListener(this);
			iKolor.addActionListener(this);
			
// item dotyczy pomocy
			iPomoc = new JMenuItem("Kontakt");
			
			mPomoc.add(iPomoc);
			
			iPomoc.addActionListener(this);
// itemy dotycz� Stylu apki
			
			iMetal = new JMenuItem("Metal");
			iNibus = new JMenuItem("Nibus");
			iWindows = new JMenuItem("Windows");
			
			
			
			
			mStyl.add(iMetal);
			mStyl.add(iNibus);
			mStyl.add(iWindows);
			
			
			
			iMetal.addActionListener(this);
			iNibus.addActionListener(this);
			iWindows.addActionListener(this);
			
		
			
			
		
		menuBar.add(mPlik);    // do paska menBar dodajemy poszczeg�lne pozycje menu 
		menuBar.add(mEdycja);
		menuBar.add(mFormat);
		menuBar.add(mPomoc);
		menuBar.add(mStyl);
		
		setJMenuBar(menuBar);// dodanie paska menu na kt�ym osadzane s� poszczegolne pozycje 
	//
	//koniec obszaru menu
		
		//Obszar pola tekstowego 
		
		taPoleTekstowe = new JTextArea();   //tworzymy obiekt pola tekstowego samo pole teksowe nie posiada s�wak�w zwi�zaku z czy dodajem panel scrol
		taPoleTekstowe.setWrapStyleWord(true);
		 margines = new Insets(1, 10, 10, 10);
		taPoleTekstowe.setMargin(margines);  //metoda ustawia marginesty ale msuie utworzy� obietk clasy Insets i utawic mu marginesty  
		
		skrolPanel = new JScrollPane(taPoleTekstowe);// dodanie panela scrol jako parametr podaje obietk pola tekstowego
		//skrolPanel.setBounds(3, 0, getWidth()-korektaSkrolBar, getHeight()-korektaSkrolBar);  // dodaje panel + pozycja  wyoko�� i szeroko�� pobieram z parametr�w naszego okna
		
		
		add(skrolPanel);// dodanie panelu do okna 
			
		zapamietajOperacje.setLimit(10000);
		
	}
	
	public void cofnij()
	{
        if(zapamietajOperacje.canUndo())
	zapamietajOperacje.undo();
	}
	public void powtorz()
	{
        if(zapamietajOperacje.canRedo())
	zapamietajOperacje.redo();
	}
	public void ZawijanieTekstu()
    {
		if(ichZawijaTeks.isSelected())
		{ StanZawijaniaTekstu=true;
		 taPoleTekstowe.setLineWrap(StanZawijaniaTekstu);
		} else 
		{
			StanZawijaniaTekstu= false;
			taPoleTekstowe.setLineWrap(StanZawijaniaTekstu);
			
			
		}
	}
	public static void main(String[] args) {
		
		Notatnik notatnik = new Notatnik();
		notatnik.setVisible(true);
	
		notatnik.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
	Object zr�d�o = e.getSource();
	
	if (zr�d�o == iNowy)
	{
		if (taPoleTekstowe.getText()!="" & !this.StanZapisu ) // warunek sprawdza czy pole tekstowe jest puste oraz czy plik by� zapisywany 
		{
		  int odp =JOptionPane.showConfirmDialog(this, "Notatnik nie zosta� zapisany. \n Utworzy� nowy ??","", JOptionPane.YES_NO_OPTION);
			
			if (odp == JOptionPane.OK_OPTION)  // warunek sprawdza jak� opcje klikn� urzytkownik Jezeli wybra� ok wykonywane jest instrukacja poni��j 
			{
				taPoleTekstowe.setText("");   //czy�ci pole tekstowe 
				setTitle("Notatnik");     //ustawiam nazw okna nowo tworzonego na Notatnik, mog�a ulec zmianie podczas otwarci pliku zpisanego  
				StanZapisu=false;
			} 	
		}else if (StanZapisu)   // warunek sprawdza czy plik zosta� zapisany jezeli tak tworzy nowy dokument bez komunikatu 
		{
			taPoleTekstowe.setText("");
			StanZapisu = false;
		}
		
	}
	if (zr�d�o == iOtw�rz) 
	{ 
		JFileChooser fc  = new JFileChooser();
		if (fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
		{	 taPoleTekstowe.setText("");//po zatwierdzeniu otwarcia pliku czyszcze pole tekstowe z poprzenich zapis�w 
			File plik = fc.getSelectedFile();
			setTitle(fc.getName(plik));//ustawiam tytu� notatnika jak nazw� pliku kt�ry zosa� otwarty
			try {
				Scanner skaner = new Scanner(plik);
				while(skaner.hasNext())     						//petla z czytuje  po koleji poszczeg�len zanki 
				{
					taPoleTekstowe.append(skaner.nextLine()+"\n");  // dodajemy do pola tekstowego kolejne linie z obiektu skaner, na koncu odajemy znak nowej lini \n
				}
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
		}		
	}

	
	 if(zr�d�o == iZapisz)
	{
		
		//JOptionPane.showMessageDialog(null, StanZapisu);
		JFileChooser fc = new JFileChooser();
		if (fc.showSaveDialog(null)== JFileChooser.APPROVE_OPTION)
		{
			File plik = fc.getSelectedFile();
			try 
			{
				PrintWriter pr = new PrintWriter(plik);     //tworzym obiekt zapisu 
				Scanner skaner = new Scanner(taPoleTekstowe.getText());   // do obieltu skanera �aduje teks z pola tekstowego 
				while(skaner.hasNext())
				{
					pr.println(skaner.nextLine()+"\n");
				}
				pr.close();
			} 
			catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
			
			StanZapisu = true;
		}
			
	}
	 if (zr�d�o == iZakoncz)
	 {
		  dispose();
	}
	 if(zr�d�o == iUstawienieStrony)
	 {
		
		if (uStawienieStrony == null)                         // warunek sprawdza czy okno zosta�o juz utworzony jezeli nie tworzy jezeli tak przechodzi do wy�wietlenia 
		  uStawienieStrony = new UstawienieStrony(this);
		uStawienieStrony.setLocation(getX()+100, getY()+100);   // ustawiam start okna dialogowego przesunietego o 100 wzgledem okna g��wnego
	 	 
		uStawienieStrony.setMarginesy(margines.left, margines.right, margines.bottom, margines.top);
		uStawienieStrony.setVisible(true);
	 	 
	 	 
	 	// JOptionPane.showMessageDialog(null,"test przycisku"+(getX()+100));
	 	  if(uStawienieStrony.isOk())
	 	  {
	 		//margines.set(top, left, bottom, right);(20, uStawienieStrony.getMarginesy(), 20, 20);
	 		margines.left = Integer.parseInt(uStawienieStrony.getMarginesyLewy());
	 		margines.right = Integer.parseInt(uStawienieStrony.getMarginesPrawy());
	 		margines.bottom = Integer.parseInt(uStawienieStrony.getlMarginesDolny());
	 		margines.top = Integer.parseInt(uStawienieStrony.getlMarginesGorny());
	 	
	 		taPoleTekstowe.setMargin(margines);
	 	
	 	  }else
	 	  {
	 	uStawienieStrony.setMarginesy(margines.left, margines.right, margines.bottom, margines.top);
	 	  }
	 	  
		
	 }
	 
	//s�uchacze dla edycji 
	 if(zr�d�o == iCofnij)
	 {
		// JOptionPane.showMessageDialog(null, "test");
	 cofnij();
		 
	 }
	 if (zr�d�o== iZaznaczWszystko)
	 	taPoleTekstowe.selectAll();
	
	 if (zr�d�o == iUsu�)		
		 taPoleTekstowe.cut();

	
	 if (zr�d�o == iWytnij) 
		 taPoleTekstowe.cut();
	 
	 if(zr�d�o== iWklej)
		 taPoleTekstowe.paste();
	 
	 //s�uchacze menii format
	 if (zr�d�o == ichZawijaTeks) 
	   ZawijanieTekstu();
	
	 
	 if(isResizable())//warunek sprawdza czy okno zosta�o z maksymalizowane lub zmniejszone i w zaleznosci o stanu zawija tekst do duzego okna lub ma�ego
		 ZawijanieTekstu(); // metoda sprawdza stan zanaczenia ichetboxZawijaTeks i ustawia zwijanie na true lub false
		 
	 
	 if(zr�d�o == iKolor)
	 {
		Color wybranyKolor= JColorChooser.showDialog(null, "Wybierz kolor", Color.BLACK);
		taPoleTekstowe.setForeground(wybranyKolor);
		
		 }	 
	 
	 if (zr�d�o == iMetal)
	 {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); // sciezka do standordowego stylu metal 
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);// polecenie od�wie�a styl dla ca�ej aplikacji 
	}
	 else if(zr�d�o == iNibus)
	{
		 try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");// ��dowanie stylu Nimbus, musi by� try Eclips dodaje automatycznie
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 SwingUtilities.updateComponentTreeUI(this);// 
	}
	 else if (zr�d�o == iWindows) 
	{
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //sciezka do stylu Windows 
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 SwingUtilities.updateComponentTreeUI(this);// 
		
	}
	 if (zr�d�o == iPomoc)
		JOptionPane.showMessageDialog(null, "Kontakt: bmariu84@gmail.com \n Autor: Mariusz Buczek");
	
	
	 
	 
	
	 

	 
		
	
	
	

	 taPoleTekstowe.getDocument().addUndoableEditListener(new UndoableEditListener() {

			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
			    zapamietajOperacje.addEdit(e.getEdit()); 

				}
			});
}
	
}



