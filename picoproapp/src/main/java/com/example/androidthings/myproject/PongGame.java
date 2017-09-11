package com.example.androidthings.myproject;

/**
 * Created by lily on 9/10/17.
 */

public class PongGame {
    private int width;
    private int height;
    private double paddle_y;
    private final int paddle_h = 180;
    final int PADDLE_THICKNESS = 10;
    final int PADDLE_MARGIN = 10;
    private double ball_x;
    private double ball_y;
    private final int ball_r = 12;
    private double dx;
    private double dy;
    private boolean ballIsMoving;
    private final int PADDLE_VELOCITY = 20;
    private CharList stringScore;
    PongGame(int w, int h) {
        width = w;
        height = h;
        ballIsMoving = true;
        paddle_y = paddle_h;
        ball_x = width * 0.5;
        ball_y = height * 0.5;
        dx = 13;
        dy = 7;
        stringScore = new CharList();
    }

    private void resetGame() {
        ballIsMoving = false;
        ball_x = width * 0.5;
        ball_y = height * 0.5;
    }

    private void bounceBall() {
        dx *= -1;
        stringScore.incrementLastChar();
    }

    void activateGame() {
        ballIsMoving = true;
    }

    void updateBall() {
        if (ballIsMoving) {
            if (ball_x < 0) { resetGame(); return; }
            if ((ball_x - ball_r) <= (PADDLE_MARGIN + PADDLE_THICKNESS) && (ball_x - ball_r) >= PADDLE_MARGIN
                    && ball_y - ball_r <= paddle_y + 0.5 * paddle_h
                    && ball_y + ball_r >= paddle_y - 0.5 * paddle_h) {
                bounceBall();
            }
            else if (ball_x > width) { dx *= -1; }
            else if (ball_y > height || ball_y < 0) { dy *= -1; }
            ball_x += dx;
            ball_y += dy;
        }
    }

    void movePaddleDown() {
        System.out.println(paddle_y);
        if (paddle_y + paddle_h * 0.5 < (height - PADDLE_VELOCITY)) {
            paddle_y += PADDLE_VELOCITY;
        } else {
            paddle_y = height - paddle_h * 0.5;
        }
    }

    void movePaddleUp() {
        System.out.println(paddle_y);
        if (paddle_y - paddle_h * 0.5 > PADDLE_VELOCITY) {
            paddle_y -= PADDLE_VELOCITY;
        } else {
            paddle_y = paddle_h * 0.5;
        }
    }

    void advanceScore() {
        stringScore.advanceChar();
    }

    double getPaddleY() {
        return paddle_y;
    }

    int getPaddleHeight() {
        return paddle_h;
    }

    double getBallX() {
        return ball_x;
    }

    double getBallY() {
        return ball_y;
    }

    int getBallR() {
        return ball_r;
    }

    String getStringScore() {
        return stringScore.getString();
    }

}
