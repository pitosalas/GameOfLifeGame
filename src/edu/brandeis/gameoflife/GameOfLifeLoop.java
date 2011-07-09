package edu.brandeis.gameoflife;

import android.util.Log;
import edu.brandeis.minigamee.GameController;
import edu.brandeis.minigamee.GameLoop;
import edu.brandeis.minigamee.GameModel;
import edu.brandeis.minigamee.GameView;

public class GameOfLifeLoop extends GameLoop {
	public String TAG="GOL";
	public GameOfLifeLoop(GameView view, GameModel model, GameController controller) {
		super(view, model, controller);
		Log.d(TAG, "GameOfLifeLoop constructor.");
	}

}
