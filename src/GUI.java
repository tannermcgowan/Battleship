
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI extends JFrame implements ActionListener{
	
	JButton bTest1 = new JButton("");
	JButton bTest2 = new JButton("");
	JButton bTest3 = new JButton("");
	
	public GUI(){
		super();
		

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
		setSize(360,700);
		setResizable(false);
		setVisible(true);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		JPanel jp1 = new JPanel();
		add(jp1);
		
		jp1.add(bTest1);
		jp1.add(bTest2);
		jp1.add(bTest3);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args){
		GUI gui = new GUI();
		//setLayout(new BoxLayout(gui, BoxLayout.PAGE_AXIS));
		//gui.setLayout(new BoxLayout(gui, BoxLayout.PAGE_AXIS));
	}

}
