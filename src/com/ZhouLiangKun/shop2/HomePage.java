package com.ZhouLiangKun.shop2;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;


public class HomePage extends JFrame{
	private JPanel contentPane;
	private static JTextField txtUsername;
	private JTextField txtPassword;

	
	
	


	public  HomePage() {
		
		
		
		contentPane=new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel chatLogin=new JLabel("����������̳ǣ���ӭ����");
		chatLogin.setBounds(150,23,200,60);
		contentPane.add(chatLogin);
		
		JLabel username=new JLabel("�û���:");
		username.setBounds(150,100,43,25);
		contentPane.add(username);
		
		JLabel password=new JLabel("����:");
		password.setBounds(150,133,107,21);
		contentPane.add(password);
		
	
		
		
		txtUsername=new JTextField();
		txtUsername.setText("abc");
		txtUsername.setBounds(200,100,107,21);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword=new JTextField();
		txtPassword.setText("123");
		txtPassword.setBounds(200,133,107,21);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		
		
	
		
		JButton btnLogin=new JButton("��¼");//���ð�ť
		btnLogin.setBounds(125,200,93,23);
		contentPane.add(btnLogin);
		
		JButton btncancel=new JButton("�˳�");//���ð�ť
		btncancel.setBounds(253,200,93,23);
		contentPane.add(btncancel);	
		
		btncancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		}
		);//�˳�������
		
		this.setTitle("��ӭ���������̳ǣ�");
		this.setSize(500, 400);
		this.setLocation(300, 200);
		this.getContentPane().setBackground(Color.CYAN);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	
	public static void main(String[] args) {
		HomePage go=new HomePage();
		go.setVisible(true);
	}

}
