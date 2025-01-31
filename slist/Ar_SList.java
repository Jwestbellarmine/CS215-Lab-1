package slist;

public class Ar_SList {
	//Use private variables to preserve Encapsulation 
	public static final int MAXSIZE = 10;	
	private int[] ListItems;
	private int length;
	private int currentPos = 0;
	
	public Ar_SList() {
		length = 0; //a newly constructed list has 0 elements
		ListItems = new int[MAXSIZE];
	}
	boolean isFull()  {
		return (length == MAXSIZE); //Useful to check that we don't add too many elements		
	}
	
	int getLength() {
	  return length;
	}

	int getItem(int gitem) 
	{
		int midpoint = 0, first = 0, last =length-1;
		boolean moreToSearch = first <= last;
		
		while(moreToSearch)
		{
			midpoint = (first + last) / 2;
			if (gitem == ListItems[midpoint])
			{
				return midpoint;
			}
			else if (gitem < ListItems[midpoint])
			{
				last = midpoint-1;
			}
			else
			{
				first = midpoint+1;
				moreToSearch = first <= last;
			}
			
			
		}
		return -1;
	}
	
	void makeEmpty() {
		length = 0; //as with the constructor, we need do nothing to the actual array, as it now "junk" data
	}
	
	void putItem(int pitem) throws Exception
	{
		int aloc = 0;
		boolean moreToSearch = aloc < length;
		
		
		while(moreToSearch)
		{
			if (length == MAXSIZE)
			{
				throw new Exception ("error list full");
			}
			if(pitem < ListItems[aloc])
			{
				moreToSearch = false;
			}
			else
			{
				aloc++;
				moreToSearch = aloc < length;
			}
		}
		for(int i = length; i > aloc; i--)
		{
			ListItems[i] = ListItems[i-1];
			ListItems[aloc] = pitem;
			length++;
		}
		 
	}
	
	void deleteItemShift(int ditem) { //This is the less efficient version of what we discussed ("Move-Up") that maintains list order		
		boolean indexfound=false;
		for (int loc=0; loc<length; loc++) {
			if (ListItems[loc]==ditem) 
				indexfound=true;
			if (indexfound && loc < MAXSIZE - 1)
				ListItems[loc]=ListItems[loc+1];	
		}
		length--;
	}

	void deleteItemSwap(int ditem) { //This is the more efficient version of what we discussed ("Swap") that is a little bit easier and faster		
		  for (int loc=0; loc<length; loc++) {
			  if (ListItems[loc]==ditem) { 
				  ListItems[loc] = ListItems[length-1];
				  return;
			  }
		  }
		 
	}

	
	void deleteItem(int ditem) throws Exception {
		if(getItem(ditem) == -1)
		{
			throw new Exception("");
		}
		deleteItemShift(ditem);
	}
	
	void resetList() {
		currentPos = 0;
	}

	
	int getNextItem() throws Exception {
		
		if (currentPos == length)
		{
			throw new Exception("end of list reached");
		}
		//Possibly counter-intuitive, but we want to return the item at the current index AND increment it
		currentPos++;
		return ListItems[currentPos-1];   
	}

	void printList() { //simple function to print a list's items in stored order
		System.out.print("(");
		for (int loc=0; loc<length; loc++) {
		  	System.out.print(ListItems[loc]);
			if (loc<length-1)
		  	  System.out.print(", ");
		}
		System.out.println(")");
	}
}
