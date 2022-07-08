package order_managment_system;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import order_managment_system.OrderManagement.Order;

public class Test1 implements  Runnable  {
	private volatile  String path = null;
	private String str;
	public  Test1(String str) {
		this.str = str;
}
	public void run() {
		 System.out.println("multithreading is running");

		Order obj = new Order();
		path = obj.createFileStamp();
		System.out.println(path);
		try {
			Scanner scd = new Scanner(System.in);
			ArrayList<String> list = new ArrayList<>();

			ArrayList<String> lf = new ArrayList<>(
					Files.readAllLines(Paths.get("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt")));
System.out.println(lf);
			int ind = 0;
			for (int i = 0; i < lf.size(); i++) {
				String str1 = lf.get(i);
				String s4 = str1.trim();
				if (s4.endsWith(str))
					list.add(s4 + "\n");
			}

			FileWriter fw = new FileWriter(path, true);
			for (int i = 0; i < lf.size(); i++) {
				System.out.println("ashghgkdashdsh");
				fw.write( lf.get(i));
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
	}

}
