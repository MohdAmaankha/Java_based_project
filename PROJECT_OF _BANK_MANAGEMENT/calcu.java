import java.text.DecimalFormat;
import java.util.Scanner;
public class calcu
{
   public static void main (String[] args) {
      int n1,n2;
      System.out.print("enter tow number");
      Scanner r=new Scanner(System.in);
      n1=r.nextInt();
      n2=r.nextInt();
       double cal;
      System.out.print("selectoperation");
    int  ch=r.nextInt();
      if (ch == 1) {
         cal= n1+n2;
         System.out.print("addd"+cal);
      }
      else if (ch == 2) {
            cal= n1-n2;
            System.out.print("sub"+cal);
      }
      else if (ch == 3) {
             cal= n1*n2;
             System.out.print("mul"+cal);
      }
      else if (ch == 4) {
               cal= n1/n2;
               System.out.print("divi"+cal);
      }
      else  {
         cal=n1%n2;
         System.out.print("return"+cal);
      }


   }











}