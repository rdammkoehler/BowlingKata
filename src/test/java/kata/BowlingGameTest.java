package kata;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.*;

public class BowlingGameTest {

	private Game game;

	@BeforeMethod
	public void beforeMethod() {
		game = new Game();
	}

	@Test(groups = { "fast" })
	public void shouldScoreZeroOnGutterGame() {
		rollMany(20, 0);
		assertEquals(game.score(), 0);
	}

	@Test(groups = { "fast" })
	public void shouldScoreTwentyWhenAllOnes() {
		rollMany(20, 1);
		assertEquals(game.score(), 20);
	}

	@Test(groups = { "fast" })
	public void shouldScoreSpareCorrectly() {
		rollSpare();
		game.roll(3);
		rollMany(17, 0);
		assertEquals(game.score(), 16);
	}

	@Test(groups = { "fast" })
	public void shouldScoreStrikeCorrectly() {
		rollStrike();
		game.roll(3);
		game.roll(4);
		rollMany(16, 0);
		assertEquals(game.score(), 24);
	}
	
	@Test(groups={"fast"})
	public void shouldScoreThreeHundredForPerfectGame() {
		rollMany(12,10);
		assertEquals(game.score(),300);
	}

	private void rollStrike() {
		game.roll(10);
	}

	private void rollSpare() {
		game.roll(5);
		game.roll(5);
	}

	private void rollMany(int rolls, int pins) {
		for (int i = 0; i < rolls; i++) {
			game.roll(pins);
		}
	}
}
