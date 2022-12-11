package lab3;
import java.util.Scanner;

class Inf implements Cloneable{
     private String name;
     private int age;
     private String breed;

     public Inf(String name, int age, String breed){
         this.name=name;
         this.age=age;
         this.breed=breed;
     }
     public Inf(String name){
         this.name=name;
         age=0;
         breed="breed";
     }

     public Inf(){
         name="name";
         age=0;
         breed="breed";
     }

     public void read(Scanner in){
         System.out.println("Введите кличку собаки: ");
         this.name=in.next();
         System.out.println("Введите породу: ");
         this.breed=in.next();
         System.out.println("Введите возраст: ");
         this.age=in.nextInt();
     }

     public String toString(){
         return "Ваша собака - " + name + ", порода - " + breed + ", возраст - " + age;
     }
     public String get_name(){
         return name;
     }
     public String get_breed(){
         return breed;
     }
     public int get_age(){
         return age;
     }
     public void set_age(int a){
         age=a;
     }
     public Object clone(){
         try
         {
         return (Inf)super.clone();
         }
         catch(CloneNotSupportedException e)
         {
         
         }
         return this;
    }
}