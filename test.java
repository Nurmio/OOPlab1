import org.junit.jupiter.api.Test;

class CarTest{

    private final Volvo240 volvo = new Volvo240();
    private final Saab95 saab = new Saab95();

    @Test
    void turnTurboON() {
        volvo.startEngine();//(wroooom)
        //for (int i = 0; i < 80; i++) {
            volvo.gas(10);
            System.out.println(volvo.getCurrentSpeed());
        //}

    }

}