package kata;

public class Game {

	private int rolls[] = new int[21];
	private int currentRoll = 0;
	
	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int score() {
		int score = 0;
		for(int frame = 0, ball = 0; frame < 10; frame++, ball += 2 ) {
			if ( isSpare(ball) ) {
				score += 10 + rolls[ball+2];
			} else {
				score += rolls[ball] + rolls[ball+1];
			}
		}
		return score;
	}

	private boolean isSpare(int ball) {
		return rolls[ball] + rolls[ball+1] == 10;
	}

}
