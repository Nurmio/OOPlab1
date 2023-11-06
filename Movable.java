interface Movable {
    int[] pos = new int[2];
    int[] direction = new int[1];
    void move(int[] direction);
    void turnLeft();
    void turnRight();
}
