package com.dimensionalcraft.chunk;

import javax.media.opengl.GL2;

import com.diemsionalcraft.renderer.Camera;
import com.dimensionalcraft.blocks.Block;
import com.dimensionalcraft.blocks.DirtBlock;
import com.dimensionalcraft.world.World;

public class normalChunk extends Chunk{

	
	
	public normalChunk(int x, int y){
		super(x,y);
		
		boolean temp = true;
		
		for(int amt = 0; amt < 16; amt++){
			for(int a = 0; a < 16; a++){			
				for(int n = 0; n < 16; n++){
					float num = (float) (Math.random() * 10);
					if(num >=9)
						this.blockData.get(amt).get(n).get(a)[0] = 1;
				}
			}
		}
		
		this.blockData.get(0).get(0).get(0)[0] = 1;
		this.blockData.get(0).get(1).get(0)[0] = 1;
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
						gl.glRotatef(Camera.getXAngle(), (float) Math.cos(Math.toRadians(Camera.getYAngle())), 0, (float)Math.sin(Math.toRadians(Camera.getYAngle())));
						gl.glTranslatef(-Camera.getPosition()[0], -Camera.getPosition()[1], -Camera.getPosition()[2]);
						gl.glTranslatef((this.xpos * 16)+x, y, (this.zpos*15)+z);

						
						Block.blockIDs.get(blockId).draw(gl);
						
//						Block top = World.getBlockAt(x, y+1, z);
//						Block bottom;
//						Block left;
//						Block right;
//						Block front;
//						Block back;
						
//						if(x != 0){
//							if(blockData.get(x-1).get(y).get(z) != null)
//								Block.blockIDs.get(blockId).drawLeft(gl);
//						}
//						if(x!=15){
//							if(blockData.get(x+1).get(y).get(z) != null)
//								Block.blockIDs.get(blockId).drawRight(gl);
//						}
//						
//						
//						if(y!=0){
//							if(blockData.get(x).get(y-1).get(z) != null)
//								Block.blockIDs.get(blockId).drawBottom(gl);
//						}
//						if(blockData.get(x).get(y+1).get(z) != null)
//							Block.blockIDs.get(blockId).drawTop(gl);
//						
//						
//						
//						if(z!=0){
//							if(blockData.get(x).get(y).get(z-1) != null)
//								Block.blockIDs.get(blockId).drawFront(gl);
//						}
//						
//						if(z!=15){
//							if(blockData.get(x).get(y).get(z+1) != null)
//								Block.blockIDs.get(blockId).drawBack(gl);
//						}
						
						
					}
				}
			}
		}
	}
	
	

}