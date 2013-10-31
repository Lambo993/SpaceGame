package io.github.lambo993.game;

import java.awt.*;
import java.util.Random;

public class Enemy implements Entity {

	private int x, y, xVelocity, yVelocity;

	public Enemy() {
        setX(400);
        setY(50);
        Random rng = new Random();
        xVelocity = -1 + rng.nextInt(3);
        yVelocity = -1 + rng.nextInt(3);
        if (xVelocity == 0 && yVelocity == 0) {
            xVelocity = 1;
            yVelocity = 1;
        }
    }

	@Override
	public void run() {
		while (true) {
			move(0, 5, 790, 590);
			try {
				Thread.sleep(5);
			} catch (InterruptedException ex) {
				System.err.println("Error: Thread Interrupted.");
			}
		}
	}

	@Override
	public void move(int xMin, int yMin, int xMax, int yMax) {
		x += xVelocity;
		y += yVelocity;
		if (getX() < xMin) {
			xVelocity = 1;
		}
		if (getX() > xMax) {
			xVelocity = -1;
		}
		if (getY() < yMin) {
			yVelocity = 1;
		}
		if (getY() > yMax) {
			yVelocity = -1;
		}
	}

	@Override
	public void draw(Graphics g) { //TODO: Get Own Graphics
		g.setColor(Color.RED);
		g.fillOval(getX(), getY(), 10, 10);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public Rectangle getHitbox() {
		return new Rectangle(getX(), getY(), 10, 10);
	}

	@Override
	public String toString() {
		return "Enemy";
	}
}