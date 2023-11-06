import java.awt.*;
public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(){
        nrDoors = 2;
        setColor(Color.red);
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
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
