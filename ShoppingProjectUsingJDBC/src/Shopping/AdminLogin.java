package Shopping;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminLogin {
	public void Admin() throws SQLException,ClassNotFoundException
	{
		java.sql.Connection con=null;
		int f=0;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","mysql","rcbvabkl@12399##@123AB");
        Scanner s=new Scanner(System.in);
        int m;
        System.out.println("Enter Your UserName");
        String username=s.next();
        System.out.println("Enter Your Password");
        String password=s.next();
        Statement smt=(Statement) con.createStatement();
        ResultSet rr=smt.executeQuery("Select * from admin");
        
        while(rr.next())
        {
        	if(username.equals(rr.getString(1))&&password.equals(rr.getString(2)))
        	{
        		f=1;
        	}
        }
        if(f==1)
        {
        	System.out.println("Successfully Verified");
        }
        else
        {
        	System.out.println("Incorrect Username or Password");
        }
        
        	do
        	{
        		System.out.println("1.Add Product");
        		System.out.println("2.Display");
        		System.out.println("3.Remove");
        		System.out.println("4.Update");
        		System.out.println("5.LogOut");
        		System.out.println("Enter Your Choice");
        		m=s.nextInt();
        		
        		switch(m)
        		{
        		case 1:
        			System.out.println("Enter Your Product Id");
        			int pid=s.nextInt();
        			System.out.println("Enter Your Product Name");
        			String pname=s.next();
        			System.out.println("Enter Your Size");
        			String size=s.next();
        			System.out.println("Enter Your Price");
        			double price=s.nextDouble();
        		    PreparedStatement ps=con.prepareStatement("insert into dress(ID,Name,Size,Price)values(?,?,?,?)");
        		    ps.setInt(1,pid);
        		    ps.setString(2,pname);
        		    ps.setString(3,size);
        		    ps.setDouble(4, price);
        		    ps.executeUpdate();
        		    System.out.println("product added successfully");
        		    break;
        		case 2:
        			Statement smt1=(Statement) con.createStatement();
        			ResultSet rs=smt1.executeQuery("Select * from dress");
        			System.out.println("###########***********##########");
        		
        			while(rs.next())
        			{
        			  System.out.println("ID -> "+rs.getInt(1)+"\n"+"Name ->"+rs.getString(2)+"\n"+"Size ->"+rs.getString(3)+"\n"+"Price ->"+rs.getDouble(4));	
        			}
        			System.out.println("#########*************############");
        			break;
        			
        		case 3:
        			Statement smt2=(Statement) con.createStatement();
        			ResultSet rs2=smt2.executeQuery("Select * from dress");
        			System.out.println("#########**********########");
        			while(rs2.next())
        			{
        				System.out.println("ID ->"+rs2.getInt(1)+"\n"+"Name ->"+rs2.getString(2));
        			}
        		
        			System.out.println("#########**********########");
       			    System.out.println("Product ID");
        			int id=s.nextInt();
        			PreparedStatement pp=con.prepareStatement("delete from dress where productid=?;");
        			pp.setInt(1, id);
        			pp.executeUpdate();
        			System.out.println("Successfully Removed");
        			break;
        			
        		case 4:
        			System.out.println("#########********########");
        			System.out.println("Enter product ID");
        			int idd=s.nextInt();
        			System.out.println("Enter New Size");
        		    String si=s.next();
        		    PreparedStatement pp1=con.prepareStatement("update dress set Size=? where ID=?");
        		    pp1.setInt(2, idd);
        		    pp1.setString(1, si);
        		    pp1.executeUpdate();
        		    System.out.println("Successfully Updated");
        		    break;
        		    
        		case 5:
        			return;
        		    
        		    
        			
        		}
        		
        	}
        	
        	while(m!=0);
        }
        
	
	}


