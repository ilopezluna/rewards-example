import java.util.List;

public class RewardsLevelExample {

	private final Config config;

	public RewardsLevelExample(Config config) {
		this.config = config;
	}

	public Config getConfig() {
		return config;
	}

	/**
	 * Given the user level, return the applicable rewards level
	 * @param level user level
	 * @return rewards applicable level
	 */
	public int getApplicableLevel(int level) {

		final int lastLevel = config.getLastLevel();
		final List<Integer> levelsToRepeat = config.getLevelsToRepeat();

		if (level <= lastLevel) {
			return level;
		}
		else {

			int index = (level - 1 - lastLevel) % levelsToRepeat.size();
			return levelsToRepeat.get(index);
		}
	}
}
