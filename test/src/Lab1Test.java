import org.junit.Test;
import org.junit.Before;
import java.awt.*;
import static org.junit.Assert.*;

public class Lab1Test {

    private Saab95 setSaab;
    private Volvo240 setVolvo;
    @Before
    public void init()
    {
         setSaab = new Saab95();
         setVolvo = new Volvo240();
    }

    @Test
    public void TestTurnTurboON() {
        setSaab.setTurboOn();
        assertTrue(setSaab.getTurboStatus());
    }
    @Test
    public void TestTurnTurboOF(){
        setSaab.setTurboOn();
        setSaab.setTurboOff();
        assertTrue(!setSaab.getTurboStatus());
    }
    @Test
    public void TestTurningLeft(){
        setSaab.turnLeft();
        assertTrue("dir: "+ setSaab.getDirection(),setSaab.getDirection() == 3);
    }
    @Test
    public void TestTurningRight(){
        setSaab.turnRight();
        assertTrue("dir: " + setSaab.getDirection(),setSaab.getDirection() == 1);

    }
    @Test
    public void TestMoveForwardWithoutStartingEngine(){
        setSaab.move();
        assertTrue(setSaab.getPos()[0] == 0 && setSaab.getPos()[1] == 0);
    }
    @Test
    public void TestMoveForwardWithStartedEngine(){
        setSaab.startEngine();
        setSaab.move();
        assertTrue("x: " + setSaab.getPos()[0] + " y: " + setSaab.getPos()[1],setSaab.getPos()[0] == 0 && setSaab.getPos()[1] == 0.1);
    }

    @Test
    public void TestVolvoSpeedFactorWhileStandingStill(){
        assertTrue(String.valueOf(0.01*setVolvo.enginePower*setVolvo.getTrimFactor()),setVolvo.speedFactor() == 0.01*setVolvo.enginePower*setVolvo.getTrimFactor());
    }
    @Test
    public void TestSaabSpeedFactorWhileStandingStill(){
        assertTrue(0.01*setSaab.enginePower + " " + setSaab.speedFactor(),setSaab.speedFactor()== 0.01*setSaab.enginePower);
    }

    @Test
    public void TestGas(){
        setSaab.startEngine();
        setSaab.gas(1);
        assertTrue(setSaab.currentSpeed > 0.1);
    }
    @Test
    public void TestBreak(){
        setSaab.startEngine();
        System.out.println(setSaab.getCurrentSpeed());
        setSaab.gas(1);
        System.out.println(setSaab.getCurrentSpeed());
        setSaab.gas(1);
        System.out.println(setSaab.getCurrentSpeed());
        setSaab.brake(1);
        System.out.println(setSaab.getCurrentSpeed());
        setSaab.brake(1);
        System.out.println(setSaab.getCurrentSpeed());
        assertTrue(""+setSaab.currentSpeed, 0.09<= setSaab.getCurrentSpeed() && setSaab.getCurrentSpeed() <= 0.11);
    }

    @Test
    public void TestMovesToStartingPos(){
        setSaab.startEngine();
        setSaab.gas(1);
        for (int i = 0; i < 4; i++) {
            setSaab.move();
            setSaab.turnRight();
        }
        setSaab.brake(1);
        for (int i = 0; i < 4; i++) {
            setSaab.move();
            setSaab.turnLeft();
        }
        assertTrue(setSaab.getPos()[0] == 0 && setSaab.getPos()[1] == 0);

    }
    @Test
    public void TestGetColorAndNrOfDoors(){
        assertTrue(setSaab.getNrDoors()== 2&& setSaab.getColor()== Color.red);
    }


}
