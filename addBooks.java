import java.util.* ;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.*;
import java.sql.* ;
import java.lang.* ;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;

class addBooks extends JFrame implements ActionListener{
	public static JPanel newBooks ;
	public static JLabel backGround1;
	public static JButton submit2 ;
	public static JLabel bookName;
	public static JTextField getBookName;
	public static JLabel bookId;
	public static JLabel bookAuthor;
	public static JTextField getBookAuthor;
	public static JLabel bookPublisher;
	public static JTextField getBookPublisher;
	public static JLabel price;
	public static JTextField getPrice;
	public static JLabel quantity ;
	public static JTextField getQuantity;
	public static JLabel title ;
	JLabel username;
	JButton home,logout;
	JPanel header,menus;
	String uname;
	public addBooks(String uname){
		this.uname=uname;
		setLayout(new BorderLayout());
		header=new JPanel(new GridLayout(1,3));
		username=new JLabel("Welcome " +uname);
		home=new JButton("HOME");
		logout=new JButton("LOGOUT");
		header.add(username);
		header.add(home);
		header.add(logout);
		add(header,BorderLayout.NORTH);
			newBooks = new JPanel();
			Border border = BorderFactory.createLineBorder(Color.GRAY);
			title = new JLabel(new ImageIcon("BOOKUPDATETITLE1.png"));
			backGround1 = new JLabel(new ImageIcon("backwodden.jpg") );
			bookName =new JLabel(new ImageIcon("BOOKNAME.png"));
			getBookName = new JTextField();
			getBookName.setFont(new Font("Franklin Gothic Heavy",Font.BOLD,20));
			getBookName.setForeground(Color.WHITE);
			getBookName.setBorder(border);
			getBookName.setOpaque(false);
			bookAuthor = new JLabel(new ImageIcon("BOOKAUTHOR.png"));
			getBookAuthor = new JTextField();
			getBookAuthor.setFont(new Font("Franklin Gothic Heavy",Font.BOLD,20));
			getBookAuthor.setForeground(Color.WHITE);
			getBookAuthor.setBorder(border);
			getBookAuthor.setOpaque(false);
			bookAuthor = new JLabel(new ImageIcon("BOOKAUTHOR.png"));
			bookPublisher = new JLabel(new ImageIcon("BOOKPUBLISHER.png"));
			getBookPublisher = new JTextField();
			getBookPublisher.setBorder(border);
			getBookPublisher.setFont(new Font("Franklin Gothic Heavy",Font.BOLD,20));
			getBookPublisher.setForeground(Color.WHITE);
			getBookPublisher.setOpaque(false);
			price = new JLabel(new ImageIcon("PRICE.png"));
			
			getPrice = new JTextField();
			getPrice.setBorder(border);
			getPrice.setFont(new Font("Franklin Gothic Heavy",Font.BOLD,20));
			getPrice.setForeground(Color.WHITE);
			getPrice.setOpaque(false);
			quantity = new JLabel(new ImageIcon("QUANTITY.png"));
			getQuantity = new JTextField();
			getQuantity.setBorder(border);
			getQuantity.setFont(new Font("Franklin Gothic Heavy",Font.BOLD,20));
			getQuantity.setForeground(Color.WHITE);
			getQuantity.setOpaque(false);
			
			submit2 = new JButton(new ImageIcon("SAVE.jpg"));
			newBooks.setLayout(null);
			backGround1.setBounds(0,0,600,500);
			newBooks.add(backGround1);
			title.setBounds(10,25,500,55);
		//	System.out.println("backGround1 se phale ");
			backGround1.add(title);
			bookName.setBounds(10,100,150,50);
			backGround1.add(bookName);
			getBookName.setBounds(175,100,250,50);
			backGround1.add(getBookName);
			bookAuthor.setBounds(10,175,150,50);
			backGround1.add(bookAuthor);
			getBookAuthor.setBounds(175,175,250,50);
			backGround1.add(getBookAuthor);
			bookPublisher.setBounds(10,250,150,50);
			backGround1.add(bookPublisher);
			getBookPublisher.setBounds(175,250,250,50);
			backGround1.add(getBookPublisher);
			quantity.setBounds(10,325,150,50);
			backGround1.add(quantity);
			getQuantity.setBounds(175,325,150,50);
			backGround1.add(getQuantity);
			price.setBounds(10,400,150,50);
			backGround1.add(price);
			getPrice.setBounds(175,400,150,50);
			backGround1.add(getPrice);
			submit2.setBounds(425,350,100,50);
			backGround1.add(submit2);
			submit2.addActionListener(this);
			home.addActionListener(this);
			logout.addActionListener(this);
			add(newBooks,BorderLayout.CENTER);
			setResizable(false);
			setVisible(true);
			setSize(600,500);
			setLocation(500,120);
				try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/libmansys","root","aA!@12");
			Statement stmt =conn.createStatement();
			DatabaseMetaData dmd=conn.getMetaData();
			ResultSet rs=dmd.getTables(null,null,"allbooks",null);
			if(!rs.next())
			{	
				boolean status=stmt.execute("create table allbooks(b_id int,b_name varchar(10),a_name varchar(10),p_name varchar(20),price varchar(10))");
				System.out.println("Table Created");
			}
			ResultSet rs1=dmd.getTables(null,null,"q_books",null);
			if(!rs1.next())
			{
				boolean status1=stmt.execute("create table q_books(b_name varchar(10),b_quantity int)");
				System.out.println("Table Created");
			}
			ResultSet leftbooks=dmd.getTables(null,null,"l_books",null);
			if(!leftbooks.next())
			{
				boolean Status2 = stmt.execute("create table l_books(b_name varchar(20),b_quantity int)");
				System.out.println("Table Created");
			}
			
			
		}
		catch(Exception z)
		{
			
			System.out.println("error in creatting table");
		}
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==home){
			setVisible(false);
			new welcome(uname);			
		}else if(e.getSource()==logout){
			setVisible(false);
			new logW();
		}else if(e.getSource()==submit2){
		    int getQ=0;
			int s1=0;
			String s2 = getBookName.getText();
			String s3 = getBookAuthor.getText();
			String s4 =getBookPublisher.getText();
			String text =getQuantity.getText();
			String text1 =getPrice.getText();
			int s5 = Integer.parseInt(text);
			int s6 = Integer.parseInt(text1);
			try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/libmansys","root","aA!@12");
			Statement stmt =conn.createStatement();
			DatabaseMetaData dmd=conn.getMetaData();
			ResultSet rs=dmd.getTables(null,null,"allbooks",null);
			if(!rs.next())
			{	
				boolean status=stmt.execute("create table allbooks(b_id int,b_name varchar(10),a_name varchar(10),p_name varchar(20),price varchar(10))");
				System.out.println("Table Created");
			}
			ResultSet rs1=dmd.getTables(null,null,"q_books",null);
			if(!rs1.next())
			{
				boolean status1=stmt.execute("create table q_books(b_name varchar(10),b_quantity int)");
				System.out.println("Table Created");
			}
			ResultSet leftbooks=dmd.getTables(null,null,"l_books",null);
			if(!leftbooks.next())
			{
				boolean Status2 = stmt.execute("create table l_books(b_name varchar(20),b_quantity int)");
				System.out.println("Table Created");
			}
						
			
		rs = stmt.executeQuery("select max(b_id) from allbooks" ) ;
		rs.next();
		int x= rs.getInt(1);
		System.out.println(x);
		x=x+1;
			try
			{
				String G="insert into allbooks values('"+x+"','"+s2+"','"+s3+"','"+s4+"','"+text1+"')";
				stmt.executeUpdate(G);
				
				try 
				{
					if(x==1)
					{
						stmt.executeUpdate("insert into q_books values('"+s2+"','"+s5+"')");
						stmt.executeUpdate("insert into l_books values('"+s2+"','"+s5+"')");
						System.out.println("value inserted in the q_books");
						JOptionPane.showMessageDialog(newBooks,"BOOK ID IS "+x);
						getBookName.setText("");
						getBookAuthor.setText("");
						getBookPublisher.setText("");
						getQuantity.setText("");
						getPrice.setText("");
					}
					else 
					{
						int countme=0;
						int z1=0;
						ResultSet ls=stmt.executeQuery("select * from q_books where b_name='"+s2+"'");
						while(ls.next())
						{
							getQ=ls.getInt("b_quantity");
							 
						}
						ResultSet me = stmt.executeQuery("select * from l_books where b_name='"+s2+"'");						
						while(me.next())
						{
							countme++;
							z1=me.getInt("b_quantity");
						}
						
						
						
						
						if(countme==0)
						{
							stmt.executeUpdate("insert into l_books values('"+s2+"','"+s5+"')");
						}
						
						z1=z1+s5;
						getQ=getQ+s5;
						stmt.executeUpdate("update q_books set b_quantity='"+getQ+"' where b_name='"+s2+"'");
						stmt.executeUpdate("update l_books set b_quantity='"+z1+"' where b_name='"+s2+"'");
						JOptionPane.showMessageDialog(newBooks,"BOOK ID IS "+x);
						getBookName.setText("");
						getBookAuthor.setText("");
						getBookPublisher.setText("");
						getQuantity.setText("");
						getPrice.setText("");
					}
				}
				catch(Exception h)
				{
					System.out.println("error is there in all books");
					h.printStackTrace();
				}
			}
			catch(Exception f)
			{
				f.printStackTrace();
				System.out.println("error in inserting the values");
			}
			
		}
		catch(Exception z)
		{
			
			System.out.println("error in creating table");
		}
	}
			
	}
		public static void main(String arg[])
		{
			//new addBooks("WELCOME USER");
		}
}