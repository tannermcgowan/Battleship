//HEY HANS I AM SITTING NEXT TO YOU ON THE COUCH
//Hi TANNER
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class GUI extends JFrame implements ActionListener{
	
	public GUI(){
		super();
		getContentPane().setBackground(new Color(51,255,255) );
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		 c.weightx = 0.5;
		 c.fill = GridBagConstraints.HORIZONTAL;
		 c.gridx = 20;
		 c.gridy = 20;
		

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
		setSize(360,700);
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args){
		GUI gui = new GUI();
	}

}
