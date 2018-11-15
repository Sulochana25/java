import java.util.*;
public class JdbcConnection {

	public static void main(String[] args) {
		String s="azxxxzyyyddddyyzzz";
		Stack<Integer> count_stack=new Stack<>();
		Stack<Character> char_stack=new Stack<>();
		
		int len=s.length();
		for(int i=0;i<len;i++)
		{
			//System.out.println(i);
			if(char_stack.isEmpty())
			{
				char_stack.push(s.charAt(i));
				count_stack.push(1);
			}
			else
			{
				int count;
				char top_char=char_stack.peek();
				//System.out.println(top_char);
				if(top_char==s.charAt(i)){
					count=count_stack.pop();
					count_stack.push(count+1);
					
				}
				else{
					count=count_stack.peek();
					if(count%2==0)
					{
						char_stack.pop();
						count_stack.pop();
						top_char=char_stack.peek();
						//System.out.println(top_char);
						if(top_char==s.charAt(i)){
							count=count_stack.pop();
							count_stack.push(count+1);
						}
						else
						{
							char_stack.push(s.charAt(i));
							count_stack.push(1);
						}
						
					}
					else
					{
						char_stack.push(s.charAt(i));
						count_stack.push(1);
					}
				}
				
			}
			
			
		}
		int count=count_stack.peek();
		if(count%2==0)
		{
			char_stack.pop();
			count_stack.pop();
		}
		String str="";
		while(!char_stack.isEmpty()){
			char c=char_stack.pop();
			int ct=count_stack.pop();
		for (int j=0;j<ct;j++)
		{str=c+str;
		}
		}
		System.out.println(str);
	}

}
