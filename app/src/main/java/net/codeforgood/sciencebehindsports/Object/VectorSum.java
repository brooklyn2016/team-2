import java.lang.Math;
public class VectorSum {
	//I guess we can say that one of the vectors is wind
	// the other vector is the actual football
	private double[] wind;
	private double[] football;
	private double Xsum;
	private double Ysum;
	
	public VectorSum(double x1, double x2, double y1, double y2) {
		this.wind = new double[2];
		wind[0] = x1;
		wind[1] = y1;
		this.football = new double[2];
		football[0] = x2;
		football[1] = y2;
	
		Xsum = wind[0] + wind[1];
		Ysum = football[0] + football[1];
	}
	
	public String Sum(){
		return "X component: " + (Double.toString(Xsum)) + 
				"Y component: " + (Double.toString(Ysum));
	}
	public double getVelocity(){
		double xsquare = Math.pow(Xsum, 2);
		double ysquare = Math.pow(Ysum, 2);
		return xsquare + ysquare;
	
		
	}
	public double getAngle(){
		double temp = Math.atan(Ysum/Xsum);
		return Math.toDegrees(temp);
	}
	
	public void getInfo(){
		ProjectialMotion Project = new ProjectialMotion(getVelocity(), getAngle());
		System.out.println(Project.actualFlightTime());
		System.out.println(Project.maxHeight());
		System.out.println(Project.range());
		
	}
	

}
