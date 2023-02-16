package soalmath;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;


public class ControlNormal extends View implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5152979170252371717L;
	private int angka1, angka2;
	
	public Random random;
	public int count = 1;
	public int skor;
	public boolean benar = false;
	private Timer tmr = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			getLblHasil().setText("");
		}
	});

	public ControlNormal() {
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
					penjumlah();	
	
				}else {
					pengurangan();
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
		angka1 = random.nextInt(50);
		angka2 = random.nextInt(50);
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
			random();
			soal();
			getBtnNext().setEnabled(false);
			getLblHasil().setText("");
			
		}
	}
	public void penjumlah() {
		random();
		getLblSoal().setText(count + ". Jawaban pertanyaan berikut " +
				angka1 + " + " + angka2 + " = ?");
	}
	public void pengurangan() {
		random();
		getLblSoal().setText(count + ".Jawaban pertanyaan berikut " +
				angka1 + " - " + angka2 + " = ?");
	}
	
	public void tambah(int n) {
		
		int kunci = angka1 + angka2;
		
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
		
		int kunci = angka1 - angka2;
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
		new ControlNormal();
	}
}
