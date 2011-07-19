package edu.brandeis.minigamee;

/** A set of configuration parameters with 
 * apprpriate defaults set.
 * @author pitosalas
 
 */

public class GameConfig {
	private static GameConfig instance = null;
	private int gameLoopSleepMs;
	
/** 
 * Constructor sets the default values
 * 
 */
	private GameConfig() {
		gameLoopSleepMs = 10;
	}
	public static GameConfig get() {
		if(instance == null) {
			instance = new GameConfig();
		}
		return instance;
	}
	
	public int getGameLoopSleepMS() {
		return gameLoopSleepMs;
	}
}
