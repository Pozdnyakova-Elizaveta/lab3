package lab3;
import java.io.*;
import lab3.Dog;
import lab3.Ride_character;
import java.util.Scanner;
import java.util.*;

class Sled_dog extends Dog implements Command{
	public Ride_character<Double> ride_character;
	public Sled_dog(Inf inf, Look look, Character character, Needs needs, Command_know command_know, Ride_character<Double> ride_character){
		super(inf, look, character, needs, command_know);	
		this.ride_character=ride_character;
	}
	public Sled_dog() {};
	public void command(){
		System.out.println("Тренируем...");
		try{
			Thread.sleep((5 - character.get_learn()) * 4000);
		}catch (InterruptedException e) {}
		ride_character.set_speed(ride_character.get_speed()+1);
	}
	public void read(Scanner in){
		super.read(in);
		ride_character.set_speed(4.5);
		ride_character.set_max_way(50.0);
	}
	public static void work_massiv_sled(Sled_dog a[]){
		String name, breed,color,color_eye,s,c[];
     		int age, learn;
     		boolean friendly;
		try{File f = new File("D:\\Работы\\laba3\\lab3\\spisok2.txt");
		if (!f.exists()) throw new IOException("Не удалось открыть файл");
	   	FileReader fr = new FileReader(f);
        	Scanner scan=new Scanner(fr);
        	for (int i=0; i<2; i++){
        		s=scan.nextLine();
			c=s.split(" ");
        		name=c[0];
        		age=Integer.parseInt(c[1]);
        		breed=c[2];
        		color=c[3];
        		color_eye=c[4];
        		friendly=Boolean.valueOf(c[5]);
        		learn=Integer.parseInt(c[6]);
        		Look look = new Look(color, color_eye);
        		Character character = new Character(friendly, learn);
			Inf inf = new Inf(name, age, breed);
			Command_know command_know = new Command_know();
           	Needs needs = new Needs();
			Ride_character<Double> ride= new Ride_character<Double>(4.3, 55.6);
			a[i]=new Sled_dog();
           	a[i].inf=inf;
			a[i].character = character;
			a[i].look=look;
			a[i].needs=needs;
			a[i].command_know=command_know;
			a[i].ride_character=ride;
			System.out.println(a[i].toString());
		}
		}catch(IOException ex){System.out.println(ex.getMessage());}
	}
	public Ride_character<Double> get_ride_character(){return ride_character;};
	public String toString(){
		String s="";
		s=s+inf.toString()+"\n";
		s=s+look.toString()+"\n";
		s=s+character.toString()+"\n";
		s=s+command_know.toString()+"\n";
		s=s+needs.toString()+"\n";
		s=s+ride_character.toString()+"\n";
		return s;
	}
	public void number_skills(){
		int n = 0;
		if (command_know.get_lie()) n=n+1;
		if (command_know.get_to_me()) n=n+1;
		if (command_know.get_sit()) n=n+1;
		n=n+1;
		System.out.println("Собака "+inf.get_name()+" имеет "+n+" навыков");
	}

}