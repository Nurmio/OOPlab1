interface Movable {
    double[] pos = new double[2];
    int[] direction = new int[1];
    void move();
    void turnLeft();
    void turnRight();
}
