package lab3;
import lab3.Dog;
import lab3.Sled_dog;
import lab3.Man_with_dog;
import lab3.Man_with_sled_dog;
import java.util.Scanner;
import java.util.*;

public class Program{ 
    public static int recursiveBinarySearch(ArrayList<Dog> d, int first, int last, int search){
		if (last>=first){
			int mid=first+(last-first)/2;
			if (d.get(mid).get_inf().get_age()==search) return mid;
			if (d.get(mid).get_inf().get_age()>search) return recursiveBinarySearch(d, first, mid-1, search);
			return recursiveBinarySearch(d, mid+1, last,search);
		}
		return -1;
    }
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        int func=0;
        int kom=0;
        int num;
        Inf inf = new Inf("name", 0, "breed");
        Look look = new Look("color", "color eyes");
        Character character = new Character(false, 0);
        Command_know command_know = new Command_know(false, false, false);
        Needs needs = new Needs(true, true);
        Ride_character<Double> ride = new Ride_character<Double>(4.0,55.6);
        ArrayList<Dog> all_dog = new ArrayList<>();
        Iterator ir=all_dog.iterator();
        Dog dog[] =new Dog[2];
        Sled_dog sled_dog[] =new Sled_dog[2];
        Dog.work_massiv(dog);
        Sled_dog.work_massiv_sled(sled_dog);
        for (int i=0; i<2; i++){
        	all_dog.add(dog[i]);
        	all_dog.add(sled_dog[i]);
        }
        while (func!=7){
		System.out.println("Работа с контейнером");
		System.out.println("1 - вывод всех собак");
		System.out.println("2 - добавить собаку");
		System.out.println("3 - удалить собаку из списка");
		System.out.println("4 - общее количество собак");
		System.out.println("5 - сортировка");
		System.out.println("6 - поиск");
		System.out.println("7 - завершить работу с контейнером");
		func=in.nextInt();
           switch (func) {
		    case 1:
           		for (int i=0; i<all_dog.size(); i++) System.out.println(all_dog.get(i).toString());
           		break;
               case 2:{
           		System.out.println("Введите 1 или 2: 1 - добавить обычную собаку, 2 - добавить ездовую собаку");
           		num=in.nextInt();
				if (num==1){
					Dog d_dog=new Dog(inf,look,character,needs,command_know);
					d_dog.read(in);
					all_dog.add(all_dog.size(),d_dog);
				}
				if (num==2){
					Sled_dog d_sled_dog=new Sled_dog(inf,look,character,needs,command_know,ride);
					d_sled_dog.read(in);
					all_dog.add(all_dog.size(),d_sled_dog);
				}
				break;
               }
               case 3:{
				System.out.println("Введите номер собаки для удаления (от 0 до "+(all_dog.size()-1)+")");
				num=in.nextInt();
				if (num<all_dog.size()&&num>-1) all_dog.remove(num);
				else System.out.println("Номер был введен неправильно");
				break;
               }
               case 4:
				System.out.println("Всего собак - "+all_dog.size());
				break;
               case 5:{
				Collections.sort(all_dog);
				System.out.println("Сортировка по возрастанию возрата выполнена");
				break;
		    }
               case 6:{
				int s_age;
				System.out.println("Введите возраст для поиска: ");
				s_age=in.nextInt();
				Collections.sort(all_dog);
				int nomer=recursiveBinarySearch(all_dog, 0, all_dog.size(),s_age);
				if (nomer==-1) System.out.println("Подходящего элемента нет");
				else System.out.println(all_dog.get(nomer));
				break;
               }
		}
        }
        Ride_character<String> ride_2 = new Ride_character<String>("тридцать", "пять");
        System.out.println(ride.toString());
        System.out.println(ride_2.toString());
        Sled_dog s_dog=new Sled_dog(inf, look, character, needs, command_know, ride);
        System.out.println("Введите информцию об ездовой собаке");
        s_dog.read(in);
        System.out.println(s_dog.toString());
        System.out.println("Введите информцию об обычной собаке");
        Inf inf1 = new Inf("name", 0, "breed");
        Look look1 = new Look("color", "color eyes");
        Character character1 = new Character(false, 0);
        inf1.read(in);
        look1.read(in);
        character1.read(in);
        Dog dog1 = new Dog(inf1, look1, character1, needs, command_know);
        System.out.println(dog1.toString());
        System.out.println(s_dog.toString());
        dog1.number_skills();
        s_dog.number_skills();
        Man_with_dog man1 = new Man_with_dog("Ivanov",inf, look, character, needs, command_know, 2.5);
        Man_with_sled_dog man2 = new Man_with_sled_dog("Sidorov", s_dog.get_inf(), s_dog.get_look(), s_dog.get_character(), needs, command_know, s_dog.get_ride_character());
        man1.moving_output(man1.moving(3));
        man2.moving_output(man2.moving(3));
        System.out.println("Введите информцию об обычной собаке для копирования");
        Dog dog2= new Dog(inf, look, character, needs, command_know);
        dog2.read(in);
        System.out.println(dog1.get_inf().toString());
        System.out.println(dog2.get_inf().toString());
        System.out.println("\n\nИзменим значение возраста второй собаки для демонстрации мелкого копирования");
        dog1=(Dog)dog2.clone();
        dog2.inf.set_age(10);
        System.out.println("Собака 1 "+dog1.get_inf().toString());
        System.out.println("Собака 2 "+dog2.get_inf().toString());
        System.out.println("\n\nЕще раз изменим значение возраста второй собаки для демонстрации глубокого копирования");
        dog1=(Dog)dog2.clone_deep();
        dog2.inf.set_age(15);
        System.out.println("Собака 1 "+dog1.get_inf().toString());
        System.out.println("Собака 2 "+dog2.get_inf().toString());
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
			    System.out.println(your_dog_1.toString());
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
			 break;
               }
	   }
    }
    System.gc();
    in.close();
  }
 }
}