package lab3;
abstract class Man{
	protected String surname;
	public Man(String s){surname=s;}
	public abstract double moving(int hour);
	public abstract void moving_output(double distance);
}