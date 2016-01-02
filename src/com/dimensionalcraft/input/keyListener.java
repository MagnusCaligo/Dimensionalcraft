package com.dimensionalcraft.input;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.diemsionalcraft.renderer.Camera;
import com.dimensionalcraft.main.Main;

public class keyListener implements KeyListener{
	
	public static boolean movingForward = false;
	public static boolean movingBackwards = false;
	public static boolean movingLeft = false;
	public static boolean movingRight = false;

	@Override
	public void keyPressed(KeyEvent event) {
		float[] newPos = Camera.getPosition();
		switch(event.getKeyCode()){
		case KeyEvent.VK_ESCAPE:
			Main.exitGame();
			break;
		case KeyEvent.VK_A:
			movingLeft = true;
			break;
		case KeyEvent.VK_D:
			movingRight = true;
			break;
		case KeyEvent.VK_S:
			movingBackwards = true;
			break;
		case KeyEvent.VK_W:
			movingForward = true;
			break;
		case KeyEvent.VK_E:
			Camera.setYAngle(Camera.getYAngle()+1.5f);
			break;
		case KeyEvent.VK_Q:
			Camera.setYAngle(Camera.getYAngle()-1.5f);
			break;
		}
		Camera.setPosition(newPos);
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		switch(event.getKeyCode()){
		case KeyEvent.VK_A:
			movingLeft = false;
			break;
		case KeyEvent.VK_D:
			movingRight = false;
			break;
		case KeyEvent.VK_S:
			movingBackwards = false;
			break;
		case KeyEvent.VK_W:
			movingForward = false;
			break;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}
	

}
