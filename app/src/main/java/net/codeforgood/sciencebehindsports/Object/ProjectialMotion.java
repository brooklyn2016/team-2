import java.lang.Math;

public class ProjectialMotion {
	final double GRAVITY = 9.81;
	private double velocity;
	private double angle;

	public ProjectialMotion(double velocity, double angle) {
		this.velocity = velocity;
		this.angle = Math.toRadians(angle);

	}
	
	public double maxHeight(){
		double time;
		time = flightTime();
		double height;
		height = (velocity*Math.sin(angle)*time) - (0.5*GRAVITY*time*time);
		return Math.round(height*100.0)/100.0;
		
	}
	
	public double range(){
		double range;
		range = ((velocity*velocity)/GRAVITY)*Math.sin(2*angle);
		return Math.round(range*100.0)/100.0;
		
	}
	
	//time to reach top of trajectory (i.e. half full flight time)
	private double flightTime(){
		double time;
		time = velocity*Math.sin(angle)/GRAVITY;
		return Math.round(time*100.0)/100.0;
	}
	 
	public double actualFlightTime(){
		return flightTime()*2;
	}
	
	
	
}
