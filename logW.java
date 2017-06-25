import java.util.* ;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.*;
public class logW extends JFrame implements ActionListener
{
	public static JPanel log_w;
	public static JLabel u_name;
	public static JLabel u_pass ;
	public static JPasswordField pass ;
	public static JButton submit1;
	public static JTextField user1 ;
	public static JLabel lms;
	public static JLabel  pic ;
	public static JLabel background ;

	public logW(){
		
		try{
		log_w= new JPanel(new FlowLayout());
		setLayout(new FlowLayout());
		lms = new JLabel(new ImageIcon("titwodden.png"));
		u_name = new JLabel(new ImageIcon("UNAME.png"));
		user1 = new JTextField();
		u_pass = new JLabel(new ImageIcon("UPASS.png"));
		pass = new JPasswordField ();
		ImageIcon water = new ImageIcon("LOGIN.png");
    	submit1= new JButton(water);
		pic = new JLabel(new ImageIcon("user.png"));
		background=new JLabel(new ImageIcon("backwodden.jpg"));
		background.setBounds(0,0,600,500);
		log_w.add(background);
		lms.setBounds(25,25,500,100);
		pic.setBounds(55,175,200,200);
		u_name.setBounds(250,215,150,50);
		user1.setBounds(425,215,125,50);
		u_pass.setBounds(250,315,150,50);
		pass.setBounds(425,315,125,50);
		submit1.setBounds(425,397,125,50);
		background.add(lms);
		background.add(pic);
		background.add(u_name);
		background.add(user1);
		background.add(u_pass);
		background.add(pass);
		 pass.addActionListener(this);
		 submit1.addActionListener(this);
		add(log_w);
		setTitle("LOG IN");
		setLocation(500,120);
		background.add(submit1);
		setVisible(true);
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		catch(Exception v)
		{
			v.printStackTrace();
			System.out.println("error found in main part");
		}
	
	}
	public static void main(String args[])
	{
			new logW();
		
	}
	public void actionPerformed(ActionEvent b)
			{
				try{
					String user="";
					String checkUName="Akash";
					String checkPassword="aA!@12";
					String s1=user1.getText();
					String s2=pass.getText();
					if(checkUName.equals(s1) && checkPassword.equals(s2))
					{
						log_w.setVisible(false);
						new welcome(checkUName);
					}
					else
					{
						JOptionPane.showMessageDialog(log_w,"WRONG PASSWORD");
						user1.setText("");
						pass.setText("");
					}
				}
				catch(Exception m)
				{
					m.printStackTrace();
					System.out.println("error found ");
				}
		
				
			}
}
