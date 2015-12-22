package com.dimensionalcraft.blocks;

import javax.media.opengl.GL2;

public class DirtBlock extends Block{
	
	
	@Override
	public void draw(GL2 gl){
		
		gl.glColor3f(145f/255f, 76f/255f, 7f/255f);
		Block.drawVerticies(gl);
		
	}

}
