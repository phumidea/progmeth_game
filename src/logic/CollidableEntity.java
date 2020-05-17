package logic;

/*import javafx.scene.canvas.GraphicsContext;

import javafx.scene.shape.Rectangle;*/

public abstract class CollidableEntity extends Entity{
	
	protected double width;
	protected double height;
	
	protected boolean collideWith(CollidableEntity other) {
		
		double x1,x2,x3,x4;
		double y1,y2,y3,y4;
		
		x1 = x;
		x2 = x+width;
		x3 = other.x;
		x4 = other.x + other.width;
		y1 = y;
		y2 = y + height;
		y3 = other.y;
		y4 = other.y + other.height;
		
		
		System.out.println("x1 = " + x1);
		System.out.println("x2 = " + x2);
		System.out.println("x3 = " + x3);
		System.out.println("x4 = " + x4);
		System.out.println("y1 = " + y1);
		System.out.println("y2 = " + y2);
		System.out.println("y3 = " + y3);
		System.out.println("y4 = " + y4);
		if(other instanceof Enemy) {
			if((betweenValue(x3, x2, x4)) && (betweenValue(y3, y1, y4) || betweenValue(y3, y2, y4))) return true;	//player collision object right side
			if((betweenValue(x3, x1, x4)) && (betweenValue(y3, y1, y4) || betweenValue(y3, y2, y4))) return true;	//player collision object left side
			if((betweenValue(y3, y2, y4)) && (betweenValue(x3, x1, x4) || betweenValue(x3, x2, x4))) return true;	//player collision object bottom side
			if((betweenValue(y3, y1, y4)) && (betweenValue(x3, x1, x4) || betweenValue(x3, x2, x4))) return true;	//player collision object above side
			return false;
		}
		if(other instanceof Kunai) {
			if(x1 <= x3 && x4 <= x2 && betweenValue(y1, y4, y2)) return true;	//player collision object above side
			if(x1 <= x3 && x4 <= x2 && betweenValue(y1, y3, y2)) return true;	//player collision object bottom side
			if(y1 <= y3 && y4 <= y2 && betweenValue(x1, x3, x2)) return true;	//player collision object left side
			if(y1 <= y3 && y4 <= y2 && betweenValue(x1, x4, x2)) return true;	//player collision object right side
			if(betweenValue(x1, x4, x2) && betweenValue(y1, y4, y2)) return true;	//player collision corner top left
			if(betweenValue(x1, x3, x2) && betweenValue(y1, y4, y2)) return true;	//player collision corner top right
			if(betweenValue(x1, x4, x2) && betweenValue(y1, y3, y2)) return true;	//player collision corner bottom left
			if(betweenValue(x1, x3, x2) && betweenValue(y1, y3, y2)) return true;	//player collision corner bottom right
			
			return false;
		} else {
			return false;
		}
		
	}
	
	private boolean betweenValue(double a1,double a2,double a3) {		//a1 <= a2 <= a3
		if(a1 <= a2 && a2 <= a3) return true;
		else return false;
	}
	
	
	
}
