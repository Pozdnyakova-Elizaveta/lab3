package lab3;
import java.util.Scanner;
import java.io.*;
class Ride_character<T>{
	private T speed;
	private T max_way;
	public Ride_character(T speed, T max_way){
		this.speed=speed;
		this.max_way=max_way;
	}
	public Ride_character(){};
	public String toString(){
		String s="Скорость собаки - "+speed+" км/ч, максимально с ней можно пройти "+max_way+" км";
		return s;
         
     }
	void set_speed(T a){speed=a;};
	void set_max_way(T a){max_way=a;};
	T get_speed() { return speed; };
	T get_max_way() { return max_way; };
}