package myproject;

import java.lang.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Store_Item extends JFrame {

	 JTextField item_code;
	 JTextField name;
	 JTextField p_rate;
	 JTextField s_rate;
	 JTextField qty;
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JLabel l5;
    JButton b1;
    JButton b2;
  RandomAccessFile rf;
  RandomAccessFile raf;
    
	public   Store_Item(){
		
		Font myFont = new Font("Consolas",Font.BOLD, 16); 
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(6,2));
		
    	 l1=new JLabel("  ITEM CODE");
    	item_code=new JTextField(15);
    	l1.setFont(new Font("Consolas",Font.BOLD,16));
    	 l2=new JLabel("  NAME");
    	 name=new JTextField(15);
    	 l2.setFont(new Font("Consolas",Font.BOLD,16));
    	 l3=new JLabel("  PURCHASE RATE");
    	 p_rate=new JTextField(15);
    	 l3.setFont(new Font("Consolas",Font.BOLD,16));
    	 l4=new JLabel("  SELLING RATE");
    	 s_rate=new JTextField(15);
    	 l4.setFont(new Font("Consolas",Font.BOLD,16));
    	 l5=new JLabel("  QUANTITY");
    	 qty=new JTextField(15);
    	 l5.setFont(new Font("Consolas",Font.BOLD,16));
    	 
    	 item_code.setFont(myFont);
    	  name.setFont(myFont);
    	  p_rate.setFont(myFont);
    	 s_rate.setFont(myFont);
    	  qty.setFont(myFont);
    	 
    	 
        b1=new JButton("Back");
        b1.setBackground(new Color(204,196,230));
        b1.setBorder(BorderFactory.createLineBorder(Color.white,2,true));
        b2=new JButton("Enter");
        b2.setBackground(new Color(204,196,230));
        b2.setBorder(BorderFactory.createLineBorder(Color.white,2,true));
        
        b1.setFont(myFont);
        b2.setFont(myFont);
      
        
        panel.add(l1);
        panel.add(item_code);
        
        panel.add(l2);
        panel.add(name);
        
        panel.add(l3);
        panel.add(p_rate);
        
        panel.add(l4);
        panel.add(s_rate);
        
        panel.add(l5);
        panel.add(qty);
        
        panel. add(b1);
        panel. add(b2);
        
        panel.setBackground(new Color(238,225,236));
        
        add(panel);
        
       b1listenerClass listener1=new b1listenerClass();
       b1.addActionListener(listener1);
       b2listenerClass listener2=new b2listenerClass();
       b2.addActionListener(listener2);
       
      Keyclass1 l1=new Keyclass1();
      
      item_code.addKeyListener(l1);
      
 Keyclass2 l2=new Keyclass2();
      
     name.addKeyListener(l2);
      
 Keyclass3 l3=new Keyclass3();
      
      p_rate.addKeyListener(l3);
      
 Keyclass4 l4=new Keyclass4();
      
      s_rate.addKeyListener(l4);
      

       
	}  
	
	class Keyclass1 implements KeyListener{
		
		public void keyPressed(KeyEvent e){
			
		
		if(e.getKeyCode()== KeyEvent.VK_ENTER)	{
			name.requestFocusInWindow();
				
		}
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
class Keyclass2 implements KeyListener{
		
		public void keyPressed(KeyEvent e){
			
		
		if(e.getKeyCode()== KeyEvent.VK_ENTER)	{
			p_rate.requestFocusInWindow();
				
		}
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

class Keyclass3 implements KeyListener{
	
	public void keyPressed(KeyEvent e){
		
	if(e.getKeyCode()== KeyEvent.VK_ENTER)	{
		s_rate.requestFocusInWindow();
			
	}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
   

class Keyclass4 implements KeyListener{
	
	public void keyPressed(KeyEvent e){
		
		
	if(e.getKeyCode()== KeyEvent.VK_ENTER)	{
		qty.requestFocusInWindow();
			
	}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	class b2listenerClass implements ActionListener {
		

		public void actionPerformed(ActionEvent e){
			
			
			try{ 
		         rf=new RandomAccessFile("data9.txt","rw");
		         raf=new RandomAccessFile("profit.txt","rw");
		         
		       }
		       catch (FileNotFoundException ex){
		    	  System.out.println("error in opening file");
		    	  
		       }
	       try{
		    	  rf.seek(rf.length());
		    	  raf.seek(raf.length());
		    	  
		    	
		      } 
		      catch (IOException eu){
		    	  System.out.println("error in seek");
		      }
			
		       try{
		    	 
		    	  
		    	   
		    	   rf.writeInt(Integer.parseInt(item_code.getText()));
		    	   
		      	   raf.writeInt(Integer.parseInt(item_code.getText()));
		    	  
		    	   rf.writeUTF(name.getText());
		    	   
		    	   raf.writeUTF(name.getText());
		    	  
		            rf.writeDouble(Double.parseDouble(p_rate.getText()));
		            
		            rf.writeDouble(Double.parseDouble(s_rate.getText()));
		            
		            rf.writeDouble(Double.parseDouble(qty.getText()));
		            
		            raf.writeDouble(0); 
		            
		         
		         raf.writeDouble(0);
		          
		         
		            
		          
		       }
		       catch (NumberFormatException ey){
javax.swing.JOptionPane.showMessageDialog(null, "Check Correctness Of Data Input", "Error In Data Input", JOptionPane.INFORMATION_MESSAGE);
		    	   

               System.out.println("error in numfe");
					
		       }
		       
		     
		       catch (IOException ew){
		    	   System.out.println("error in IO here"); 
		       }
		       
		     
		       
		      item_code.setText("");
		      name.setText("");
		    p_rate.setText("");
		    s_rate.setText("");
		    qty.setText("");
		    
		    try{
			     rf.close();
			  raf.close();
			     }
			
			     catch (IOException y){
			    	 System.out.println("error in closing");
			     }
		   
		}
	}

	class b1listenerClass implements ActionListener {
		public void actionPerformed(ActionEvent e){
			
			
			setVisible(false);
		}

	}

		public static void main(String[] args) {
	
			JFrame myframe=new Store_Item();
			myframe.setTitle("Store Item");
			myframe.setSize(700,400);
			
			myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			myframe.setLocationRelativeTo(null);
			
			myframe.setVisible(true);
	   
	}
}

