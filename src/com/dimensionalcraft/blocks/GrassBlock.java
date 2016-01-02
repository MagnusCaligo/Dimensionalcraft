package com.dimensionalcraft.blocks;

import javax.media.opengl.GL2;

public class GrassBlock extends Block{
	
	public GrassBlock(){
		this.isVisible = true;
	}

	@Override
	public void draw(GL2 gl) {
		gl.glColor3f(0f, 1f, 0f);
		Block.drawVerticies(gl);
		
	}

	@Override
	public void drawTop(GL2 gl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawBottom(GL2 gl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawLeft(GL2 gl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawRight(GL2 gl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawBack(GL2 gl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawFront(GL2 gl) {
		// TODO Auto-generated method stub
		
	}


}
