package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import logic.Field;
import logic.Player;

public class RenderableHolder {
	
	private static final RenderableHolder instance = new RenderableHolder();
	
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image topLeftTile;
	public static Image topTile;
	public static Image topRightTile;
	public static Image leftTile;
	public static Image rightTile;
	public static Image bottomLeftTile;
	public static Image bottomTile;
	public static Image bottomRightTile;
	
	public static Image playerRun000;
	public static Image playerRun001;
	public static Image playerRun002;
	public static Image playerRun003;
	public static Image playerRun004;
	public static Image playerRun005;
	public static Image playerRun006;
	public static Image playerRun007;
	public static Image playerRun008;
	public static Image playerRun009;
	
	public static Image playerLRun000;
	public static Image playerLRun001;
	public static Image playerLRun002;
	public static Image playerLRun003;
	public static Image playerLRun004;
	public static Image playerLRun005;
	public static Image playerLRun006;
	public static Image playerLRun007;
	public static Image playerLRun008;
	public static Image playerLRun009;
	
	public static Image enemyGirlRun000;
	public static Image enemyGirlRun001;
	public static Image enemyGirlRun002;
	public static Image enemyGirlRun003;
	public static Image enemyGirlRun004;
	public static Image enemyGirlRun005;
	public static Image enemyGirlRun006;
	public static Image enemyGirlRun007;
	
	public static Image kunai;
	
	public static AudioClip bgMusic;
	
	static {
		loadResource();
	}
	
	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if(o1.getZ() > o2.getZ()) return 1;
			return -1;
		};
	}
	
	public static RenderableHolder getInstance() {
		return instance;
	}
	
	public static void loadResource() {
		topLeftTile = new Image(ClassLoader.getSystemResource("Tile_TopLeft.png").toString());
		topTile = new Image(ClassLoader.getSystemResource("Tile_Top.png").toString());
		topRightTile = new Image(ClassLoader.getSystemResource("Tile_TopRight.png").toString());
		leftTile = new Image(ClassLoader.getSystemResource("Tile_Left.png").toString());
		rightTile = new Image(ClassLoader.getSystemResource("Tile_Right.png").toString());
		bottomLeftTile = new Image(ClassLoader.getSystemResource("Tile_BottomLeft.png").toString());
		bottomTile = new Image(ClassLoader.getSystemResource("Tile_Bottom.png").toString());
		bottomRightTile = new Image(ClassLoader.getSystemResource("Tile_BottomRight.png").toString());
	
		playerRun000 = new Image(ClassLoader.getSystemResource("Run__000.png").toString());
		playerRun001 = new Image(ClassLoader.getSystemResource("Run__001.png").toString());
		playerRun002 = new Image(ClassLoader.getSystemResource("Run__002.png").toString());
		playerRun003 = new Image(ClassLoader.getSystemResource("Run__003.png").toString());
		playerRun004 = new Image(ClassLoader.getSystemResource("Run__004.png").toString());
		playerRun005 = new Image(ClassLoader.getSystemResource("Run__005.png").toString());
		playerRun006 = new Image(ClassLoader.getSystemResource("Run__006.png").toString());
		playerRun007 = new Image(ClassLoader.getSystemResource("Run__007.png").toString());
		playerRun008 = new Image(ClassLoader.getSystemResource("Run__008.png").toString());
		playerRun009 = new Image(ClassLoader.getSystemResource("Run__009.png").toString());
		
		playerLRun000 = new Image(ClassLoader.getSystemResource("L__Run__000.png").toString());
		playerLRun001 = new Image(ClassLoader.getSystemResource("L__Run__001.png").toString());
		playerLRun002 = new Image(ClassLoader.getSystemResource("L__Run__002.png").toString());
		playerLRun003 = new Image(ClassLoader.getSystemResource("L__Run__003.png").toString());
		playerLRun004 = new Image(ClassLoader.getSystemResource("L__Run__004.png").toString());
		playerLRun005 = new Image(ClassLoader.getSystemResource("L__Run__005.png").toString());
		playerLRun006 = new Image(ClassLoader.getSystemResource("L__Run__006.png").toString());
		playerLRun007 = new Image(ClassLoader.getSystemResource("L__Run__007.png").toString());
		playerLRun008 = new Image(ClassLoader.getSystemResource("L__Run__008.png").toString());
		playerLRun009 = new Image(ClassLoader.getSystemResource("L__Run__009.png").toString());

		enemyGirlRun000 = new Image(ClassLoader.getSystemResource("Attack__000.png").toString());
		enemyGirlRun001 = new Image(ClassLoader.getSystemResource("Attack__001.png").toString());
		enemyGirlRun002 = new Image(ClassLoader.getSystemResource("Attack__002.png").toString());
		enemyGirlRun003 = new Image(ClassLoader.getSystemResource("Attack__003.png").toString());
		enemyGirlRun004 = new Image(ClassLoader.getSystemResource("Attack__004.png").toString());
		enemyGirlRun005 = new Image(ClassLoader.getSystemResource("Attack__005.png").toString());
		enemyGirlRun006 = new Image(ClassLoader.getSystemResource("Attack__006.png").toString());
		enemyGirlRun007 = new Image(ClassLoader.getSystemResource("Attack__007.png").toString());
	
		kunai = new Image(ClassLoader.getSystemResource("Kunai.png").toString());
		
		bgMusic = new AudioClip(ClassLoader.getSystemResource("bgMusic.wav").toString());
		//explosionSound = new AudioClip(ClassLoader.getSystemResource("Explosion.wav").toString());

	}
	
	public void add(IRenderable entity) {
		entities.add(entity);
		Collections.sort(entities, comparator);

	}
	
	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed())
				entities.remove(i);
		}
	}
	
	public List<IRenderable> getEntities() {
		return entities;
	}
}
