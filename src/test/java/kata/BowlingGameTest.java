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
		for(int i = 0; i < 20; i++ ) {
			game.roll(0);
		}
		assertEquals(game.score(), 0);
	}
	
	@Test(groups={"fast"})
	public void shouldScoreTwentyWhenAllOnes() {
		for(int i = 0; i < 20; i++ ) {
			game.roll(1);
		}
		assertEquals(game.score(), 20);
	}
}
