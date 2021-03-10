import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;


public class Enemigo {
	
	protected boolean moveY;
	protected int speed;
	protected int vida;
	protected int posX;
	protected int posY;
	protected int enemigoSize;
	protected PImage enemigo1;

	public Enemigo(PApplet app, int x, int y) {
		
		moveY = true;
		posX = x;
		posY = y;
		enemigoSize = 55;
		speed = (int)(app.random(3,5));
		vida = 1;
		
		enemigo1 = app.loadImage("iMAGENES FULL/MXEZETA.png");
		
	}
	
	public void pintarEnemigos(PApplet app) {
		app.image(enemigo1,posX, posY, enemigoSize, enemigoSize);
		
		vidaEnemigo();
		moverEnemigo();
		
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
