package com.dimensionalcraft.entities;

import com.diemsionalcraft.renderer.Camera;

import InputManager.keyListener;

public class Player {
	
	public static void update(){
		float[] newPos = Camera.getPosition();
		
		if(keyListener.movingForward){
			newPos[2]+=.1f*Math.cos(Math.toRadians(Camera.getYAngle()));
			newPos[0]-=.1f*Math.sin(Math.toRadians(Camera.getYAngle()));
		}
		
		
		if(keyListener.movingBackwards){
			newPos[2]-=.1f*Math.cos(Math.toRadians(Camera.getYAngle()));
			newPos[0]+=.1f*Math.sin(Math.toRadians(Camera.getYAngle()));
		}
		
		
		if(keyListener.movingLeft){
			newPos[2]+=.1f*Math.sin(Math.toRadians(Camera.getYAngle()));
			newPos[0]+=.1f*Math.cos(Math.toRadians(Camera.getYAngle()));
		}
		
		
		if(keyListener.movingRight){
			newPos[2]-=.1f*Math.sin(Math.toRadians(Camera.getYAngle()));
			newPos[0]-=.1f*Math.cos(Math.toRadians(Camera.getYAngle()));
			
		}
		
		Camera.setPosition(newPos);
	}
	
}
