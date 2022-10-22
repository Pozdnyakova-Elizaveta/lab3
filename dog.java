package lab3;
import java.util.Scanner;
import lab3.Inf;
import lab3.Look;
import lab3.Character;
import lab3.Needs;
import lab3.Command_know;
class Dog{
     Inf inf;
	Look look;
	Character character;
	Needs needs;
	Command_know command_know;

     public Dog(Inf inf, Look look, Character character, Needs needs, Command_know command_know){
         this.inf = inf;
         this.look = look;
         this.character = character;
         this.needs = needs;
         this.command_know = command_know;
     }
     public Dog(Inf inf){
         this.inf = inf;
     }

     public Dog(){
     }

     public void read(Scanner in){
         inf.read(in);
         look.read(in);
         character.read(in);
     }

     public void display(){
         inf.display();
         look.display();
         character.display();
         command_know.display();
         needs.display();
     }
     public void touch(Dog dog){
         if (dog.character.friendly) System.out.println(dog.inf.name+" рад(а)!");
         else System.out.println(dog.inf.name+" не нравится!");
     }
     public void eat(Dog dog){
         if (dog.needs.eat) {
             System.out.println(dog.inf.name+" накормлен(а)!");
             dog.needs.eat=false;
         }
         else System.out.println(dog.inf.name+" не хочет есть!");
     }
     public void walk(Dog dog){
         if (dog.needs.walk) {
             System.out.println(dog.inf.name+" погулял(а)!");
             dog.needs.walk=false;
         }
         else System.out.println(dog.inf.name+" не хочет гулять!");
     }
     public void command(Dog dog, int com){
         switch (com) {
	        case 1:
                  if (dog.command_know.sit) System.out.println("Собака уже это умеет");
		       else {
			      System.out.println ("Учим...");
			      try {
			      Thread.sleep((5 - dog.character.learn) * 4000);
                       }catch (InterruptedException e) {}
			      System.out.println("Теперь собака знает эту команду");
			      dog.command_know.sit = true;
                  }
                  break;
	        case 2: 
		       if (dog.command_know.lie) System.out.println("Собака уже это умеет");
		       else {
			      System.out.println ("Учим...");
                      try {
			      Thread.sleep((5 - dog.character.learn) * 4000);
                       }catch (InterruptedException e) {}
			      System.out.println("Теперь собака знает эту команду");
			      dog.command_know.lie = true;
                  }
                  break;
              case 3:
                  if (dog.command_know.to_me) System.out.println("Собака уже это умеет");
		       else {
			      System.out.println ("Учим...");
			      try {
			      Thread.sleep((5 - dog.character.learn) * 4000);
                       }catch (InterruptedException e) {}
			      System.out.println("Теперь собака знает эту команду");
			      dog.command_know.to_me = true;
                  }
                  break;
     }
  }
}