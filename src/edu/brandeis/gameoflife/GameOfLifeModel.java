package edu.brandeis.gameoflife;

import android.util.Log;
import edu.brandeis.minigamee.GameModel;

public class GameOfLifeModel extends GameModel {
	public String TAG="GOL";
	
	// see if the user has run out of time
	public float gameLength; 				// length of a game in seconds
	public float timeRemaining;				// time remaining in the current game

	public void resetGame() {
		Log.d(TAG, "GameOfLifeModel::resetGame resetting");
		gameLength = 15;
	}
	
	public void updateGame(long now) {
		super.updateGame(now);
		timeRemaining = gameLength - (now - startTime)/1000f;
	}
@Override
	public boolean isLevelOver() {
		super.isLevelOver();
		Log.d(TAG, "GameModel.isLevelOver, timeRemaining = " + String.valueOf(timeRemaining));
		return timeRemaining < 0.0;
	}
}
