import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class PersistenceManager extends Flight{
	String validity1,validity2,ss;
	 public void read (String f1,String f2) 
	   {
	       int i=0,j=0;
	      String filename1=f1;
	     File file=new File(filename1);
             
             try{
		Scanner input=new Scanner(file);
		input.nextLine();
                
		while(input.hasNext()){
                  
			String data=input.nextLine();
                         StringTokenizer st =new StringTokenizer(data,",");
                         j=0;
                         while(st.hasMoreTokens()){
                             
                            origin1.add(i,st.nextToken());
                      
                            dest.add(i,st.nextToken());
                     
                            String temp=new String();
                            temp=st.nextToken().trim();
                       
                            if(temp.charAt(0)=='"'){
                               
                                freq.add(i,(temp+','));
                                //System.out.println("got it at"+i+" at token "+j);
                                int t=0;
                               
                                
                             while(temp.charAt((temp.length())-1)!='"'){
                                   
                                temp=(st.nextToken()).trim();
                  
                                    freq.add(i,freq.get(i)+temp+',');
                                    
                               }
                            
                               
                            }
                            else{
                                 freq.add(i,temp);
                            }
                            flno.add(i,st.nextToken());
                        
                            dep.add(i,st.nextToken());
                         
                            arr.add(i,st.nextToken());
                         
                            via.add(i,st.nextToken());
                          
                            efr.add(i,st.nextToken());
                          
                            etl.add(i,st.nextToken());
                            
                                
                         }
                         i++;
             }
           }catch(FileNotFoundException e){
               e.printStackTrace();
           }
             catch(NoSuchElementException e){
                // System.out.println("the no.of line is::"+i+"::::column is::"+j);
             }
             catch(NullPointerException e){
                 e.printStackTrace();
             }
            // System.out.println("origin");
             for(int k=0;k<origin1.size();k++){
                // System.out.println(origin1.get(k));
             }
            // System.out.println("destination");
             for(int k=0;k<dest.size();k++){
                 //System.out.println(dest.get(k));
             }
            //  System.out.println("freq");
             for(int k=0;k<dest.size();k++){
                // System.out.println(freq.get(k));
             }
              //System.out.println("flightno");
             for(int k=0;k<flno.size();k++){
                 //System.out.println(flno.get(k));
             }
            //  System.out.println("departure");
             for(int k=0;k<dep.size();k++){
                 //System.out.println(dep.get(k));
             }
              //System.out.println("arrival");
             for(int k=0;k<arr.size();k++){
                // System.out.println(arr.get(k));
             }
             
              //System.out.println("via");
             for(int k=0;k<via.size();k++){
                 //System.out.println(via.get(k));
             }
              //System.out.println("effective from");
             for(int k=0;k<efr.size();k++){
                // System.out.println(efr.get(k));
             }
              //System.out.println("effective till");
             for(int k=0;k<etl.size();k++){
                // System.out.println(etl.get(k));
             }
             String temp1=etl.get(0);
             StringTokenizer st1=new StringTokenizer(temp1,"-");
             st1.nextToken();
             st1.nextToken();
             validity1=st1.nextToken();
             if(validity1.equals("2014"))
               validity1=  validity1.substring(2,4);
             //System.out.println("validity1="+validity1);
             
             
            // System.out.println("--------------silkair-------------------");
              String filename2=f2;
	     File file2=new File(filename2);
             
             try{
		Scanner input=new Scanner(file2);
		String temp2=input.nextLine();
		StringTokenizer st2=new StringTokenizer(temp2," ");
		st2.nextToken();
		st2.nextToken();
		st2.nextToken();
		st2.nextToken();
		st2.nextToken();
		st2.nextToken();
		st2.nextToken();
		validity2=st2.nextToken();
		validity2=validity2.substring(2, 4);
		//System.out.println("validity2="+validity2);
		input.nextLine();
                input.nextLine(); 
                i=0;
		while(input.hasNext()){
                  
			String data=input.nextLine();
                         StringTokenizer st =new StringTokenizer(data,",(/");
          
                         while(st.hasMoreTokens()){
                             
                            origin2.add(i,st.nextToken().toUpperCase());
                      st.nextToken();
                      
                  String temp=new String();
                            temp=(st.nextToken()).trim();
                       
                            if(temp.charAt(0)=='"'){
                                freq2.add(i,(temp+','));
                               
                                int t=0;
                               
                                
                             while(temp.charAt((temp.length())-1)!='"'){
                                   
                                temp=(st.nextToken()).trim();
                  
                                    freq2.add(i,freq2.get(i)+temp+',');
                   
                               }
                            }
                            flno2.add(i,st.nextToken());
                            dep2.add(i,st.nextToken());
                            arr2.add(i,st.nextToken());
                            
                         }
                         i++;
                }
             }catch(FileNotFoundException e){
               e.printStackTrace();
           }             
 // System.out.println("origin2");
             for(int k=0;k<origin2.size();k++){
                 //System.out.println(origin2.get(k));
             }
            
             // System.out.println("freq2");
             for(int k=0;k<origin2.size();k++){
                // System.out.println(freq2.get(k));
             }
              //System.out.println("flightno");
             for(int k=0;k<flno2.size();k++){
                // System.out.println(flno2.get(k));
             }
              //System.out.println("departure");
             for(int k=0;k<dep2.size();k++){
                 //System.out.println(dep2.get(k));
             }
              //System.out.println("arrival");
             for(int k=0;k<arr2.size();k++){
                 //System.out.println(arr2.get(k));
             }
             
             
           }
      
	     
	}

