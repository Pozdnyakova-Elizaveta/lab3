package lab3;
import lab3.Man;
import lab3.Dog;
class Man_with_sled_dog extends Man{
	protected Sled_dog his_sled_dog;
	public Man_with_sled_dog(String s, Inf inf, Look look, Character character, Needs needs, Command_know command_know, Ride_character<Double> ride_character){
		super(s);
		his_sled_dog = new Sled_dog(inf, look, character, needs, command_know, ride_character);
	}
	public double moving(int hour){
		double distance = hour * his_sled_dog.get_ride_character().get_speed();
		return distance;
	}
	public void moving_output(double distance){
		System.out.println(surname+" проехал в упряжке "+distance+" км");
	}
}