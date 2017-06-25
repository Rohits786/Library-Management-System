import java.util.* ;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.*;
import java.sql.* ;
import java.lang.* ;
class returnBooks extends JFrame implements ActionListener 
{
	public static JPanel frameReturn;
	public static JLabel backgroundReturn;
	public static JLabel returnTitle;
	public static JLabel bookId;
	public static JTextField getBookId;
	public static JLabel Bname ;
	public static JTextField getBname;
	public static JLabel studentId;
	public static JTextField getStudenId;
	public static JButton returnButton;
	JLabel username;
	JButton home,logout ;
	JPanel header, menus;
	String uname ;
	public returnBooks(String uname)
	{
		this.uname= uname ;
		setLayout(new BorderLayout());
		header=new JPanel(new GridLayout(1,3));
		username=new JLabel("Welcome "+uname);
		home=new JButton("HOME");
		logout=new JButton("LOGOUT");
		header.add(username);
		header.add(home);
		header.add(logout);
		add(header,BorderLayout.NORTH);
		frameReturn = new JPanel();
		backgroundReturn = new JLabel(new ImageIcon("backwodden.jpg"));
		returnTitle= new JLabel(new ImageIcon("RETURNBOOK.png"));
		bookId =  new JLabel(new ImageIcon("BOOKID.png"));
		getBookId = new JTextField();
		getBookId.setFont(new Font("Franklin Gothic Heavy",Font.BOLD,20));
		getBookId.setForeground(Color.WHITE);
		getBookId.setOpaque(false);
		studentId= new JLabel(new ImageIcon("STUDENTID.png"));
		getStudenId = new JTextField();
		getStudenId.setFont(new Font("Franklin Gothic Heavy",Font.BOLD,20));
		getStudenId.setForeground(Color.WHITE);
		getStudenId.setOpaque(false);
		returnButton = new JButton(new ImageIcon("RETURN.jpg"));
		Bname = new JLabel(new ImageIcon("BOOKNAME.png"));
		getBname= new JTextField();
		getBname.setFont(new Font("Franklin Gothic Heavy",Font.BOLD,20));
		getBname.setForeground(Color.WHITE);
		getBname.setOpaque(false);
		frameReturn.setLayout(null);
		backgroundReturn.setBounds(0,0,600,500);
		frameReturn.add(backgroundReturn);
		returnTitle.setBounds(50,50,500,50);
		backgroundReturn.add(returnTitle);
		studentId.setBounds(50,125,150,50);
		backgroundReturn.add(studentId);
		getStudenId.setBounds(250,125,150,50);
		backgroundReturn.add(getStudenId);
		bookId.setBounds(50,210,150,50);
		backgroundReturn.add(bookId);
		getBookId.setBounds(250,210,150,50);
		backgroundReturn.add(getBookId);
		Bname.setBounds(50,295,150,50);
		backgroundReturn.add(Bname);
		getBname.setBounds(250,295,175,50);
		backgroundReturn.add(getBname);
		returnButton.setBounds(215,360,100,50);
		backgroundReturn.add(returnButton);
		returnButton.addActionListener(this);
		home.addActionListener(this);
		logout.addActionListener(this);
		add(frameReturn,BorderLayout.CENTER); 
		setResizable(false);
		setVisible(true);
		setSize(600,500);
		setLocation(500,120);
	}
		public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==home)
					{
					setVisible(false);
					new welcome(uname);			
					}
				else if(e.getSource()==logout)
					{
					setVisible(false);
					new logW();
					}
				else if(e.getSource()==returnButton)
				{
					int count=0;
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn9 = DriverManager.getConnection("jdbc:mysql://localhost/libmansys","root","aA!@12");
						Statement stmt9 =conn9.createStatement();
						DatabaseMetaData dmd9=conn9.getMetaData();
						ResultSet rBooks=dmd9.getTables(null,null,"r_books",null);
						if(!rBooks.next())
						{
							boolean statusR = stmt9.execute(" create table r_books (studId int , book_id int , status varchar(99) , date varchar(99),bNamer varchar(99) )");
							System.out.println("Tabel has been created");
						}
						String GETSID = getStudenId.getText();
						String GETBID= getBookId.getText();
						int s1= Integer.parseInt(GETSID);
						int s2= Integer.parseInt(GETBID);
						String  s3=getBname.getText();
						String status_r ="Returned";
						java.text.SimpleDateFormat sdfDate = new java.text.SimpleDateFormat("dd-MM-yyyy");
						java.util.Date date = new java.util.Date();
						String curDate = sdfDate.format(date);
						ResultSet getbid = stmt9.executeQuery("select bI_id  from issueBooks where bI_id='"+s2+"' AND stuId='"+s1+"'");
						while(getbid.next()){
							count++;
				
						}
						if(count==0)
							{
								getStudenId.setText("");
								getBookId.setText("");
								getBname.setText("");
								JOptionPane.showMessageDialog(frameReturn,"BOOK NOT EXIST");
					
							}
						else
							{
							stmt9.executeUpdate("insert into r_books values('"+s1+"','"+s2+"','"+status_r+"','"+curDate+"','"+s3+"') ");
							ResultSet updateQ = stmt9.executeQuery("select b_quantity from l_books where b_name='"+s3+"'");
							updateQ.next();
							int x = updateQ.getInt(1);
							x=x+1;
							stmt9.executeUpdate("update l_books set b_quantity="+x+" where b_name='"+s3+"' ");
							getStudenId.setText("");
							getBookId.setText("");
							getBname.setText("");
							JOptionPane.showMessageDialog(frameReturn,"BOOK HAS BEEN SUCCESFULLY RETURNED");
							
							}	
					}
					catch(Exception us)
						{
							System.out.println("Error is there");
							us.printStackTrace();
						}
				}
			}
		
	
	
	public static void main(String arv[])
	{
		//new returnBooks("WELCOME USER");
	}
}
	