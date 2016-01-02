package com.dimensionalcraft.chunk;

import java.util.ArrayList;

import javax.media.opengl.GL2;

public abstract class Chunk {
	
	protected final int xpos;
	protected final int zpos;
	
	//The ArrayList that will contain all the block meta data
	//The first thing in the int array is the block id/type
	//The second thing in the int array is the blcok metta data
	protected ArrayList<ArrayList<ArrayList<Integer[]>>> blockData;
	
	public Chunk(int xpos, int zpos){
		blockData = new ArrayList<ArrayList<ArrayList<Integer[]>>>();
		for(int x = 0; x < 16; x++){
			blockData.add(new ArrayList<ArrayList<Integer[]>>());
			for(int y = 0; y < 255; y++){
				blockData.get(x).add(new ArrayList<Integer[]>());
				for(int z = 0; z < 16; z++){
					Integer[] temp = {0,0}; 
					blockData.get(x).get(y).add(temp);
				}
			}
		}
		
		this.xpos = xpos;
		this.zpos = zpos;
	}
	
	public abstract void draw(GL2 gl);
	
	public Integer[] getBlockData(int x, int y, int z){
		return blockData.get(x).get(y).get(z);
	}
	
	public ArrayList<ArrayList<ArrayList<Integer[]>>> getChunkData(){
		return blockData;
	}
	
	public int getXpos(){
		return this.xpos;
	}
	
	public int getZpos(){
		return this.zpos;
	}
	
	
}
