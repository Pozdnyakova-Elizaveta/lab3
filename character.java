package lab3;
import java.util.Scanner;

class Character{
     private boolean friendly;
     private int learn;

     public Character(boolean friendly, int learn){
         this.friendly=friendly;
         this.learn=learn;
     }
     public Character(int learn){
         this.learn=learn;
         friendly=true;
     }

     public Character(){
         learn=0;
         friendly=true;
     }

     public void read(Scanner in){
         System.out.print("Она дружелюбная (true - да, false - нет)?: ");
         this.friendly=in.nextBoolean();
         System.out.print("Оцените ее обучаемость от 1 до 5 (5 - легко обучаема): ");
         this.learn=in.nextInt();
     }

     public String toString(){
         String s;
         if (friendly) s="Дружелюбная, ";
         else s="Агрессивная, ";
         s=s+"уровень обучаемости - " + learn;
         return s;
     }
     public boolean get_friendly(){
         return friendly;
     }
     public int get_learn(){
         return learn;
     }
}