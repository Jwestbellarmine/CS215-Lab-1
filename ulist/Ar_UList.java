package ulist;

public class Ar_UList {
	public static final int MAXSIZE = 10;
	private int[] listItems;
	private int length;
	private int currentPos;
	
	public Ar_UList()
	{
		length = 0;
		currentPos = 0;
		listItems = new int[MAXSIZE];
	}
	
	public int getLength()
	{
		return length;
	}
	
	public boolean isFull()
	{
		return length == MAXSIZE;
	}
	
	public void putItem(int pItem)
	{
		listItems[length] = pItem;
		length ++;
	}
	
	private void deleteItemSwap(int dItem)
	{
		for (int loc = 0; loc < length; loc++)
		{
			if(listItems[loc] == dItem)
			{
				listItems[loc] = listItems[length];
				length--;
				return;
			}
		}
		
	}
	
	private void deleteItemShift(int dItem)
	{
		boolean indexFound = false;
		for (int loc = 0; loc < length; loc++)
		{
			if(listItems[loc] == dItem)
			{
				indexFound = true;
				if (indexFound)
				{
					listItems[loc] = listItems[loc+1];
				}
				
				length--;
				return;
			}
		}
	}
	
	public void deleteItem(int dItem)
	{
		deleteItemShift(dItem);
	}
	
	public void makeEmpty()
	{
		length = 0;
	}
	
	public void resetList()
	{
		currentPos = 0;
	}
	
	public int getNextItem()
	{
		currentPos++;
		return listItems[currentPos-1];
	}
	
	public int getItem(int gItem)
	{
		for(int loc = 0; loc < length; loc++)
		{
			if(listItems[loc] == gItem)
			{
			return loc;
			}
			
		}
		return -1;
		
		
		
	}
		
	public void printList()
	{
		System.out.print("(");
		for(int loc = 0; loc < length; loc++)
		{
			
		}
	}
	
	

}
