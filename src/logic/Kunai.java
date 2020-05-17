package logic;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import sharedObject.RenderableHolder;

public class Kunai extends CollidableEntity{
	
	private double speedUp;
	private boolean outOfScreen;
	
	public Kunai() {
		this.width = 30;
		this.height = 100;
		this.speedUp = 1;
		this.outOfScreen = false;
		this.y = 0;
		this.x = 1280*Math.random();
	}
	
	public void update() {
		
		//positionNotMinus(y);
		y += speedUp;
		
		if(InputUtility.getKeyPressed(KeyCode.S)) {
			if(speedUp > 0) speedUp -= 1;
		}
		
		if(InputUtility.getKeyPressed(KeyCode.D)) {
			speedUp += 1;
		}
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		if(y >= 720) {
			y = 0;
			outOfScreen = false;
			speedUp += Math.random();
		}
		
		if(!outOfScreen) {
			x = 1280*Math.random();
			outOfScreen = true;
		}
		
		gc.drawImage(RenderableHolder.kunai, x, y, width, height);
	}
	
	/*public void positionNotMinus(double y) {
		if(y <= 0) y = 0.01;
	}*/


	public double getSpeedUp() {
		return speedUp;
	}

	public void setSpeedUp(double speedUp) {
		this.speedUp = speedUp;
	}

	public boolean isOutOfScreen() {
		return outOfScreen;
	}

	public void setOutOfScreen(boolean outOfScreen) {
		this.outOfScreen = outOfScreen;
	}

}
