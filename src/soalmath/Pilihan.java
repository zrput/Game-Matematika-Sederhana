package soalmath;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.JButton;

public class Pilihan extends JFrame {
	private JLabel lblDateTime;
	private SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy || hh:mm:ss");
	private JButton btnNormal;
	private JButton btnBack;
	private JButton btnHard;
	
	public Pilihan() {
		
		setSize(400,450);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("PILIH TINGKAT KESULITAN");
		lblNewLabel.setFont(new Font("Bulldozer", Font.PLAIN, 28));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblDateTime = new JLabel("");
		lblDateTime.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblDateTime);
		
		JLabel lblNewLabel_2 = new JLabel("kuno.il");
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		btnNormal = new JButton("Standar");
		btnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ControlNormal().setVisible(true);
				setVisible(false);
			}
		});
		btnNormal.setBounds(140, 35, 90, 60);
		panel_2.add(btnNormal);
		
		btnHard = new JButton("Sulit");
		btnHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ControlSulit();
				setVisible(false);
				}
		});
		btnHard.setBounds(140, 138, 90, 60);
		panel_2.add(btnHard);
		
		btnBack = new JButton("kembali");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AwalMenu().setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(140, 242, 90, 30);
		panel_2.add(btnBack);
		setVisible(true);
		
		Timer tmr = new Timer(200, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date dt= Calendar.getInstance().getTime();
				getLblDateTime().setText("Tanggal : "+sdf.format(dt)+"   ");
			}
		});
		
		tmr.start();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Pilihan();
		
	}

	public JLabel getLblDateTime() {
		return lblDateTime;
	}
	public JButton getBtnNormal() {
		return btnNormal;
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public JButton getBtnHard() {
		return btnHard;
	}
}
