import java.io.*;
public class FileIO {
    public static int openMessagesFile(String fileName) {
	try {
	    Globals.msg = new RandomAccessFile(fileName, "rw");
	    Globals.totalRecordsInMessageFile = (int) (Globals.msg.length() / Globals.RECORD_LEN);
	    return Globals.PROCESS_OK;
	}
	catch(IOException error) {
	    return Globals.PROCESS_ERROR;
	}
    }
    
    public static int closeMessagesFile() {
	try {
	    Globals.msg.close();
	    return Globals.PROCESS_OK;
	}
	catch(IOException error) {
	    return Globals.PROCESS_ERROR;
	}
    }
}
