package button;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SimpleFrameTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
				{
					public void run() {
						SimpleFrame frame = new SimpleFrame();
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				}
		);

	}

}
