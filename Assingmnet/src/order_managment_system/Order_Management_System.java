package order_managment_system;

import java.util.Scanner;

import order_managment_system.OrderManagement.Order;

public class Order_Management_System extends Thread implements OrderManagement {
	

	public static void main(String[] args) {
		Order obj = new Order();
	//	obj.run();
		while(true) 
		{
			System.out.println("Menu :");
			System.out.println();
			System.out.println("*************Order Management System************");
			
			System.out.println("              1.)Add Order ");
			System.out.println("              2.)View Order List  ");
			System.out.println("              3.)View By Order Id  ");
			System.out.println("              4.)Sort Order  ");
			System.out.println("              5.)Delete Order by Id  ");
			System.out.println("              6.)Mark as Delivered.  ");
			System.out.println("              7.)Cancel Order ");
			System.out.println("              8.)Generate Report.  ");
			System.out.println("              9.)Exit ");
			int choose =0;
			Scanner scan = new Scanner(System.in);
			 choose = scan.nextInt();
			 
		
			
			switch(choose) 
			{
				
				case 1:
					
				    obj.Add_order();
				
				    break;
				case 2:
					obj.ViewOrderList();
					break;
				case 3:
					while(true) {
					System.out.println("Enter the Order id ");
					String id = scan.next();
					obj.ViewOrderList(id);
					break;
					}
					break;
				
				case 4:
					obj.sortOrder();
					break;
				case 5:
					obj.DeleteById();
					break;
				case 6:
					obj.MarkAsDel();
					break;
				case 7:
					obj.CancleById();
					break;
				case 8:
					obj.GenReport();
					break;
				case 9:
						System.out.println("Exiting the Program.....");
					
						System.exit(0);
				default:
					System.out.println("Please select the valid Option");
					
		   }
	   }
    }
}

