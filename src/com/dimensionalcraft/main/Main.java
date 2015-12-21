package com.dimensionalcraft.main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import com.diemsionalcraft.renderer.Renderer;
import com.dimensionalcraft.world.World;
import com.jogamp.opengl.util.FPSAnimator;

public class Main{
	
	private static World world;
	private JFrame frame;
	
	public static void main(String args[]){
		
		new Main().begin();
	}
	

	private void begin() {
		
		
		frame = new JFrame("DimensionalCraft");
		
		world = new World(frame);

	}
	
	public static void exitGame(){
		world.unLoad();
		System.exit(0);
	}
	

}
