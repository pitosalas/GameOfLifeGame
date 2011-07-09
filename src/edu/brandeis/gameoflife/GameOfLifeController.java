package edu.brandeis.gameoflife;

import edu.brandeis.minigamee.*;

public class GameOfLifeController extends GameController {
	public String getLogString() {
		return "No state defined yet!";
	}
	
	@Override
	public void touch_up(float x, float y) {
		gameModel.userWon = true;
	}


}
