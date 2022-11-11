package lab3;
import lab3.Dog;
import java.util.Scanner;
import java.util.*;

public class Program{ 
      
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        int func=0;
        int kom=0;
        Inf inf = new Inf("name", 0, "breed");
        Look look = new Look("color", "color eyes");
        Character character = new Character(false, 0);
        Command_know command_know = new Command_know(false, false, false);
        Needs needs = new Needs(true, true);
        ArrayList<Dog> your_dog = new ArrayList<>();
        for (int i=0; i<2; i++){
           your_dog.add(new Dog(inf, look, character, needs, command_know));
           your_dog.get(i).read(in);
           your_dog.get(i).display();
           Dog.number_dogs();
        }
        your_dog.clear();
        Dog your_dog_1 = new Dog(inf, look, character, needs, command_know);
        your_dog_1.read(in);
        while (func != 7) {
		System.out.println("Нажмите: 1 - для вывода информации о собаке");
		System.out.println("2 - погладить собаку");
		System.out.println("3 - обучить команде");
		System.out.println("4 - покормить");
		System.out.println("5 - погулять");
		System.out.println("6 - получить год рождения собаки");
		System.out.println("7 - завершение");
		func=in.nextInt();
		switch (func) {
		    case 1:
			    your_dog_1.display();
			    break;
		    case 2:
			    your_dog_1.touch(your_dog_1);
			    break;
		    case 3: {
			System.out.println("Выберите команду: 1. Сидеть");
			System.out.println("2. Лежать");
			System.out.println("3. Ко мне");
			kom=in.nextInt();
			switch (kom) {
			case 1:
				your_dog_1.command(your_dog_1,1);
				break;
			case 2:
				your_dog_1.command(your_dog_1, 2);
				break;
			case 3:
				your_dog_1.command(your_dog_1, 3);
				break;
			}
			break;
               }
		    case 4:
			    your_dog_1.eat(your_dog_1);
			    break;
		    case 5:
			    your_dog_1.walk(your_dog_1);
			    break;
               case 6:{
                  int k;
                  Dog.Year_of_birtday y = your_dog_1.new Year_of_birtday();
                  your_dog_1.dog_year(y);
                  k=y.year;
                  System.out.println("Год рождения - "+k);
               }
	   }
    }
    System.gc();
    in.close();
  }
}