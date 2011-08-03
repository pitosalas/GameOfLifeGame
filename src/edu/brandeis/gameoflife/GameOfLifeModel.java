package edu.brandeis.gameoflife;

import android.util.Log;
import edu.brandeis.minigamee.GameModel;

public class GameOfLifeModel extends GameModel {
	public String TAG="GOL";
	
	// see if the user has run out of time
	public float gameLength; 				// length of a game in seconds
	public float timeRemaining;				// time remaining in the current game

	public GameOfLifeModel() {
		Log.d(TAG, "GameOfLifeModel::Constructor");
	}
	
	public void resetGame() {
		Log.d(TAG, "GameOfLifeModel::resetGame resetting");
		gameLength = 60.0f;
		timeRemaining = gameLength;
		startTime = System.currentTimeMillis();
	}
	
	public void updateGame(long now) {
		super.updateGame(now);
		timeRemaining = gameLength - (now - startTime)/1000f;
	}
	
@Override
	public boolean isLevelOver() {
		Log.d(TAG, "GameModel.isLevelOver, timeRemaining = " + String.valueOf(timeRemaining));
		return timeRemaining <= 0.0;
	}

@Override
	public String toString() {
		return "Game Of Life (time to go: " + timeRemaining + ")";	
	}
}
