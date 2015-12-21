package com.dimensionalcraft.chunk;

import javax.media.opengl.GL2;

import com.diemsionalcraft.renderer.Camera;
import com.dimensionalcraft.blocks.Block;
import com.dimensionalcraft.blocks.DirtBlock;

public class normalChunk extends Chunk{

	
	
	public normalChunk(int x, int y){
		super(x,y);
		
		for(int amt = 0; amt < 15; amt++){
			this.blockData.get(amt).get(0).get(0)[0]=1;
		}
	}
	
	
	
	@Override
	public void draw(GL2 gl) {
		for(int x = 0; x <blockData.size(); x++){
			for(int y = 0; y < blockData.get(x).size(); y++){
				for(int z = 0; z < blockData.get(x).get(y).size(); z++){
					
					int blockId = blockData.get(x).get(y).get(z)[0];
					if(blockId != Block.NONE){
						gl.glLoadIdentity();
						gl.glRotatef(Camera.getYAngle(), 0f, 1f, 0f);
						gl.glTranslatef(Camera.getPosition()[0], Camera.getPosition()[1], Camera.getPosition()[2]);
						gl.glTranslatef((this.xpos * 16)+x, y, (this.zpos*15)+z);

						
						Block.blockIDs.get(blockId).draw(gl);
						
					}
				}
			}
		}
	}

}