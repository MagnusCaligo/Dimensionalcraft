package com.dimensionalcraft.entities;

import com.diemsionalcraft.renderer.Camera;

import InputManager.keyListener;

public class Player {
	
	public static void update(){
		float[] newPos = Camera.getPosition();
		
		if(keyListener.movingForward){
<<<<<<< HEAD
			newPos[2]-=.1f*Math.cos(Math.toRadians(Camera.getYAngle()));
			newPos[0]+=.1f*Math.sin(Math.toRadians(Camera.getYAngle()));
=======
			newPos[2]+=.1f*Math.cos(Math.toRadians(Camera.getYAngle()));
			newPos[0]-=.1f*Math.sin(Math.toRadians(Camera.getYAngle()));
>>>>>>> origin/Desktop
		}
		
		
		if(keyListener.movingBackwards){
<<<<<<< HEAD
			newPos[2]+=.1f*Math.cos(Math.toRadians(Camera.getYAngle()));
			newPos[0]-=.1f*Math.sin(Math.toRadians(Camera.getYAngle()));
=======
			newPos[2]-=.1f*Math.cos(Math.toRadians(Camera.getYAngle()));
			newPos[0]+=.1f*Math.sin(Math.toRadians(Camera.getYAngle()));
>>>>>>> origin/Desktop
		}
		
		
		if(keyListener.movingLeft){
<<<<<<< HEAD
			newPos[2]-=.1f*Math.sin(Math.toRadians(Camera.getYAngle()));
			newPos[0]-=.1f*Math.cos(Math.toRadians(Camera.getYAngle()));
=======
			newPos[2]+=.1f*Math.sin(Math.toRadians(Camera.getYAngle()));
			newPos[0]+=.1f*Math.cos(Math.toRadians(Camera.getYAngle()));
>>>>>>> origin/Desktop
		}
		
		
		if(keyListener.movingRight){
<<<<<<< HEAD
			newPos[2]+=.1f*Math.sin(Math.toRadians(Camera.getYAngle()));
			newPos[0]+=.1f*Math.cos(Math.toRadians(Camera.getYAngle()));
=======
			newPos[2]-=.1f*Math.sin(Math.toRadians(Camera.getYAngle()));
			newPos[0]-=.1f*Math.cos(Math.toRadians(Camera.getYAngle()));
>>>>>>> origin/Desktop
			
		}
		
		Camera.setPosition(newPos);
	}
	
}
