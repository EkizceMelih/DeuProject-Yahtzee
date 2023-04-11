import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static int score_player1=0;//global  score variable for player1
	public static int score_player2=0;//global  score variable for player1
	public static SingleLinkedList sll=new SingleLinkedList();//creating singlelinkedlist 
	public static SingleLinkedList sll2=new SingleLinkedList();	//creating singlelinkedlist 
	public static SingleLinkedList players_sll=new SingleLinkedList();//creating singlelinkedlist 
	public static void main(String[] args) throws IOException {		
		int turn=1;//turn counter
		for (int i = 0; i <10; i++) {//main game loop
			int player1_1=(int) (Math.random()*6+1);//1st of 6 dice
			int player1_2=(int) (Math.random()*6+1);//2st of 6 dice
			int player1_3=(int) (Math.random()*6+1);//3st of 6 dice
			int player2_1=(int) (Math.random()*6+1);//4st of 6 dice
			int player2_2=(int) (Math.random()*6+1);//5st of 6 dice
			int player2_3=(int) (Math.random()*6+1);//6st of 6 dice
			sll.add(player1_1); sll.add(player1_2);sll.add(player1_3); sll2.add(player2_1); sll2.add(player2_2); sll2.add(player2_3);;//adding sll operation
			System.out.println("Turn:"+turn);			
			System.out.print("Player1: " );
			sll.disPlay();//singleLinkedlist disPlay operation
			System.out.print("Score: "+score_player1+" ");//score print
			System.out.println();			
			System.out.print("Player2: " );
			sll2.disPlay();//singleLinkedlist disPlay operation
			System.out.print("Score: "+score_player2+" ");//score print
			System.out.println();
			turn++;//increasing turn variable		
			while (sll.yahtzeeChecker(sll)) {//yahtzee check operation	for player1	
				System.out.println();
				score_player1+=10;//if yathzee is exist player's score +10				
				System.out.print("Player1: " );
				sll.disPlay();
				System.out.print("Score: "+score_player1+" ");
				System.out.println();			
				System.out.print("Player2: " );
				sll2.disPlay();
				System.out.print("Score: "+score_player2+" ");
				System.out.println();
			}
			while (sll2.yahtzeeChecker(sll2)) {//yahtzee check for player2		
				System.out.println();
				score_player2+=10;				
				System.out.print("Player1: " );
				sll.disPlay();
				System.out.print("Score: "+score_player1+" ");
				System.out.println();			
				System.out.print("Player2: " );
				sll2.disPlay();
				System.out.print("Score: "+score_player2+" ");
				System.out.println();
			}
			while(sll.largeStraightChecker(sll)) {//large Straight check for player1				
				System.out.println();
				score_player1+=40;				
				System.out.print("Player1: " );
				sll.disPlay();
				System.out.print("Score: "+score_player1+" ");
				System.out.println();			
				System.out.print("Player2: " );
				sll2.disPlay();
				System.out.print("Score: "+score_player2+" ");
				System.out.println();
			}
			while(sll2.largeStraightChecker(sll2)) {//large Staright check for player2
				System.out.println();
				score_player2+=40;				
				System.out.print("Player1: " );
				sll.disPlay();
				System.out.print("Score: "+score_player1+" ");
				System.out.println();			
				System.out.print("Player2: " );
				sll2.disPlay();
				System.out.print("Score: "+score_player2+" ");
				System.out.println();
			}
		}
			 
			if (score_player1>=score_player2) {//compare oparation  between player1 and player2
				System.out.println("The winner is Player1");
				Player player1=new Player("Player1",score_player1);
				players_sll.sortSll(player1);//highscoretable adding
				}
			else {//compare oparation  between player1 and player2
				System.out.println("The winner is Player2");
				Player player2=new Player("Player2",score_player2);
				players_sll.sortSll(player2);//high score table adding
				}
			
			System.out.println("High Score Table");	
			
			File highscoretable = new File("HighScoreTable.txt");//Reading highscoretable file
			Scanner highscoretable_Reader = new Scanner(highscoretable);
			Object[] temporary_array = new Object[2];//temp array for high score table		   		    
			while ((highscoretable_Reader.hasNextLine())) {//split and adding to array operations if "0"=name if"1"=score
				temporary_array = highscoretable_Reader.nextLine().split(" ");//split operation
				  Player player=new Player(" ",0);//creating player object
			     player.setName((String)temporary_array[0]);
			      player.setScore(Integer.valueOf(temporary_array[1].toString()) );
			      players_sll.sortSll(player);	//sort operation		     				  
			}				
			 highscoretable_Reader.close();   
		        players_sll.displaySorted();//disPlay the screen
		        players_sll.writeTxt();//writing the text file
	
	}
}
