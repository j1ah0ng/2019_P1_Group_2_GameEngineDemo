import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Score extends javafx.scene.text.Text {
	private int score;
	
	public Score() {
		score = 0;
		this.setFont(new Font(20));  //does this make sense?
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
		updateDisplay();
	}	
}
