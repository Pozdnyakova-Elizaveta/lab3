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
        Dog your_dog[];
        your_dog = new Dog[2];
        Dog.work_massiv(your_dog);
        System.out.println("\nОбработка двумерного массива:\n");
        Dog your_dog_2[][];
        your_dog_2 = new Dog[2][2];
        if (Dog.work_massiv_two(your_dog_2)==1){
		func = 7;
		System.out.println("\n\nИсправьте ошибку в файле для дальнейшей работы");
        }
        if (func!=7){
		Dog your_dog_1= new Dog();
		int a1=0,a2=0;
		int p=0;
        	System.out.println("Введите индекс элемента для дальнейшей работы");
        	while (p!=1){
        	  try{
        		a1=in.nextInt();
			if (a1 < 0 || a1>1) throw new IllegalArgumentException();
        		a2=in.nextInt();
           	if (a2 < 0 || a2>1) throw new IllegalArgumentException();
			p = 1;
        	}
           catch(Exception e){
			System.out.println("Введите индексы числами от 0 до 1");
			in.nextLine();
           }
        }
	  your_dog_1=your_dog_2[a1][a2];
        while (func != 7) {
		System.out.println("Нажмите: 1 - для вывода информации о собаке");
		System.out.println("2 - погладить собаку");
		System.out.println("3 - обучить команде");
		System.out.println("4 - покормить");
		System.out.println("5 - погулять");
		System.out.println("6 - получить год рождения собаки");
		System.out.println("7 - завершение");
           p=0;
           while(p!=1){
                try{
			func=in.nextInt();
                if (func < 1 || func>7) throw new IllegalArgumentException();
			p = 1;
                }
                catch (Exception e) {
			   System.out.println("Введите число от 1 до 7");
			   in.nextLine();
                }
           }
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
			p=0;
			while (p!=1){
				try{
					kom=in.nextInt();
					if (kom < 1 || kom>3) throw new IllegalArgumentException();
					p = 1;
				}
				catch(Exception e){
					System.out.println("Введите число от 1 до 3");
		                in.nextLine();
				}
			}
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
}