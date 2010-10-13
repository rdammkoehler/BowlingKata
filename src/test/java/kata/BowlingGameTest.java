package kata;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.*;

public class BowlingGameTest {

	private Game game;
	
	@BeforeMethod
	public void beforeMethod() {
		game = new Game();
	}
	
	@Test(groups={"fast"})
	public void shouldScoreZeroOnGutterGame() {
		rollMany(20,0);
		assertEquals(game.score(), 0);
	}
	
	@Test(groups={"fast"})
	public void shouldScoreTwentyWhenAllOnes() {
		rollMany(20,1);
		assertEquals(game.score(), 20);
	}
	
	@Test(groups={"fast"})
	public void shouldScoreSpareCorrectly() {
		game.roll(5);
		game.roll(5); //spare
		game.roll(3);
		rollMany(17,0);
		assertEquals(game.score(),16);
	}
	
	private void rollMany(int rolls, int pins) {
		for(int i = 0; i < rolls; i++ ) {
			game.roll(pins);
		}
	}
}
