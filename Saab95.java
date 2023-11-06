import java.awt.*;

public class Saab95{

    public boolean turboOn;
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    
    public Saab95(){
        nrDoors = 2;
        setColor(Color.red);
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }
    
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    @Override double speedFactor(){
        double turbo = 1;
        if(turboOn)
            turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
