package kata;

public class Game {

	private int rolls[] = new int[21];
	private int currentRoll = 0;
	
	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int score() {
		int score = 0;
		int frameIndex = 0;
		for(int frame = 0; frame < 10; frame++ ) {
			if ( isStrike(frameIndex) ) { 
				score += strikeBonus(frameIndex);
				frameIndex += 1;
			} else if ( isSpare(frameIndex) ) {
				score += spareBonus(frameIndex);
				frameIndex += 2;
			} else {
				score += sumOfBallsInFrame(frameIndex);
				frameIndex += 2;
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
