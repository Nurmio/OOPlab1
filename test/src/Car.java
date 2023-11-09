import java.awt.*;

public class Car implements Movable{
    protected double[] pos = new double[2];
    protected int direction = 0;
    protected int nrDoors; // Number of doors on the car vroom
    protected double currentSpeed; // The current speed of the car
    protected double enginePower; // Engine power of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

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
    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        //SAAB was missing math.min()
    }
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        //SAAB was missing math.max()
    }

    public double[] getPos(){
        return pos;
    }
    //int[] pos = new int[2];

    public void move(){
        switch(getDirection()){
            case 0:
                pos[1]+=getCurrentSpeed();
                break;
            case 1:
                pos[0]+=getCurrentSpeed();
                break;
            case 2:
                pos[1]-=getCurrentSpeed();
                break;
            case 3:
                pos[0]-=getCurrentSpeed();
                break;
        }
    }
    public void turnLeft(){
        direction = ((((getDirection()-1) % 4) + 4) % 4);
    }
    public void turnRight(){
        direction = (getDirection() +1)%4;
    }
    public int getDirection(){return direction;}
    public void gas(double amount){
        incrementSpeed(Math.min(Math.abs(amount),1));
    }

    public void brake(double amount){
        decrementSpeed(Math.max(amount,0));
    }

    double speedFactor(){
        return enginePower * 0.01;
    }
}
