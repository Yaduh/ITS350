
public class CharStack {
    int size;
    char stack[];
    int top;
    CharStack(int size){
        this.size = size;
        stack = new char[size];
        top = -1;
    }
    void push(char element){
        if(isFull()){
            System.out.println("Stack Overflow!");
            return;
        }
        top++;
        stack[top] = element;
    }
    boolean isFull(){
        return top >= size-1;
    }
    char pop(){
        if(isEmpty()){
            System.out.println("stack underflow");
            return ' ';
        }
        char popped = stack[top];
        stack[top] = ' ';
        top--;
        return popped;
    }
    char peek(){
        if(isEmpty()){
            System.out.println("Empty");
            return ' ';
        }
        return stack[top];
    }
    boolean isEmpty(){
        return top < 0;
    }
    boolean balanced(String exp){
        if(exp.length()%2 != 0){
            return false;
        }
        for(int i=0; i<exp.length()/2; i++){
            if(exp.charAt(i) == '(' || exp.charAt(i)=='[' ||
                    exp.charAt(i)=='{' || exp.charAt(i)=='<')
                push(exp.charAt(i));
            else
                return false;
        }
        //This method is not complete
        return true;
    }
    void display(){
        for(int i=size-1; i>=0; i--){
            System.out.println(stack[i]);
        }
    }
    boolean isPal(String word){
        for(int i=0; i<word.length(); i++){
            push(word.charAt(i));
        }
        String str = "";
        for(int i=0; i<word.length(); i++){
            str = str + pop();
        }
        return word.equalsIgnoreCase(str);
    }
    public static void main(String args[]){
        CharStack st = new CharStack(4);
        System.out.println(st.isPal("dadk"));
//        st.push('A');
//        st.push('K');
//        st.push('M');
//        st.pop();
//        st.push('D');
//        st.pop();
//        st.display();
//        System.out.println("Peek: "+st.peek());
    }
}
