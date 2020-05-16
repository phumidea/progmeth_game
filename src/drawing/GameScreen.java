package drawing;

import input.InputUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameLogic;
import logic.Score;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class GameScreen extends Canvas {
	
	private Score score;
	
	public GameScreen(double width, double height) {
		super(width, height);
		this.setVisible(true);
		addListener();
		score = new Score();
	}

	public void addListener() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});

		this.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});

	}
	
	public void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			// System.out.println(entity.getZ());
			if (entity.isVisible() && !entity.isDestroyed()) {
				entity.draw(gc);
			}
			
			if(!GameLogic.isGameStart()) {
				String gameover = "Game Over";
				gc.setFill(Color.RED);
				gc.setFont(Font.font(50));
				gc.fillText(gameover, 100, 100);
			}
		}
		
		score.draw(gc);
		score.update();
		
	
		
	}
	
}
