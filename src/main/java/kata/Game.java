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
			if ( isStrike(ball) ) { 
				score += strikeBonus(ball);
				ball -= 1; //ugly index hack!
			} else if ( isSpare(ball) ) {
				score += spareBonus(ball);
			} else {
				score += sumOfBallsInFrame(ball);
			}
		}
		return score;
	}

	private int sumOfBallsInFrame(int ball) {
		return rolls[ball] + rolls[ball+1];
	}
	
	private int spareBonus(int ball) {
		return 10 + rolls[ball+2];
	}

	private int strikeBonus(int ball) {
		return 10 + rolls[ball+1] + rolls[ball+2];
	}

	private boolean isStrike(int ball) {
		return rolls[ball] == 10;
	}

	private boolean isSpare(int ball) {
		return rolls[ball] + rolls[ball+1] == 10;
	}

}
