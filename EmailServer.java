import java.io.*;
public class EmailServer {
    public static void main(String[] args) {
	//Test Nov.16
	/*
	int error = FileIO.openMessagesFile(Globals.MESSAGES_FILE);
	if (error == Globals.PROCESS_OK) {
	    Record record = new Record("Dear Susan, how are you today? I am going to try to write you more frequently ab", 2);
	    record.writeToMessagesFile(0, Globals.APPEND);
	    Record record1 = new Record("Hi Johnny, do you want to go to the movies tonight? I have free passes. Suzie", -1);
	    record1.writeToMessagesFile(1, Globals.APPEND);
	    Record record2 = new Record("out the material that we had left open last time. It seems that the entries that", 3);
	    record2.writeToMessagesFile(2, Globals.APPEND);
	    Record record3 = new Record("you had included in the invoices contain some calculation errors. For example, t", 4);
	    record3.writeToMessagesFile(3, Globals.APPEND);
	    Record record4 = new Record("he first item has a price of $39.75 and there were 5 items ordered. The resultin", 6);
	    record4.writeToMessagesFile(4, Globals.APPEND);
	    Record record5 = new Record("To everyone at the sales department: This is a reminder that our monthly luncheo", 8);
	    record5.writeToMessagesFile(5, Globals.APPEND);
	    Record record6 = new Record("g price should be $39.75 x 5 = $198.75 but you have it showing as $201.25, and t ", 7);
	    record6.writeToMessagesFile(6, Globals.APPEND);
	    Record record7 = new Record("he tax is calculated based on this figure of $201.25. Could you please review th", 9);
	    record7.writeToMessagesFile(7, Globals.APPEND);
	    Record record8 = new Record("n will take place at Favourite Pizza, 275 Pepperoni Road. See you all there.", -1);
	    record8.writeToMessagesFile(8, Globals.APPEND);
	    Record record9 = new Record("e entire worksheet and email me a new copy. I truly appreciate it. Sincerely Pet", 10);
	    record9.writeToMessagesFile(9, Globals.APPEND);
	    Record record10 = new Record("er, Inventory Manager.", -1);
	    record10.writeToMessagesFile(10, Globals.APPEND);
	}
	else System.out.print("Error opening messages file");
	
	//Test 1
	Message message = new Message();
	message.readFromMessagesFile(1);
	System.out.println(message);
	//Test 2
	message.readFromMessagesFile(0);
	System.out.println(message);
	//Test 3
	message.readFromMessagesFile(5);
	System.out.println(message);
	FileIO.closeMessagesFile();
	*/
	
	//Test 1a
	/*
	int error = FileIO.openMessagesFile(Globals.MESSAGES_FILE);
	if (error == Globals.PROCESS_OK) {
	    Record record = new Record("Apple", 7);
	    record.writeToMessagesFile(0, Globals.APPEND);
	    FileIO.closeMessagesFile();
	}
	else System.out.print("Error opening messages file");
	*/
	
	//Test 1b
	/*
	int error2 = FileIO.openMessagesFile(Globals.MESSAGES_FILE);
	if (error2 == Globals.PROCESS_OK) {
	    Record record = new Record();
	    record.readFromMessagesFile(0);
	    System.out.println(record);
	    FileIO.closeMessagesFile();
	}
	else System.out.print("Error opening messages file");
	*/
	
	//Test 2a
	/*
	int error = FileIO.openMessagesFile(Globals.MESSAGES_FILE);
	if (error == Globals.PROCESS_OK) {
	    Record record = new Record("Apple1", 65);
	    record.writeToMessagesFile(0, Globals.APPEND);
	    Record record1 = new Record("Apple2", 7);
	    record1.writeToMessagesFile(1, Globals.APPEND);
	    Record record2 = new Record("Apple3", 7);
	    record2.writeToMessagesFile(2, Globals.APPEND);
	    Record record3 = new Record("Apple4", 7);
	    record3.writeToMessagesFile(3, Globals.APPEND);
	    Record record4 = new Record("Apple5", 7);
	    record4.writeToMessagesFile(4, Globals.APPEND);
	    Record record5 = new Record("Apple6", 7);
	    record5.writeToMessagesFile(5, Globals.APPEND);
	    Record record6 = new Record("Apple7", 7);
	    record6.writeToMessagesFile(6, Globals.APPEND);
	    Record record7 = new Record("Apple8", 7);
	    record7.writeToMessagesFile(7, Globals.APPEND);
	    Record record8 = new Record("Apple9", 7);
	    record8.writeToMessagesFile(8, Globals.APPEND);
	    Record record9 = new Record("Apple10", 7);
	    record9.writeToMessagesFile(9, Globals.APPEND);
	    Record record10 = new Record("Apple11", 7);
	    record10.writeToMessagesFile(10, Globals.APPEND);
	    FileIO.closeMessagesFile();
	}
	else System.out.print("Error opening messages file");
	
	//Test 2b
	int error2 = FileIO.openMessagesFile(Globals.MESSAGES_FILE);
	if (error2 == Globals.PROCESS_OK) {
	    Record record = new Record();
	    for (int i = 0; i < Globals.totalRecordsInMessageFile; i++) {
		record.readFromMessagesFile(i);
		System.out.println(record);
	    }
	    FileIO.closeMessagesFile();
	}
	else System.out.print("Error opening messages file");
	*/
	
	//Testing Record class
	/*
	Record record = new Record();
	byte[] data = record.getArray();
	for (int i = 0; i < data.length; i++) {
	    System.out.println("$" + (char) data[i] + "$" + "Line" + i);
	}
	
	System.out.println(record.getNext());
	System.out.println("$" + record.getData() + "$");
	System.out.println(record.getData().length() + "\n");
	
	Record record2 = new Record("Hello Sun!", 6);
	byte[] data2 = record2.getArray();
	for (int i = 0; i < data2.length; i++) {
	    if (data2[i] != 32) System.out.println((char) data2[i]);
	    else System.out.println("$" + (char) data2[i] + "$" + "Line" + i);
	}
	
	System.out.println(record2.getNext());
	System.out.println("$" + record2.getData() + "$");
	System.out.println(record2.getData().length());
	*/
	
	//Testing FiloIO and Globals class
	/*
	int error = FileIO.openMessagesFile(Globals.MESSAGES_FILE);
	
	if (error == Globals.PROCESS_OK) {
	    try {
		Globals.msg.writeBytes("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		Globals.msg.writeBytes("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		Globals.msg.writeBytes("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
		Globals.msg.writeBytes("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
		Globals.msg.writeBytes("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");

		System.out.println(Globals.totalRecordsInMessagesFile);
	    }
	    catch (IOException err) {
		System.out.print("Error writing to file");
	    }
	    FileIO.closeMessagesFile();
	}
	else System.out.print("Error opening messages file");
	*/
    }
}
