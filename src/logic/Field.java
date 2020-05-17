package logic;

import javafx.scene.canvas.GraphicsContext;

/*import javafx.scene.image.Image;*/
import javafx.scene.paint.Color;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class Field implements IRenderable {

	private static int[][] field = { 
			/*{ -1, -2, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, -1 },		//0
			{ -1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0 },		//1
			{ 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0 },		//2
			{ -1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0 },		//3
			{ -1, -2, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0 },		//4
			{ -1, -2, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0 },		//5
			{ -1, -2, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0 },		//6
			{ -1, -2, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0 },		//7
			{ -1, -2, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0 },		//8
			//0-15*/
			
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2}
			
			//16 : 9 -> 80*80 pixel per block
			
	};

	public int getTerrain(int x, int y) {
		if (x < 0 || x >= field[0].length || y < 0 || y >= field.length) return 0;
		return field[y][x];
	}

	private int getTileIndex(int x, int y) {
		int terrain = getTerrain(x, y);
		if (terrain <= 0 && terrain >= -8) return -terrain;
		return 0;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return -9999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		for (int x = 0; x < field[0].length; x++) {
			for(int y = 0; y < field.length; y++){
				if(getTileIndex(x, y) == 0) {
					gc.setFill(Color.BLACK);
					gc.fillRect(x*80, y*80, 80, 80);
				}
				//else if (getTileIndex(x, y) == 1) gc.drawImage(RenderableHolder.topLeftTile, x*80, y*80, 80, 80);
				else if (getTileIndex(x, y) == 2) gc.drawImage(RenderableHolder.topTile, x*80, y*80, 80, 80);
				/*else if (getTileIndex(x, y) == 3) gc.drawImage(RenderableHolder.topRightTile, x*80, y*80, 80, 80);
				else if (getTileIndex(x, y) == 4) gc.drawImage(RenderableHolder.leftTile, x*80, y*80, 80, 80);
				else if (getTileIndex(x, y) == 5) gc.drawImage(RenderableHolder.rightTile, x*80, y*80, 80, 80);
				else if (getTileIndex(x, y) == 6) gc.drawImage(RenderableHolder.bottomLeftTile, x*80, y*80, 80, 80);
				else if (getTileIndex(x, y) == 7) gc.drawImage(RenderableHolder.bottomTile, x*80, y*80, 80, 80);
				else if (getTileIndex(x, y) == 8) gc.drawImage(RenderableHolder.bottomRightTile, x*80, y*80, 80, 80);*/
				
			}
		}

	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	

}
