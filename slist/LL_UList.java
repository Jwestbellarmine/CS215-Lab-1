package slist;

public class LL_UList {
	private class LNode
	{
		private int item;
	    private LNode next;

	    //--------------------------------------------------------------
	    //  Sets up the node
	    //--------------------------------------------------------------
	    public LNode(int newitem)
	    {
	    	item = newitem;
	    	next = null;
	    }
	}
	private LNode ListStart;
	private LNode currentPos;	
	
	public LL_UList() {
		ListStart = null;
		currentPos = null;
	}
	
	
	boolean isFull()  {
		return false; //Assume the size of a linked-list based implementation is UNBOUNDED for simplicity		
	}
	
	int getLength() {
		LNode iterPos = ListStart;
		int length=0;
		while (iterPos != null) {
			iterPos = iterPos.next;
			length++;
		}
		return length;
	}
	
	int getItem(int gitem) {
		LNode iterPos = ListStart;
		int position = 0;
		while (iterPos != null && iterPos.item != gitem) {
			iterPos = iterPos.next;
			position++;
		}
		if (iterPos == null) 
			return -1;
		else
			return position;
	}
	
	void makeEmpty() {
		ListStart = null; //Garbage collector will take care of the rest!
	}
	
	void putItem(int pitem) {
		LNode node = new LNode(pitem);
		node.next = ListStart;
		ListStart = node;
	}
	
	void deleteItem(int ditem) { //Find the item in question, and "unlink" it		
		LNode iterPos = ListStart;
		LNode nextPos;
		if (ListStart.item == ditem) 
			ListStart = ListStart.next;
		else {
			nextPos = iterPos.next;
			while (nextPos != null && nextPos.item != ditem) {
				iterPos = nextPos;
				nextPos = nextPos.next;
			}
			if (nextPos.item == ditem) 
				iterPos.next = nextPos.next;
		}
	}
	
	void resetList() {
		currentPos = ListStart;
	}

	
	int getNextItem() {
		int retItem = currentPos.item;
		currentPos = currentPos.next;
		return retItem;
	}

	void printList() { //simple function to print a list's items in stored order
		LNode iterPos = ListStart;
		System.out.print("(");
		while (iterPos != null) {
			System.out.print(iterPos.item);
			if (iterPos.next != null)
				System.out.print(", ");
			iterPos = iterPos.next;
		}				
		System.out.println(")");
	}
}
