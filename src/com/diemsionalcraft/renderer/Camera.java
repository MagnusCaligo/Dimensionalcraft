package com.diemsionalcraft.renderer;

public class Camera {
	
	private static float cameraPosition[] = {0,3,6};
	private static float angleX = 0;
	private static float angleY = 0;
	private static float angleZ = 0;
	
	public static float[] getPosition(){
		return cameraPosition;
	}
	
	public static void setPosition(float[] newPosition){
		cameraPosition = newPosition;
	}
	
	public static void setXAngle(float newX){
		if(newX >= -90 && newX <= 90)
			angleX = newX;
	}
	
	public static void setYAngle(float newY){
		angleY = newY;
	}
	
	public static float getXAngle(){
		return angleX;
	}
	
	public static float getYAngle(){
		return angleY;
	}
	
	public static float getZAngle(){
		return angleZ;
	}
	
	public static void setZAngle(float newZ){
		angleZ = newZ;
	}
	

	
}
