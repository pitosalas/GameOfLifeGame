package edu.brandeis.gameoflife;

import android.os.Bundle;
import org.bitstorm.gameoflife.*;

import edu.brandeis.minigamee.GameActivity;

public class GameOfLifeGameActivity extends GameActivity {
	
	GameOfLifeGrid theGrid = new GameOfLifeGrid(20, 20);
	
    /** Called when the activity is first created. */
	public GameOfLifeGameActivity() {
		super(new GameOfLifeModel(), new GameOfLifeController());
		getController().setModel(getModel());
	}

	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		setKeyResources(R.layout.main, R.layout.main);
		
		
        super.onCreate(savedInstanceState);
    }
}