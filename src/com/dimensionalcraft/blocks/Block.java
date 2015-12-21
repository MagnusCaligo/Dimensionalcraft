package com.dimensionalcraft.blocks;

import java.util.HashMap;

import javax.media.opengl.GL2;

public abstract class Block {
	
	public static final int NONE = 0;
	public static final int DIRT = 1;
	
	public static HashMap<Integer, Block> blockIDs;
	
	static {
		blockIDs = new HashMap<Integer, Block>();
		blockIDs.put(0, null);
		blockIDs.put(1,  new DirtBlock());
		blockIDs.put(2,  new GrassBlock());
	}
	
	public static void drawVerticies(GL2 gl){
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(0, 1, 0);
		gl.glVertex3f(1, 1, 0);
		gl.glVertex3f(1, 0, 0);
		gl.glVertex3f(0, 0, 0);
		
		gl.glVertex3f(0, 1, 1);
		gl.glVertex3f(0, 1, 0);
		gl.glVertex3f(0, 0, 0);
		gl.glVertex3f(0, 0, 1);
		
		gl.glVertex3f(0, 1, 1);
		gl.glVertex3f(1, 1, 1);
		gl.glVertex3f(1, 0, 1);
		gl.glVertex3f(0, 0, 1);
		
		gl.glVertex3f(1, 1, 0);
		gl.glVertex3f(1, 1, 1);
		gl.glVertex3f(1, 0, 1);
		gl.glVertex3f(1, 0, 0);
		
		gl.glVertex3f(0, 1, 1);
		gl.glVertex3f(1, 1, 1);
		gl.glVertex3f(1, 1, 0);
		gl.glVertex3f(0, 1, 0);
		
		gl.glVertex3f(0, 0, 1);
		gl.glVertex3f(1, 0, 1);
		gl.glVertex3f(1, 0, 0);
		gl.glVertex3f(0, 0, 0);
	
		gl.glEnd();
		gl.glFlush();
		gl.glLoadIdentity();
	}
	
	public abstract void draw(GL2 gl);
	
	

}
