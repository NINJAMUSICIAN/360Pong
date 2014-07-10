import java.awt.Rectangle;

public abstract class Entity{
	
	// position and vector
	protected double x;
	protected double y;
	protected double dx;
	protected double dy;
	
	// dimensions
	protected int width;
	protected int height;
	
	// collision box
	protected int cwidth;
	protected int cheight;
	
	// collision
	protected int currRow;
	protected int currCol;
	protected double xdest;
	protected double ydest;
	protected double xtemp;
	protected double ytemp;
	protected boolean topLeft;
	protected boolean topRight;
	protected boolean bottomLeft;
	protected boolean bottomRight;
	
	// animation
	protected Animation animation;
	protected int currentAction;
	protected int previousAction;
	protected boolean facingRight;
	
	// movement
	protected boolean left;
	protected boolean right;
	protected boolean up;
	protected boolean down;
	
	// movement attributes
	protected double moveSpeed;
	protected double maxSpeed;
	protected double stopSpeed;
	
	// constructor
	public Entity() {
		animation = new Animation();
		facingRight = true;
	}
	
	public boolean intersects(Entity o) {
		Rectangle r1 = getRectangle();
		Rectangle r2 = o.getRectangle();
		return r1.intersects(r2);
	}
	
	public boolean intersects(Rectangle r) {
		return getRectangle().intersects(r);
	}
	
	public boolean contains(Entity o) {
		Rectangle r1 = getRectangle();
		Rectangle r2 = o.getRectangle();
		return r1.contains(r2);
	}
	
	public boolean contains(Rectangle r) {
		return getRectangle().contains(r);
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(
				(int)x - cwidth / 2,
				(int)y - cheight / 2,
				cwidth,
				cheight
		);
	}
	
	public int getx() { return (int)x; }
	public int gety() { return (int)y; }
	public double getDX() {return dx;}
	public double getDY(){return dy;}
	public void setDy(double y){dy = y;}
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getCWidth() { return cwidth; }
	public int getCHeight() { return cheight; }
	public boolean isFacingRight() { return facingRight; }
	
	//change this to take in degrees instead of an x y position
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void setLeft(boolean b) { left = b; }
	public void setRight(boolean b) { right = b; }
	public void setUp(boolean b) { up = b; }
	public void setDown(boolean b) { down = b; }
	
	public void draw(java.awt.Graphics g) {
		if(facingRight) {
			g.drawImage(
				animation.getImage(),
				(int)(x - width / 2),
				(int)(y - height / 2),
				null
			);
		}
		else {
			g.drawImage(
				animation.getImage(),
				(int)(x - width / 2 + width),
				(int)(y - height / 2),
				-width,
				height,
				null
			);
		}
		// draw collision box
		//Rectangle r = getRectangle();
		//r.x += xmap;
		//r.y += ymap;
		//g.draw(r);
	}
	
}

