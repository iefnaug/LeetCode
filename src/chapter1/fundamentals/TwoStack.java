package chapter1.fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/*
 * Author guanfei
 * Date 2018/11/6
 */
public class TwoStack {


    /**
     * 一个简易的表达式计算，每个子表达式都需要括号包围
     */
    public void evaluate(){
        Stack<Double> vals = new Stack<>();
        Stack<String> operators = new Stack<>();

        String input;
        while( !(input = StdIn.readString()).equals("stop")){
            if("(".equals(input)){

            }else if("+".equals(input) || "-".equals(input) || "*".equals(input) ||"/".equals(input)){
                operators.push(input);
            }else if(")".equals(input)){
                double val = vals.pop();
                String op = operators.pop();
                if("+".equals(op)){
                    vals.push(vals.pop() + val);
                }else if("-".equals(op)){
                    vals.push(vals.pop() - val);
                }else if("*".equals(op)){
                    vals.push(vals.pop() * val);
                }else if("/".equals(op)){
                    vals.push(vals.pop() / val);
                }
            }else{
                vals.push(Double.parseDouble(input));
            }
        }
        StdOut.println(vals.peek());
    }

    public static void main(String[] args) {
        TwoStack twoStack = new TwoStack();
        twoStack.evaluate();
    }
}
