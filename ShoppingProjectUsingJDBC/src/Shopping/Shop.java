package Shopping;

import java.sql.SQLException;
import java.util.Scanner;

public class Shop {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	System.out.println("1.Admin Login");
	System.out.println("2.Customer Login");
	System.out.println("3.Exit");
	System.out.println("Enter Your Choice");
	AdminLogin al=new AdminLogin();
	CustomerLogin cl=new CustomerLogin();
	Scanner s=new Scanner(System.in);
	int a=s.nextInt();
	switch(a)
	{
	case 1:
		al.Admin();
		break;
	case 2:
		cl.CustomerLogin();
		break;
		
	case 3:
		return;
	}
    
	}

}
