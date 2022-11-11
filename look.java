package lab3;
import java.util.Scanner;

class Look{
     private String color;
     private String eye_color;

     public Look(String color, String eye_color){
         this.color=color;
         this.eye_color=eye_color;
     }
     public Look(String color){
         this.color=color;
         eye_color="eye_color";
     }

     public Look(){
         color="color";
         eye_color="eye_color";
     }

     public void read(Scanner in){
         System.out.println("Какой у нее окрас?: ");
         this.color=in.next();
         System.out.println("Какой у нее цвет глаз?: ");
         this.eye_color=in.next();
     }

     public void display(){
         System.out.println("Окрас - " + color + ", цвет глаз - " + eye_color);
     }
}