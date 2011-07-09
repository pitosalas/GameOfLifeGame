package edu.brandeis.minigamee;

import android.util.Log;

public class GameModel {
	public static String TAG="MGE";
	public boolean levelOver=true; 		// True means level is completed (duh)
	
	public GameModel() {
		Log.d(TAG, "GameModel Constructed");
	}

	public float gameLength=15; 			// length of a game in seconds
	public float timeRemaining;				// time remaining in the current game
	public int wins = 0;					// number of games won so far
	public int losses = 0;					// number of games lost so far
	public boolean userWon = false; 		// this is set to true when the user wins 
	public boolean userLost = false;		// this is set to true when the user loses

	
	private long startTime=0; 			// Start time in milliseconds
	private boolean firstEval=true; 	// true if this is the first time updateGame starting app	
	private long lastTime;				// last time the updateGame method was called
	private long currTime;				// current time that the updateGame method is called
	private long dt;					// time since the last call to doDraw
	
	public void updateGame(long now) {
		if (levelOver) return; // don't do anything when the game is not being played ...
		currTime = now;
		if (firstEval){
			dt=0;
			firstEval=false;
		} else {
			dt = currTime - lastTime;
		}
		
		// see if the user has run out of time
		timeRemaining = gameLength - (now - startTime)/1000f;
		if (timeRemaining<0){
			Log.d(TAG, "GameModel::updateGame user lost due to no more time");
			levelOver=true; 
			userLost=true;
			losses += 1;
			return;
		}
    }

	public void resetGame(){
		Log.d(TAG, "GameModel::resetGame resetting");
		levelOver=false;
		userWon=false;
		userLost=false;
	}
    
	public void createLevel(int level, int width, int height) {
		startTime = System.currentTimeMillis();
		timeRemaining = gameLength;
	}
}
