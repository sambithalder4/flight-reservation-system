import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class DisplayManager {
    public Timer timer;
     JLabel sourcelabel,datelabel,seatlabel;
	JButton okbutton,cancelbutton;
	JComboBox citycombo,seatcombo,datecombo,monthcombo,yearcombo;
	ImageIcon searchicon,cancelicon;
	JFrame fr;
        String mode[]={"MODE","NET BANKING","CREDIT CARD"};
	private String city[]={"DELHI","MUMBAI","PUNE"};
	private String date[]={"dd","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String month[]={"mm","10","11","12","1","2","3"};
	private String year[]={"yyyy","2014","2015"};
	private String seat[]={"SEAT","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
String[] columnNames = {"SOURCE CITY","DEPARTURE","ARRIVAL",
            "INTERMEDIATE CITY","DEPARTURE",
           "DESTINATION CITY","ARRIVAL","SPICEJET FLIGHT NO.","SILK AIR FLIGHT NO."
            };
                  public String sp,sl; 
                  String st1;
                static  String f1,f2;
    public static void main(String args[]){
       f1=args[0];
       f2=args[1];
       
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
                        DisplayManager dm=new DisplayManager();
                        dm.Firstpage();
                        
	          
	            }
	        });
 }
    
    void query(){
       
	 fr=new JFrame("QUERY");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.getContentPane();
		fr.setSize(630, 570);
		fr.setLocation(100, 100);
		fr.setVisible(true);
		fr.setLayout(null);
		
                ImageIcon img=new ImageIcon("C:\\flightproject\\src\\28.jpg");
                JLabel piclabel=new JLabel(img);
                piclabel.setBounds(0, 0, 630, 310);
		fr.add(piclabel);
                
                
		sourcelabel=new JLabel("ENTER THE SOURCE CITY:");
		sourcelabel.setBounds(10, 320, 250, 40);
		sourcelabel.setFont(new Font("Serif",Font.BOLD,18));
		fr.add(sourcelabel);
		
		citycombo=new JComboBox<String>(city);
		citycombo.setBounds(300, 320, 200, 40);
		citycombo.setFont(new Font("Serif",Font.BOLD,18));
		fr.add(citycombo);
		
		datelabel=new JLabel("ENTER DATE OF JOURNEY:");
		datelabel.setBounds(10, 370, 250, 40);
		datelabel.setFont(new Font("Serif",Font.BOLD,18));
		fr.add(datelabel);
		
		datecombo=new JComboBox<String>(date);
		datecombo.setBounds(300, 370, 70, 40);
		datecombo.setFont(new Font("Serif",Font.BOLD,18));
		fr.add(datecombo);
		
		monthcombo=new JComboBox<String>(month);
		monthcombo.setBounds(380, 370, 70, 40);
		monthcombo.setFont(new Font("Serif",Font.BOLD,18));
                fr.add(monthcombo);
		
		yearcombo=new JComboBox<String>(year);
		yearcombo.setBounds(460, 370, 70, 40);
		yearcombo.setFont(new Font("Serif",Font.BOLD,18));
		fr.add(yearcombo);
		
		searchicon=new ImageIcon("C:\\flightproject\\src\\4.jpg");
		okbutton=new JButton("SEARCH",searchicon);
		okbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		okbutton.setBounds(10, 440, 220, 70);
		okbutton.setFont(new Font("Serif",Font.BOLD,30));
		okbutton.setToolTipText("CLICK TO SEARCH");
		fr.add(okbutton);
		
		cancelicon=new ImageIcon("C:\\flightproject\\src\\12.png");
		cancelbutton=new JButton("CANCEL",cancelicon);
		cancelbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		cancelbutton.setBounds(350, 440, 220, 70);
		cancelbutton.setFont(new Font("Serif",Font.BOLD,30));
		cancelbutton.setToolTipText("CLICK TO EXIT APPLICATION");
		fr.add(cancelbutton);
             
               okbutton.addMouseListener(new MouseListener(){
                   Color c=okbutton.getBackground();
             @Override
             public void mouseClicked(MouseEvent e) {
             
                
             }

             @Override
             public void mousePressed(MouseEvent e) {
             }

             @Override
             public void mouseReleased(MouseEvent e) {
             }

             @Override
             public void mouseEntered(MouseEvent e) {
                 okbutton.setBackground(Color.LIGHT_GRAY);
             }

             @Override
             public void mouseExited(MouseEvent e) {
                 okbutton.setBackground(c);
             }
                   
               });
                
                
                okbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
                            if(datecombo.getSelectedItem().toString().equalsIgnoreCase("dd") || monthcombo.getSelectedItem().toString().equalsIgnoreCase("mm") || yearcombo.getSelectedItem().toString().equalsIgnoreCase("yyyy") ){
                                JOptionPane.showMessageDialog(fr, "OOPS!!!!!PLEASE ENTER CORRECT DATE MONTH AND YEAR VALUE");
                            }
                            else{
				FlightManager fl=new FlightManager();
				String st=new String();
				st=(String)citycombo.getSelectedItem();
				
				st1=(String)datecombo.getSelectedItem();
                                int st2=Integer.parseInt(st1);
                                
                                st1=(String)monthcombo.getSelectedItem();
                                int st3=Integer.parseInt(st1);
                                
                                st1=(String)yearcombo.getSelectedItem();
                                int st4=Integer.parseInt(st1);
				System.out.println(st);
                                int w;
				//fl.search(st,st2);
                               // w=fl.k;
                             
				
				fr.setVisible(false);
				fr.dispose();
                                DisplayManager dm=new DisplayManager();
                                dm.tableshow(st,st2,st3,st4);
                        }             
                        }
    });
                
                 cancelbutton.addMouseListener(new MouseListener(){
                   Color c=cancelbutton.getBackground();
             @Override
             public void mouseClicked(MouseEvent e) {
             
                
             }

             @Override
             public void mousePressed(MouseEvent e) {
             }

             @Override
             public void mouseReleased(MouseEvent e) {
             }

             @Override
             public void mouseEntered(MouseEvent e) {
                 cancelbutton.setBackground(Color.red);
             }

             @Override
             public void mouseExited(MouseEvent e) {
                 cancelbutton.setBackground(c);
             }
                   
               });
                 
                cancelbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
                            System.exit(0);
                        }
                });
}
    void Firstpage(){
        
	
	JFrame fr;

	 fr=new JFrame("FLIGHT RESERVATION SYSYTEM");
	fr.setSize(800, 500);
	fr.setLocation(200, 100);
	ImageIcon img1=new ImageIcon("C:\\flightproject\\src\\8.jpg");
	JLabel lb2=new JLabel(img1);
	//ImageIcon img2=new ImageIcon("C:\\Users\\Shailesh\\workspace\\MySwing\\src\\9.jpg");
	//JLabel lb1=new JLabel(img2);
	//fr.add(lb1,BorderLayout.SOUTH);
	
	
	
	 timer = new Timer(2000, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {
	    	DisplayManager dm=new DisplayManager();
                dm.query();
            
            fr.dispose();
	      timer.stop();
	    }    
	});
	timer.start();
	
	
	fr.add(lb2,BorderLayout.CENTER);
	fr.setResizable(false);
	fr.setVisible(true);
	
	
	
}
void tableshow(String s1,int s2,int s3,int s4){
    FlightManager fl=new FlightManager();
  fl.search(f1,f2,s1,s2,s3,s4);
  int w=fl.k;
  //JOptionPane.showMessageDialog(fr, w+" RESULTS FOUND FOR YOUR QUERY");
	      JFrame fr=new JFrame("RESULT PAGE");
	      fr.setLayout(null);
			fr.setSize(1050, 450);
			fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fr.setLocation(100,150);
			 Object[][] data=new Object[w][9] ;
			JTable table=new JTable(data,columnNames);
				table.setBounds(10,150,1000,130);
			//table.setFillsViewportHeight(true);
			
			for(int i=0;i<w;i++){
				data[i][0]=fl.torigin.get(i);
			}
			for(int i=0;i<w;i++){
				data[i][1]=fl.spicedep.get(i);
			}
			for(int i=0;i<w;i++){
				data[i][2]=fl.spicearr.get(i);
			}
			for(int i=0;i<w;i++){
				data[i][3]=fl.tdest.get(i);
			}
			for(int i=0;i<w;i++){
				data[i][4]=fl.silkdep.get(i);
			}
                        for(int i=0;i<w;i++){
				data[i][5]="SINGAPORE";
			}
                        for(int i=0;i<w;i++){
				data[i][6]=fl.silkarr.get(i);
			}
                        for(int i=0;i<w;i++){
				data[i][7]=fl.tflno1.get(i);
			}
                        for(int i=0;i<w;i++){
				data[i][8]=fl.tflno2.get(i);
			}
                       
			JLabel lb1=new JLabel("::RESULTS FOR YOUR QUERY::");
			lb1.setFont(new Font("Serif", Font.BOLD, 24));
			lb1.setBounds(350, 100, 400, 40);
			fr.add(lb1);
			
                        ImageIcon spiceicon=new ImageIcon();
			spiceicon=new ImageIcon("C:\\flightproject\\src\\21.jpg");
			JLabel lb2=new JLabel(spiceicon);
			lb2.setBounds(10, 10, 281, 112);
			fr.add(lb2);
			
                         ImageIcon silkicon=new ImageIcon();
			silkicon=new ImageIcon("C:\\flightproject\\src\\20.jpg");
			JLabel lb3=new JLabel(silkicon);
			lb3.setBounds(740, 10, 281, 112);
			fr.add(lb3);
                        
                        
			ImageIcon backicon=new ImageIcon();
			backicon=new ImageIcon("C:\\flightproject\\src\\13.png");
			JButton bt1=new JButton("BACK",backicon);
			bt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			bt1.setFont(new Font("Serif", Font.BOLD, 24));
			
			 JTableHeader header = table.getTableHeader();
		      header.setBackground(Color.black);
		      header.setForeground(Color.yellow);
		      table.setBackground(Color.BLACK);
		      table.setForeground(Color.WHITE);
		    bt1.setToolTipText("GO BACK TO PREVIOUS PAGE");
		    bt1.setBounds(10, 320, 220, 70);
		    fr.add(bt1);
		   // fr.getContentPane().add(bt1,BorderLayout.SOUTH);
		    ImageIcon confirmicon=new ImageIcon();
                    confirmicon=new ImageIcon("C:\\flightproject\\src\\16.png");
		    JButton bt2=new JButton("CONFIRM",confirmicon);
		    bt2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			bt2.setFont(new Font("Serif", Font.BOLD, 24));
                         bt2.setToolTipText("CONFIRM YOUR TICKET");
		    bt2.setBounds(800, 320, 220, 70);
		    fr.add(bt2);

                   table.addMouseListener(new MouseAdapter(){
                       public void mouseClicked(MouseEvent e){
                           int row=table.getSelectedRow();
                           int column=table.getColumnCount();
                           sp=table.getValueAt(row,7).toString();
                           sl=table.getValueAt(row,8).toString();
                       }
                   });
                    
                    
                    
                    
                    
                    
			bt1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
			fr.dispose();
			DisplayManager dm=new DisplayManager();
                        dm.query();
            
				}
			});

			bt2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
                                    if(table.isRowSelected(0)||table.isRowSelected(1)||table.isRowSelected(2)||table.isRowSelected(3)||table.isRowSelected(4)||table.isRowSelected(5)||table.isRowSelected(6)||table.isRowSelected(7)){
                                        fr.dispose();
			
                        Booking(sp,sl,s2,s3,s4);
                                    }
                                    else{
                                         JOptionPane.showMessageDialog(fr," OOPS!!ATLEAST SELECT ANY ROW FROM THE TABLE SHOWN");
                                    }
                                    
			
				}
			});
			//fr.getContentPane().add(table,BorderLayout.CENTER);
			fr.setVisible(true);
			JScrollPane jsp=new JScrollPane(table);
			jsp.setBounds(table.getBounds());
			fr.add(jsp);
	      bt1.addMouseListener(new MouseListener(){
                   Color c=bt1.getBackground();
             @Override
             public void mouseClicked(MouseEvent e) {
             
                
             }

             @Override
             public void mousePressed(MouseEvent e) {
             }

             @Override
             public void mouseReleased(MouseEvent e) {
             }

             @Override
             public void mouseEntered(MouseEvent e) {
                 bt1.setBackground(Color.LIGHT_GRAY);
             }

             @Override
             public void mouseExited(MouseEvent e) {
                 bt1.setBackground(c);
             }
                   
               });
              
				bt2.addMouseListener(new MouseListener(){
                   Color c=bt2.getBackground();
             @Override
             public void mouseClicked(MouseEvent e) {
             
                
             }

             @Override
             public void mousePressed(MouseEvent e) {
             }

             @Override
             public void mouseReleased(MouseEvent e) {
             }

             @Override
             public void mouseEntered(MouseEvent e) {
                 bt2.setBackground(Color.GREEN);
             }

             @Override
             public void mouseExited(MouseEvent e) {
                 bt2.setBackground(c);
             }
                   
               });

    }


 void  Booking(String sp,String sl,int date,int month,int year) {
	JLabel namelabel,seatlabel,flightlabel,paymentmode,spicelabel,silklabel,num1label,num2label,piclabel;
	JButton bookbutton,cancelbutton,searchbutton;
	JComboBox paycombo,seatcombo;
	ImageIcon bookicon,cancelicon;
	JFrame fr;
	JTextField namefield;
	 
        
        
	 fr=new JFrame("BOOKING");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.getContentPane();
		fr.setSize(500, 720);
		fr.setLocation(100, 0);
		fr.setVisible(true);
		fr.setLayout(null);
                
                ImageIcon icon=new ImageIcon("C:\\flightproject\\src\\23.jpg");
                piclabel=new JLabel(icon);
		piclabel.setBounds(10, -20, 450, 317);
		fr.add(piclabel);
                
                
		namelabel=new JLabel("ENTER YOUR NAME:");
		namelabel.setBounds(10, 270, 250, 40);
		namelabel.setFont(new Font("Serif",Font.BOLD,18));
		fr.add(namelabel);
		
		namefield=new JTextField(40);
		namefield.setBounds(250, 270, 200, 40);
		namefield.setFont(new Font("Serif",Font.BOLD,18));
		fr.add(namefield);
		
		seatlabel=new JLabel("NO. OF SEATS:");
		seatlabel.setBounds(10, 320, 250, 40);
		seatlabel.setFont(new Font("Serif",Font.BOLD,18));
		fr.add(seatlabel);
		
		seatcombo=new JComboBox<String>(seat);
		seatcombo.setBounds(250, 320, 70, 40);
		seatcombo.setFont(new Font("Serif",Font.BOLD,18));
		fr.add(seatcombo);
		
		paymentmode=new JLabel("PAYMENT MODE:");
		paymentmode.setBounds(10, 370, 250, 40);
		paymentmode.setFont(new Font("Serif",Font.BOLD,18));
		fr.add(paymentmode);
		
		paycombo=new JComboBox<String>(mode);
		paycombo.setBounds(250, 370, 170, 40);
		paycombo.setFont(new Font("Serif",Font.BOLD,18));
		fr.add(paycombo);
		
                flightlabel=new JLabel("::FLIGHT DETAILS::");
		flightlabel.setBounds(10, 420, 250, 40);
		flightlabel.setFont(new Font("Serif",Font.BOLD,18));
		fr.add(flightlabel);
		
                spicelabel=new JLabel("SPICEJET FLIGHT NO:");
		spicelabel.setBounds(10, 470, 250, 40);
		spicelabel.setFont(new Font("Serif",Font.BOLD,18));
		fr.add(spicelabel);
                
                num1label=new JLabel(sp);
		num1label.setBounds(270, 470, 250, 40);
		num1label.setFont(new Font("Serif",Font.BOLD,18));
                fr.add(num1label);
                
                 silklabel=new JLabel("SILKAIR FLIGHT NO:");
		silklabel.setBounds(10, 520, 250, 40);
		silklabel.setFont(new Font("Serif",Font.BOLD,18));
		fr.add(silklabel);
		
                num2label=new JLabel(sl);
		num2label.setBounds(270, 520, 250, 40);
		num2label.setFont(new Font("Serif",Font.BOLD,18));
                fr.add(num2label);
                
		bookicon=new ImageIcon("C:\\flightproject\\src\\11.png");
		bookbutton=new JButton("BOOK",bookicon);
		bookbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		bookbutton.setBounds(10, 580, 150, 70);
                bookbutton.setToolTipText("FINALISE YOUR BOOKING");
		bookbutton.setFont(new Font("Serif",Font.BOLD,20));
		fr.add(bookbutton);
		
                bookicon=new ImageIcon("C:\\flightproject\\src\\13.png");
		searchbutton=new JButton("SEARCH AGAIN",bookicon);
		searchbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		searchbutton.setBounds(170, 580, 150, 70);
               searchbutton.setToolTipText("SEARCH AGAIN");
		searchbutton.setFont(new Font("Serif",Font.BOLD,20));
		fr.add(searchbutton);
                
                
		cancelicon=new ImageIcon("C:\\flightproject\\src\\12.png");
		cancelbutton=new JButton("EXIT",cancelicon);
		cancelbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		cancelbutton.setBounds(330, 580, 150, 70);
                cancelbutton.setToolTipText("EXIT THE APPLICATION");
		cancelbutton.setFont(new Font("Serif",Font.BOLD,20));
		fr.add(cancelbutton);
                
                bookbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
                            int flag2=1;
                            if(namefield.getText().toString().equals("")||seatcombo.getSelectedItem().toString().equalsIgnoreCase("SEAT")||paycombo.getSelectedItem().toString().equalsIgnoreCase("MODE") ){
                                JOptionPane.showMessageDialog(fr,"OOPS!! EITHER NAME OR SEAT NO. OR PAYMENT MODE FIELD IS VACANT");
                                flag2=2;
                            }
                            
                          
                           else{
                               String inputseat=seatcombo.getSelectedItem().toString();
                              System.out.println("entered no. of seats:"+inputseat);
                              String inputdate=Integer.toString(date);
                              String inputmonth=Integer.toString(month);
                              String inputyear=Integer.toString(year);
                              System.out.println("entered date:"+inputdate+"-"+inputmonth+"-"+inputyear);
                              String filename1="update.txt";
                              File file1=new File(filename1);
                              String filename2="temp.txt";
                              File file2=new File(filename2);
                               
                              if(file1.exists()==false){
                                   try {
                                       PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter(file1,true)));
                                      out1.println(sp+","+inputseat+","+sl+","+inputseat+","+inputdate+"-"+inputmonth+"-"+inputyear);
                                       System.out.println("update file and temp file written for the first time");
                                       out1.flush();
                                       out1.close();
                                      
                                   } catch (IOException ex) {
                                       System.out.println(ex);
                                   }
                              }
                              else{
                                  String flag1="initial";
                                 
                                  
                                   try {
                                       Scanner in1=new Scanner(file1);
                                      while(in1.hasNextLine()){
                                          String fileline=in1.nextLine();
                                          StringTokenizer st=new StringTokenizer(fileline,",-");
                                              String tsp=st.nextToken();
                                              String tseat1=st.nextToken();
                                              String tsl=st.nextToken();
                                              String tseat2=st.nextToken();
                                              String tdate=st.nextToken();
                                              String tmonth=st.nextToken();
                                              String tyear=st.nextToken();
                                          //System.out.println(tsp+","+tseat1+","+tsl+","+tseat2+","+tdate+"-"+tmonth+"-"+tyear);
                                          if(tsp.equalsIgnoreCase(sp)&&tsl.equalsIgnoreCase(sl)&&tdate.equalsIgnoreCase(inputdate)&&tmonth.equalsIgnoreCase(inputmonth)&&tyear.equalsIgnoreCase(inputyear)){
                                              // System.out.println("data matched");
                                               flag1="data matched";
                                               int bookedseat=Integer.parseInt(tseat1);
                                               int leftseat=15-bookedseat;
                                               if(Integer.parseInt(inputseat)<=leftseat){
                                                   // System.out.println("u can book the filght");
                                                    int totalbookedseat=Integer.parseInt(inputseat)+bookedseat;
                                                    
                                                        PrintWriter out2=new PrintWriter(new BufferedWriter(new FileWriter(file2,true)));
                                                  
                                                        out2.println(sp+","+totalbookedseat+","+sl+","+totalbookedseat+","+inputdate+"-"+inputmonth+"-"+inputyear);         
                                                        //System.out.println("temp file modified");
                                                        
                                                        out2.flush();
                                                        out2.close();
                                               }
                                               else{
                                                   //System.out.println("u cannnot book the flight");
                                                   PrintWriter out2=new PrintWriter(new BufferedWriter(new FileWriter(file2,true)));
                                                    out2.println(sp+","+tseat1+","+sl+","+tseat2+","+tdate+"-"+tmonth+"-"+tyear);  
                                                    out2.flush();
                                                        out2.close();
                                                        flag2=2;
                                                         JOptionPane.showMessageDialog(fr,"THESE NO. OF SEATS ARE NOT AVAILABLE");
                                               }
                                             
                                          }
                                          else{
                                               PrintWriter out2=new PrintWriter(new BufferedWriter(new FileWriter(file2,true)));
                                               out2.println(tsp+","+tseat1+","+tsl+","+tseat2+","+tdate+"-"+tmonth+"-"+tyear);  
                                              // System.out.println("data not matched");
                                               out2.flush();
                                                        out2.close();
                                          }
                                      }
                                      if(flag1.equalsIgnoreCase("data matched")==false){
                                     PrintWriter out2=new PrintWriter(new BufferedWriter(new FileWriter(file2,true)));
                                               out2.println(sp+","+inputseat+","+sl+","+inputseat+","+inputdate+"-"+inputmonth+"-"+inputyear);  
                                               out2.flush();
                                                        out2.close();
                                      }
                                      in1.close();
                                   }catch (IOException ex) {
                                       Logger.getLogger(DisplayManager.class.getName()).log(Level.SEVERE, null, ex);
                                   }
                                  file1.delete();
                                  boolean t=file2.renameTo(file1);
                              }
                           }
                          
                            if(flag2!=2){
                               
                                    JOptionPane.showMessageDialog(fr,"CONGRATULATIONS!! TICKET BOOKED SUCCESSFULLY");
                                    JFrame fr1=new JFrame("WELCOME TO SINGAPORE");
                                    fr1.setSize(927, 313);
                                    fr1.setLocation(200, 100);
                                    ImageIcon img1=new ImageIcon("C:\\flightproject\\src\\27.jpg");
                                    JLabel lb2=new JLabel(img1);
                                    
                                    timer = new Timer(2000, new ActionListener() {
                                        public void actionPerformed(ActionEvent evt) {
                                            
                                            
                                            fr1.dispose();
                                            timer.stop();
                                        }
                                    });                         timer.start();
        fr1.add(lb2,BorderLayout.CENTER);
                                    fr1.setResizable(false);
                                    fr1.setVisible(true);
                                } 
                            
                            


                          
                        }
                        
	});
               

                
                cancelbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
	});
 searchbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DisplayManager dm=new DisplayManager();
                                dm.query();
                                fr.dispose();
			}
	});

	
		bookbutton.addMouseListener(new MouseListener(){
                   Color c=bookbutton.getBackground();
             @Override
             public void mouseClicked(MouseEvent e) {
             
                
             }

             @Override
             public void mousePressed(MouseEvent e) {
             }

             @Override
             public void mouseReleased(MouseEvent e) {
             }

             @Override
             public void mouseEntered(MouseEvent e) {
                 bookbutton.setBackground(Color.LIGHT_GRAY);
             }

             @Override
             public void mouseExited(MouseEvent e) {
                 bookbutton.setBackground(c);
             }
                   
               });
	
	cancelbutton.addMouseListener(new MouseListener(){
                   Color c=cancelbutton.getBackground();
             @Override
             public void mouseClicked(MouseEvent e) {
             
                
             }

             @Override
             public void mousePressed(MouseEvent e) {
             }

             @Override
             public void mouseReleased(MouseEvent e) {
             }

             @Override
             public void mouseEntered(MouseEvent e) {
                 cancelbutton.setBackground(Color.RED);
             }

             @Override
             public void mouseExited(MouseEvent e) {
                 cancelbutton.setBackground(c);
             }
                   
               });
	
}


}