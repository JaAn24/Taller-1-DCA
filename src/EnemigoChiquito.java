import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;


public class EnemigoChiquito extends Enemigo {
	protected PImage chiqui;

	

	public EnemigoChiquito(PApplet app, int x, int y) {
		super(app, x, y);
		
		vida = 10;
		chiqui = app.loadImage("iMAGENES FULL/CABEZA.png");

	}
	
	public void mover() {
		posY += speed;
		
	}
	public void pintarEnemigo(PApplet app) {
		app.image(chiqui,posX, posY, enemigoSize, enemigoSize);

		//app.ellipse(posX, posY, enemigoSize, enemigoSize);
		
	}
	


}
