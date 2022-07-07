package order_managment_system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import order_managment_system.OrderManagement.Order;

interface OrderManagement {
	
	public class Order {
		private static String path = null,rPath="Delivered";
		private String Order_id;
		private String Order_Description;
		private String D_Address;
		private String Order_date;
		private String Amount;
		private String D_DateTime;
		static Scanner scan = new Scanner(System.in);
		DateFormat dtf = new SimpleDateFormat("yyyy/MM/dd'@'HH:mm:ss");
		Date now = new Date();
	
		static ArrayList<String> list = new ArrayList<String>();
		
		public void Add_order() {//ArrayList list = new ArrayList();

			System.out.println("Enter Order Id ");
			Order_id = scan.next();
			try {
				Scanner scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
				ArrayList<String> list = new ArrayList<String>();

				while (scan.hasNext()) {
					list.add(scan.next());
				} 
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).equals(Order_id)) {

						System.out.println("Duplicate Order Id. Please enter unique order id");
						Add_order();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(Order_id);
			System.out.println("Enetr Order Description ");
			Order_Description = scan.next();
			list.add(Order_Description);
			System.out.println("Enetr Order Delivery Address ");
			D_Address = scan.next();
			list.add(D_Address);
			System.out.println("Enetr the Amount ");
			Amount = scan.next();
			list.add(Amount);
			System.out.println("order time = " + dtf.format(now));
			list.add(dtf.format(now));
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Using today's date
			c.add(Calendar.DATE, 5); // Adding 5 days
			String output = dtf.format(c.getTime());
			System.out.println("Delivery Time = " + output);
			list.add(output);
			System.out.println("Order stuts : ");
			list.add("In_Progress");

			try {
				FileWriter fw = new FileWriter("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt", true);
				for (int i = 0; i < 7; i++) {
					fw.write((String) list.get(i) + "   ");
				}
				fw.write("\n");
				fw.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("Order Added Successfully");

			System.out.println("Do you want to enter more order details(Y/N)");
			String ch = scan.next();
			if (ch.charAt(0) == 'y' || ch.charAt(0) == 'Y') {
				list.clear();
				Add_order();

			} else if (ch.charAt(0) == 'n' || ch.charAt(0) == 'N') {
				main();
			}
		}

		public void ViewOrderList() {
			String filePath = "C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt";
			try {
			//	FileInputStream fis = new FileInputStream(filePath);
				Scanner scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
				ArrayList<String> list1 = new ArrayList<String>();
				while (scan.hasNext()) {
					list1.add(scan.next());
				}
				//int i = fis.read();
				System.out.println("Order id | Order Description | Delivery Address | Amount | Order date | Delivery date | Status ");
				for(int i=0; i<list1.size(); i++) {
					String str =list1.get(i);
					int len = str.length();
					String str1 = str+"       ";
					System.out.print(str1 + " |");
					if((i+1)%7==0) {
						System.out.println();
					}
				}
//				while (i != -1) {
//					System.out.print((char) i );
//					i = fis.read();
//				}
//				
//				System.out.println();
//				fis.close();
			} catch (FileNotFoundException ex) {
				System.out.println(ex);
				ex.getMessage();
			} catch (IOException ex) {
				System.out.println("cannot read the file");
			}

		}

		public void ViewOrderList(String id) {
			try {
				Scanner scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));

				ArrayList<String> list1 = new ArrayList<String>();
				ArrayList<String> data = new ArrayList<String>();
				data.add("Order id "); data.add("Order Description");data.add("Delivery Address");data.add("Amount ");data.add("Order date ");
				data.add("Delivery date ");data.add("Status ");
				while (scan.hasNext()) {
					list1.add(scan.next());
				}
				if (!(list1.contains(id))) {

					System.out.println("Please enter valid Order Id");
					return;
				}
				//System.out.println("returnig");
				int ind = list1.indexOf(id);
				int count=0;
				System.out.println("----------------------------------");
				System.out.println("Order Detail :");
				System.out.println("----------------------------------");
				for (int i = ind; i < ind + 6; i++) {
					//System.out.print(list1.get(i) + " ");
				
						System.out.println(data.get(count)+":"+list1.get(i));
					count++;
				}
				return;
				//scan.close();
				

			} catch (Exception e) {
				System.out.println("Enter valid order id");
			}
			

		}

		public void sortOrder() {

			System.out.println("******** Choose Sort Order Property********* ");
			System.out.println("  1.Order Id ");
			System.out.println("  2.Order Desc  ");
			System.out.println("  3.DeliveryAddress");
			System.out.println("  4.Amount  ");
			System.out.println("  5.Order Date ");
			System.out.println("  6.Delivery Datetime  ");
			System.out.println("  7.Exit  ");

			int ch = scan.nextInt();
			SortFuction obj1 = new SortFuction();
			switch (ch) {
			case 1:
				obj1.sortByOrderId();
				break;
			case 2:
				obj1.sortByOrderDesc();
				break;
			case 3:
				obj1.deleveryAddress();
				break;
			case 4:
				obj1.sortByAmount();
				break;
			case 5:
				obj1.sortByOrderDate();
				break;
			case 6:
				obj1.deliveryTine();
				break;
			case 7:
				return;
			}
		}

		public void DeleteById() {
			System.out.println("Enter the Order id ");
			String O_id = scan.next();
			try {
				Scanner scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
				ArrayList<String> list2 = new ArrayList<String>();
				while (scan.hasNext()) {
					list.add(scan.next());
				}
				System.out.println(list);

				if (!(list.contains(O_id))) {

					System.out.println("Please enter valid Order Id");
					DeleteById();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Scanner scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));

				ArrayList list3 = new ArrayList();
				while (scan.hasNext()) {
					list3.add(scan.nextLine());
				}
				int ind = 0;

				for (int i = 0; i < list3.size(); i++) {
					String str = (String) list3.get(i);
					if (str.startsWith(O_id)) {

						break;
					}
					ind++;
				}

				System.out.println(ind);
				try {
					list3.remove(ind);
				} catch (Exception e) {
					System.out.println("Id not Found the file is empty");
					return;
				}
				System.out.println(list3);
				scan.close();
				File file = new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt");
				PrintWriter writer = new PrintWriter(file);
				writer.print("");
				writer.close();

				try {
					FileWriter fw = new FileWriter("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt", true);
					for (int i = 0; i < list3.size(); i++) {
						fw.write((String) list3.get(i));
						fw.write("\n");
					}
					fw.write("\n");
					fw.close();
				} catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}

				System.out.println("Order deleted Succussfull");
				System.out.println("Do you want to delete another order(Y/N) ");

			} catch (Exception e) {
				System.out.println("Id Not found Enter valid order id");
				e.printStackTrace();
			}
			String ch1 = scan.next();
			if (ch1.charAt(0) == 'y' || ch1.charAt(0) == 'Y') {
				DeleteById();
			} else if (ch1.charAt(0) == 'n' || ch1.charAt(0) == 'N') {
				main();
			}

		}

		private void main() {
			return;

		}

		public void MarkAsDel() {
			System.out.println("enter order id ");
			Order_id = scan.next();
			
			
			try {
				Scanner scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
				ArrayList list3 = new ArrayList();
				while (scan.hasNext()) {
					list3.add(scan.next());
				}
				if(!(list3.contains(Order_id)))
				{
					System.out.println("Pleae enter valid order id");
					 MarkAsDel();
				}
				int ind = list3.indexOf(Order_id);
				for (int i = ind; i < ind + 7; i++) {
					list3.set((ind + 6), "Delivered");
				}
				File file = new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt");
				PrintWriter writer = new PrintWriter(file);
				writer.print("");
				writer.close();
				try {
					FileWriter fw = new FileWriter("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt", true);
					for (int i = 0; i < list3.size(); i++) {
						fw.write(list3.get(i) + "  ");
						if ((i + 1) % 7 == 0) {
							fw.write("\n");
						}

					}
					fw.close();
					System.out.println("Order is already delivered on : " + list3.get(ind+5));
				} catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void CancleById() {
			System.out.println("enter order id ");
			Order_id = scan.next();
			try {
				Scanner scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
				ArrayList list3 = new ArrayList();
				while (scan.hasNext()) {
					list3.add(scan.next());
				}
				int ind = list3.indexOf(Order_id);
					if((list3.get(ind+6).equals("Cancelled")))
					{
						System.out.println("Order is already cancelled");
						CancleById();
					}
			
				
					list3.set((ind + 6), "Cancelled");
					list3.set((ind + 5),"null");
					
				File file = new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt");
				PrintWriter writer = new PrintWriter(file);
				writer.print("");
				writer.close();
				
					FileWriter fw = new FileWriter("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt", true);
					for (int i = 0; i < list3.size(); i++) {
						fw.write(list3.get(i) + "  ");
						if ((i + 1) % 7 == 0) {
							fw.write("\n");
						}

					}
					fw.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Order Cancelled Succussfull");
			System.out.println("Do you want to delete another order(Y/N) ");
			String ch1 = scan.next();
			if (ch1.charAt(0) == 'y' || ch1.charAt(0) == 'Y') {
				CancleById();
			} else if (ch1.charAt(0) == 'n' || ch1.charAt(0) == 'N') {
				main();
			}


		}

		static String createFileStamp() {
			try {
				String filename = new Date().getTime() + "Order_Report_" + ".txt";

				File file = new File("C://Users//Sathisha Narayana//Desktop//Reports//" + filename);
				boolean value = file.createNewFile();
				System.out.println(file.getAbsolutePath());
				path = file.getAbsolutePath();

				if (value)
					System.out.println("file created");
				else
					System.out.println("file exist");

			} catch (Exception e) {
			}
			return path;

		}

		private static String byStatus(String str) {

			createFileStamp();
			System.out.println(path);
			try {
				Scanner scd = new Scanner(System.in);
				ListIterator li = null;
				ArrayList<String> nlist = new ArrayList<>();

				ArrayList<String> lf = new ArrayList<>(
						Files.readAllLines(Paths.get("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt")));
				//System.out.println(lf);
				//System.out.println("----------------------------");
				int ind = 0;
				for (int i = 0; i < lf.size(); i++) {
					String str1 = lf.get(i);
					//System.out.println("**********");
					String s4 = str1.trim();
					if (s4.endsWith(str))
						nlist.add(s4 + "\n");
				}


				FileWriter fw = new FileWriter(path, true);
				for (int i = 0; i < nlist.size(); i++) {
					fw.write(nlist.get(i) );
					if ((i + 1) % 10 == 0) {
						fw.write("\n");
					}
				}
				fw.write("\n");
				fw.close();
				System.out.println("Report Generated Successfully");

			} catch (Exception e) {
				System.out.println(e);
			}
			return null;

		}

		public static void GenReport() {
			System.out.println(" ******** Choose Report Generation Option ********* ");
			System.out.println("                1).Export All                       ");
			System.out.println("                2).By Status ");
			try {
				Scanner scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));

				while (scan.hasNext()) {
					list.add(scan.next());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			int ch = scan.nextInt();
			switch (1) {
			case 1:
				try {
					File file = new File("C:/Users/Sathisha Narayana/Desktop/GenaralReport.txt");

					PrintWriter writer = new PrintWriter(file);
					writer.print("");
					writer.close();

					FileWriter fw = new FileWriter("C:/Users/Sathisha Narayana/Desktop/GenaralReport.txt", true);
					for (int i = 0; i < list.size(); i++) {
						fw.write(list.get(i) + "\t" + " | " + "\t");
						if ((i + 1) % 7 == 0) {
							fw.write("\n");
						}
					}
					fw.write("\n");
					fw.close();
					System.out.println("Report Generated Successfully");
					break;

				} catch (Exception e) {
					e.printStackTrace();
				}
			case 2:
				System.out.println("******** Choose Status********* ");
				System.out.println("         1).In Progress			");
				System.out.println("         2).Delivered 			");
				System.out.println("         3).Cancelled		    ");
				Scanner scan = new Scanner(System.in);
				int ch1 = scan.nextInt();

				switch (ch1) {
				case 1:
					String str = "In_Progress";
					byStatus(str);
					break;
				case 2:
					String str1 = "Delivered";
					byStatus(str1);
					break;
				case 3:
					String str2 = "Cancelled";
					byStatus(str2);
					break;

				}

			}
		}
//		public static void run() {
//			
//			System.out.println("Generating Report");
//			try {
//				 GenReport();
//				
//				byStatus(rPath);
//				Thread.sleep(2000);
//				byStatus("In_Progress");
//				Thread.sleep(2000);
//				byStatus("Cancelled");
//				
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//
//		}
	}

}
