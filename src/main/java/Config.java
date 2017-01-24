import java.util.List;

public class Config {

	private int lastLevel;
	private final List<Integer> levelsToRepeat;

	public Config(int lastLevel, List<Integer> levelsToRepeat) {
		this.lastLevel = lastLevel;
		this.levelsToRepeat = levelsToRepeat;
	}

	public int getLastLevel() {
		return lastLevel;
	}

	public List<Integer> getLevelsToRepeat() {
		return levelsToRepeat;
	}


}
