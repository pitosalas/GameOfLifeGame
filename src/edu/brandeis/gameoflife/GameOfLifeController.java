package edu.brandeis.gameoflife;

import android.util.Log;
import edu.brandeis.minigamee.*;

public class GameOfLifeController extends GameController {
	public String TAG = "GOL";
	public String getLogString() {
		return "No state defined yet!";
	}
	
	@Override
	public void touch_up(float x, float y) {
		Log.d(TAG, "GameOfLifeController: touch_up");
	}
}
