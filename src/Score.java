import javafx.scene.text.Text;

public class Score extends javafx.scene.text.Text {
	private int score;
	
	public Score() {
		score = 0;
		this.setFontSize(15); //not done yet
		updateDisplay();
	}
	
	void updateDisplay() {
		this.setText(""+score);
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
		
		//also update display
	}	
}
