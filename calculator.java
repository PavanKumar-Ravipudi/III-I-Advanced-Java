import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Sender:Hi");
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Receiver:Hello,What do you want?");
        int a,b;
        char ch=sc.next().charAt(0);
        String s;
        a=sc.nextInt();
        b=sc.nextInt();
        ope m=new ope();
        int res=m.cal(ch,a,b);
        System.out.println(res);
        System.out.println("Would you like to continue?");
        s=sc.next();
        if(s.equalsIgnoreCase("yes")){
         ch=sc.next().charAt(0);
         a=sc.nextInt();
         b=sc.nextInt();
         res=m.cal(ch,a,b);
         System.out.println(res);
        }
        else System.out.println("Receiver:Bye:)");
    }
}
class ope{
    int cal(char ch,int a,int b){
        int res=0;
        switch(ch){
            case '+':res=a+b;
                     break;
            case '-':res=a-b;
                     break;
            case '*':res=a*b;
                     break;
            case '/':res=a/b;
                     break;
        }
        return res;
    }
}