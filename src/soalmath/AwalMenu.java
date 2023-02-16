package soalmath;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;

public class AwalMenu extends JFrame {
	private JButton btnMain;
	private SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy || hh:mm:ss");
//	private Timer tmr;
	private JLabel lblDateTime;
	private JButton btnKeluar;
	public AwalMenu() {
		
		setSize(500,400);
		setLocationRelativeTo(null);
		setVisible(true);
	
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnMain = new JButton("");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Pilihan().setVisible(true);
				setVisible(false);
			}
		});
		btnMain.setIcon(new ImageIcon(AwalMenu.class.getResource("/soalmath/play.png")));
		btnMain.setBounds(200, 215, 70, 40);
		panel.add(btnMain);
		
		JLabel lblNewLabel = new JLabel("SOAL MATEMATIKA DASAR");
		lblNewLabel.setFont(new Font("Bulldozer", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(66, 73, 347, 103);
		panel.add(lblNewLabel);
		
		btnKeluar = new JButton("");
		btnKeluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnKeluar.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\soalmath\\src\\gambar\\quit.png"));
		btnKeluar.setBounds(200, 266, 70, 40);
		panel.add(btnKeluar);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblDateTime = new JLabel("");
		lblDateTime.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblDateTime);
		
		JLabel lblNewLabel_1 = new JLabel("kuno.il");
		panel_1.add(lblNewLabel_1);
		
		Timer tmr = new Timer(200, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date dt= Calendar.getInstance().getTime();
				getLblDateTime().setText("Tanggal : "+sdf.format(dt)+"   ");
			}
		} );
		tmr.start();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AwalMenu();
		
		
	}
	public JButton getBtnMain() {
		return btnMain;
	}
	public JLabel getLblDateTime() {
		return lblDateTime;
	}
	public JButton getBtnKeluar() {
		return btnKeluar;
	}
}
