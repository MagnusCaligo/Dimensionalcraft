package com.dimensionalcraft.blocks;

import javax.media.opengl.GL2;

public class DirtBlock extends Block{
	
	
	public DirtBlock() {
		this.isVisible = true;
	}
	
	@Override
	public void draw(GL2 gl){
		
		gl.glColor3f(145f/255f, 76f/255f, 7f/255f);
		Block.drawVerticies(gl);
		
	}

	@Override
	public void drawTop(GL2 gl) {
		
		gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube
		gl.glVertex3f(1.0f, 1.0f, 0f); // Top Right Of The Quad (Top)
		gl.glVertex3f(0f, 1.0f, 0f); // Top Left Of The Quad (Top)
		gl.glVertex3f(0f, 1.0f, 1.0f); // Bottom Left Of The Quad (Top)
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Bottom Right Of The Quad (Top)
		gl.glEnd();
	}

	@Override
	public void drawBottom(GL2 gl) {
		gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube
		
		gl.glVertex3f(1.0f, 0f, 1.0f); // Top Right Of The Quad (Bottom)
		gl.glVertex3f(0f, 0f, 1.0f); // Top Left Of The Quad (Bottom)
		gl.glVertex3f(0f, 0f, 0f); // Bottom Left Of The Quad (Bottom)
		gl.glVertex3f(1.0f, 0f, 0f); // Bottom Right Of The Quad (Bottom)
		gl.glEnd();
	}

	@Override
	public void drawLeft(GL2 gl) {
		gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube
		gl.glVertex3f(0f, 1.0f, 1.0f); // Top Right Of The Quad (Left)
		gl.glVertex3f(0f, 1.0f, 0f); // Top Left Of The Quad (Left)
		gl.glVertex3f(0f, 0f, 0f); // Bottom Left Of The Quad (Left)
		gl.glVertex3f(0f, 0f, 1.0f); // Bottom Right Of The Quad (Left)
		gl.glEnd();
	}

	@Override
	public void drawRight(GL2 gl) {
		gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube
		gl.glVertex3f(1.0f, 1.0f, 0f); // Top Right Of The Quad (Right)
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Left Of The Quad (Right)
		gl.glVertex3f(1.0f, 0f, 1.0f); // Bottom Left Of The Quad (Right)
		gl.glVertex3f(1.0f, 0f, 0f); // Bottom Right Of The Quad (Right)
		gl.glEnd();
	}

	@Override
	public void drawBack(GL2 gl) {
		gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube
		gl.glVertex3f(1.0f, 0f, 0f); // Bottom Left Of The Quad (Back)
		gl.glVertex3f(0f, 0f, 0f); // Bottom Right Of The Quad (Back)
		gl.glVertex3f(0f, 1.0f, 0f); // Top Right Of The Quad (Back)
		gl.glVertex3f(1.0f, 1.0f, 0f); // Top Left Of The Quad (Back)
		gl.glEnd();
	}

	@Override
	public void drawFront(GL2 gl) {
		gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The Quad (Front)
		gl.glVertex3f(0f, 1.0f, 1.0f); // Top Left Of The Quad (Front)
		gl.glVertex3f(0f, 0f, 1.0f); // Bottom Left Of The Quad (Front)
		gl.glVertex3f(1.0f, 0f, 1.0f); // Bottom Right Of The Quad (Front)
		gl.glEnd();
	}


}
