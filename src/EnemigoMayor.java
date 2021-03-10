import processing.core.PApplet;
import processing.core.PImage;

public class EnemigoMayor extends Enemigo {

	public EnemigoMayor(PApplet app, int x, int y) {
		super(app, x, y);
		vida = 2;
		speed = 9;
		enemigo1 = app.loadImage("iMAGENES FULL/MXEZETA.png");
		
	}
	
	public void mover() {
		posY += speed;
		
	}
	public void pintarEnemigo(PApplet app) {
		app.fill(45,67,21);
		app.image(enemigo1,posX, posY, enemigoSize, enemigoSize);
		
	}
	
	public void moverEnemigo() {
		posX -= speed;
		
	}
	
	public void vidaEnemigo() {
		vida += 1;
	}
	
	public int getVidaEnemigo() {
		return vida;
	}

	public void setvidaEnemigo(int vidaEnemigo) {
		this.vida = vida;
	}
	
	public void removeEnemigo() {
		
		}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getEnemigoSize() {
		return enemigoSize;
	}

	public void setEnemigoSize(int enemigoSize) {
		this.enemigoSize = enemigoSize;
	}
	

}
