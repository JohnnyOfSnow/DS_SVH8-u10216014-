class IntDLLNode{
	int data;
	IntDLLNode next = null, prev = null;

	IntDLLNode(){

	}

	IntDLLNode(int newData){
		data = newData;
	}

	IntDLLNode(IntDLLNode p, int newData, IntDLLNode n){
		prev = p;
		data = newData;
		next = n;
	}
} // end class IntDLLNode

public class IntDLList{
	IntDLLNode head, tail;

	public IntDLList(){
		head = tail = null;
	}

	public void addToDLListHead(int newData){
		if(!isEmpty()){
			head = new IntDLLNode(null, newData, head); // insert at head  prev = null  next = original head
			head.next.prev = head;
		}else{
			head = tail = new IntDLLNode(newData);
		}
	}

	public void addToDLListTail(int newData){
		if(!isEmpty()){
			tail = new IntDLLNode(tail, newData, null); // insert at tail  prev = original tail  next = null
			tail.prev.next = tail;
		}else{
			head = tail = new IntDLLNode(newData);
		}
	}

	public int deleteFromDLListHead(){
		if(!isEmpty()){
			int reData = head.data;
			if(head == tail){
				head = tail = null; // if only one node in the list
			}else{
				head = head.next;
				head.prev = null;
			}
			return reData;
		}
			return -1; // No node in the list
	}

	public int deleteFromDLListTail(){
		if(!isEmpty()){
			int reData = tail.data;
			if(head == tail){
				head = tail = null; // if only one node in the list
			}else{
				tail = tail.prev;
				tail.next = null;
			}
			return reData;
		}
			return -1; // No node in the list
	}

	public boolean isEmpty(){
		return head == null; // Check the list whether is empty.
	}

	public void clear(){
		head = tail = null; // Clear all node in this list
	}

	public int peakFirstElement(){
		if(isEmpty()){
			return head.data;
		}
		return -1; // No node in the list.
	}

	public String print(int number){
		StringBuilder a = new StringBuilder();
		a.append("Bucket " + number + ": ");
		if ( isEmpty() ) {
			String result = new String(a);
			return result;
		} // end if

		IntDLLNode current = head;

		// while not at end of list, output current node's data
		while ( current != null ) {
			a.append(current.data + ",");
			current = current.next;
		} // end while
		String result = new String(a);
		return result;
	} // end method print

	public String print1(int number){
		StringBuilder a = new StringBuilder();
		if ( isEmpty() ) {
			String result = new String(a);
			return result;
		} // end if

		IntDLLNode current = head;

		// while not at end of list, output current node's data
		while ( current != null ) {
			a.append(current.data + ",");
			current = current.next;
		} // end while
		String result = new String(a);
		return result;
	} // end method print
} // end class IntDLList
