import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class welcome extends JFrame implements ActionListener{
	JLabel username,backg;
	JLabel title ;
	JButton home,logout;
	JPanel full;
	String uname;
	JButton addBook,issueBook,returnBook;
	public welcome(String uname){
		this.uname=uname;
	
		 full = new JPanel();
		 backg = new JLabel(new ImageIcon("backwodden.jpg"));
		 title = new JLabel(new ImageIcon("SELECT.png"));
		 home=new JButton(new ImageIcon("homebutton1.jpg"));
		logout=new JButton(new ImageIcon("LOGOUTBUTTON.png"));
		addBook=new JButton(new ImageIcon("ADDBOOKTEXTTURE175X100.jpg"));
		issueBook=new JButton(new ImageIcon("ISSUEBOOKTEXTTURE175X100.jpg"));
		returnBook=new JButton(new ImageIcon("RETURNBOOKTEXTTURE175X100.jpg"));
		add(full);
		full.setLayout(null);
		backg.setBounds(0,0,600,500);
		full.add(backg);
		home.setBounds(25,25,70,70);
		backg.add(home);
		logout.setBounds(450,25,70,70);
		backg.add(logout);
		title.setBounds(200,25,200,50);
		backg.add(title);
		addBook.setBounds(100,200,175,100);
		backg.add(addBook);
		issueBook.setBounds(325,200,175,100);
		backg.add(issueBook);
		returnBook.setBounds(200,325,175,100);
		backg.add(returnBook);
		setSize(600,500);
		setLocation(500,120);
		setVisible(true);
		setResizable(false);
		home.addActionListener(this);
		logout.addActionListener(this);
		addBook.addActionListener(this);
		issueBook.addActionListener(this);
		returnBook.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==home){
			setVisible(false);
			new welcome(uname);			
		}else if(e.getSource()==logout){
			setVisible(false);
			new logW();
		}else if(e.getSource()==addBook){
			setVisible(false);
			new addBooks(uname);
		}else if(e.getSource()==issueBook){
			setVisible(false);
			new issueBooks(uname);
		}else if(e.getSource()==returnBook){
			setVisible(false);
			new returnBooks(uname);
		}
	}
	public static void main(String ar[]){
		new welcome("WELCOME USER");
		
	}
	
}