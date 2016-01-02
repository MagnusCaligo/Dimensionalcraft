package com.dimensionalcraft.world;

import java.util.ArrayList;

import javax.swing.JFrame;

import com.diemsionalcraft.renderer.Renderer;
import com.dimensionalcraft.blocks.Block;
import com.dimensionalcraft.chunk.Chunk;
import com.dimensionalcraft.chunk.normalChunk;

public class World {
	
	private static ArrayList<ArrayList<Chunk>> chunks;
	private static Renderer render;
	
	public World(JFrame frame){
		
		chunks = new ArrayList<ArrayList<Chunk>>();
		for(int i = 0; i < 5; i++){
			chunks.add(new ArrayList<Chunk>());
			for(int m = 0; m < 5; m++){
				chunks.get(i).add(new normalChunk(i,m));
			}
		}

		
		render = new Renderer(chunks, frame);
		
	}
	
	public Chunk getChunk(int x, int y){
		return chunks.get(x).get(y);
	}
	
	public static void unLoad(){
		render.exit();	
		
		System.exit(0);
	}
	
	public static Block getBlockAt(int x, int y, int z){
		
		Chunk chunk = chunks.get(x%15).get(z%15);
		
		Integer[] block = chunk.getBlockData((x%15)+chunk.getXpos(), y, (z%15)+chunk.getZpos());
		
		return Block.blockIDs.get(block[0]);
		
		
	}

}
