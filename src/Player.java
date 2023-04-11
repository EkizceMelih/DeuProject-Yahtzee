
public class Player {//Player class,I created this class because I need the player's name and score at the same time
	private String name;
	private int score;
	public Player(String name,int score) {
		this.name=name;
		this.score=score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
