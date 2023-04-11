import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SingleLinkedList {
	private Node head;
	 public static int counter1=0,counter2=0,counter3=0,counter4=0,counter5=0,counter6=0;
	public void add(Object data) {
		if(head==null) {
			Node newNode=new Node(data);
			head=newNode;
		}
		else {
			Node temp=head;
			while(temp.getLink()!=null) {
				temp=temp.getLink();
			}
			Node newNode=new Node(data);
			temp.setLink(newNode);
		}
	}
	public int size() {
		if(head==null) {
			return 0;
		}
		else {
			int count=0;
			Node temp=head;
			
			while(temp!=null) {
				temp=temp.getLink();
				count++;
			}
			return count;
		}
	}
	public void disPlay() {
		if(head==null) {
			System.out.println("List is empty");
		}
		else {
			Node temp=head;
			while(temp!=null) {
				System.out.print(temp.getData()+" ");
				temp=temp.getLink();				
			}
		}
		}
	
	public void writeTxt() throws IOException {//Writing operation to text file
	    FileWriter highscoreWriter=new FileWriter(new File("HighScoreTable.txt"));//writing of the text file
					PrintWriter highscoretable_w=new PrintWriter(highscoreWriter);	
		if(head==null) {
			System.out.println("List is empty");
		}
		else {
			Node temp=head;
			while(temp!=null) {
				highscoretable_w.write(((Player)temp.getData()).getName() + " " + ((Player)temp.getData()).getScore() + "\n");
				temp=temp.getLink();				
			}
		}
		highscoretable_w.close();//close the file
		}
	public void displaySorted() {//displaying the singleLinkedList for sorted SingleLinkedList
		if(head == null)
			System.out.println("List is empty!");
		else {
			Node temp = head;
			while(temp != null) {
				System.out.print(((Player)temp.getData()).getName() + " " + ((Player)temp.getData()).getScore() + "\n");
				temp = temp.getLink();
			}
		}
	}
		public void removeYahtzee(Object dataToDelete) {//remove operation for yahtzee
			int count=0;//count variable
			if(head==null) System.out.println("List is empty");			
			else {				
					while(count<5&&(Integer)head.getData()==(Integer)dataToDelete) { //check operation
						head=head.getLink();
						count++;//count variable increasing part
					}			
				Node temp=head;Node previous=null;
				while(temp!=null) {
					if((Integer)temp.getData()==(Integer)dataToDelete) {//check operation
						previous.setLink(temp.getLink());
						temp=previous;
					}
					previous=temp;
					temp=temp.getLink();
				}
			}
		}
		public void remove(Object dataToDelete) {
			boolean flag=false;
			if(head==null) System.out.println("List is empty");			
			else {				
					while(flag==false &&(Integer)head.getData()==(Integer)dataToDelete) { 
						head=head.getLink();	
						flag=true;
					}			
				Node temp=head;Node previous=null;
				while(temp!=null) {
					if(flag==false &&(Integer)temp.getData()==(Integer)dataToDelete) {
						previous.setLink(temp.getLink());
						temp=previous;
						break;
					}
					previous=temp;
					temp=temp.getLink();
				}
			}
		}
		public void sortSll(Player pl) {//sorting part
			if(head == null ) {
				Node newNode = new Node(pl);
				head = newNode;
				
			}
			else {
				Node temp=head;				
				Node previous=null;
				while( temp!=null &&pl.getScore() > ((Player) temp.getData()).getScore()) {
					previous=temp;
					temp=temp.getLink();					
				}
				if(temp==null) {//inserting last element					
				 Node newNode=new Node(pl);
				previous.setLink(newNode);
				
				}
				else if(pl.getScore() < ((Player) head.getData()).getScore()) {//inserting front element
					Node newNode=new Node(pl);
					newNode.setLink(head);
					head=newNode;
					
				}
				else  {//inserting between element
					Node  newNode=new Node(pl);
					newNode.setLink(temp);
					previous.setLink(newNode);
					
				}
			}
			
		}
		public int findMax() {
			if(head==null) {
				System.err.println("The linked list is empty");
				return Integer.MIN_VALUE;
			}
			else {
				int maxVal=Integer.MIN_VALUE;
				Node temp=head;
				while(temp!=null) {
					if((int)temp.getData()>maxVal) {
						maxVal=(int) temp.getData();
					}
					temp=temp.getLink();
				}
				return maxVal;				
			}
		}
		public boolean search(Object data) {
			if(head==null) {
				System.out.println("List is empty");
				return false;
			}
			else {
				Node temp=head;
				while(temp!=null) {
					if((Integer)temp.getData()==(Integer)data)
						return true;
					temp=temp.getLink();
				}
			}
			return false;
		}
		public boolean largeStraightChecker(SingleLinkedList sll) {//large straight check  func
			boolean flag=false;
			if(sll.search(1)&&sll.search(2)&&sll.search(3)&&sll.search(4)&&sll.search(5)&&sll.search(6)) {
				flag=true;
				sll.remove(1);sll.remove(2);sll.remove(3);sll.remove(4);sll.remove(5);sll.remove(6);								
			}
			return flag;
		}
		public boolean yahtzeeChecker(SingleLinkedList sll) {//YahtzeeCheck func
			int count1=0;int count2=0;int count3=0;int count4=0;int count5=0;int count6=0;
			boolean flag=false;
			if(head==null) {
				System.out.println("List is empty");
				return false;
			}
			else {
				Node temp=head;
				while(temp!=null) {
					if((Integer)temp.getData()==1) count1++;
					else if((Integer)temp.getData()==2) count2++;
					else if((Integer)temp.getData()==3) count3++;
					else if((Integer)temp.getData()==4) count4++;
					else if((Integer)temp.getData()==5) count5++;
					else if((Integer)temp.getData()==6) count6++;						
					temp=temp.getLink();
				}
				if(count1>=4) {
					sll.removeYahtzee(1);
					flag=true;
					return flag;
				}
				if(count2>=4) {
					sll.removeYahtzee(2);
					flag=true;
					return flag;
				}
				if(count3>=4) {
					sll.removeYahtzee(3);
					flag=true;
					return flag;
				}
				if(count4>=4) {
					sll.removeYahtzee(4);
					flag=true;
					return flag;
				}
				if(count5>=4) {
					sll.removeYahtzee(5);
					flag=true;
					return flag;
				}
				if(count6>=4) {
					sll.removeYahtzee(6);
					flag=true;
					return flag;
				}
			}
			return false;			
		}				
		}
		
		
		
	
	

