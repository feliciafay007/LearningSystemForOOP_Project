import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


class AudioTest extends JFrame
{
	  JButton btn = new JButton("Play Sound");
	  File wavFile = new File("./resource/Adding_and_Subtracting/subtracting16.wav");
	  AudioClip sound;
	  Boolean loopStatus;
	  public AudioTest()
	  {
		    setSize(300,100);
		    setLocation(400,300);
		    setDefaultCloseOperation(EXIT_ON_CLOSE);
		    loopStatus = true;
		    JPanel jp = new JPanel();
			try{
				sound = Applet.newAudioClip(wavFile.toURL());
				sound.loop();
				sound.play();
			}catch(Exception e){
		    	e.printStackTrace();
			}	
		    btn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	loopStatus = false;
					sound.stop();
	            }
		    });
		    jp.add(btn);
		    getContentPane().add(jp);
		    pack();
	  }
	  public static void main(String args[]){
		  new AudioTest().setVisible(true);
	  }
}