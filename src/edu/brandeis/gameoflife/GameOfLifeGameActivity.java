package edu.brandeis.gameoflife;

import android.os.Bundle;
import android.view.SurfaceHolder;

import org.bitstorm.gameoflife.*;

import edu.brandeis.minigamee.GameActivity;
import edu.brandeis.minigamee.GameController;
import edu.brandeis.minigamee.GameModel;
import edu.brandeis.minigamee.GameView;

public class GameOfLifeGameActivity extends GameActivity {
	public String TAG="GOL";
		
	/** Called when the activity is first created. */
	public GameOfLifeGameActivity() {
		super(new GameOfLifeModel(), new GameOfLifeController(), new GameOfLifeView());
		setKeyResources(R.layout.game, R.id.game_surface);
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}