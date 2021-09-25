package abhishek;

import java.util.Scanner;


public class DynamicStack extends CustomStack.Stack{
   public DynamicStack(int cap) {
		super(cap);
	}
   int[] increaseArraySize(){
       int currSize = top + 1;
       int incArray[] = new int[2 * currSize];
       for(int i=0;i<=top;i++){
           incArray[i] = stack[i];
       }
       return incArray;
   }
   void push(int val) {
	   if(isFull()){
		   stack = increaseArraySize();
      }
      stack[++top] = val;
      System.out.println(val + " pushed into stack");
   }
  
  public static void main(String[] args) throws Exception {
	  Scanner sc = new Scanner(System.in);
	  int size = sc.nextInt();
	  DynamicStack s = new DynamicStack(size);
	  s.push(10);
      s.push(20);
      s.push(30);
      s.push(40);
      System.out.println(s.pop() + " Popped from stack");
      System.out.println("Top element is :" + s.peek());
      System.out.print("Elements present in stack :");
      s.display();
  }
}
