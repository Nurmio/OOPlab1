import java.awt.*;

public class Car implements Movable{
    public int nrDoors; // Number of doors on the car vroom
    public double currentSpeed; // The current speed of the car
    public double enginePower; // Engine power of the car
    public Color color; // Color of the car
    public String modelName; // The car model name


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
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    //int[] pos = new int[2];

    public void move(int[] direction){
        switch(direction[0]){
            case 0:
                pos[1]++;
            case 1:
                pos[0]++;
            case 2:
                pos[1]--;
            case 3:
                pos[0]--;
        }
    }
    public void turnLeft(){
        direction[0] = (direction[0] -1)%4;
    }
    public void turnRight(){
        direction[0] = (direction[0] +1)%4;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    double speedFactor(){
        return enginePower * 0.01;
    }


}
