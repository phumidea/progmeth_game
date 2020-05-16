package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sharedObject.IRenderable;

public class Score implements IRenderable{

	private int score = 0;
	private double count = 0;
	double x = 640, y = 360;
	
	public Score() {}
	

	public void update() {
		if(GameLogic.isGameStart()) {
			count += 0.02;
			if(count >= 1) {
				score += 1;
				count = 0;
			}
		}
	}
	
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		String text= "SCORE : "+score;
		gc.setFill(Color.ORANGE);
		gc.setFont(Font.font(25));
		gc.fillText(text, x, y);
		
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

}
