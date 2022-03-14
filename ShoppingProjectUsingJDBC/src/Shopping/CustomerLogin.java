package Shopping;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerLogin {

	
		public void CustomerLogin() throws SQLException,ClassNotFoundException
		{
	     
	     java.sql.Connection con=null;
	     int f=0;
	     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","mysql","rcbvabkl@12399##@123AB");
         Scanner s=new Scanner(System.in);
       int m=0;
         System.out.println("Enter Your UserName");
         String username=s.next();
         System.out.println("Enter Your Password");
         String password=s.next();
         Statement smt=(Statement)con.createStatement();
         ResultSet rr=smt.executeQuery("Select * from customer");
         while(rr.next())
         {
        	 if(username.equals(rr.getString(1))&&password.equals(rr.getString(2)));
        	 {
        		 f=1;
        	 }
         }
         if(f==1)
         {
        	 System.out.println("Successfully Verified!!!!!!!!!!");
         }
         else
         {
        	 System.out.println("Incorrect Username or Password");
         }
        	 do
        	 {
        		 System.out.println("1.Buy");
        		 System.out.println("2.View Product");
        		 System.out.println("3.Logout");
        		 System.out.println("Enter Your Choice");
        		 m=s.nextInt();
        		switch(m)
        		{
        		case 1:
        			System.out.println("Enter Product ID");
        			int pid=s.nextInt();
        			System.out.println("Enter Quantity");
        			int q=s.nextInt();
        			double price=0;
        			int flag=0;
        			Statement smt2=(Statement) con.createStatement();
        			ResultSet rr2=smt2.executeQuery("Select *from dress");
        			while(rr2.next())
        			{
        				if(pid==rr2.getInt(1))
        				{
        					 price = rr2.getDouble(4);
        					int quantity=rr2.getInt(5);
        					if(q<=quantity)
        					{
        						double sum=price*q;
        						System.out.println("Cost is "+sum);
        						flag=1;
        					}
        					else
        					{
        						System.out.println("Stack Overflow");
        						flag=0;
        					}
        				}
        			}
        			if(flag==1)
        			{
        				Statement smt4=(Statement) con.createStatement();
        				ResultSet rs4=smt4.executeQuery("Select *from dress");
        				int qua=0;
        				while(rs4.next())
        				{
        					int idd=rs4.getInt(1);
        					if(idd==pid)
        					{
        						int q1=rs4.getInt(5);
        						qua=q1-q;
        					}
        				}
        				PreparedStatement pss=con.prepareStatement("update dress set quantity=? where ID=?");
        				pss.setInt(1, qua);
        				pss.setInt(2, pid);
        				pss.executeUpdate();
        				
        			}
        		     break;
        		case 2:
        			Statement smt1=(Statement) con.createStatement();
        			ResultSet rs=smt1.executeQuery("Select * from dress");
        			System.out.println("--------List Of Product------");
        			System.out.println("#############################");
        			while(rs.next())
        			{
        				System.out.println("ID"+rs.getInt(1)+"\n"+"Name"+rs.getString(2)+"\n"+"Quantity"+rs.getInt(5));
        			}
        			System.out.println("############################");
        			break;
        		case 3:
        			return;
        		
        		}
        		 
        	 }while(m!=0);
        		 
         }
        
         }


