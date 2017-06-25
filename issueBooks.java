import java.util.* ;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.*;
import java.sql.* ;
import java.lang.* ;
	class issueBooks extends JFrame implements ActionListener
	{
		
				
				public static JPanel fIssue ;
				public static JLabel backGroundI;
				public static JLabel titleIssueBook ;
				public static JLabel bName ;
				public static JLabel studentId;
				public static JLabel date ;
				public static JLabel bookId;
				public static JTextField getBName;
				public static JTextField getStudenId;
				public static JTextField getDate;
				public static JTextField getBookId;
				public static JButton issueB ;
				JLabel username;
				JButton home,logout;
				JPanel header,menus;
				String uname;
				public issueBooks(String uname)
				{
						this.uname=uname;
						setLayout(new BorderLayout());
						header=new JPanel(new GridLayout(1,3));
						username=new JLabel("Welcome "+uname);
						home=new JButton("HOME");
						logout=new JButton("LOGOUT");
						header.add(username);
						header.add(home);
						header.add(logout);
						add(header,BorderLayout.NORTH);
						try
						{
							fIssue = new JPanel();
							backGroundI = new JLabel(new ImageIcon("backwodden.jpg"));
							titleIssueBook = new JLabel(new ImageIcon("ISSUEBOOKSTITLE.png"));
							bName = new JLabel(new ImageIcon("BOOKNAME.png"));
							studentId = new JLabel(new ImageIcon("STUDENTID.png"));
							date = new JLabel(new ImageIcon("DATE.png"));
							bookId=  new JLabel(new ImageIcon("BOOKID.png"));
							getBName=new JTextField();
							getBName.setFont(new Font("Franklin Gothic Heavy",Font.BOLD,20));
							getBName.setForeground(Color.WHITE);
							getBName.setOpaque(false);
							getStudenId=new JTextField();
							getStudenId.setFont(new Font("Franklin Gothic Heavy",Font.BOLD,20));
							getStudenId.setForeground(Color.WHITE);
							getStudenId.setOpaque(false);
							getBookId=new JTextField();
							getBookId.setFont(new Font("Franklin Gothic Heavy",Font.BOLD,20));
							getBookId.setForeground(Color.WHITE);
							getBookId.setOpaque(false);
							getDate=new JTextField();
							getDate.setFont(new Font("Franklin Gothic Heavy",Font.BOLD,20));
							getDate.setForeground(Color.WHITE);
							getDate.setOpaque(false);
							issueB= new JButton(new ImageIcon("ISSUEBUTTON.jpg"));
							fIssue.setLayout(null);
							backGroundI.setBounds(0,0,600,500);
							fIssue.add(backGroundI);
							studentId.setBounds(50,125,150,50);
							backGroundI.add(studentId);
							bName.setBounds(50,200,150,50);
							backGroundI.add(bName);
							bookId.setBounds(50,270,150,50);
							backGroundI.add(bookId);
							date.setBounds(50,345,150,50);
							backGroundI.add(date);
							issueB.setBounds(50,425,150,50);
							backGroundI.add(issueB);
							getStudenId.setBounds(250,125,150,50);
							backGroundI.add(getStudenId);
							getBName.setBounds(250,200,150,50);
							backGroundI.add(getBName);
							getBookId.setBounds(250,270,150,50);
							backGroundI.add(getBookId);
							getDate.setBounds(250,345,150,50);
							backGroundI.add(getDate);
							issueB.setBounds(200,400,150,40);
							backGroundI.add(issueB);
							titleIssueBook.setBounds(100,20,300,60);
							backGroundI.add(titleIssueBook);
							issueB.addActionListener(this);
							home.addActionListener(this);
							logout.addActionListener(this);
							add(fIssue,BorderLayout.CENTER);
							setVisible(true);
							setResizable(false);
							setSize(600,500);
							setLocation(500,120);
								try
									{
											Class.forName("com.mysql.jdbc.Driver");
											Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost/libmansys","root","aA!@12");
											Statement stmt1 =conn1.createStatement();
											DatabaseMetaData dmd1=conn1.getMetaData();
											ResultSet found=dmd1.getTables(null,null,"issueBooks",null);
											if(!found.next())
											{	
												boolean status=stmt1.execute("create table issueBooks(stuId int ,book_name varchar(10),bI_id int,issueD varchar(99), status varchar(99))");
												System.out.println("Table Created");
											}
											 found=dmd1.getTables(null,null,"q_books",null);
											if(!found.next())
											{
												boolean status1=stmt1.execute("create table q_books(b_name varchar(10),b_quantity int)");
												System.out.println("Table Created");
											}
											conn1.close();
			
									}
								catch(Exception z)
									{
										
										System.out.println("error in creatting table");
									}
			
							
						} 
					catch(Exception aa)
						{
							System.out.println(aa);
						}
						setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
					else if(e.getSource()==issueB)
						{
							String studentid = getStudenId.getText();
							String s2= getBName.getText();
							String bookid =getBookId.getText();
							String s4 = getDate.getText();
							int s1= Integer.parseInt(studentid);
							int s3=Integer.parseInt(bookid);
							
						try
							{
								Class.forName("com.mysql.jdbc.Driver");
								Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost/libmansys","root","aA!@12");
								Statement stmt1 =conn1.createStatement();
								DatabaseMetaData dmd1=conn1.getMetaData();
								
								try
									{
										ResultSet found=dmd1.getTables(null,null,"issueBooks",null);
										if(!found.next())
											{	
												boolean status=stmt1.execute("create table issueBooks(stuId int ,book_name varchar(10),bI_id int,issueD varchar(99), status varchar(99) )");
												System.out.println("Table Created");
											}
										found=dmd1.getTables(null,null,"q_books",null);
											if(!found.next())
											{
												boolean status1=stmt1.execute("create table q_books(b_name varchar(10),b_quantity int)");
												System.out.println("Table Created");
											}
										ResultSet leftbooks=dmd1.getTables(null,null,"l_books",null);
										if(!leftbooks.next())
										{
										boolean Status2 = stmt1.execute("create table l_books(b_name varchar(20),b_quantity int)");
										System.out.println("Table Created");
										}
									}
									
									catch(Exception you)
									{
										System.out.println("error in creating tables");
									} 
									String bstatus= "issued";
									int countsee =0;
								ResultSet find = stmt1.executeQuery("select b_name from allbooks where b_name='"+s2+"' AND b_id ='"+s3+"'");
								while(find.next())
								{
									countsee++;
								}
								if(countsee ==0)
								{
									JOptionPane.showMessageDialog(fIssue,"PLEASE CHECK THE DETAILS");
								}
								else
								{	
								String issue ="insert into issueBooks values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+bstatus+"')";
								stmt1.executeUpdate(issue);  System.out.println("error is not here ");
								ResultSet getBookQuantity= stmt1.executeQuery("select b_quantity from l_books where b_name='"+s2+"'");
								getBookQuantity.next();
								int x=getBookQuantity.getInt(1);
								System.out.println(x);
								x=x-1; 
								stmt1.executeUpdate("update l_books set b_quantity="+x+" where b_name='"+s2+"' ");
								JOptionPane.showMessageDialog(fIssue,"book has been issued");
								getBName.setText("");
											getStudenId.setText("");
											getBookId.setText("");
											getDate.setText("");

								}
							}
							catch(Exception z)
							{
								System.out.println("error in creatting table");
								z.printStackTrace();
							}
						}
				}
			public static void main(String arg[])
				{
						//new issueBooks("WELCOME USER");
				}
	}

