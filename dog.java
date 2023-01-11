package lab3;
import java.io.*;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import lab3.Inf;
import lab3.Look;
import lab3.Character;
import lab3.Needs;
import lab3.Command_know;
import java.util.Arrays;
class Dog implements Command, Cloneable, Comparable<Dog> {
     static int sum=0;
     static int sum_friendly=0;
     protected Inf inf;
     protected Look look;
     protected Character character;
     protected Needs needs;
     protected Command_know command_know;

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

     public String toString(){
         String s="";
         s=s+inf.toString()+"\n";
         s=s+look.toString()+"\n";
         s=s+character.toString()+"\n";
         s=s+command_know.toString()+"\n";
         s=s+needs.toString()+"\n";
         return s;
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
  public void set_inf(Inf inf){this.inf=inf;}
  public static void work_massiv(Dog a[]){
     String name, breed,color,color_eye,s,c[];
     int age, learn;
     boolean friendly;
     try
     {  File f = new File("D:\\Работы\\laba3\\lab3\\spisok.txt");
        if (!f.exists()) throw new IOException("Не удалось открыть файл");
	   FileReader fr = new FileReader(f);
        Scanner scan=new Scanner(fr);
        if (!scan.hasNext()) throw new Exception("Файл пуст");
        for (int i=0; i<2; i++){
		if (!scan.hasNext()) throw new Exception("В файле недостаточно данных для заполнения массива");
        	s=scan.nextLine();
		c=s.split(" ");
		if (c.length<7)throw new Exception("В файле недостаточно данных для заполнения массива");
		try{
        		name=c[0];
        		age=Integer.parseInt(c[1]);
			if (age<0) throw new Exception("Введите возраст положительным числом");
        		breed=c[2];
        		color=c[3];
        		color_eye=c[4];
        		friendly=Boolean.valueOf(c[5]);
			if (friendly==false&c[5].equals("false")==false) throw new Exception("Введите правильно булевое значение дружелюбности");
        		learn=Integer.parseInt(c[6]);
			if (learn<1|learn>5) throw new Exception("Введите уровень обучаемости числом от 1 до 5");
        		Look look = new Look(color, color_eye);
        		Character character = new Character(friendly, learn);
			Inf inf = new Inf(name, age, breed);
			Command_know command_know = new Command_know();
           	Needs needs = new Needs();
			a[i]=new Dog();
           	a[i].inf=inf;
			a[i].character = character;
			a[i].look=look;
			a[i].needs=needs;
			a[i].command_know=command_know;
			System.out.println(a[i].toString());
		}
		catch(NumberFormatException e){
			System.out.println("Не удалось считать численное значение");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
        }
	fr.close();
     }
     catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }
	catch (Exception ex) {
		 System.out.println(ex.getMessage());
     }
  }
  public static int work_massiv_two(Dog a[][]){
     String name, breed,color,color_eye,s,c[];
     Inf inf;
     Character character;
     Look look;
     Command_know command_know;
     Needs needs;
     int age, learn;
     boolean friendly;
     int p=0;
      try
     {  File f = new File("C:\\Users\\Елизавета\\Desktop\\laba3\\lab3\\spisok2.txt");
        if (!f.exists()) throw new IOException("Не удалось открыть файл");
	   FileReader fr = new FileReader(f);
        Scanner scan=new Scanner(fr);
        if (!scan.hasNext()) throw new Exception("Файл пуст");
        for (int i=0; i<2; i++){
			for(int j=0; j<2; j++){
        			if (!scan.hasNext()) throw new Exception("В файле недостаточно данных для заполнения массива");
        			s=scan.nextLine();
				c=s.split(" ");
				if (c.length<7)throw new Exception("\nВ файле недостаточно данных для заполнения массива\n");
				try{
        				name=c[0];
        				age=Integer.parseInt(c[1]);
					if (age<0) throw new Exception("\nВведите возраст положительным числом\n");
        				breed=c[2];
        				color=c[3];
        				color_eye=c[4];
        				friendly=Boolean.valueOf(c[5]);
					if (friendly==false&c[5].equals("false")==false) throw new Exception("\nВведите правильно булевое значение дружелюбности\n");
        				learn=Integer.parseInt(c[6]);
					if (learn<1|learn>5) throw new Exception("\nВведите уровень обучаемости числом от 1 до 5\n");
        				look = new Look(color, color_eye);
        				character = new Character(friendly, learn);
					inf = new Inf(name, age, breed);
					command_know = new Command_know();
           			needs = new Needs();
					a[i][j]=new Dog();
           			a[i][j].inf=inf;
					a[i][j].character = character;
					a[i][j].look=look;
					a[i][j].needs=needs;
					a[i][j].command_know=command_know;
					System.out.println(a[i][j].toString());
			   }
			   catch(NumberFormatException e){
				System.out.println("\nНе удалось считать численное значение\n");
				p=1;
		        }
			   catch(Exception e){
				System.out.println(e.getMessage());
				p=1;
		        }
        }
	  }
	fr.close();
     }
     catch(IOException ex){
             
            System.out.println(ex.getMessage());
		 p=1;
        }
	catch (Exception ex) {
		 System.out.println(ex.getMessage());
		 p=1;
     }
   return p;
 }
 public Inf get_inf(){return inf;}
 public Character get_character(){return character;}
 public Look get_look(){return look;}
 public void number_skills(){
     int n = 0;
	if (command_know.get_lie()) n=n+1;
	if (command_know.get_to_me()) n=n+1;
	if (command_know.get_sit()) n=n+1;
      System.out.println("Собака "+inf.get_name()+" имеет "+n+" навыков");
 }
 public Object clone_deep()
 {
     try
     {
       Dog clone=(Dog)super.clone();
       clone.inf=(Inf)inf.clone();
       return clone;
     }
   catch(CloneNotSupportedException e)
   {      
   }
   return this;  
 }
 public Object clone()
 {
     try
     {
       Dog clone=(Dog)super.clone();
       return clone;
     }
   catch(CloneNotSupportedException e)
   {      
   }
   return this;  
 }
  public int compareTo(Dog d) {
	Integer age1, age2, k;
	age1=this.inf.get_age();
	age2=d.inf.get_age();
	k=age1.compareTo(age2);
	if (k>0) return 1;
	if (k<0) return -1;
	else{
		Integer learn1, learn2;
		learn1=this.character.get_learn();
		learn2=d.character.get_learn();
		k=learn1.compareTo(learn2);
		if (k>0) return 1;
		else return -1;
     }
  }
}
