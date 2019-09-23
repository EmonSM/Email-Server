public class Testing {
    public static void main(String[] args) {
	Globals.availableList = new AvailableList();
	Message message = new Message();
	int error = FileIO.openMessagesFile(Globals.MESSAGES_FILE);
	if (error == Globals.PROCESS_OK) {
	    message.setText("HelloooHelloooHelloooHelloooHelloooHelloooHelloooHelloooHelloooHelloooHelloooHelloooHelloooHelloooHelloooHelloooHelloooHelloooHelloooHelloooHellooo");
	    message.writeToMessagesFile();
	    message.setText("Helloooa");
	    message.writeToMessagesFile();
	    message.deleteFromMessagesFile(0);
	    message.deleteFromMessagesFile(2);
	    System.out.println(Globals.availableList);
	    
	    /*
	    message.setText("Helloooa");
	    System.out.println(message.writeToMessagesFile());
	    message.setText("Helloob");
	    System.out.println(message.writeToMessagesFile());
	    message.setText("Hellooc");
	    System.out.println(message.writeToMessagesFile());
	    message.setText("Hellood");
	    System.out.println(message.writeToMessagesFile());
	    message.readFromMessagesFile(1);
	    System.out.println(message);*/
	    FileIO.closeMessagesFile();
	}

	/*
	list.addRecord(5);
	list.addRecord(7);
	list.addRecord(0);
	list.getNextRecord();
	list.getNextRecord();
	list.getNextRecord();
	
	System.out.println(list);
	*/
    
	/*SLList list = new SLList();
	
	SNode a = new SNode("John", 82.6, null);
	SNode b = new SNode("Peter", 82.6, null);
	SNode c = new SNode("Paul", 82.6, null);
	SNode d = new SNode("Fayyad", 82.6, null);
	SNode e = new SNode("Peggy", 82.6, null);
	SNode f = new SNode("Kohava", 82.6, null);
	SNode g = new SNode("Nafis", 82.6, null);
	SNode h = new SNode("Mario", 82.6, null);
	list.insertNodeAlpha(a);
	list.insertNodeAlpha(b);
	list.insertNodeAlpha(c);
	list.insertNodeAlpha(d);
	list.insertNodeAlpha(e);
	list.insertNodeAlpha(f);
	list.insertNodeAlpha(g);
	list.insertNodeAlpha(h);
	list.deleteNode(g);
	System.out.println(list);
	
	SNode p = list.findNode("Nafis");
	System.out.println(p != null ? p.toString() : "not found");*/
    }
}
