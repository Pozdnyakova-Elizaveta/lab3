package lab3;
import java.util.Scanner;

class Inf{
     String name;
     int age;
     String breed;

     public Inf(String name, int age, String breed){
         this.name=name;
         this.age=age;
         this.breed=breed;
     }
     public Inf(String name){
         this.name=name;
         this.age=0;
         this.breed="breed";
     }

     public Inf(){
         this.name="name";
         this.age=0;
         this.breed="breed";
     }

     public void read(Scanner in){
         System.out.println("Введите кличку собаки: ");
         this.name=in.next();
         System.out.println("Введите породу: ");
         this.breed=in.next();
         System.out.println("Введите возраст: ");
         this.age=in.nextInt();
     }

     public void display(){
         System.out.println("Ваша собака - " + name + ", порода - " + breed + ", возраст - " + age);
     }
}