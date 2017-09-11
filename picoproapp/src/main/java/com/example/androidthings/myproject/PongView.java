package com.example.androidthings.myproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by lily on 9/10/17.
 */

public class PongView extends View {
    private int height;
    private int width;
    private PongGame game;
    Bitmap bitmap;
    Bitmap background;
    Canvas canvas;
    Paint paddlePaint;
    Paint ballPaint;
    Paint textPaint;
    public PongView(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels;
        game = new PongGame(width, height);
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        Bitmap unscaledBackground = BitmapFactory.decodeResource(getResources(), R.drawable.idd_pong);
        float imageRatio = (float) unscaledBackground.getWidth() / (float) unscaledBackground.getHeight();
        int realHeight = (int) (width / imageRatio);
        background = Bitmap.createScaledBitmap(unscaledBackground, width, realHeight, true);
        paddlePaint = new Paint();
        paddlePaint.setARGB(255, 255, 255, 255);
        ballPaint = new Paint();
        ballPaint.setARGB(255, 255, 255, 255);

        Typeface spaceMono = Typeface.createFromAsset(context.getResources().getAssets(),"fonts/SpaceMono-Bold.ttf");

        textPaint = new Paint();
        textPaint.setARGB(255, 255, 255, 255);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(64);
        textPaint.setTypeface(spaceMono);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        game.updateBall();
        canvas.drawBitmap(background, 0, 0, null);
        canvas.drawRect(
                game.PADDLE_MARGIN,
                (int)(game.getPaddleY() - game.getPaddleHeight() * 0.5),
                game.PADDLE_MARGIN + game.PADDLE_THICKNESS,
                (int)(game.getPaddleY() + game.getPaddleHeight() * 0.5),
                paddlePaint
        );
        canvas.drawCircle(
                (int)game.getBallX(),
                (int)game.getBallY(),
                game.getBallR(),
                paddlePaint
        );
        canvas.drawText(game.getStringScore(), width / 2, 80, textPaint);
        invalidate();
    }

    void movePaddleUp() {
        game.movePaddleUp();
    }

    void movePaddleDown() {
        game.movePaddleDown();
    }

    void reactivateGame() {
        game.activateGame();
    }

    void advanceScore() {
        game.advanceScore();
    }
}
