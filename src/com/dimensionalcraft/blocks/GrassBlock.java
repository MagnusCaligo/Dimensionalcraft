package com.dimensionalcraft.blocks;

import javax.media.opengl.GL2;

public class GrassBlock extends Block{

	@Override
	public void draw(GL2 gl) {
		gl.glColor3f(0f, 1f, 0f);
		Block.drawVerticies(gl);
		
	}

}
