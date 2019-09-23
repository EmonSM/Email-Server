public class SLList {
    private SNode head = null;
    private SNode tail = null;
    
    public SLList() {
	head = null;
	tail = null;
    }
    
    public void insertNode(SNode p) {
	if (head == null) {
	    head = p;
	}
	else {
	    tail.setNext(p);
	}   
	tail = p;
    }
    
    public void insertNodeAlpha(SNode p) {
	if (head == null) {
	    head = p;
	    tail = p;
	}
	else {
	    SNode q = head;
	    SNode r = head;
	    for (; q!= null && q.getName().compareTo(p.getName()) < 0; r = q, q = q.getNext());
	    if (q == head) { //If element added at beginning
		head = p;
		p.setNext(q);
	    }
	    else if (q == null) { //If element added at end
		tail = p;
		r.setNext(p);
	    }
	    else {
		r.setNext(p);
		p.setNext(q);
	    }    
	} 
    }
    
    public void deleteNode(SNode p) { //p is in the list
	if (head == tail) {
	    head = null;
	    tail = null;
	}
	else if (head == p) {
	    head = head.getNext();
	}
	else if (tail == p) {
	    SNode q = head;
	    for (; q.getNext() != p; q = q.getNext());
	    tail = q;
	    q.setNext(null);
	}
	else {
	    SNode q = head;
	    for (; q.getNext() != p; q = q.getNext());
	    q.setNext(p.getNext());
	} 
    }
    
    public SNode findNode(String key) {
	SNode p = head;
	for (; p != null && !key.equals(p.getName()); p = p.getNext());
	return p;
    }
    
    public void insertNodeAtHead(SNode p) {
	if (tail == null) {
	    tail = p;
	}
	else {
	    p.setNext(head);
	}   
	head = p;
    }
    
    
    public SNode getHead() {
	return head;
    }
    
    public SNode getTail() {
	return tail;
    }
    
    public void setHead(SNode h) {
	head = h;
    }
    
    public void setTail(SNode t) {
	tail = t;
    }
    
    public String toString() {
	String s = "";
	for (SNode p = head; p != null; p = p.getNext()) {
	    s += p.toString() + "\n";
	}
	return s;
    }
}
