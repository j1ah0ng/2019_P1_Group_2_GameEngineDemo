public class BallWorld extends World {

	private Score score;

	public BallWorld() {
		score = new Score();
		score.setX(20);  //where should the x pos be? center?
		score.setY(20);  //where should the y pos be? top center?
		getChildren().add(score);
	}
	
	@Override
	public void act(long now) {
		//according to the instructions this is left blank
	}
	
	public Score getScore() {
		return score;
	}
}
