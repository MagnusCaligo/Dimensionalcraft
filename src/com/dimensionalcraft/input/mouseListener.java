package com.dimensionalcraft.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.diemsionalcraft.renderer.Camera;

public class mouseListener implements MouseListener, MouseMotionListener{
	
	private boolean entered = false;
	private float oldMousePosX;
	private float oldMousePosY;

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		entered = true;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		entered = false;
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		if(entered){
			float xDif;
			float yDif;
			if(oldMousePosX != 0){
				xDif = event.getX() - oldMousePosX;
			} else {
				xDif = event.getX();
			}
			
			if(oldMousePosY != 0){
				yDif = event.getY() - oldMousePosY;
			} else {
				yDif = event.getY();
			}
			
			Camera.setXAngle(Camera.getXAngle()+yDif);
			Camera.setYAngle(Camera.getYAngle()+xDif);
			
			oldMousePosX = event.getX();
			oldMousePosY = event.getY();
			
			
		}
		
	}

}
