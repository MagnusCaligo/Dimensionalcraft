package Tutorial;

import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
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
import javax.swing.JPanel;

import com.jogamp.opengl.util.FPSAnimator;

public class Render implements GLEventListener{
	
	private static GraphicsEnvironment graphicsEnvironment;
	private static boolean isFullScreen = false;
	public static DisplayMode dm, dm_old;
	private static Dimension xgraphic;
	private static Point point = new Point(0,0);
	
	private GLU glu = new GLU();
	
	private float rtri = 0.0f;

	@Override
	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		final GL2 gl = drawable.getGL().getGL2();
		
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT| GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glTranslatef(-1.5f, 0f, -6f);
		gl.glRotatef(rtri, 0f, 1f, 0f);
		gl.glBegin(GL2.GL_TRIANGLES);
			gl.glColor3f(1f,0,0);
			gl.glVertex3f(0f, 1f, 0f);
			gl.glColor3f(0, 1f, 0);
			gl.glVertex3f(-1f, -1f, 0f);
			gl.glColor3f(0,0,1f);
			gl.glVertex3f(1f, -1f, 0f);
		gl.glEnd();
		
		gl.glLoadIdentity();
		gl.glTranslatef(1f,0.0f,-6.0f);                   // Move Right 3 Units
		 gl.glBegin(GL2.GL_QUADS);                      // Draw A Quad
	        gl.glVertex3f(-1.0f, 1.0f, 0.0f);              // Top Left
	        gl.glVertex3f( 1.0f, 1.0f, 0.0f);              // Top Right
	        gl.glVertex3f( 1.0f,-1.0f, 0.0f);              // Bottom Right
	        gl.glVertex3f(-1.0f,-1.0f, 0.0f);              // Bottom Left
	    gl.glEnd();          
	    gl.glLoadIdentity();
		gl.glFlush();
		
		rtri +=2f;
		
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		final GL2 gl = drawable.getGL().getGL2();
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		final GL2 gl = drawable.getGL().getGL2();
		
		gl.glShadeModel(GL2.GL_SMOOTH);
		gl.glClearColor(0, 0, 0, 0);
		gl.glClearDepth(1f);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glDepthFunc(GL2.GL_LEQUAL);
		//gl.glHintPGI(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		final GL2 gl = drawable.getGL().getGL2();
		
		if(height <= 0)
			height = 1;
		final float h = (float)width / (float) height;
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluPerspective(45.0f,  h,  1.0,  20);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glFrustum(-1, 1, -1, 6, 3, 30);
		gl.glLoadIdentity();
	}
	
	public static void main(String args[]){
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		
		// The canvas
		final GLCanvas glcanvas = new GLCanvas(capabilities);
		Render r = new Render();
		glcanvas.addGLEventListener(r);
		glcanvas.setSize(400,400);
		
		final FPSAnimator animator = new FPSAnimator(glcanvas, 300, true);
		
		final JFrame frame = new JFrame("Testing");
		
		frame.getContentPane().add(glcanvas);
		
		//Shutdown
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				if(animator.isStarted())
					animator.stop();
				System.exit(0);
			}
		});
		
		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setVisible(true);
		
		animator.start();
		
		
		
	}
	

}
