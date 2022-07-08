package order_managment_system;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import order_managment_system.OrderManagement.Order;

public class Test1 extends Order implements Runnable {
	private volatile String path = null;
	private String str;

	public Test1(String str) {
		this.str = str;
	}

	public void run() {
		System.out.println("multithreading is running");

		Order obj = new Order();
		path = obj.createFileStamp();
		System.out.println(path);
		try {

			ArrayList  StoreTrimdLines = new ArrayList();

			ArrayList  List = new ArrayList(
					Files.readAllLines(Paths.get("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt")));

			String Lines = null;
			for (int i = 0; i < List.size(); i++) {
				Lines = (String) List.get(i);

				String TrimmedSrting = Lines.trim();

				if (TrimmedSrting.endsWith(str)) {
					StoreTrimdLines.add(Lines + "\n");
				}
			}
			System.out.println(path);
			FileWriter fileWriter = new FileWriter(path, true);
			for (int i = 0; i < StoreTrimdLines.size(); i++) {
					String str = String.valueOf(StoreTrimdLines.get(i));
				fileWriter.write( str );
				if ((i + 1) % 7 == 0) {
					fileWriter.write("\n");
				}
			}
			fileWriter.write("\n");
			fileWriter.close();
			System.out.println("Report Generated Successfully");

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
