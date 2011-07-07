package edu.brandeis.gameoflife;

import android.os.Bundle;
import org.bitstorm.gameoflife.*;

import edu.brandeis.minigamee.GameActivity;

public class GameOfLifeGameActivity extends GameActivity {
	
	GameOfLifeGrid theGrid = new GameOfLifeGrid(20, 20);
	
	
    /** Called when the activity is first created. */
	public GameOfLifeGameActivity() {
		super(new GameOfLifeModel(), new GameOfLifeController(), new GameOfLifeView());
		getController().setModel(getModel());
		getView().setContext(getController(), getHolder(), getModel());
		setKeyResources(R.layout.game, R.id.game_surface);
	}

	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}