package sharedObject;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class RenderableHolder {
	
	private static final RenderableHolder instance = new RenderableHolder();
	
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	//public static Image topLeftTile;
	public static Image topTile;
	/*public static Image topRightTile;
	public static Image leftTile;
	public static Image rightTile;
	public static Image bottomLeftTile;
	public static Image bottomTile;
	public static Image bottomRightTile;*/
	
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
		//topLeftTile = new Image(ClassLoader.getSystemResource("Tile_TopLeft.png").toString());
		topTile = new Image(ClassLoader.getSystemResource("Tile_Top.png").toString());
		/*topRightTile = new Image(ClassLoader.getSystemResource("Tile_TopRight.png").toString());
		leftTile = new Image(ClassLoader.getSystemResource("Tile_Left.png").toString());
		rightTile = new Image(ClassLoader.getSystemResource("Tile_Right.png").toString());
		bottomLeftTile = new Image(ClassLoader.getSystemResource("Tile_BottomLeft.png").toString());
		bottomTile = new Image(ClassLoader.getSystemResource("Tile_Bottom.png").toString());
		bottomRightTile = new Image(ClassLoader.getSystemResource("Tile_BottomRight.png").toString());*/
	
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

	public Comparator<IRenderable> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<IRenderable> comparator) {
		this.comparator = comparator;
	}

	

	public static Image getTopTile() {
		return topTile;
	}

	public static void setTopTile(Image topTile) {
		RenderableHolder.topTile = topTile;
	}

	public static Image getPlayerRun000() {
		return playerRun000;
	}

	public static void setPlayerRun000(Image playerRun000) {
		RenderableHolder.playerRun000 = playerRun000;
	}

	public static Image getPlayerRun001() {
		return playerRun001;
	}

	public static void setPlayerRun001(Image playerRun001) {
		RenderableHolder.playerRun001 = playerRun001;
	}

	public static Image getPlayerRun002() {
		return playerRun002;
	}

	public static void setPlayerRun002(Image playerRun002) {
		RenderableHolder.playerRun002 = playerRun002;
	}

	public static Image getPlayerRun003() {
		return playerRun003;
	}

	public static void setPlayerRun003(Image playerRun003) {
		RenderableHolder.playerRun003 = playerRun003;
	}

	public static Image getPlayerRun004() {
		return playerRun004;
	}

	public static void setPlayerRun004(Image playerRun004) {
		RenderableHolder.playerRun004 = playerRun004;
	}

	public static Image getPlayerRun005() {
		return playerRun005;
	}

	public static void setPlayerRun005(Image playerRun005) {
		RenderableHolder.playerRun005 = playerRun005;
	}

	public static Image getPlayerRun006() {
		return playerRun006;
	}

	public static void setPlayerRun006(Image playerRun006) {
		RenderableHolder.playerRun006 = playerRun006;
	}

	public static Image getPlayerRun007() {
		return playerRun007;
	}

	public static void setPlayerRun007(Image playerRun007) {
		RenderableHolder.playerRun007 = playerRun007;
	}

	public static Image getPlayerRun008() {
		return playerRun008;
	}

	public static void setPlayerRun008(Image playerRun008) {
		RenderableHolder.playerRun008 = playerRun008;
	}

	public static Image getPlayerRun009() {
		return playerRun009;
	}

	public static void setPlayerRun009(Image playerRun009) {
		RenderableHolder.playerRun009 = playerRun009;
	}

	public static Image getPlayerLRun000() {
		return playerLRun000;
	}

	public static void setPlayerLRun000(Image playerLRun000) {
		RenderableHolder.playerLRun000 = playerLRun000;
	}

	public static Image getPlayerLRun001() {
		return playerLRun001;
	}

	public static void setPlayerLRun001(Image playerLRun001) {
		RenderableHolder.playerLRun001 = playerLRun001;
	}

	public static Image getPlayerLRun002() {
		return playerLRun002;
	}

	public static void setPlayerLRun002(Image playerLRun002) {
		RenderableHolder.playerLRun002 = playerLRun002;
	}

	public static Image getPlayerLRun003() {
		return playerLRun003;
	}

	public static void setPlayerLRun003(Image playerLRun003) {
		RenderableHolder.playerLRun003 = playerLRun003;
	}

	public static Image getPlayerLRun004() {
		return playerLRun004;
	}

	public static void setPlayerLRun004(Image playerLRun004) {
		RenderableHolder.playerLRun004 = playerLRun004;
	}

	public static Image getPlayerLRun005() {
		return playerLRun005;
	}

	public static void setPlayerLRun005(Image playerLRun005) {
		RenderableHolder.playerLRun005 = playerLRun005;
	}

	public static Image getPlayerLRun006() {
		return playerLRun006;
	}

	public static void setPlayerLRun006(Image playerLRun006) {
		RenderableHolder.playerLRun006 = playerLRun006;
	}

	public static Image getPlayerLRun007() {
		return playerLRun007;
	}

	public static void setPlayerLRun007(Image playerLRun007) {
		RenderableHolder.playerLRun007 = playerLRun007;
	}

	public static Image getPlayerLRun008() {
		return playerLRun008;
	}

	public static void setPlayerLRun008(Image playerLRun008) {
		RenderableHolder.playerLRun008 = playerLRun008;
	}

	public static Image getPlayerLRun009() {
		return playerLRun009;
	}

	public static void setPlayerLRun009(Image playerLRun009) {
		RenderableHolder.playerLRun009 = playerLRun009;
	}

	public static Image getEnemyGirlRun000() {
		return enemyGirlRun000;
	}

	public static void setEnemyGirlRun000(Image enemyGirlRun000) {
		RenderableHolder.enemyGirlRun000 = enemyGirlRun000;
	}

	public static Image getEnemyGirlRun001() {
		return enemyGirlRun001;
	}

	public static void setEnemyGirlRun001(Image enemyGirlRun001) {
		RenderableHolder.enemyGirlRun001 = enemyGirlRun001;
	}

	public static Image getEnemyGirlRun002() {
		return enemyGirlRun002;
	}

	public static void setEnemyGirlRun002(Image enemyGirlRun002) {
		RenderableHolder.enemyGirlRun002 = enemyGirlRun002;
	}

	public static Image getEnemyGirlRun003() {
		return enemyGirlRun003;
	}

	public static void setEnemyGirlRun003(Image enemyGirlRun003) {
		RenderableHolder.enemyGirlRun003 = enemyGirlRun003;
	}

	public static Image getEnemyGirlRun004() {
		return enemyGirlRun004;
	}

	public static void setEnemyGirlRun004(Image enemyGirlRun004) {
		RenderableHolder.enemyGirlRun004 = enemyGirlRun004;
	}

	public static Image getEnemyGirlRun005() {
		return enemyGirlRun005;
	}

	public static void setEnemyGirlRun005(Image enemyGirlRun005) {
		RenderableHolder.enemyGirlRun005 = enemyGirlRun005;
	}

	public static Image getEnemyGirlRun006() {
		return enemyGirlRun006;
	}

	public static void setEnemyGirlRun006(Image enemyGirlRun006) {
		RenderableHolder.enemyGirlRun006 = enemyGirlRun006;
	}

	public static Image getEnemyGirlRun007() {
		return enemyGirlRun007;
	}

	public static void setEnemyGirlRun007(Image enemyGirlRun007) {
		RenderableHolder.enemyGirlRun007 = enemyGirlRun007;
	}

	public static Image getKunai() {
		return kunai;
	}

	public static void setKunai(Image kunai) {
		RenderableHolder.kunai = kunai;
	}

	public static AudioClip getBgMusic() {
		return bgMusic;
	}

	public static void setBgMusic(AudioClip bgMusic) {
		RenderableHolder.bgMusic = bgMusic;
	}

	public void setEntities(List<IRenderable> entities) {
		this.entities = entities;
	}
	
	
}
