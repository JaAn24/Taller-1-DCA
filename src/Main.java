
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
	//Zona para cargar todos los archivos
	PImage Inicio;
	PImage Controles;
	PImage Historia;
	PImage Iniciar;
	PImage Jugar1;
	PImage Jugar2;
	PImage Pregame;
	PImage Siguiente1;
	PImage Siguiente2;
	PImage PantallaJuego;
	PImage PanelUsuario;
	PImage enemigo1;
	PImage perdiste;
	
	//Pantallas
	int Pantalla;
	
	//Matriz
	int Filas;
	int Columnas;
	
	//Traer a Kih
	private KihHeroe heroe;
	//Enemigo 1
	private EnemigoChiquito mxezeta;
	private EnemigoMayor mxez;
	
	//Tiempo
	int minutos;
	int segundos;
	
	//puntaje
	int score = 0;
	
	//Enemigos
	private ArrayList<Enemigo> mxenemigo;
	private ArrayList<EnemigoMayor> mxGrande;
	
	
	

public Main() {
	
}


	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
		

	}
	
	public void settings() {
		size(1200,800);
	}
	
	public void setup() {
		//Imagenes
		Inicio = loadImage("iMAGENES fULL/INICIO.jpg");
		Controles = loadImage("iMAGENES fULL/CONTROLES.jpg");
		Historia = loadImage("iMAGENES fULL/HISTORIA.jpg");
		Iniciar = loadImage("iMAGENES fULL/INICIAR.jpg");
		Jugar1 = loadImage("iMAGENES fULL/JUGAR1.jpg");
		Jugar2 = loadImage("iMAGENES fULL/JUGAR2.jpg");
		Pregame = loadImage("iMAGENES fULL/PREGAME.jpg");
		Siguiente1 = loadImage("iMAGENES fULL/SIG1.jpg");
		Siguiente2 = loadImage("iMAGENES fULL/SIG2.jpg");
		PantallaJuego = loadImage("iMAGENES fULL/JUEGO.jpg");
		PanelUsuario = loadImage("iMAGENES fULL/PANEL.jpg");
		enemigo1 = loadImage("iMAGENES FULL/MXEZETA.png");
		perdiste = loadImage("iMAGENES FULL/LOST.jpg");
		
		//Otros Datos
		Pantalla = 1;
		
		//Inicializar Kih
		heroe = new KihHeroe(this);
		int x = (int) (Math.random()*1050+75);
		int y = -50;
		mxezeta = new EnemigoChiquito(this,x,y);
		mxez = new EnemigoMayor(this,x,y);
		
		//Tiempo
		minutos = 0;
		segundos = 0;
		
		//puntaje
		score = 0;
		
		//ENEMIGOS
		mxenemigo = new ArrayList<Enemigo>();
		frameRate(50);
		
		//ENEMIGO FUERTE
		mxGrande = new ArrayList <EnemigoMayor>();
		frameRate(60);
		
		
	}
	
	public void draw() {
		
		//Switch de Pantalla
		switch (Pantalla) {
		case 1:
			//Imagen de Inicio
			image(Inicio,0,0,1200,800);
			image(Jugar1,940,706,120,40);
			if(mouseX > 940 && mouseX < 940 + 120 && mouseY > 706 && mouseY < 706 + 40) {
				image(Jugar2,940,706,120,40);
			}
			break;
			
		case 2:
			image(Historia,0,0,1200,800);
			image(Siguiente1,940,706,120,40);
			if(mouseX > 940 && mouseX < 940 + 120 && mouseY > 706 && mouseY < 706 + 40) {
				image(Siguiente2,940,706,120,40);
			}
			break;
			
		case 3:
			image(Controles,0,0,1200,800);
			image(Siguiente1,940,706,120,40);
			if(mouseX > 940 && mouseX < 940 + 120 && mouseY > 706 && mouseY < 706 + 40) {
				image(Siguiente2,940,706,120,40);
			}
			break;
			
		case 4:
			image(Pregame,0,0,1200,800);
			image(Iniciar,400,300,400,100);
			if(mouseX > 400 && mouseX < 400 + 400 && mouseY > 300 && mouseY < 300 + 100) {

			}
		break;
		
		case 5: //Pantalla de juego
			image(PantallaJuego,0,0,1200,800);
			image(PanelUsuario,0,600,1200,200);
			heroe.drawKih(this);
			mxezeta.pintarEnemigo(this);
			mxezeta.mover();
			
			mxez.pintarEnemigo(this);
			mxez.mover();
			enemigosInit();
			enemigosDraw();
			
			//System.out.println(heroe.getBalas().size());
			
			matarEzeta();
			
			//tiempo
			tiempo();
			
			break;
		//case 6: //PERDISTE
			//image(perdiste,0,0,1200,800);
		
		}
		
		//Ver Coordenadas
		//fill(255);
		//textSize(15);
		//text("posX"+mouseX +"posY"+ mouseY,mouseX, mouseY);
		
	}


	
	public void mousePressed() {
		
		//Cambio de las pantallas
		switch(Pantalla) {
			case 1:
				if(mouseX > 940 && mouseX < 940 + 120 && mouseY > 706 && mouseY < 706 + 40) {
					Pantalla = 2;
				}
			break;
			
			case 2:
				if(mouseX > 940 && mouseX < 940 + 120 && mouseY > 706 && mouseY < 706 + 40) {
					Pantalla = 3;
				}
			break;
				
			case 3:
				if(mouseX > 940 && mouseX < 940 + 120 && mouseY > 706 && mouseY < 706 + 40) {
					Pantalla = 4;
				}
			break;
				
			case 4:
				if(mouseX > 400 && mouseX < 400 + 400 && mouseY > 300 && mouseY < 300 + 100) {
						Pantalla = 5;
						
				}
				break;
				
			case 5:
				for (int i = 0; i < mxenemigo.size(); i++) {
					
					if (mxenemigo.get(i).getPosX() >= -mxenemigo.get(i).getPosX()- 80) {
						
						mxenemigo.remove(i);	
					
					score+=10;
					
					}
				}
				
			

		
		}
				
	}
	
	public void matarEzeta() {
		for (int i = 0; i < heroe.getBalas().size(); i++) {
			
		
			if(Math.sqrt((Math.pow(heroe.getBalas().get(i).getPosiX() - mxezeta.getPosX(), 2)+(Math.pow(heroe.getBalas().get(i).getPosiY() - mxezeta.getPosY(), 2) ))) < mxezeta.getEnemigoSize()){
				System.out.println("Te dio por marica");
				
				//Math.sqrt((Math.pow((heroe.getBalas()-((EnemyShooter)enemies.get(j)).getEnemyBullets().get(k).getPosX()), 2)))+
                //Math.sqrt((Math.pow((player.getPosY()-((EnemyShooter)enemies.get(j)).getEnemyBullets().get(k).getPosY()), 2)))<
                //player.getShipSize()/2) {
				
				if(Math.sqrt((Math.pow(heroe.getBalas().get(i).getPosiX() - mxez.getPosX(), 2)+(Math.pow(heroe.getBalas().get(i).getPosiY() - mxez.getPosY(), 2) ))) < mxez.getEnemigoSize()){
					System.out.println("shoot");
				
				
				mxezeta.removeEnemigo(); 
			}
			}
	}
	
	}
	public void keyPressed() {
		//Mover personaje
		switch(key) {
		
		case'a':
		case 'A':
			heroe.moveKih(false);
			break;
			
		case'd':
		case 'D':
			heroe.moveKih(true);

			break;
			
		case'k':
		case'K':
			heroe.generarBalas(this);
			break;
		}
		
		
	}
	
	public void tiempo() {
		if(frameCount % 60 == 0 && minutos >= 0) {
			segundos ++;
		}
		if(segundos == 60) {
			minutos ++;
			segundos = 0;
		}
		if(minutos < 0) {
			fill(255, 233, 0);
			textSize(100);
			text("0:00",112, 729);
		}else if (segundos <= 9) {
			fill(255, 233, 0);
			textSize(100);
			text(minutos + ":" + segundos,112, 729);
			
		}else if (segundos > 9) {
			fill(255, 233, 0);
			textSize(100);
			text(minutos + ":" + segundos, 112, 729);
		}
		
	}
	
	public void enemigosInit () {
		
		if (frameCount == 50) {
			
			int posX = (int) random(60,1000);
			int posY = (int) (80);
					
			mxenemigo.add(new Enemigo(this, posX, posY));
			
			System.out.println("HOLA");
			
			frameCount = 0;
			
		}
		
		
	}
	
	public void enemigosDraw () {
		
		for (int i = 0; i < mxenemigo.size() ; i++) {
			
			Enemigo enemigoT = mxenemigo.get(i);
			
			enemigoT.pintarEnemigos(this);
			
			if (mxenemigo.get(i).getPosX() > 900) {
				
				Pantalla = 5;

			}
			
		}
		
	}
	
	
		
	
}