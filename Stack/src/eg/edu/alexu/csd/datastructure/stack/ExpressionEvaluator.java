package eg.edu.alexu.csd.datastructure.stack;

/**
 * @author Mohamed
 *
 */
public class ExpressionEvaluator implements IExpressionEvaluator {
	
    private int pri(char t) {if(t=='+'||t=='-') {return 1;}
    else if(t=='/'||t=='*') {return 2;}
    else
    	return -1;}
    

	/**
	 *evaluate a given symbolic/numeric infix expression to postfix expression
	 *check if this expression is valid otherwise throw an exception 
	 *@param expression
	 *output the result with only one space separator
	 *@return postfix expression 
	 */
	public String infixToPostfix(String expression) {
		String g=expression.trim();
		g=g.replaceAll("\\s+","");
		if(g.length()==0) {throw new IllegalStateException("Empty expression");}
		for(int i=0;i<g.length();i++) {if((!Character.isLetter(g.charAt(i)))&&(!Character.isDigit(g.charAt(i))&&(g.charAt(i)!='.')&&(g.charAt(i)!='*')&&(g.charAt(i)!='/')&&(g.charAt(i)!='-')&&(g.charAt(i)!='+')&&(g.charAt(i)!='(')&&(g.charAt(i)!=')')&&(g.charAt(i)!=' '))) {
			throw new IllegalStateException("Wrong expression");
		}
			}
		if((g.contains("()"))||(g.charAt(0)=='.')||(g.contains("./"))||(g.contains(".+"))||(g.contains(".-"))||(g.contains(".*"))||(g.contains("*."))||(g.contains("/."))||(g.contains("+."))||(g.contains("-."))||(g.contains("*)"))||(g.contains("/)"))||(g.contains("+)"))||(g.contains("-)"))||(g.contains("(*"))||(g.contains("(/"))||(g.contains("-/"))||(g.contains("-*"))||(g.contains(".."))||(g.contains("*/"))||(g.contains("/*"))||(g.contains("+*"))||(g.contains("+/"))||(g.contains("//"))||(g.contains("**"))||(g.charAt(0)=='+')||(g.charAt(0)=='/')||(g.charAt(0)=='*')||(!Character.isDigit(g.charAt(g.length()-1))&&(g.charAt(g.length()-1)!=')')&&!Character.isLetter(g.charAt(g.length()-1)))) {
			throw new IllegalStateException("Wrong expression");
		}String st=" "+g+" ";
		for(int i=1;i<=g.length()+1;i++) {
			if(Character.isLetter(st.charAt(i))){
				if(Character.isLetter(st.charAt(i-1))||Character.isLetter(st.charAt(i+1))||Character.isDigit(st.charAt(i-1))||Character.isDigit(st.charAt(i+1))||(st.charAt(i+1)=='.')||(st.charAt(i-1)=='.')||(st.charAt(i-1)==')')) {
					throw new IllegalStateException("Wrong expression");
				}
			}
			else if(Character.isDigit(st.charAt(i))) {
				if(st.charAt(i-1)==')') {
					throw new IllegalStateException("Wrong expression");
				}
			}
		}
		StringBuffer vrr1= new StringBuffer(st);
		for(int i=1;i<vrr1.length()-1;i++) {
			if(((Character.isLetter(vrr1.charAt(i)))&&(vrr1.charAt(i+1)=='('))||((Character.isDigit(vrr1.charAt(i))&&(vrr1.charAt(i+1)=='(')))) {
				vrr1.insert(i+1,"*");
			}
		}g=vrr1.toString();
		g=g.trim();
		g=g.replace(")(", ")*(");
		while(g.contains("++")||g.contains("-+")||g.contains("(+")||g.contains("*+")||g.contains("/+")) {g=g.replace("++","+");g=g.replace("-+","-");g=g.replace("(+","(");g=g.replace("*+","*");g=g.replace("/+","/");}
		expression=g;
		Stack b=new Stack();boolean z=true;
		for(int i=0;(i<expression.split("").length)&&(z);i++) {
			if(expression.charAt(i)=='(') {String j="(";
				b.push(j);
			}
			else if(expression.charAt(i)==')') {
				 if(b.isEmpty()) {z=false;break;}
				 if(b.pop()!="(") {z=false;break;}
			}
		}
		if(b.isEmpty()&&(z)) {z=true;}
		else {z=false;}
		if(!z) {throw new IllegalStateException("wrong Parentheses");}
		String vr=" ";String tr="";
		String exp=expression+" ";int i=0;
		vr+=exp.substring(i);
		StringBuffer vrr= new StringBuffer(vr);
		boolean flag=true;boolean flag1=true;
	while(flag||flag1) {
		flag=false;i=0;boolean jr=true;int last=1;flag1=false;
		for(int j=1;(j<vr.split("").length-1)&&(jr);j++) {
			if((vr.charAt(j)=='-')&&(vr.charAt(j+1)=='(')&&(!Character.isDigit(vr.charAt(j-1)))&&(!Character.isLetter(vr.charAt(j-1)))&&(vr.charAt(j-1)!=')')){
				flag=true;i=j;int f=1;jr=false;
				for(int k=i+2;(k<vr.split("").length-1)&&(f!=0);k++) {
					if(vr.charAt(k)==')') {f--;}
					else if(vr.charAt(k)=='(') {f++;}
					if(f==0) {last=k;}}
				}
			else if(((Character.isDigit(vr.charAt(j+1)))||(Character.isLetter(vr.charAt(j+1))))&&(vr.charAt(j)=='-')&&(!Character.isDigit(vr.charAt(j-1)))&&(!Character.isLetter(vr.charAt(j-1)))&&(vr.charAt(j-1)!=')'))
			{flag1=true;i=j;jr=false;int k=i+1;
			while((k<vr.split("").length-1)&&(Character.isDigit(vr.charAt(k+1))||Character.isLetter(vr.charAt(k+1))||(vr.charAt(k+1)=='.'))) {k++;
			}last=k;
			}
			}
		if(flag||flag1) {
		vrr.insert(i,"(0");
		vrr.insert(last+3,")");
		vr=vrr.toString();}
		}
		i=0;
		expression=vr;
		String OU="";Stack c=new Stack();
		    while(i<(expression.split("").length-1)) {
		    	 if(Character.isDigit(expression.charAt(i))||Character.isLetter(expression.charAt(i))||(expression.charAt(i)=='.')) {
		    		 OU+=expression.charAt(i++);
		    			 if(!(Character.isDigit(expression.charAt(i))||Character.isLetter(expression.charAt(i))||(expression.charAt(i)=='.')))
		    		 {OU+=" ";}
		    	 }
		    	 else {
		    		 if(expression.charAt(i)!='(' && expression.charAt(i)!=')') {
		    			 if(c.isEmpty()) {c.push(expression.charAt(i++));}
		    			 else {
		    				 if(pri(expression.charAt(i))>pri((char)c.peek())) {c.push(expression.charAt(i++));}
		    				 else {
		    					 OU+=c.pop();OU+=" ";
		    				 }
		    			 }
		    		 }
		    		 else
		    		   {if(expression.charAt(i)=='(') {c.push(expression.charAt(i++));}
		    		    else {
		    		    	while((char)c.peek()!='(') {
		    		    	OU+=c.pop();OU+=" ";
		    		     }
		    		    	c.pop();i++;
		    		    	}
		    			   }
		    	 }
		         }
		    while(!c.isEmpty()) {OU+=c.pop();OU+=" ";}
		    OU=OU.trim();
		    return OU;
	}

	/**
	 *evaluate a given numeric postfix expression
	 *check if the expression is valid,i.e, integer and without symbolic characters
	 * @param expression
	 * return the integer value rounded to nearest integer
	 * @return result
	 */
	public int evaluate(String expression) {
		if(expression.contains(".")||(expression.matches(".*[a-zA-Z]+.*")))
		{throw new IllegalStateException("Only integer numbers are permitted to be evaluated \r\n");}
		String g=expression.trim();if(g.length()==0) {throw new IllegalStateException("Empty expression");}
		String arr=g.replaceAll("\\s+","!");
		String [] arg=arr.split("!");
	    float result=0;Stack sz=new Stack();
	    if(arg.length==0) {throw new IllegalStateException("Empty expression");}
	    else if(arg.length==1) {
	    	if(arg[0].contains("+")||arg[0].contains("-")||arg[0].contains("/")||arg[0].contains("*")) {
	    		throw new IllegalStateException("Wrong expression");}
	    	else {
	    		return Integer.parseInt(arg[0]);
	    	}
	    }
	    for(int i=0;i<arg.length;i++) {
	    	if(!((arg[i].contains("*"))||(arg[i].contains("/"))||(arg[i].contains("+"))||(arg[i].contains("-")))) {
	    		sz.push(Float.parseFloat(arg[i]));
	    	}
	    	else {
	    		float x1=(float) sz.pop();
	    		float x2=(float) sz.pop();
	    		if(arg[i].contains("/")) {
	    		if(x1==0) {throw new RuntimeException("Can't divide by zero");}
	    		else
	    		   {result=x2/x1;
	    		   sz.push(result);}
	    		}
	    		else if(arg[i].contains("*")) {
	    			result=x2*x1;
	    			sz.push(result);
	    		}
	    		else if(arg[i].contains("-")) {
	    			result=x2-x1;
	    			sz.push(result);
	    		}
	    		else if(arg[i].contains("+")) {
	    			result=x2+x1;
	    			sz.push(result);}
	    	}  }
	  return Math.round(result);
	}
}

