package logic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.media.AudioClip;
import sharedObject.RenderableHolder;

public class GameLogic {
	
	private List<Entity> gameObjectContainer;
	
	private Player player;
	private Enemy enemy;
	private Kunai kunai1;
	private Kunai kunai2;
	private Kunai kunai3;
	private static boolean gameStart;
	
	
	public GameLogic() {
		this.gameObjectContainer = new ArrayList<Entity>();
		
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		player = new Player(400,560);
		enemy = new Enemy();
		kunai1 = new Kunai();
		kunai2 = new Kunai();
		kunai3 = new Kunai();
		addNewObject(player);
		addNewObject(enemy);
		addNewObject(kunai1);
		addNewObject(kunai2);
		addNewObject(kunai3);
		gameStart = true;
		
	}
	
	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	
	public void playMusic() {
		try {
			AudioClip bg = RenderableHolder.bgMusic;
			if(!bg.isPlaying()) bg.play();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logicUpdate() {
		
		playMusic();
		
		player.update();
		enemy.update();
		kunai1.update();
		kunai2.update();
		kunai3.update();
		
		

		System.out.println(player.collideWith(enemy));
		if(!enemy.isDestroyed() && player.collideWith(enemy)) {
			player.onCollision(enemy);
			gameStart = false;
		}
		if(!kunai1.isDestroyed() && player.collideWith(kunai1)) {
			player.onCollision(kunai1);
			gameStart = false;
		}
		if(!kunai2.isDestroyed() && player.collideWith(kunai2)) {
			player.onCollision(kunai2);
			gameStart = false;
		}
		if(!kunai3.isDestroyed() && player.collideWith(kunai3)) {
			player.onCollision(kunai3);
			gameStart = false;
		}
	}

	public List<Entity> getGameObjectContainer() {
		return gameObjectContainer;
	}

	public void setGameObjectContainer(List<Entity> gameObjectContainer) {
		this.gameObjectContainer = gameObjectContainer;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	public Kunai getKunai1() {
		return kunai1;
	}

	public void setKunai1(Kunai kunai1) {
		this.kunai1 = kunai1;
	}

	public Kunai getKunai2() {
		return kunai2;
	}

	public void setKunai2(Kunai kunai2) {
		this.kunai2 = kunai2;
	}

	public Kunai getKunai3() {
		return kunai3;
	}

	public void setKunai3(Kunai kunai3) {
		this.kunai3 = kunai3;
	}

	public static boolean isGameStart() {
		return gameStart;
	}

	public void setGameStart(boolean gameStart) {
		this.gameStart = gameStart;
	}
}
