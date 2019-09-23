public class Message {
    private String text = null;
    
    public Message() {
	text = null;
    }
    
    public void readFromMessagesFile(int recordNumber) {
	String data = "";
	Record record = new Record();
	
	do {
	    record.readFromMessagesFile(recordNumber);
	    data += record.getData();
	    recordNumber = record.getNext();
	} while (recordNumber != Globals.END_OF_MESSAGE);
	
	text = data;
    }
    
    public void setText(String t) {
	text = t;
    }
    
    public int writeToMessagesFile() {
	String s = text;
	int recordNumber = -1;  //current record
	int nextRecordNumber = -1;  //link to next record
	int startRecordNumber = -1; //first record of message
	
	startRecordNumber = Globals.availableList.getHead() == null ? Globals.totalRecordsInMessageFile : Globals.availableList.getHead().getRecordNumber();
       
	Record record = new Record();
	
	while (!s.equals("")) {
	    if (Globals.availableList.getHead() == null) {
		recordNumber = Globals.totalRecordsInMessageFile;
		if (s.length() <= Globals.RECORD_DATA_LEN) {
		    record.setData(s, Globals.END_OF_MESSAGE);
		    record.writeToMessagesFile(recordNumber, Globals.APPEND);
		    s = "";
		}
		else {
		    nextRecordNumber = recordNumber + 1;
		    record.setData(s.substring(0,Globals.RECORD_DATA_LEN), nextRecordNumber);  
		    record.writeToMessagesFile(recordNumber, Globals.APPEND);
		    s = s.substring(Globals.RECORD_DATA_LEN);   // forces out of loop
		}
	    }
	    else {
		recordNumber = Globals.availableList.getNextRecord();
		if (s.length() <= Globals.RECORD_DATA_LEN) {
		    record.setData(s, Globals.END_OF_MESSAGE);
		    record.writeToMessagesFile(recordNumber, Globals.MODIFY);
		    s = "";
		}
		else {
		    nextRecordNumber = Globals.availableList.getHead() == null ? Globals.totalRecordsInMessageFile : Globals.availableList.getHead().getRecordNumber();
		    record.setData(s.substring(0,Globals.RECORD_DATA_LEN), nextRecordNumber);  
		    record.writeToMessagesFile(recordNumber, Globals.MODIFY);
		    s = s.substring(Globals.RECORD_DATA_LEN);  
		}
	    }
	}
	return startRecordNumber;
    }
    
    public void deleteFromMessagesFile (int recordNumber) {
	Record record = new Record();
	
	while (recordNumber != -1) {
	    record.deleteFromMessagesFile(recordNumber);
	    recordNumber = record.getNext();
	}
    }
    
    public String toString() {
	return "Message text: " + text;
    }
}
