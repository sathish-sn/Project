package order_managment_system;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortFuction implements OrderManagement {
	Scanner scan = new Scanner(System.in);

	public void sortByOrderId() {

		System.out.println("******** Choose Sort Order *********");
		System.out.println("            1).Ascending            ");
		System.out.println("            2).Descending             ");
		int num = scan.nextInt();

		try {
			scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> list2 = new ArrayList<String>();
		while (scan.hasNext()) {
			list2.add(scan.next());
		}

		ArrayList IDlist = new ArrayList();
		for (int i = 0; i < list2.size(); i = i + 7) {
			IDlist.add(list2.get(i));
		}
		switch (num) {
		case 1:
			Collections.sort(IDlist);
			break;
		case 2:
			Collections.sort(IDlist, Collections.reverseOrder());
			break;
		}
	
		System.out.println(IDlist);
		System.out.println(IDlist.indexOf(3));

		try {
			Scanner scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
			ArrayList<String> list1 = new ArrayList<String>();
			while (scan.hasNext()) {
				list1.add(scan.next());
			}
			System.out.println(list1.size());
			for (int j = 0; j < IDlist.size(); j++) {
				String str = (String) IDlist.get(j);
				int ind = list1.indexOf(str);
				for (int i = ind; i < ind + 7; i++) {
					System.out.print(list1.get(i) + " ");
				}
				System.out.println();
			}
			scan.close();
			System.out.println();

		} catch (Exception e) {
			System.out.println("Enter valid order id");
			e.printStackTrace();
		}
	}

	public void sortByOrderDesc() {
		System.out.println("******** Choose Sort Order *********");
		System.out.println("            1).Ascending            ");
		System.out.println("            2).Descending             ");
		int num = scan.nextInt();
		try {
			scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> list2 = new ArrayList<String>();
		while (scan.hasNext()) {
			list2.add(scan.next());
		}

		ArrayList or_desc = new ArrayList();
		for (int i = 1; i < list2.size(); i = i + 7) {
			or_desc.add(list2.get(i));
		}
		switch (num) {
		case 1:
			Collections.sort(or_desc);
			break;
		case 2:
			Collections.sort(or_desc, Collections.reverseOrder());
			break;
		}

		try {
			Scanner scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
			ArrayList<String> list1 = new ArrayList<String>();
			while (scan.hasNext()) {
				list1.add(scan.next());
			}
			for (int j = 0; j < or_desc.size(); j++) {
				String str = (String) or_desc.get(j);
				int ind = list1.indexOf(str);
				list1.remove(ind);
				list1.add((ind - 1), str);

				for (int i = ind - 1; i < ind + 6; i++) {

					System.out.print(list1.get(i) + " ");
				}
				System.out.println();
			}
			System.out.println(list1);
			scan.close();
			System.out.println();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void deleveryAddress() {
		System.out.println("******** Choose Sort Order *********");
		System.out.println("            1).Ascending            ");
		System.out.println("            2).Descending             ");
		int num = scan.nextInt();
		try {
			scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> list2 = new ArrayList<String>();
		while (scan.hasNext()) {
			list2.add(scan.next());
		}
		ArrayList d_add = new ArrayList();
		for (int i = 2; i < list2.size(); i = i + 7) {
			d_add.add(list2.get(i));
		}
		switch (num) {
		case 1:
			Collections.sort(d_add);
			break;
		case 2:
			Collections.sort(d_add, Collections.reverseOrder());
			break;
		}

		try {
			Scanner scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));

			ArrayList<String> list1 = new ArrayList<String>();
			while (scan.hasNext()) {
				list1.add(scan.next());
			}
			ArrayList<String> tempList = new ArrayList<String>(list1);

			for (int j = 0; j < d_add.size(); j++) {
				String str = (String) d_add.get(j);

				int ind = tempList.indexOf(str);

				list1.remove(ind);
				list1.add((ind - 2), str);

				for (int i = ind - 2; i < ind + 5; i++) {

					System.out.print(list1.get(i) + " ");
				}
				System.out.println();
			}

			scan.close();
			System.out.println();

		} catch (Exception e) {
			System.out.println("Enter valid order id");
			e.printStackTrace();
		}

	}

	public void sortByAmount() {
		System.out.println("******** Choose Sort Order *********");
		System.out.println("            1).Ascending            ");
		System.out.println("            2).Descending             ");
		int num = scan.nextInt();

		try {
			scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> list2 = new ArrayList<String>();
		while (scan.hasNext()) {
			list2.add(scan.next());
		}
		ArrayList amount = new ArrayList();
		for (int i = 3; i < list2.size(); i = i + 7) {
			amount.add(list2.get(i));
		}
		switch (num) {
		case 1:
			Collections.sort(amount);
			break;
		case 2:
			Collections.sort(amount, Collections.reverseOrder());
			break;
		}
		System.out.println(amount);

		try {
			Scanner scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
			ArrayList<String> list1 = new ArrayList<String>();
			while (scan.hasNext()) {
				list1.add(scan.next());
			}
			ArrayList<String> tempList = new ArrayList<String>(list1);

			for (int j = 0; j < amount.size(); j++) {
				String str = (String) amount.get(j);

				int ind = tempList.indexOf(str);
				list1.remove(ind);
				list1.add((ind - 3), str);
				for (int i = ind - 3; i < ind + 4; i++) {

					System.out.print(list1.get(i) + " ");
				}
				System.out.println();
			}

			scan.close();
			System.out.println();

		} catch (Exception e) {
			System.out.println("Enter valid order id");
			e.printStackTrace();
		}

	}

	public void sortByOrderDate() {
		System.out.println("******** Choose Sort Order *********");
		System.out.println("            1).Ascending            ");
		System.out.println("            2).Descending             ");
		int num = scan.nextInt();
		try {
			scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> list2 = new ArrayList<String>();
		while (scan.hasNext()) {
			list2.add(scan.next());
		}
		ArrayList O_date = new ArrayList();
		for (int i = 4; i < list2.size(); i = i + 7) {
			O_date.add(list2.get(i));
		}
		switch (num) {
		case 1:
			Collections.sort(O_date);
			break;
		case 2:
			Collections.sort(O_date, Collections.reverseOrder());
			break;
		}
		try {
			Scanner scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
			ArrayList<String> list1 = new ArrayList<String>();
			while (scan.hasNext()) {
				list1.add(scan.next());
			}
			ArrayList<String> tempList = new ArrayList<String>(list1);

			for (int j = 0; j < O_date.size(); j++) {
				String str = (String) O_date.get(j);

				int ind = tempList.indexOf(str);
				list1.remove(ind);
				list1.add((ind - 4), str);
				for (int i = ind - 4; i < ind + 3; i++) {

					System.out.print(list1.get(i) + " ");
				}
				System.out.println();
			}
			scan.close();
			System.out.println();

		} catch (Exception e) {
			System.out.println("Enter valid order id");
			e.printStackTrace();
		}

	}

	public void deliveryTine() {
		System.out.println("******** Choose Sort Order *********");
		System.out.println("            1).Ascending            ");
		System.out.println("            2).Descending             ");
		int num = scan.nextInt();

		try {
			scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> list2 = new ArrayList<String>();
		while (scan.hasNext()) {
			list2.add(scan.next());
		}
		ArrayList D_date = new ArrayList();
		for (int i = 5; i < list2.size(); i = i + 7) {
			D_date.add(list2.get(i));
		}
		switch (num) {
		case 1:
			Collections.sort(D_date);
			break;
		case 2:
			Collections.sort(D_date, Collections.reverseOrder());
			break;
		}
		try {
			Scanner scan = new Scanner(new File("C:/Users/Sathisha Narayana/Desktop/OrderManagement.txt"));
			ArrayList<String> list1 = new ArrayList<String>();
			while (scan.hasNext()) {
				list1.add(scan.next());
			}
			ArrayList<String> tempList = new ArrayList<String>(list1);

			for (int j = 0; j < D_date.size(); j++) {
				String str = (String) D_date.get(j);

				int ind = tempList.indexOf(str);
				list1.remove(ind);
				list1.add((ind - 5), str);
				for (int i = ind - 5; i < ind + 2; i++) {

					System.out.print(list1.get(i) + " ");
				}
				System.out.println();
			}
			scan.close();
			System.out.println();

		} catch (Exception e) {
			System.out.println("Enter valid order id");
			e.printStackTrace();
		}

	}

}
