package eg.edu.alexu.csd.datastructure.stack;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Mohamed
 *
 */
public class ExpEvaUI {
	public static void main(String []args) {
	    	ExpressionEvaluator ap=new ExpressionEvaluator();boolean flag =true;boolean flag1=true;
	    	System.out.println("Enter the infix expression : \r\n");
	    	Scanner sq=new Scanner(System.in);
	    	String ss=sq.nextLine();
	    	String sss=null;int result=0;
	    	try {
	    		sss=ap.infixToPostfix(ss);
	    	}catch(Exception e) {System.out.println(e.getMessage());flag=false;}
	    	if(flag) {System.out.println("The postfix is : "+sss+"\r\n");
	    		if(sss.matches(".*[a-zA-Z]+.*")) {int j=0;String g[]=new String[100];
	    		for(int q=0;q<100;q++) {g[q]="$";}
	    			for(int i=0;i<sss.length();i++) {
	    				if(Character.isLetter(sss.charAt(i))) {
	    					String x=""+sss.charAt(i);
	    					boolean zz=true;
	    						for(int z=0;(z<100)&&(zz);z++) {if(g[z].contains(x)) {zz=false;}}
	    					    if(zz) {
	    					    g[j++]=x;}}
	    			}String []gr=new String[j];
	    			 for(int i=0;i<gr.length;i++) {gr[i]=g[i];}
	    			 String[]f=new String[gr.length];
	    			 for(int i=0;i<gr.length;i++) {String c=null;boolean ff=true;
	    				 while(ff) {ff=false;
	    					 System.out.println("Enter the value of : "+gr[i]+"\r\n");
	    					 c=sq.next();
	    					 c=c.trim();
	    					 for(int r=0;(r<c.length())&&(!ff);r++) {
	    						 if((r==0)&&(c.charAt(r)!='-')&&(!(Character.isDigit(c.charAt(r))))) {ff=true;}
	    						 else if(r>0){
	    						   {if(!(Character.isDigit(c.charAt(r)))) {ff=true;}}}
	    						 else if((c.length()==1)&&(c.charAt(0)=='-')) {ff=true;}
	    					 }
	    			 }
	    				 f[i]=c;
	    		}
	    			 for(int r=0;r<f.length;r++) {
	    				 ss=ss.replaceAll(gr[r], f[r]);}boolean cr=true;
	    				 try {sss=ap.infixToPostfix(ss);}catch(Exception e){System.out.println(e.getMessage());}
	    			 try {result=ap.evaluate(sss);}catch(Exception e) {System.out.println(e.getMessage());cr=false;}
	    			 if(cr)
	    			   {System.out.println("The value is : "+result+"\r\n");}
	    		}
	    		else {
	    			try {result=ap.evaluate(sss);}
	    			catch(Exception e) {System.out.println(e.getMessage());flag1=false;}
	    			if(flag1) {System.out.println("The value is : "+result+"\r\n");}
	    		
	    		
	    		}
	    	}
	 }}