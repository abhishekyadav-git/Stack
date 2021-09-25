package abhishek;

import java.io.*;
import java.util.*;

class StackOverFlowException extends Exception{
    public StackOverFlowException(String str){
        super(str);
    }
}
class StackUnderFlowException extends Exception{
    public StackUnderFlowException(String str){
        super(str);
    }
}
public class CustomStack {

  public static class Stack {
    protected int[] stack;
    protected int top;
    protected int capacity;

    public Stack(int cap) {
      stack = new int[cap];
      top = -1;
    }

    int size() {
      return top + 1;
    }
    
    public boolean isEmpty(){
        return top==-1; 
    }
    
    public boolean isFull(){
        return top >= stack.length-1;
    }
    
    void display() {
      for(int i=top;i>=0;i--){
          System.out.print(stack[i] + " ");
      }
      System.out.println();
    }
    
    void printStackOverFlow(){
        try{
              throw new StackOverFlowException( "Stack overflow");
          }
          catch(StackOverFlowException e){
              System.out.println(e.getMessage());
          }
    }
    int printStackUnderFlow(){
        try{
              throw new StackUnderFlowException("Stack underflow");
          }
          catch(StackUnderFlowException e){
               System.out.println(e.getMessage());
               return -1;
          }
    }
    void push(int val) {
      if(isFull()){
           printStackOverFlow();
      }
      else{
          stack[++top] = val;
          System.out.println(val + " pushed into stack");
      }
    }

    int pop() {
        if(isEmpty()){
          return printStackUnderFlow();
        }    
      return stack[top--];
    }

    int peek() {
        if(isEmpty()){
          return printStackUnderFlow();
        } 
       return stack[top];
    }
  }

  public static void main(String[] args) throws Exception {
	  Scanner sc = new Scanner(System.in);
	  int size = sc.nextInt();
	  Stack s = new Stack(size);
	  s.push(10);
      s.push(20);
      s.push(30);
      System.out.println(s.pop() + " Popped from stack");
      System.out.println("Top element is :" + s.peek());
      System.out.print("Elements present in stack :");
      s.display();
  }
}
