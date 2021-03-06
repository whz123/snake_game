package whz.entity;

import java.awt.Point;

import whz.util.Global;

public class Snake_2 extends Snake {
	public static final int type =2;
	
	public int sleep =100;
	
	public void setSleep(int sleep) {
		this.sleep = sleep;
	}

	public int getSleep() {
		return sleep;
	}
	public void init() {
		food = 0;
		body.clear();
		life = true;
		int x = 76;
		int y = 0;
		for (int i = 0; i < 4; i++) {
			body.add(new Point(x + i, y));
		}
		oldDirection = newDirection = Global.LEFT;
	}

	public void start() {
		new Snake_2Drive().start();
	}
    
	public void move() {
		System.out.println("Snake is moving");
		tail = body.removeLast();
		int x = body.getFirst().x;
		int y = body.getFirst().y;
		if (oldDirection + newDirection != 0) {
			oldDirection = newDirection;
		}
		switch (oldDirection) {
		case Global.UP:
			y--;
			if (y < 0) {
				y = Global.DOUBLE_HEIGHT - 1;
			}
			break;
		case Global.DOWN:
			y++;
			if (y >= Global.DOUBLE_HEIGHT) {
				y = 0;
			}
			break;
		case Global.LEFT:
			x--;
			if (x < 0) {
				x = Global.DOUBLE_WIDTH - 1;
			}
			break;
		case Global.RIGHT:
			x++;
			if (x >= Global.DOUBLE_WIDTH) {
				x = 0;
			}
			break;
		case Global.UP_LEFT:
			x--;
			y--;
			if(x<0) {
				x=Global.DOUBLE_WIDTH-1;
			}
			if(y<0) {
				y=Global.DOUBLE_HEIGHT-1;
			}
			break;
		case Global.UP_RIGHT:
			x++;
			y--;
			if(x>=Global.DOUBLE_WIDTH) {
				x=0;
			}
			if(y<0) {
				y=Global.DOUBLE_HEIGHT-1;
			}
			break;
		case Global.DOWN_LEFT:
			x--;
			y++;
			if(x<0) {
				x=Global.DOUBLE_WIDTH-1;
			}
			if(y>=Global.DOUBLE_HEIGHT) {
				y=0;
			}
			break;
		case Global.DOWN_RIGHT:
			x++;
			y++;
			if(x>=Global.DOUBLE_WIDTH) {
				x=0;
			}
			if(y>=Global.DOUBLE_HEIGHT) {
				y=0;
			}
			break;
		}
		body.addFirst(new Point(x, y));
	}
	
	public void eatFood() {
		System.out.println("Snake is eating food");
		body.addLast(tail);
	}
	
	private class Snake_2Drive extends Thread {
		@Override
		public void run() {
			while (life) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				move();
				snakeListener.snakeMove(Snake_2.this);
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
