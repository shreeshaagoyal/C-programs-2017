public class Game {
    public void playGame() {
        Ball ball = new Ball();
        ball.setSpeed(10);
        passBall(ball);
        ball.setSpeed(30);
    }

    public void passBall(Ball ball) {
        ball.setSpeed(ball.getSpeed() + 5);
        catchBall(ball);
        System.out.println("ball speed: " + ball.getSpeed());
    }

    public void catchBall(Ball ball) {
        Ball newBall = new Ball();
        newBall.setSpeed(40);
        newBall.setSpeed(0);
        System.out.println("newBall speed: " + newBall.getSpeed());
        ball = newBall;
        System.out.println("ball speed: " + ball.getSpeed());
        System.out.println("Caught the Ball");
    }
}