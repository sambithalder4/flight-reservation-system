
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

public class FlightManager extends PersistenceManager{
    ArrayList<String> torigin = new ArrayList<String>();
    ArrayList<String> tdest = new ArrayList<String>();
     ArrayList<String> tfreq = new ArrayList<String>();
     ArrayList<String> tflno1 = new ArrayList<String>();
     ArrayList<String> tflno2 = new ArrayList<String>();
     ArrayList<String> spicedep = new ArrayList<String>();
     ArrayList<String> spicearr = new ArrayList<String>();
     ArrayList<String> silkdep = new ArrayList<String>();
     ArrayList<String> silkarr = new ArrayList<String>();
    Calendar c4;
    String dd;
    String flag;
    public int k=0;
     PersistenceManager pr=new PersistenceManager();
    
    void search(String f1,String f2,String source,int date,int month,int year){
      
        pr.read(f1,f2);
        int arrhr,arrmin,dephr,depmin,total1,durm1,durh1; 
       if(pr.validity1.equals(pr.validity2)){
    	  if((year==2014&&(month==11||month==12||(month==10&&(date>25&&date<32))))||(year==2015&&(month==1||month==2||(month==3&&(date<29)))))
    	  {flag="15";}
          else if(year==2014&&month==10&&(date>=1&&date<=25)) flag="14";
    	  if(pr.validity1.equals(flag)){
    	   for(int i=0;i<pr.origin1.size();i++){
            if(source.equalsIgnoreCase(pr.origin1.get(i)) &&  check(date,month,year,pr.freq.get(i)) ){
                  String des=pr.dest.get(i);
                for(int j=0;j<pr.origin2.size();j++){
                    
                if((pr.origin2.get(j).trim().equalsIgnoreCase(des))){
                   
                    if(check2(date,month,year,pr.freq2.get(j))){
                        
                        StringTokenizer pt=new StringTokenizer(pr.arr.get(i),": ");
                                                        String tm1=pt.nextToken();
                                                       
                                                        String tm2=pt.nextToken();
                                                        
                                                        String tm3=pt.nextToken();
                                                        
                                                         arrhr=Integer.parseInt(tm1);
                                                         arrmin=Integer.parseInt(tm2);     
                                                        if(tm3.equals("PM"))
                                                        arrhr=arrhr+12;
                                                        int slktime=Integer.parseInt(pr.dep2.get(j));
                                                         depmin=slktime%100;
                                                         dephr=slktime/100;  
                                                        if(depmin<arrmin){
                                                        durm1=depmin+60-arrmin;
                                                        dephr--;
                                                        durh1=dephr-arrhr;
                                                        }
                                                        else
                                                         {
                                                           durm1=depmin-arrmin;
                                                           durh1=dephr-arrhr;
                                                         }
                                                        total1=60*durh1+durm1;


							if(total1>=120 && total1<=360){
                        
                        
                torigin.add(k,source);
                tdest.add(k,des);
                tfreq.add(k,convertdatetoday(date,month,year));
                tflno1.add(k,pr.flno.get(i));
                tflno2.add(k,pr.flno2.get(j));
                spicedep.add(k,pr.dep.get(i));
                spicearr.add(k,pr.arr.get(i));
                silkarr.add(k,pr.arr2.get(j));
                silkdep.add(k,pr.dep2.get(j));
                System.out.println(pr.flno.get(i)+" "+pr.flno2.get(j));
                
                k++;
                }
                                                        
                    }
            }
           }
            }
        }}
       }
       /* System.out.println("origin found");
        for(int i=0;i<torigin.size();i++){
            System.out.println(torigin.get(i));
        }*/
        /* System.out.println("frequency found");
        for(int i=0;i<torigin.size();i++){
            System.out.println(tfreq.get(i));
        }*/
        /*System.out.println("spicejet found");
        for(int i=0;i<tflno1.size();i++){
            System.out.println(tflno1.get(i));
        }*/
        /*System.out.println("silkair found");
        for(int i=0;i<tflno2.size();i++){
            System.out.println(tflno2.get(i));
        }*/
        
    }
    static String convertdatetoday(int date,int month,int year){
		int t=year%400;
		int leap=t/4;
		int nonleap=t-(t/4);
		int days=leap*2+nonleap;
		days=days%7;
		int monthdays[]={31,28,31,30,31,30,31,31,30,31,30,31};
		for(int i=0;i<month-1;i++){
			days=days+monthdays[i];
		}
		days=days+date-1;
		  int rem=days%7;
	        String day="";
	        switch(rem){
	            case 0:
	                day="SUNDAY";
	               break;
	                case 1:
	                    day="MONDAY";
	                        break;
	                    case 2:
	                        day="TUESDAY";
	                        break;
	                        case 3:
	                            day="WEDNESDAY";
	                            break;
	                            case 4:
	                                day="THURSDAY";
	                                break;
	                                case 5:
	                                    day="FRIDAY";
	                                        break;
	                                    case 6:
	                                         day="SATURDAY";
	                                            break;
	        }
	        return day;
	}
    
    boolean check2(int date,int month,int year,String data){
       String day=convertdatetoday(date,month,year);
       day=day.substring(0,3);
        
            data=data.replace('"', ' ');
            StringTokenizer st=new StringTokenizer(data,", ");
            while(st.hasMoreTokens()){
                if(day.equalsIgnoreCase(st.nextToken())){
                    return true;
                
            }
            
    }
    return false;
    }
    
    
    boolean check(int date,int month,int year,String data){
        String day=convertdatetoday(date,month,year);
          
        
        if(data.substring(0,4).equalsIgnoreCase("first")){
            //System.out.println("yes every");
            StringTokenizer st=new StringTokenizer(data," ");
        String t=st.nextToken().trim();
            String temp1="",temp2="",temp3="";
            int[] date1=new int[5];
            int aux=0;
            temp1=t;
            String temp4=st.nextToken();
            if(temp4.equalsIgnoreCase("and")){
                temp2=st.nextToken();
                temp3=st.nextToken();
            }
            else{
                temp3=temp4;
            }
            
            if(temp3.equalsIgnoreCase("wednesday")){
                aux=1;
            }
            else if(temp3.equalsIgnoreCase("thursday")){
                aux=2;
            }
             else if(temp3.equalsIgnoreCase("friday")){
                aux=3;
            }
             else if(temp3.equalsIgnoreCase("saturday")){
                aux=4;
            }
             else if(temp3.equalsIgnoreCase("sunday")){
                aux=5;
            } 
             else if(temp3.equalsIgnoreCase("monday")){
                aux=6;
            }
             else if(temp3.equalsIgnoreCase("tuesday")){
                aux=7;
            }
         
            int i=0;
            if(temp1.equalsIgnoreCase("first") || temp2.equalsIgnoreCase("first")){
                date1[i++]=aux;
            }
             if(temp1.equalsIgnoreCase("second")|| temp2.equalsIgnoreCase("second")){
                date1[i++]=aux+7;
            }
              if(temp1.equalsIgnoreCase("third")|| temp2.equalsIgnoreCase("third")){
                date1[i++]=aux+14;
            }
               if(temp1.equalsIgnoreCase("fourth")|| temp2.equalsIgnoreCase("fourth")){
                date1[i++]=aux+21;
            }
             for(int s=0;s<date1.length;s++){
                 if(date1[s]==date){
                     
                     return true;
                 }
               }
            
        }
        if(data.equalsIgnoreCase("daily")){
           //  System.out.println("yes daily");
           return true;
        }
        
        if(data.charAt(0)=='"'){
             //System.out.println("yes days");
            data=data.replace('"', ' ');
            StringTokenizer st;
            st=new StringTokenizer(data,", ");
            while(st.hasMoreTokens()){
                if(day.equalsIgnoreCase(st.nextToken())){
                   
                    return true;
                }
            }
        }
      
        
        return false;
    }
   
}
