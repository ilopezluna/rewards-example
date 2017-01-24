import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class RewardsLevelExampleTest {

	@Test
	public void simpleTest() {
		Assert.assertTrue(true);
	}

	@Test
	public void testGetApplicableLevel() throws Exception {

		Config config = new Config(3, Arrays.asList(3));
		RewardsLevelExample rewardsLevelExample = new RewardsLevelExample(config);
		checkLevels(rewardsLevelExample, 1000);


		config = new Config(6, Arrays.asList(4,5,6));
		rewardsLevelExample = new RewardsLevelExample(config);
		checkLevels(rewardsLevelExample, 1000);
	}

	private void checkLevels(RewardsLevelExample rewardsLevelExample, int to) {
		checkInitialLevels(rewardsLevelExample);
		checkRepeatedLevels(rewardsLevelExample, to);
	}

	private void checkInitialLevels(RewardsLevelExample rewardsLevelExample) {

		int lastLevel = rewardsLevelExample.getConfig().getLastLevel();

		for(int i=0; i <= lastLevel; i++) {
			Assert.assertEquals(rewardsLevelExample.getApplicableLevel(i), i );
		}
	}

	private void checkRepeatedLevels(RewardsLevelExample rewardsLevelExample, int to) {

		int lastLevel = rewardsLevelExample.getConfig().getLastLevel();
		List<Integer> levelsToRepeat = rewardsLevelExample.getConfig().getLevelsToRepeat();

		int from = lastLevel + 1;
		int index = 0;

		while (from < to) {

			Assert.assertEquals(rewardsLevelExample.getApplicableLevel(from), (int) levelsToRepeat.get(index) );

			index++;
			if (index == levelsToRepeat.size()) {
				index = 0;
			}
			from++;
		}
	}
}