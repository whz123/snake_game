package whz.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import whz.util.Global;

/*
 * Barrier
 * Ways of Barrier:
 * 1.isEatenBySelf()
 * 2.drawSelf()
 * 
 */

public class Barrier {
	private int[][] rocks = new int[Global.WIDTH][Global.HEIGHT];

	public Barrier() {
		for (int y = 0; y < Global.HEIGHT; y++) {
			for (int x = 0; x < Global.WIDTH; x++) {
				if (y == 0 || y == Global.HEIGHT - 1) {
					rocks[x][y] = 1;
				}
				if (x == 0 || x == Global.WIDTH - 1) {
					rocks[x][y] = 1;
				}
			}
		}
	}

	public boolean isEatenBySnake(Snake snake) {
		System.out.println("The barrier isn't touched by the snake");
		Point head = snake.getHead();
		for (int x = 0; x < Global.WIDTH; x++) {
			for (int y = 0; y < Global.HEIGHT; y++) {
				if (rocks[x][y] == 1 && head.x == x && head.y == y) {
					return true;
				}
			}
		}
		return false;
	}

	public void drawSelf(Graphics g) {
		System.out.println("Barrier is drawing itself");
		g.setColor(Color.yellow);
		for (int y = 0; y < Global.HEIGHT; y++) {
			for (int x = 0; x < Global.WIDTH; x++) {
				if (rocks[y][x] == 1) {
					
					g.fill3DRect(x * Global.CELL_SIZE, y * Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
				}
			}
		}
	}

	public int[][] getRocks() {
		return this.rocks;
	}
}
