package edu.brandeis.minigamee;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;


/**
 * This class implements the view of the game. Its main purpose is to know 
 * how to draw a representation of the model onto the Surface when called to do so.
 * It also responds to the events generated with the surface is created, changed, destroyed.
 * It reads from the model but does not change anything in the model. The view also starts
 * up the game loop when the surface is created ... 
 * @author tim
 *
 */
public class GameView  implements Callback{
	
	private GameController controller;
	private SurfaceHolder holder;
	private GameModel model;
	private GameLoop gameLoop;
	
	private Paint backgroundPaint;
	private Paint textPaint;
	private String TAG="MGE";
	
	public GameView(GameController controller,SurfaceHolder holder,GameModel model){
		Log.d(TAG, "GameView Constructor with params");
		setContext(controller, model);
	}
	
	public GameView() {
		Log.d(TAG, "GameView Constructor without params");
	}
	
	public void setContext(GameController controller, GameModel model) {
		Log.d(TAG, "GameView reset");
		this.controller=controller;
		this.model = model;
        createPaints();
	}
	
	public void setSurfaceHolder(SurfaceHolder theHolder) {
		Log.d(TAG, "GameView setSurfaceHolder");
		holder = theHolder;
	}

	/**
	 * When the drawing surface size changes we need to tell the controller so it
	 * can adjust the mapping between the view and the model
	 */
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		controller.setSize(width, height);

	}
		
	/**
	 *  When the drawing surface is created we start up a game loop,
	 *  the game loop just draws the scene and updates the model in an infinite loop
	 *  running in a separate thread. We create the thread and start it up here ...
	 */
	public void surfaceCreated(SurfaceHolder holder) {
		if (gameLoop == null) {
			gameLoop = new GameLoop(this,model,controller);
			gameLoop.start();
		}

	}

	/**
	 * This uses the surface holder to get a lock on the canvas,
	 * the draws a representation of the model on the canvas (if its not null),
	 * and finally releases the lock and posts a "draw" event to the main GUI thread
	 * which will copy the canvas onto the screen.
	 */
	public void draw() {
		Log.d(TAG, "draw");
		Canvas c = null;
		try {
			c = holder.lockCanvas();

			if (c != null) {
				doDraw(c);
			
			}
		} finally {
			if (c != null) {
				holder.unlockCanvasAndPost(c);
			}
		}
	}

	/*
	 * The drawing method simply draws the disks, squares, and targets
	 * after it paints the entire screen with the background color.
	 */
	private void doDraw(Canvas c) {
		Log.d(TAG, "doDraw");
		int width = c.getWidth();
		int height = c.getHeight();
		controller.setSize(width, height);

		c.drawRect(0, 0, width, height, backgroundPaint);
		c.drawText(model.toString(), 0, 50, textPaint);
	}

	/**
	 * When the surface is destroyed we stop the game loop
	 */
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.d(TAG, "SurfaceDestroyed");
		safeStop();
	}
	
	public void safeStop() {
		try {
			gameLoop.safeStop();
		} finally {
			gameLoop = null;
		}
	}


	/*
	 * Setup some default colors
	 */
	private void createPaints(){
		Log.d(TAG, "CreatePaints");
		backgroundPaint = new Paint();
		backgroundPaint.setColor(Color.BLUE);
		textPaint = new Paint();
		textPaint.setColor(Color.GREEN);
		textPaint.setAntiAlias(true);
		textPaint.setTextSize(20);
		
	}

	
}
