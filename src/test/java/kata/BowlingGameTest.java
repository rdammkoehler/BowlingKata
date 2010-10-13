package kata;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.*;

public class BowlingGameTest {

	@Test(groups={"fast"})
	public void shouldScoreZeroOnGutterGame() {
		Game game = new Game();
		for(int i = 0; i < 20; i++ ) {
			game.roll(0);
		}
		assertEquals(game.score(), 0);
	}
}
