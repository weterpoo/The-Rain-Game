//UIUC CS125 FALL 2014 MP. File: RainGame.java, CS125 Project: PairProgramming, Version: 2014-09-29T23:52:21-0500.407407157
/**
 * @author pywoo2
 */
import java.io.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
public class RainGame {
	
	public static int holder = 1;
	public static int current = 0;	

	public static void main(String[] args) throws IOException{
			intro();
			menu();
	}
		
		public static void intro() {
			boolean input = false;
			String x = "welcome";
			String z = "... to the rain game!";
			String y= "Would you like to skip the first level? (Yes or No)";
			int swag = 10;
			Zen.setFont("Times New Roman-30");
			Zen.drawText("___________________________________________________________________", swag, Zen.getZenHeight()/2);
			Zen.sleep(2000);
			for(int i = 0; i < x.length(); i++) {
				Zen.drawText(x.substring(i,i+1), swag, Zen.getZenHeight()/2 - 35);
				swag += 30;
				Zen.sleep(200);
			}
			Zen.sleep(2000);
			swag = 10;
			for(int j = 0; j < z.length(); j++) {
				Zen.drawText(z.substring(j, j+1), swag, Zen.getZenHeight()/2 + 65);
				swag += 30;
				Zen.sleep(80);
			}
			Zen.sleep(2000);
			for(int k = 1000; k > 1; k = (6*k)/7) {
				Zen.setColor((int)(Math.random() * 50)+125, (int)(Math.random() * 50)+125, (int)(Math.random() * 50)+200);
				Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
				Zen.setColor(0,0,0);
				swag = 10;
				for(int i = 0; i < x.length(); i++) {
					Zen.drawText(x.substring(i,i+1), swag, Zen.getZenHeight()/2 - 35);
					swag += 30;
				}
				swag = 10;
				for(int j = 0; j < z.length(); j++) {
					Zen.drawText(z.substring(j, j+1), swag, Zen.getZenHeight()/2 + 65);
					swag += 30;
				}
				swag = 10;
				Zen.drawText("___________________________________________________________________", swag, Zen.getZenHeight()/2);
				Zen.sleep(k);
			}
			int a = (int)(Math.random() * 50)+200, b = (int)(Math.random() * 50)+200, c = (int)(Math.random() * 50)+200;
			Zen.setColor(a,b,c);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
			Zen.setColor(0,0,0);
			swag = 10;
			for(int i = 0; i < x.length(); i++) {
				Zen.drawText(x.substring(i,i+1), swag, Zen.getZenHeight()/2 - 35);
				swag += 30;
			}
			swag = 10;
			for(int j = 0; j < z.length(); j++) {
				Zen.drawText(z.substring(j, j+1), swag, Zen.getZenHeight()/2 + 65);
				swag += 30;
			}
			swag = 10;
			Zen.drawText("___________________________________________________________________", swag, Zen.getZenHeight()/2);
			Zen.sleep(3000);
			
			for(int p = 1000; p > 1; p = (2*p)/3) {
				Zen.setColor(255,255,255);
				Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
				Zen.setColor(0,0,0);
				swag = 10;
				for(int i = 0; i < x.length(); i++) {
					Zen.drawText(x.substring(i,i+1), swag, Zen.getZenHeight()/2 - 35);
					swag += 30;
				}
				swag = 10;
				for(int j = 0; j < z.length(); j++) {
					Zen.drawText(z.substring(j, j+1), swag, Zen.getZenHeight()/2 + 65);
					swag += 30;
				}
				swag = 10;
				Zen.drawText("___________________________________________________________________", swag, Zen.getZenHeight()/2);
				Zen.sleep(p);
				Zen.setColor(0,0,0);
				Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
				Zen.sleep(100);
			}
			
			Zen.sleep(3000);
			menu();
		}
			
		public static void menu() {
			Zen.setFont("Times New Roman-80");
			Zen.setColor(255,255,0);
			Zen.drawText("Play", Zen.getZenWidth()/2 - 70, 2 * Zen.getZenHeight()/8);
			Zen.setFont("Times New Roman-60");
			Zen.setColor(255,255,255);
			Zen.drawText("Instructions", Zen.getZenWidth()/2-133, 4 * Zen.getZenHeight()/8);
			Zen.setColor(255,255,255);
			Zen.drawText("Select level", Zen.getZenWidth()/2-130, 6 * Zen.getZenHeight()/8);
			Zen.setFont("Times New Roman-12");
			Zen.drawText("W-key to move up   ||   S-key to move down   ||   E-key to select.  ||  X-key to exit program",10,30);
			boolean end = false;
			int total = 0;
			
			while(end == false) {
				String input = Zen.getEditText();
				System.out.println(input);
				Zen.setEditText("");
				
				if(holder == 1) {
					if(input.equals("w")){
						level(); 	 
						System.out.println("1");
					}
					else if(input.equals("s")) {
						instructions();
						System.out.println("2");
					}
				}
				else if(holder == 2) {
					if(input.equals("w")){
						play();
						System.out.println("1");
					}
					else if(input.equals("s")) {
						level();
						System.out.println("2");
					}
				}
				else if(holder == 3) {
					if(input.equals("w")){
						instructions();
						System.out.println("1");
					}
					else if(input.equals("s")) {
						play();
						System.out.println("2");
					}
				}
				if(input.equals("e")) {
					end = true;
					total = holder;
				}
				if(input.equals("x")) {
					System.exit(1);
				}
				Zen.sleep(3);
			}
			
			if(holder == 1) {
				run(current);

			}
			if(holder == 2) {
				Zen.setColor(0,0,0);
				Zen.fillRect(0,0,Zen.getZenWidth(), Zen.getZenHeight());
				Zen.setFont("Times New Roman-18");
				Zen.setColor(255,255,0);
				Zen.drawText("Welcome to the rain game! The rain game is a simple reactive and cognitive game.", 10, 30);
				Zen.drawText("It is quite easy to play. All you have to do is type the number you see on the", 10, 60);
				Zen.drawText("screen, before it touches the ground! As you progress, the game will become more", 10, 90);
				Zen.drawText("challenging, so be prepared!", 10, 120);
				Zen.drawText("If you ever want to go back to the main menu, just press the M-key!", 10, 180);
				Zen.drawText("If in game, press the X-key to exit the game.", 10, 220);
				boolean check = false;
				while(check == false) {
					String input = Zen.getEditText();
					Zen.setEditText("");
					if(input.equals("m")) {
						check = true;
						Zen.setColor(0,0,0);
						Zen.fillRect(0,0,Zen.getZenWidth(), Zen.getZenHeight());
						holder = 1;
						menu();
					}
					Zen.sleep(3);
					
				}
			}
			if(holder == 3) {
				Zen.setColor(0,0,0);
				Zen.fillRect(0,0,Zen.getZenWidth(), Zen.getZenHeight());
				Zen.setFont("Times New Roman-16");
				Zen.setColor(255,255,0);
				Zen.drawText("Press the M-key to return to menu, after entering a level.", 10, 30);
				Zen.setFont("Times New Roman-35");
				Zen.drawText("Which level would you like to start on?!?", 10, Zen.getZenHeight()/2 - 40);
				Zen.drawText("Type your level then press e to enter.", 10, Zen.getZenHeight()/2);
				Zen.setFont("Times New Roman-50");
				Zen.setColor(255,255,255);
				boolean target= false;
				String num = "";
				int space = 0;
				while(target == false) {
					String in = Zen.getEditText();
					Zen.setEditText("");
					if(in.equals("e") && !num.equals(""))  {
						target = true;
						current = Integer.parseInt(num) - 1;
						Zen.setFont("Times New Roman-35");
						Zen.setColor(255,255,0);
						Zen.drawText("New Level Confirmed!", 10, Zen.getZenHeight()/2 + 160);
					}
					else {
						if(in.equals("1") || in.equals("2") || in.equals("3") || in.equals("4") || in.equals("5") || in.equals("6") || in.equals("7") || in.equals("8") || in.equals("9") || in.equals("0")) {
							Zen.drawText(in, 40 + space, Zen.getZenHeight()/2 + 90);
							num += in;
							space += 30;
						}
					}
					Zen.sleep(3);
				}
					
				boolean check = false;
				while(check == false) {
					String input = Zen.getEditText();
					Zen.setEditText("");
					if(input.equals("m")) {
						check = true;
						Zen.setColor(0,0,0);
						Zen.fillRect(0,0,Zen.getZenWidth(), Zen.getZenHeight());
						holder = 1;
						menu();
					}
					Zen.sleep(3);
					
				}
			}
			
			
		}
		
		public static void play() {
			Zen.setColor(0,0,0);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
			holder = 1;
			Zen.setFont("Times New Roman-80");
			Zen.setColor(255,255,0);
			Zen.drawText("Play", Zen.getZenWidth()/2 - 70, 2 * Zen.getZenHeight()/8);
			Zen.setFont("Times New Roman-60");
			Zen.setColor(255,255,255);
			Zen.drawText("Instructions", Zen.getZenWidth()/2-133, 4 * Zen.getZenHeight()/8);
			Zen.setColor(255,255,255);
			Zen.drawText("Select level", Zen.getZenWidth()/2-130, 6 * Zen.getZenHeight()/8);
			Zen.setFont("Times New Roman-12");
			Zen.drawText("W-key to move up   ||   S-key to move down   ||   E-key to select.  ||  X-key to exit program",10,30);
			Zen.sleep(50);
		}
		
		public static void instructions() {
			Zen.setColor(0,0,0);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
			holder = 2;
			Zen.setFont("Times New Roman-80");
			Zen.setColor(255,255,0);
			Zen.drawText("Instructions", Zen.getZenWidth()/2-133, 4 * Zen.getZenHeight()/8);
			Zen.setFont("Times New Roman-60");
			Zen.setColor(255,255,255);
			Zen.drawText("Play", Zen.getZenWidth()/2 - 70, 2 * Zen.getZenHeight()/8);
			Zen.setColor(255,255,255);
			Zen.drawText("Select level", Zen.getZenWidth()/2-130, 6 * Zen.getZenHeight()/8);
			Zen.setFont("Times New Roman-12");
			Zen.drawText("W-key to move up   ||   S-key to move down   ||   E-key to select.  ||  X-key to exit program",10,30);
			Zen.sleep(50);
		}
		
		public static void level() {
			Zen.setColor(0,0,0);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
			holder = 3;
			Zen.setFont("Times New Roman-80");
			Zen.setColor(255,255,0);
			Zen.drawText("Select level", Zen.getZenWidth()/2-130, 6 * Zen.getZenHeight()/8);
			Zen.setFont("Times New Roman-60");
			Zen.setColor(255,255,255);
			Zen.drawText("Play", Zen.getZenWidth()/2 - 70, 2 * Zen.getZenHeight()/8);
			Zen.drawText("Instructions", Zen.getZenWidth()/2-133, 4 * Zen.getZenHeight()/8);
			Zen.setColor(255,255,255);
			Zen.drawText("Instructions", Zen.getZenWidth()/2-133, 4 * Zen.getZenHeight()/8);
			Zen.setFont("Times New Roman-12");
			Zen.drawText("W-key to move up   ||   S-key to move down   ||   E-key to select.  ||  X-key to exit program",10,30);
			Zen.sleep(50);
		}
		
		public static synchronized void run(int level) {
	
		int x=0, y=0, dx=0, dy=0, temp = 0, up = 5;
		double score = 0;
		double ctime = 250/(level+1), chold = 250/(level+1);
		String text = "";
		long startTime =System.currentTimeMillis();
		
		Zen.setFont("Times New Roman-50");
		while (Zen.isRunning()) {

			if (text.length() == 0) {
				x = (int)(Math.random() * (Zen.getZenWidth() - 200) + 75);
				y = Zen.getZenHeight() / 2;
				if(x > 0)
					dx = 1;
				if(x < 0)
					dx = -1;
				if(y > 0)
					dy = 1;
				if(y < 0)
					dy = -1;
				text = "" + (int) (Math.random() * 999);
				long elapsed = System.currentTimeMillis() - startTime;
				startTime = System.currentTimeMillis();
				score += 3000 / (elapsed + 1);
				temp += 3000 / (elapsed + 1);
				if(temp > up) {
					level++;
					temp = 0;
					up += 3;
					ctime /= 2; 
					chold =ctime;
				}
			}


			Zen.setColor(0, 255, 0);
			Zen.drawText(text, x, y);
			
			
			Zen.drawText("Level: " + level,10,60);
			Zen.drawText("Score: " + (score-3000),10,120);
			
			if((score - 3000) == -1500) {
				score += 1500;
			}
			
			x += dx;
			y += dy;
			
			Zen.flipBuffer();
			
			if(y == Zen.getZenHeight() || y == 35) {
				dy = -dy;
				score -= .25;
			}
			if(x == Zen.getZenWidth() - 58 || x == 0) {
				dx = -dx;
				score -= .25;
			}
			
			if(ctime < 0) {
				Zen.setColor((int)(Math.random() * 250), (int)(Math.random() * 250), (int)(Math.random() * 250));
				Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
				ctime = chold;
			}
			else {
				ctime -= 1;
			}
			
			String user = Zen.getEditText();
			System.out.println(user);
			Zen.setEditText("");
			
			for(int i=0;i < user.length();i++) {
				char c = user.charAt(i);
				if(c == text.charAt(0))
					text = text.substring(1,text.length()); 
				if(c == 'x') {
					System.exit(1);
				}
			}
			
			if(user.equals("x")) {
				System.exit(1);
			}
				
			
			Zen.sleep(3);
		}
		}
	}


