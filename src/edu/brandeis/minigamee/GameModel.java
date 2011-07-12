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
	private boolean firstEval=true; 	// true if this is the first time updateGame starting app	
	private long lastTime;				// last time the updateGame method was called
	private long currTime;				// current time that the updateGame method is called
	
	public void updateGame(long now) {
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
		return true;
	}
	
/** String showing state of model 
 * 
 */
	public String toString() {
		return "GameModel: time="+currTime;
	}
}
