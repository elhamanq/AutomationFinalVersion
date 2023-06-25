package FinalVersion;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;


public class ButtonImage 
{  
	ButtonImage()
  {
    //JFrame f = new JFrame("Add Image/Text to JButton");
    Icon icon = new ImageIcon("C:\\Users\\kmail\\OneDrive\\سطح المكتب\\R.png");
    
    // JButton with image / text
    JButton btn = new JButton("Setting", icon);
    // Text below the image
    btn.setVerticalTextPosition(SwingConstants.BOTTOM);
    // Centered Text
    btn.setHorizontalTextPosition(SwingConstants.CENTER);
    
    btn.setBounds(800, 56, 89, 23);  
  //  f.add(btn);  
  //  f.setSize(300,250);  
   // f.setLayout(null);  
    //f.setVisible(true);  
    //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}