import java.io.*;
public class Record {
    private byte[] data = new byte[Globals.RECORD_DATA_LEN];
    private int next = Globals.END_OF_MESSAGE;
    
    public Record() {
	for (int i = 0; i < data.length; i++) {
	    data[i] = (byte) Globals.BLANK;
	}
	next = Globals.END_OF_MESSAGE;
    }
    
    public Record(String s, int nextRecord) {
	setData(s, nextRecord);
    }
    
    public String getData() {
	String txt = "";
	for (int i = 0; i < data.length; i++) {
	    txt += (char) ((data[i] + 256) % 256);
	}
	return txt;
    }
    
    public void setData(String txt, int nextRecord) {
	for (int i = 0; i < data.length; i++) {
	    if (i < txt.length()) data[i] = (byte) txt.charAt(i);
	    else data[i] = (byte) Globals.BLANK;
	}
	next = nextRecord;
    }
    
    public int getNext() {
	return next;
    }
    
    //Temporary
    public byte[] getArray() {
	return data;
    }
    
    public int readFromMessagesFile(int recordNumber) {
	try {
	    Globals.msg.seek(recordNumber * Globals.RECORD_LEN);
	    int bytes = Globals.msg.read(data);
	    next = Globals.msg.readInt();
	    return Globals.PROCESS_OK;
	}
	catch (IOException e) {
	    return Globals.PROCESS_ERROR;
	}
    }
    
    public int writeToMessagesFile(int recordNumber, int mode) {
	try {
	    Globals.msg.seek(recordNumber * Globals.RECORD_LEN);
	    Globals.msg.write(data);
	    Globals.msg.writeInt(next);
	    if (mode == Globals.APPEND) Globals.totalRecordsInMessageFile++;
	    return Globals.PROCESS_OK;
	}
	catch (IOException e) {
	    return Globals.PROCESS_ERROR;
	}
    }
    
    public int deleteFromMessagesFile (int recordNumber) {
	int error = readFromMessagesFile(recordNumber);
	if (error == Globals.PROCESS_OK) {
	    data[0] = (byte) Globals.DELETED;
	    error = writeToMessagesFile(recordNumber, Globals.MODIFY);
	    if (error == Globals.PROCESS_OK) {
		Globals.availableList.addRecord(recordNumber);
	    }
	    else {
		System.out.println("Error writing to messages file. In method deleteFromMessagesFile");
	    }
	}
	else {
	    System.out.println("Error reading from messages file. In method deleteFromMessagesFile");
	}
	return error;
    }
    
    public String toString() {
	return this.getData() + next;
    }
}
