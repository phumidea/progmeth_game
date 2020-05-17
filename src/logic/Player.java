package logic;

import input.InputUtility;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
/*import javafx.scene.paint.Color;*/
import sharedObject.RenderableHolder;

public class Player extends CollidableEntity {

	private double dx;
	private double dy;

	private boolean isJump;

	private boolean isMoveLeft;
	private boolean isMoveRight;
	private boolean isDash;

	private int animationCount = 0; // 0...3

	public Player(double x, double y) {
		this.x = x;
		this.y = y;
		this.width = 160;
		this.height = 160;
		this.isJump = false;
		dx = 8;
		dy = 8;
		this.isMoveLeft = false;
		this.isMoveRight = true;
		this.isDash = false;
	}

	public void checkMove() {
		//check x axis
		if (x >= 1280 - width)
			this.x = 1280 - width;
		if (x <= 0)
			this.x = 0;

		//check y axis
		if (y > 640 - height) this.y = 640 - height; // calculate from 720-80 blockSize(80*80) at ground
		this.y += dy;	//always falling
		
		//check jump
		if (isJump == true)
			this.dy += 1;
		if (y >= 640 - height)
			this.isJump = false;
		
		
	}
	
	public void onCollision(Enemy enemy) {
		this.destroyed = true;
	}
	
	public void onCollision(Kunai kunai) {
		this.destroyed = true;
	}

	public void update() {
		
		checkMove();
		
		
		if(InputUtility.getKeyPressed(KeyCode.RIGHT)) {
			isMoveLeft = false;
			isMoveRight = true;
			x += dx;
		}
		if(InputUtility.getKeyPressed(KeyCode.LEFT)) {
			isMoveLeft = true;
			isMoveRight = false;
			x -= dx;
		}
		if(InputUtility.getKeyPressed(KeyCode.UP)) {
			if(isJump == false) {
				dy = -22;
				isJump = true;
			}
		}
		if(InputUtility.getKeyPressed(KeyCode.Z)) {
			if(isDash == false) {
				isDash = true;
				dx = 20;
			}
		}
		if(!InputUtility.getKeyPressed(KeyCode.Z) && isDash == true) {
			dx = 5;
			isDash = false;
		}
		
		
		
		animationCount = (animationCount+1)%10;
		
		
		
		//System.out.println("player x = "+x+" , y = "+y+" dy = "+dy+" isJump = "+isJump+ " dash dx = "+dx);
	}

	@Override
	public void draw(GraphicsContext gc) {
		
		System.out.println("Player x = " + x);
		// TODO Auto-generated method stub
		if(!isMoveLeft && isMoveRight) {
			if (animationCount == 0)
				gc.drawImage(RenderableHolder.playerRun000, x, y, width, height);
			else if (animationCount == 1)
				gc.drawImage(RenderableHolder.playerRun001, x, y, width, height);
			else if (animationCount == 2)
				gc.drawImage(RenderableHolder.playerRun002, x, y, width, height);
			else if (animationCount == 3)
				gc.drawImage(RenderableHolder.playerRun003, x, y, width, height);
			else if (animationCount == 4)
				gc.drawImage(RenderableHolder.playerRun004, x, y, width, height);
			else if (animationCount == 5)
				gc.drawImage(RenderableHolder.playerRun005, x, y, width, height);
			else if (animationCount == 6)
				gc.drawImage(RenderableHolder.playerRun006, x, y, width, height);
			else if (animationCount == 7)
				gc.drawImage(RenderableHolder.playerRun007, x, y, width, height);
			else if (animationCount == 8)
				gc.drawImage(RenderableHolder.playerRun008, x, y, width, height);
			else if (animationCount == 9)
				gc.drawImage(RenderableHolder.playerRun009, x, y, width, height);
		}
		
		
		  else if(isMoveLeft && !isMoveRight) {
			  if (animationCount == 0)
					gc.drawImage(RenderableHolder.playerLRun000, x, y, width, height);
				else if (animationCount == 1)
					gc.drawImage(RenderableHolder.playerLRun001, x, y, width, height);
				else if (animationCount == 2)
					gc.drawImage(RenderableHolder.playerLRun002, x, y, width, height);
				else if (animationCount == 3)
					gc.drawImage(RenderableHolder.playerLRun003, x, y, width, height);
				else if (animationCount == 4)
					gc.drawImage(RenderableHolder.playerLRun004, x, y, width, height);
				else if (animationCount == 5)
					gc.drawImage(RenderableHolder.playerLRun005, x, y, width, height);
				else if (animationCount == 6)
					gc.drawImage(RenderableHolder.playerLRun006, x, y, width, height);
				else if (animationCount == 7)
					gc.drawImage(RenderableHolder.playerLRun007, x, y, width, height);
				else if (animationCount == 8)
					gc.drawImage(RenderableHolder.playerLRun008, x, y, width, height);
				else if (animationCount == 9)
					gc.drawImage(RenderableHolder.playerLRun009, x, y, width, height);
			  
			  
		  }
		  
		  
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	public boolean isMoveLeft() {
		return isMoveLeft;
	}

	public void setMoveLeft(boolean isMoveLeft) {
		this.isMoveLeft = isMoveLeft;
	}

	public boolean isMoveRight() {
		return isMoveRight;
	}

	public void setMoveRight(boolean isMoveRight) {
		this.isMoveRight = isMoveRight;
	}

	public boolean isDash() {
		return isDash;
	}

	public void setDash(boolean isDash) {
		this.isDash = isDash;
	}

	public int getAnimationCount() {
		return animationCount;
	}

	public void setAnimationCount(int animationCount) {
		this.animationCount = animationCount;
	}
	
	

}
