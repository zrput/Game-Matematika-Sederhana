package soalmath;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class ControlSulit extends View implements ActionListener{
private int angka1, angka2;
	
	public Random random;
	public int count = 1;
	public int skor;
	public boolean benar = false;
	private float tempsum;
	private float rand, rand1;
    
	private Timer tmr = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			getLblHasil().setText("");
		}
	});

	public ControlSulit() {
		soal();
		
		getBtnNext().addActionListener(this);
		getBtnNewButton().addActionListener(this);
		
	}
	
	public void cekBenar() {
		isBenar();
		if (benar == true) {
			getBtnNext().setEnabled(true);
			
		}else {
			getBtnNext().setEnabled(false);
		}
	}
	
	public void soal() {
		cekBenar();
				if(count % 2 == 1) {
					perkalian();	
	
				}else {
					pembagian();
				}
	}
	
	public boolean isBenar() {
		return benar;
	}

	public void setBenar(boolean benar) {
		this.benar = benar;
	}
	
	public void random() {
		random = new Random();
		angka1 = random.nextInt(15);
		angka2 = random.nextInt(20);
	}
	
	public void randombagi() {	
	    do {
	    	random = new Random();
	    	rand = random.nextInt(10, 20); // mengacak angka dari 10 sampai 19
		    rand1 = random.nextInt(2, (int) (rand / 2) + 1); // mengacak angka dari 2 sampai 
            tempsum = rand / rand1; // tempsum = temporary sum
        } while (tempsum % 1 != 0);

//	    System.out.println(rand + " / " + rand1 + " = " + tempsum);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == getBtnNewButton()) {
			kirim();
			cekBenar();
		}
		
		if(e.getSource() == getBtnNext()) {
			if(count == 10) {
				tmr.start();
				result();
				
			}
			count++;
			if (count % 2 == 1) {
				random();
				soal();
				getBtnNext().setEnabled(false);
				getLblHasil().setText("");
			}
			else {
				soal();
				getBtnNext().setEnabled(false);
				getLblHasil().setText("");
			}
			
		}
	}
	public void perkalian() {
		random();
		getLblSoal().setText(count + ". Jawaban pertanyaan berikut " +
				angka1 + " X " + angka2 + " = ?");
	}
	public void pembagian() {
		
		randombagi();
		getLblSoal().setText(count + ".Jawaban pertanyaan berikut " +
				(int) rand + " / " + (int) rand1 );

	}
	
	public void tambah(int n) {
		
		int kunci = angka1 * angka2;
		
		if (n == kunci) {
			getLblHasil().setText("Jawaban Anda benar!");
			setBenar(true);
			skor += 10;

		}
		else {
			getLblHasil().setText("Jawaban Anda Salah!"); 
			setBenar(false);
			skor -= 2;
			tmr.start();
		}
	}
	
	public void kurang(int n) {
		
		float kunci = rand / rand1;
		if (n == kunci) {
			getLblHasil().setText("Jawaban Anda benar!");
			setBenar(true);
			skor += 10;

		}
		else {
			getLblHasil().setText("Jawaban Anda Salah!");
			setBenar(false);
			skor -= 2;
			tmr.start();
		}
	}
	
	public void kirim() {
		
		try {
			tmr.stop();
			int nilai = Integer.parseInt(getTextField().getText());
				if(count % 2 == 1) {
					tambah(nilai);
				}
				else {
					kurang(nilai);
				}
			getTextField().setText("");
		}
		catch(Exception f) {
				
		}
	}
	
	public void result() {
		setVisible(false);
		String name = JOptionPane.showInputDialog(null,"Kamu Sudah Menyelesaikan Quiz.\n Masukkan Nama mu :");
		JOptionPane.showMessageDialog(null, "Name: " + name + "\nTotal Score: " + skor + "\nGood job!");
		new AwalMenu();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ControlSulit();

	}

}
