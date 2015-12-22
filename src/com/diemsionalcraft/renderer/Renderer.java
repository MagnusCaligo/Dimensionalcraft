package com.diemsionalcraft.renderer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import com.dimensionalcraft.chunk.Chunk;
import com.dimensionalcraft.chunk.normalChunk;
import com.dimensionalcraft.entities.Player;
import com.jogamp.opengl.util.FPSAnimator;

import InputManager.keyListener;
import Tutorial.Lighting;

public class Renderer implements GLEventListener{
	
	private ArrayList<ArrayList<Chunk>> chunks;
	private JFrame frame;
	private GLCanvas glcanvas;
	private GLU glu = new GLU();
	private FPSAnimator animator;
	
	
	public Renderer(ArrayList<ArrayList<Chunk>> chunks, JFrame frame){
		this.chunks = chunks;
		this.frame = frame;
		
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		glcanvas = new GLCanvas(capabilities);
		glcanvas.addGLEventListener(this);
		glcanvas.setSize(800,800);
		animator = new FPSAnimator(glcanvas, 300, true);
		
		frame.getContentPane().add(glcanvas);
		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setVisible(true);
		frame.addKeyListener(new keyListener());
		
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				if(animator.isStarted())
					animator.stop();
				System.exit(0);
			}
		});
		
		animator.start();
		
	}
	
	public void exit(){
		if(animator.isStarted())
			animator.stop();
	}
	

	@Override
	public void display(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT|GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		for( ArrayList<Chunk> list : chunks){
			for(Chunk chunk : list){
				chunk.draw(gl);
			}
		}
		
		glu.gluLookAt(0,0,-10,
				0f, Camera.getYAngle(), Camera.getZAngle()-6, 
				0, 0,0);
		
		Player.update();

		
		
		
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		
		final GL2 gl = drawable.getGL().getGL2();
		
		gl.glShadeModel(GL2.GL_SMOOTH);
		gl.glClearColor(0, 0f, 0f, 0);
		gl.glClearDepth(1f);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glDepthFunc(GL2.GL_LEQUAL);
		//gl.glHintPGI(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
		gl.glLightfv(gl.GL_LIGHT1, gl.GL_AMBIENT, Lighting.AmbientLight, 0);
		gl.glLightfv(gl.GL_LIGHT1, gl.GL_DIFFUSE, Lighting.DiffuseLight, 0);
		gl.glLightfv(gl.GL_LIGHT1, gl.GL_POSITION, Lighting.lightLocation, 0);
		gl.glEnable(gl.GL_LIGHT1);
		gl.glEnable(gl.GL_LIGHTING);
		gl.glEnable(gl.GL_COLOR_MATERIAL);
		
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		final GL2 gl = drawable.getGL().getGL2();
		
		if(height <= 0)
			height = 1;
		final float h = (float)width / (float) height;
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluPerspective(70.0f,  h,  1.0,  80);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		
	}

}
