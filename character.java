package lab3;
import java.util.Scanner;

class Character{
     boolean friendly;
     int learn;

     public Character(boolean friendly, int learn){
         this.friendly=friendly;
         this.learn=learn;
     }
     public Character(int learn){
         this.learn=learn;
     }

     public Character(){
     }

     public void read(Scanner in){
         System.out.print("Она дружелюбная (true - да, false - нет)?: ");
         this.friendly=in.nextBoolean();
         System.out.print("Оцените ее обучаемость от 1 до 5 (5 - легко обучаема): ");
         this.learn=in.nextInt();
     }

     public void display(){
         System.out.print((friendly)?"Дружелюбная, ":"Агрессивная, ");
         System.out.println("уровень обучаемости - " + learn);
     }
}