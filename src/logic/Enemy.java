package logic;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class Enemy extends CollidableEntity{
	
	private double speedUp;
	private double animationCount;
	
	
	public Enemy() {
		this.x = 1280;
		this.y = 500;
		this.speedUp = 0;
		this.animationCount = 0;
		this.width = 160;
		this.height = 160;
	}
	
	/*public void onCollisoin(Player player) {

		this.destroyed = true;
	}*/
	
	public void update() {
		animationCount += 1;
		
		x -= 2+speedUp/2;
		speedUp += 0.005;
		
		if(InputUtility.getKeyPressed(KeyCode.S)) {
			if(speedUp > 0) speedUp -= 1;
		}
		if(InputUtility.getKeyPressed(KeyCode.D)) {
			speedUp +=1;
		}
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		//gc.setFill(Color.RED);
		System.out.println("Enemy X = "+x);
		System.out.println("Enemy visble = " + visible);
		if(x <= 0) x = 1280;
		//gc.fillRect(x, 600, width, height);
		if(animationCount%8 == 0)
			gc.drawImage(RenderableHolder.enemyGirlRun000, x, y, width, height);
		else if(animationCount%8 == 1)
			gc.drawImage(RenderableHolder.enemyGirlRun001, x, y, width, height);
		else if(animationCount%8 == 2)
			gc.drawImage(RenderableHolder.enemyGirlRun002, x, y, width, height);
		else if(animationCount%8 == 3)
			gc.drawImage(RenderableHolder.enemyGirlRun003, x, y, width, height);
		else if(animationCount%8 == 4)
			gc.drawImage(RenderableHolder.enemyGirlRun004, x, y, width, height);
		else if(animationCount%8 == 5)
			gc.drawImage(RenderableHolder.enemyGirlRun005, x, y, width, height);
		else if(animationCount%8 == 6)
			gc.drawImage(RenderableHolder.enemyGirlRun006, x, y, width, height);
		else if(animationCount%8 == 7)
			gc.drawImage(RenderableHolder.enemyGirlRun007, x, y, width, height);
		
		
	}
	

	

}
