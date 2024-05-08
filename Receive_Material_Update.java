package myproject;

import java.awt.*;



import java.awt.event.*;
import java.io.*;


import javax.swing.*;

public class Receive_Material_Update extends JFrame {
	
	
	JTextField datatextfield;
	JLabel datalabel;
	JButton enter;

	JLabel label1,lname,lmobno;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	
	JTextField text1,name,mobno;
	JTextField text2;
	JTextField text3;
	JTextField text4;
	
	JTextField text55;
	
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	int no_of_item;
	JButton done;
	
	double p_rate,amount,t_amount=0;
	int qty,item_code;
	
	JFrame f=new JFrame();
	
	RandomAccessFile rf=null;
	
	RandomAccessFile raf=null;
	
	class Vendor{
		
		
		JTextField text11;
		JTextField text22;
		JTextField text33;
		JTextField text44;
		
		
	}
	
	
	Vendor vendor[]=new Vendor[10];
	
	
	
	Receive_Material_Update(){
		
		 panel1=new JPanel();
			
			panel1.setLayout(new GridLayout(2,2));
			
			
			Font myFont = new Font("Consolas",Font.BOLD, 16); 
			datalabel=new JLabel("  Enter the Number Of \n Items Purchased");
			datalabel.setFont(myFont);
			datatextfield=new JTextField(15);
			
			datatextfield.setText("");
			datatextfield.setFont(myFont);
			enter=new JButton("ENTER");
			enter.setFont(myFont);
			enter.setBackground(new Color(71,71,71));
			enter.setForeground(Color.white);
		    enter.setBorder(BorderFactory.createLineBorder(Color.white,2,true));
		    

			datatextfield.setBackground(new Color(168, 167, 167));
			panel1.add( datatextfield);
			panel1.add(datalabel);
			panel1.add(enter);
			
			panel1.setBackground(new Color(238,225,236));
			add(panel1);
			
			enterClass listener1=new enterClass();
			enter.addActionListener(listener1);
			
		
		
	}
	
	
	class enterClass implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			setVisible(false);
			
			for(int j=0;j<vendor.length;j++)
				vendor[j]=new Vendor();
			
			
			try{
				String str=datatextfield.getText();
				System.out.println(str);
		no_of_item=Integer.parseInt(str);
			}
			
			catch (NumberFormatException eg){
				System.out.println("number formar erro");
				System.exit(0);
			}
			
			
			System.out.println("here is ok");
			panel2=new JPanel();
			panel2.setLayout(new GridLayout(0,3));
			
		

			label1=new JLabel("ITEM CODE");
			label2=new JLabel("PURCHASE  RATE");
			label3=new JLabel("QUANTITY");

			panel2.add(label1);
			panel2.add(label2);
			panel2.add(label3);
			
			for(int i=0;i<no_of_item;i++){
				System.out.println("here is  also ok");
				vendor[i].text11=new JTextField(15);
				vendor[i].text22=new JTextField(15);
				vendor[i].text33=new JTextField(15);
				
				vendor[i].text11.setText("");
				vendor[i].text22.setText("");
				vendor[i].text33.setText("");
				
				panel2.add(vendor[i].text11);
				panel2.add(vendor[i].text22);
				panel2.add(vendor[i].text33);
				
				System.out.println("here is ok");
				
			}
			
			JButton jbt1=new JButton("Enter");
			
			panel2.add(jbt1);
			
			JFrame f=new JFrame();
			f.setTitle("Receive Material Update");
			f.setSize(700,400);
			f.add(panel2);
			f.setLocationRelativeTo(null);
			f.setVisible(true);

			jbt1class jbt1listener=new jbt1class();
			jbt1.addActionListener(jbt1listener);
			
		}
	}
	
class jbt1class implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			
			f.setVisible(false);
			
			try{
				raf=new RandomAccessFile("data9.txt","rw");
			}
			
			catch (FileNotFoundException eq){ }
			
			panel3=new JPanel();
			panel3.setLayout(new GridLayout(0,4));
			
			lname=new JLabel("Vendor name");
			lmobno=new JLabel("Vendor Mobile No");
			try{
			
			}
			
			catch (NumberFormatException eq){ System.out.println("error in number format 11"); System.exit(0); }
			
			name=new JTextField();
			mobno=new JTextField();
			
			panel3.add(lname);
			panel3.add(name);
			
			panel3.add(lmobno);
			panel3.add(mobno);
	
			
			
			label1=new JLabel("ITEM CODE");
			label2=new JLabel("PURCHASE  RATE");
			label3=new JLabel("QUANTITY");
			label4=new JLabel("amount");
			
			panel3.add(label1);
			panel3.add(label2);
			panel3.add(label3);
			panel3.add(label4);
			
			try{
			
			for(int i=0;i<no_of_item;i++){
				
				text1=new JTextField(15);
				text2=new JTextField(15);
				text3=new JTextField(15);
				text4=new JTextField(15);
				
				vendor[i].text44=new JTextField(15);
				
				String s1=(vendor[i].text11.getText());
				
				item_code=Integer.parseInt(s1);
				
				text1.setText(s1);
				System.out.println("good");
				
				
				s1=vendor[i].text22.getText();
				
				System.out.println(s1);
				text2.setText(s1);
				
				p_rate=Double.parseDouble(s1);
				
				System.out.println("good");
				
				s1=(vendor[i].text33.getText());

				qty=Integer.parseInt(s1);
				
				text3.setText(s1);
				try{
				raf.seek(0);
				}
				
				catch(IOException ew){}
				
				
				int icode;  long fpointer; double tqty;
				try{
				while(true){
					
					if(raf.length()==raf.getFilePointer())  break;
					
				icode=	raf.readInt();
					raf.readUTF();
					raf.readDouble();
					raf.readDouble();
					
					fpointer=raf.getFilePointer();
					tqty=raf.readDouble();
					
					
					
					if(item_code==icode){
						
						tqty=tqty+qty;
						
						raf.seek(fpointer);
						raf.writeDouble(tqty);
						
						break;
						
					}
					
					
				}
				
				}
				
				catch(IOException ew){}
				System.out.println("good");
				
				amount=p_rate*qty;
				
				
				
				vendor[i].text44.setText(String.valueOf(amount));
				
				t_amount=t_amount+amount;
				
				panel3.add(text1);
				panel3.add(text2);
				panel3.add(text3);
				panel3.add(vendor[i].text44);
				
				System.out.println(vendor[i].text11.getText());
				System.out.println(vendor[i].text22.getText());
				System.out.println(vendor[i].text33.getText());
				System.out.println(vendor[i].text44.getText());
			}
			
			}
			
			catch(NumberFormatException ew){ System.out.println("error in numberformat");}
			text55=new JTextField(15);
			text55.setText(String.valueOf(t_amount));
			JLabel total=new JLabel("Total");
			
			panel3.add(total);
			
			JLabel l1=new JLabel("");
			JLabel l2=new JLabel("");
			
			panel3.add(l1);
			panel3.add(l2);
			
			panel3.add(text55);
			
			JButton jbtenter=new JButton("SAVE");
			
			panel3.add(jbtenter);
			
			jbtenterclass jbt1listener=new jbtenterclass();
			jbtenter.addActionListener(jbt1listener);
			
			
			f.setTitle("Receive Material Update");
			f.setSize(700,400);
			f.add(panel3);
			f.setLocationRelativeTo(null);
			f.setVisible(true);
			
		}
}

class jbtenterclass implements ActionListener{
	
	public void actionPerformed(ActionEvent e){
		
		f.setVisible(false);
		
		try{
			rf=new RandomAccessFile("vendor.txt","rw");
		}
		
		catch (FileNotFoundException eq){ }
		
		try{
			rf.seek(rf.length());
		}
		
		catch(IOException et){}
		try{
			
			rf.writeInt(no_of_item);
			rf.writeUTF(name.getText());
			rf.writeUTF(mobno.getText());
			
			for(int i=0;i<no_of_item;i++){
				
				rf.writeInt(Integer.parseInt((vendor[i].text11.getText())));
				rf.writeUTF((vendor[i].text22.getText()));
				rf.writeDouble(Double.parseDouble((vendor[i].text33.getText())));
				rf.writeDouble(Double.parseDouble((vendor[i].text44.getText())));
				
			}
			
			rf.writeDouble(Double.parseDouble(text55.getText()));
			
			
			rf.close();
			
			
		}
		
		catch(NumberFormatException ew){}
		
		catch (IOException ee) {}
		
	  }
	}

	public static void main(String[] args) {
		
		
		JFrame fram=new Receive_Material_Update();
		   fram.setTitle("Receive Material Update");
		  fram.setSize(700,400);
		  fram.setLocationRelativeTo(null);
		  
		  fram.setVisible(true);

	}

}

