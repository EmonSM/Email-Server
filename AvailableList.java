public class AvailableList{
    private Available head;
    private Available tail;
    
    public AvailableList(){
	head = null;
	tail = null;
    }
    
    public AvailableList(Available h, Available t){
	head = h;
	tail = t;
    }
    
    public Available getHead(){
	return head;        
    }
    
    public Available getTail(){
	return tail;
    }
    
    public void setHead(Available h){
	head = h;        
    }
    
    public void setTail(Available t){
	tail = t;
    }
    
    public void addRecord(int recordNumber) {
	if (head == null) {
	    head = new Available(recordNumber);
	    tail = head;
	}
	else {
	    tail.setNext(new Available(recordNumber));
	    tail = tail.getNext();
	}
    }
    
    public int getNextRecord() {
	if (head == null) {
	    return Globals.EMPTY_AVAILABLE_LIST;
	}
	else {  
	    int ret = head.getRecordNumber();
	    head = head.getNext();
	    if (head == null) tail = null;
	    return ret;
	}
    }
    
    public String toString(){
	String s = "";
	for (Available p = head; p != null; p = p.getNext()){
	    s = s + "node: " + p.toString() + "\n";
	}
	return s; 
    }
    
}
