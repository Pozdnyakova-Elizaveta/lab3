package lab3;
import lab3.Man;
import lab3.Dog;
class Man_with_dog extends Man{
	protected Dog his_dog;
	protected double speed_walk;
	public Man_with_dog(String s, Inf inf, Look look, Character character, Needs needs, Command_know command_know, double speed){
		super(s);
		speed_walk = speed;
		his_dog = new Dog(inf, look, character, needs, command_know);
	}
	public double moving(int hour){
		double distance = hour * speed_walk;
		return distance;
	}
	public void moving_output(double distance){
		System.out.println(surname+" прошел с собакой "+distance+" км");
	}
}