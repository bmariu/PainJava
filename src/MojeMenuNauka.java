import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class MojeMenuNauka extends JFrame implements ActionListener {
	
	
	private JMenuBar menuBar;
	private JMenu mOpcje, mUstawienia,mPomoc, mPlik;
	private JMenuItem iOpcja1, iOpcja2, iUstawienia, ipomoc, iZapisz,iOtw�rz;
	private JCheckBoxMenuItem chOpcja3;
	private JTextArea taNotatnik;
	
	public MojeMenuNauka() {
		
		
		
		setTitle("Nauka menu");
		setSize(400, 400);
		//setBounds(50, 50, 300, 300);
		setLayout(null);
				//setVisible(true);
	
		menuBar = new JMenuBar();
		
		mPlik = new JMenu("Plik");
		iOtw�rz = new JMenuItem("Otw�rz");
		iZapisz  = new JMenuItem("Zapisz");
		
		mPlik.add(iOtw�rz);
		mPlik.add(iZapisz);
		
		iOtw�rz.addActionListener(this);
		iZapisz.addActionListener(this);
		
		
		
		
		mOpcje = new JMenu("Opcja");
			iOpcja1  = new JMenuItem("Ocja", 'O');
			iOpcja1.addActionListener(this);
			iOpcja1.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
			
			iOpcja2  = new JMenuItem("Opcja2");
			//iOpcja2.setEnabled(false);
			iOpcja2.addActionListener(this);
			
			mOpcje.add(iOpcja1);
			mOpcje.addSeparator();
			mOpcje.add(iOpcja2);
		
		mUstawienia = new JMenu("Ustawienia");
		chOpcja3 = new JCheckBoxMenuItem("czebox");
		mUstawienia.add(chOpcja3);
		
		mPomoc = new JMenu("Pomoc");
		ipomoc = new JMenuItem("POmoc");
		mPomoc.add(ipomoc);
	     ipomoc.addActionListener(this);
	     
	    
		
		
		
		menuBar.add(mPlik);
		menuBar.add(mOpcje);
		menuBar.add(mUstawienia);
		menuBar.add(mPomoc);
		
		
		setJMenuBar(menuBar);
		
		taNotatnik = new JTextArea();
		JScrollPane skrolNotatnik = new JScrollPane(taNotatnik);
		skrolNotatnik.setBounds(10, 10,300 , 300);
		add(skrolNotatnik);
		//taNotatnik.setBounds(20, 20, 300, 300);
		//add(taNotatnik);
		
		
		
	}
	
	
	
	

	public static void main(String[] args) {
		
	MojeMenuNauka MenuOkno = new  MojeMenuNauka();
		
		MenuOkno.setVisible(true);
		MenuOkno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	}





	@Override
	public void actionPerformed(ActionEvent e) {
	
		Object z = e.getSource();
		if (z == iOtw�rz)
		{
			JFileChooser  fc = new JFileChooser();
			if (fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) 
			{
				File plik = fc.getSelectedFile();
				//JOptionPane.showMessageDialog(null, "Nazwa pliku:  "+ plik.getAbsolutePath());
				try {
					Scanner skaner = new Scanner(plik);
					while(skaner.hasNext())
					{
						taNotatnik.append(skaner.nextLine()+"\n");
					}
				} catch (FileNotFoundException e1) {
				
					e1.printStackTrace();
				}
				
			}
		}
		else if (z == iZapisz)
		{
			JFileChooser fc = new JFileChooser();// FileChooser tworzymy obietk kt�ry bedzie wywo�ywa� okno dialogowe zapisu
			if (fc.showSaveDialog(null)== JFileChooser.APPROVE_OPTION)//wywo�ujemy okno dialogowe i spawdzamy czy urzytkowniek zatwierdzi�
			{
				File plik = fc.getSelectedFile();//tworzym obiekt typu plik kt�y do ktorego bedziem ��dowa� wybrany plik FileChooser
				try {      // blok try wymagany przez jave  Obsluga plikow musi byc w tym bloku w razie jak otwierany zaisywany plik nie istnieje 
					PrintWriter pw = new PrintWriter(plik);  // tworzym obiekt zapisuj�cy 
					Scanner skaner = new Scanner(taNotatnik.getText());  //tworzym obietk skanera kt�ry bedzie czyta� zanki z pola tekstowego 
					while(skaner.hasNext())   // petla  z szczytuje kolejne zanki do puki s� 
						pw.println(skaner.nextLine()+"\n"); //printline zapisuje poszczeg�lne linie w pliku odczytane ze skanera 
															// musimy dodac \n aby przechodzi�o do kolejnej linii 
					
					pw.close();//po zapisaniu musimy zamkno� printa bez tego buffor nie zostanie zamkniety i nie zapisze sie do pliku 
					
					
				} catch (FileNotFoundException e1) {
				
					e1.printStackTrace();
				}
				
			}
			
		}
		
		if(z == iOpcja1)
		{
			int odp = JOptionPane.showConfirmDialog(null, "Napewno chcesz wyj��?", "Wyjscie", JOptionPane.YES_NO_OPTION);
			if(odp  ==  JOptionPane.YES_OPTION)
			dispose();
			else if(odp == JOptionPane.NO_OPTION) {}
				
		}
		if(z == ipomoc)
			{  JOptionPane.showMessageDialog(this, "Pomoc aktualnie nie dostepna \n Wersja 1.0", "Tytu�",JOptionPane.ERROR_MESSAGE);}
		if (z == iOpcja2) {
			String watro��Podana =JOptionPane.showInputDialog(null,"Podaj odleg�o�� w metrach","Przelicznik");
			double metry = Double.parseDouble(watro��Podana);
			double przelicznikStopy = metry/0.33;
			String sStopy = String.format("%.2f",przelicznikStopy);
			JOptionPane.showMessageDialog(null,metry+" metr�w = "+ sStopy+" st�p");
			
		
		}
	}

	
}
