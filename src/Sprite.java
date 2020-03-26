import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Sprite {
	private Image spriteImage;
	private String imageSrc;
	private float x;
	private float y;
	private BoundingBox hitbox;
	private final int PIXEL = 48;
	private final int X_RES = 1024;
	private final int Y_RES = 768;
	private final double busSpeed = 0.15;

	public Sprite(String imageSrc, float x, float y) throws SlickException {
		// Sprite Constructor that sets x y coordinate ,image path and its hitbox
		this.imageSrc = imageSrc;
		this.x = x;
		this.y = y;
		this.spriteImage = new Image(this.imageSrc);
		hitbox = new BoundingBox(this.spriteImage, this.x, this.y);
	}

	public void busupdate1(Input input, int delta) {
		// frame updates for row 1 ,3,5 buses
		hitbox = new BoundingBox(this.spriteImage, this.x, this.y);
		this.x += busSpeed * delta;
		if (this.x > X_RES) {
			this.x = 0;
		}
	}

	public void busupdate2(Input input, int delta) {
		// frame updates for row 2,4 buses
		hitbox = new BoundingBox(this.spriteImage, this.x, this.y);
		this.x -= busSpeed * delta;
		if (this.x < 0) {
			this.x = X_RES;
		}
	}

	public void update(Input input, int delta) {
		// the update from user input on the frog
		hitbox = new BoundingBox(this.spriteImage, this.x, this.y);
		if (input.isKeyPressed(Input.KEY_UP)) {
			if (this.y > PIXEL) {
				this.y -= PIXEL;
			}
		}
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			if (this.y < Y_RES - PIXEL)
				this.y += PIXEL;
		}

		if (input.isKeyPressed(Input.KEY_LEFT)) {
			if (this.x >= PIXEL) {
				this.x -= PIXEL;
			}
		}
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			if (this.x < X_RES - PIXEL) {
				this.x += PIXEL;
			}
		}

	}

	public void render() {
		// render image at the x,y coordinate
		this.spriteImage.draw(this.x, this.y);
	}

	public void contactSprite(Sprite other) {
		// called when one sprite makes contact with another,exit the game when do.
		if (this.hitbox.intersects(other.hitbox)) {
			System.exit(0);
		}
	}
}
