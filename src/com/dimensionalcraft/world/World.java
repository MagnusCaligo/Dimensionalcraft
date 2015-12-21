package com.dimensionalcraft.world;

import java.util.ArrayList;

import javax.swing.JFrame;

import com.diemsionalcraft.renderer.Renderer;
import com.dimensionalcraft.chunk.Chunk;
import com.dimensionalcraft.chunk.normalChunk;

public class World {
	
	private ArrayList<ArrayList<Chunk>> chunks;
	private Renderer render;
	
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
	
	public void unLoad(){
		render.exit();
		System.exit(0);
	}

}
