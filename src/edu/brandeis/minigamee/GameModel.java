package edu.brandeis.minigamee;

import android.util.Log;

public abstract class GameModel {
	public static String TAG="MGE";
	
	public abstract void resetGame();

	public GameModel() {
		Log.d(TAG, "GameModel Constructed");
	}

	protected long startTime=0; 		// Start time in milliseconds
	protected long dt;					// time since the last call to doDraw
	private long lastTime;				// last time the updateGame method was called
	private long currTime;				// current time that the updateGame method is called
	
// Abstracted leveling facility:
// Levels are numbered 0 and up as integers
// When a level is over for whatever reason, the levelOver becomes true
	private boolean firstEval=true; 	// true if this is the first time updateGame starting app
	private int level=0;				// We always start at level = 0
	private boolean levelOver=false;

	
	public void updateGame(long now) {
		if (levelOver) return; 			// don't do anything when the game is not being played ...
		currTime = now;
		if (firstEval){
			dt=0;
			firstEval=false;
		} else {
			dt = currTime - lastTime;
		}
    }


/** A game goes for one level. Upleveling happens when the model is reset for the
 * next level and then begins again.
 * @return true if level is over.
 */
	public boolean isLevelOver() {
		return levelOver;
	}
	
/** String showing state of model. 
 * 
 */
	public String toString() {
		return "GameModel: level = " + level + ", time=" + currTime;
	}
}
