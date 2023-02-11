import java.util.*;
import java.io.*;

public class client{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		//this definitely works boi!! (loved it for sure man!!)
		MyyLinkedList list = new MyyLinkedList();
		list.addFirst(5);
		list.addFirst(6);
		list.addFirst(7);
		list.addLast(8);
		list.addLast(9);

		int x = list.getAtIndex(3);
		int y = list.getAtIndex(4);
		int z =list.getAtIndex(0);

		list.display();

		System.out.println();

		// System.out.println(x);
		// System.out.println(y);
		// System.out.println(z);

		list.removeAtIndex(3);
		list.display();

		System.out.println();

		list.addAtIndex(20, 3);
		list.display();

		

	}

}