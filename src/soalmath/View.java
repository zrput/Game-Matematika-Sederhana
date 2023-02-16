package soalmath;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class View extends JFrame{
	private JTextField textField;
	private JLabel lblHasil;
	private JLabel lblSoal;
	private JButton btnKirim;
//	public int angka1 = ThreadLocalRandom.current().nextInt(0,10);
//	public int angka2 = ThreadLocalRandom.current().nextInt(0,50);
	
	private JButton btnKeluar;
	private JButton btnNext;
	public View () {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnKirim = new JButton("kirim");
		btnKirim.setBounds(105, 278, 80, 23);
		panel.add(btnKirim);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(105, 252, 178, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		lblSoal = new JLabel("\r\n");
		lblSoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoal.setBounds(67, 99, 242, 67);
		panel.add(lblSoal);
		
		lblHasil = new JLabel("");
		lblHasil.setHorizontalAlignment(SwingConstants.CENTER);
		lblHasil.setBounds(10, 205, 364, 36);
		panel.add(lblHasil);
		
		btnKeluar = new JButton("Keluar");
		btnKeluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnKeluar.setBounds(143, 312, 100, 23);
		panel.add(btnKeluar);
		
		btnNext = new JButton("Next");
		btnNext.setBounds(203, 278, 80, 23);
		panel.add(btnNext);
		
		setSize(400,400);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new View();
	}
	public JLabel getLblHasil() {
		return lblHasil;
	}
	public JTextField getTextField() {
		return textField;
	}
	public JLabel getLblSoal() {
		return lblSoal;
	}
	public JButton getBtnNewButton() {
		return btnKirim;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public void setLblHasil(JLabel lblHasil) {
		this.lblHasil = lblHasil;
	}

	public void setLblSoal(JLabel lblSoal) {
		this.lblSoal = lblSoal;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnKirim = btnNewButton;
	}
	public JButton getBtnKeluar() {
		return btnKeluar;
	}

	public JButton getBtnNext() {
		return btnNext;
	}
}
