package lab3;
import lab3.Dog;
import lab3.Ride_character;
import java.util.Scanner;
import java.util.*;

class Sled_dog extends Dog implements Command{
	private Ride_character<Double> ride_character;
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