package com.dimensionalcraft.blocks;

import java.util.HashMap;

import javax.media.opengl.GL2;

public abstract class Block{
	
	public static final int NONE = 0;
	public static final int DIRT = 1;
	public static final int GRASS = 2;
	
	public static HashMap<Integer, Block> blockIDs;
	
	protected boolean isVisible = false;
	
	static {
		blockIDs = new HashMap<Integer, Block>();
		blockIDs.put(0, null);
		blockIDs.put(1,  new DirtBlock());
		blockIDs.put(2,  new GrassBlock());
	}
	
	public boolean getVisible(){
		return this.isVisible;
	}
	
	public static void drawVerticies(GL2 gl){
	
		
		gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

		gl.glVertex3f(1.0f, 1.0f, 0f); // Top Right Of The Quad (Top)
		gl.glVertex3f(0f, 1.0f, 0f); // Top Left Of The Quad (Top)
		gl.glVertex3f(0f, 1.0f, 1.0f); // Bottom Left Of The Quad (Top)
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Bottom Right Of The Quad (Top)

		gl.glVertex3f(1.0f, 0f, 1.0f); // Top Right Of The Quad (Bottom)
		gl.glVertex3f(0f, 0f, 1.0f); // Top Left Of The Quad (Bottom)
		gl.glVertex3f(0f, 0f, 0f); // Bottom Left Of The Quad (Bottom)
		gl.glVertex3f(1.0f, 0f, 0f); // Bottom Right Of The Quad (Bottom)

		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The Quad (Front)
		gl.glVertex3f(0f, 1.0f, 1.0f); // Top Left Of The Quad (Front)
		gl.glVertex3f(0f, 0f, 1.0f); // Bottom Left Of The Quad (Front)
		gl.glVertex3f(1.0f, 0f, 1.0f); // Bottom Right Of The Quad (Front)

		gl.glVertex3f(1.0f, 0f, 0f); // Bottom Left Of The Quad (Back)
		gl.glVertex3f(0f, 0f, 0f); // Bottom Right Of The Quad (Back)
		gl.glVertex3f(0f, 1.0f, 0f); // Top Right Of The Quad (Back)
		gl.glVertex3f(1.0f, 1.0f, 0f); // Top Left Of The Quad (Back)

		gl.glVertex3f(0f, 1.0f, 1.0f); // Top Right Of The Quad (Left)
		gl.glVertex3f(0f, 1.0f, 0f); // Top Left Of The Quad (Left)
		gl.glVertex3f(0f, 0f, 0f); // Bottom Left Of The Quad (Left)
		gl.glVertex3f(0f, 0f, 1.0f); // Bottom Right Of The Quad (Left)

		gl.glVertex3f(1.0f, 1.0f, 0f); // Top Right Of The Quad (Right)
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Left Of The Quad (Right)
		gl.glVertex3f(1.0f, 0f, 1.0f); // Bottom Left Of The Quad (Right)
		gl.glVertex3f(1.0f, 0f, 0f); // Bottom Right Of The Quad (Right)
	
		gl.glEnd();
		gl.glLoadIdentity();
	}
	
	public abstract void draw(GL2 gl);
	
	public abstract void drawTop(GL2 gl);
	public abstract void drawBottom(GL2 gl);
	public abstract void drawLeft(GL2 gl);
	public abstract void drawRight(GL2 gl);
	public abstract void drawBack(GL2 gl);
	public abstract void drawFront(GL2 gl);
	
	
	
	

}
