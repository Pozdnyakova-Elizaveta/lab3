package lab3;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import lab3.Inf;
import lab3.Look;
import lab3.Character;
import lab3.Needs;
import lab3.Command_know;
class Dog{
     static int sum=0;
     static int sum_friendly=0;
     private Inf inf;
     private Look look;
     private Character character;
     private Needs needs;
     private Command_know command_know;

     public Dog(Inf inf, Look look, Character character, Needs needs, Command_know command_know){
         this.inf = inf;
         this.look = look;
         this.character = character;
         this.needs = needs;
         this.command_know = command_know;
         sum=sum+1;
     }
     public Dog(Inf inf){
         this.inf = inf;
         sum=sum+1;
     }

     public Dog(){
         sum=sum+1;
     }
     static void number_dogs(){
        int k=sum-sum_friendly;
        System.out.println("Всего собак - "+sum+", из них дружелюбных - "+sum_friendly+", агрессивных - "+k);
     }

     public void read(Scanner in){
         inf.read(in);
         look.read(in);
         character.read(in);
         if (character.get_friendly()) sum_friendly++;
     }

     public void display(){
         inf.display();
         look.display();
         character.display();
         command_know.display();
         needs.display();
     }
     public void touch(Dog dog){
         if (dog.character.get_friendly()) System.out.println(dog.inf.get_name()+" рад(а)!");
         else System.out.println(dog.inf.get_name()+" не нравится!");
     }
     public void eat(Dog dog){
         if (dog.needs.get_eat()) {
             System.out.println(dog.inf.get_name()+" накормлен(а)!");
             dog.needs.set_eat(false);
         }
         else System.out.println(dog.inf.get_name()+" не хочет есть!");
     }
     public void walk(Dog dog){
         if (dog.needs.get_walk()) {
             System.out.println(dog.inf.get_name()+" погулял(а)!");
             dog.needs.set_walk(false);
         }
         else System.out.println(dog.inf.get_name()+" не хочет гулять!");
     }
     public void command(Dog dog, int com){
         switch (com) {
	        case 1:
                  if (dog.command_know.get_sit()) System.out.println("Собака уже это умеет");
		       else {
			      System.out.println ("Учим...");
			      try {
			      Thread.sleep((5 - dog.character.get_learn()) * 4000);
                       }catch (InterruptedException e) {}
			      System.out.println("Теперь собака знает эту команду");
			      dog.command_know.set_sit(true);
                  }
                  break;
	        case 2: 
		       if (dog.command_know.get_lie()) System.out.println("Собака уже это умеет");
		       else {
			      System.out.println ("Учим...");
                      try {
			      Thread.sleep((5 - dog.character.get_learn()) * 4000);
                       }catch (InterruptedException e) {}
			      System.out.println("Теперь собака знает эту команду");
			      dog.command_know.set_lie(true);
                  }
                  break;
              case 3:
                  if (dog.command_know.get_to_me()) System.out.println("Собака уже это умеет");
		       else {
			      System.out.println ("Учим...");
			      try {
			      Thread.sleep((5 - dog.character.get_learn()) * 4000);
                       }catch (InterruptedException e) {}
			      System.out.println("Теперь собака знает эту команду");
			      dog.command_know.set_to_me(true);
                  }
                  break;
     }
  }
  class Year_of_birtday{
     public int year;
  }
  public void dog_year(Year_of_birtday y){
     Calendar cal = new GregorianCalendar();
     y.year= cal.get(Calendar.YEAR)-inf.get_age();
  }
}