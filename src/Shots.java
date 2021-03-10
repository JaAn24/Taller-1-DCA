import processing.core.PApplet;


public class Shots {
	
	int damage;
	boolean moveY;
	int posiX;
	int posiY;
	int velocidad;
	int shotSize;
	private PApplet app;

	public Shots(PApplet app, int x, int y) {
		
		damage = 50;
		moveY = true;
		velocidad = 15;
		shotSize = 15;
		this.app = app;
		this.posiX = x;
		this.posiY = y;
		
		
		
		
	}
	
	
	
	public int getPosiX() {
		return posiX;
	}



	public void setPosiX(int posiX) {
		this.posiX = posiX;
	}



	public int getPosiY() {
		return posiY;
	}



	public void setPosiY(int posiY) {
		this.posiY = posiY;
	}



	public void drawShot() {
		app.ellipse(posiX,posiY,shotSize,shotSize);
		
	}
	public void moverBala() {
		posiY -= velocidad;
	}
}