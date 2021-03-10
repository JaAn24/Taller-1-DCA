
import java.util.ArrayList;


import processing.core.PApplet;

import processing.core.PImage;

public class KihHeroe {

	boolean moveX;
	int speed;
	int dtr;
	int posX;
	int posY;
	int kihSize;
	Shots bala;
	PImage player;
	private ArrayList<Shots> balas;
	int delay;
	
	
	
	public KihHeroe(PApplet app) {
		
		moveX = true;
		speed = 11;
		posX = 660;
		posY = 542;
		kihSize = 55;
		dtr = 8;
		bala = new Shots(app, posX, posY);
		delay = 0;
		
		//Imagen del personaje
		player = app.loadImage("iMAGENES fULL/KIHH.png");
		
		//Arraylist
		balas = new ArrayList<>();

		
		
	}
	

	public void drawKih(PApplet app) {
		
		app.image(player,posX, posY, kihSize, kihSize);
		if(balas.size() > 0) {
		for (int i = 0; i < balas.size(); i++) {
			balas.get(i).drawShot();
			balas.get(i).moverBala();
			
			}
		eliminarShots();

		}
		
		
		if(delay > 0) {
			delay --;
		}
		
	
	}
	
	
	
	public ArrayList<Shots> getBalas() {
		return balas;
	}


	public void setBalas(ArrayList<Shots> balas) {
		this.balas = balas;
	}


	public void moveKih(boolean moveX) {
		
		if(posX < 1118 ) {
			if(moveX) {
				posX += speed;
			}
		
		}else posX = 1117;
		
		if(posX > 74) {
			if(!moveX) {
				posX -=speed;
			}
		}else posX = 75;
	}
	
	public void generarBalas(PApplet app) {
		if(delay == 0) {
		Shots bala = new Shots(app, posX,posY);
		balas.add(bala);
		delay = 8;
		
		}
	}
	
	public void eliminarShots() {
		
		for (int i = 0; i < balas.size(); i++) {
			if(balas.get(i).getPosiY() < 0) {
				balas.remove(i);
			}
			
		//math sqrt (para sacar la raiz cuadrada)
	}
}
	
}