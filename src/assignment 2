import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class World {

	private Sprite water;
	private Sprite grass;
	private Sprite player;
	private Sprite bus;
	private ArrayList<Sprite> buslist1;
	private ArrayList<Sprite> buslist2;
	private ArrayList<Sprite> buslist3;
	private ArrayList<Sprite> buslist4;
	private ArrayList<Sprite> buslist5;
	private ArrayList<Sprite> buslist;
	private ArrayList<Sprite> waterlist;
	private final int PIXEL_SIZE;
	private final int WATER_COOR;
	private final int X_RESOLUTION;
	private final int busarray[] = { 48, 0, 64, 128, 250 };
	private final double gap[] = { 6.5, 5, 12, 5, 6.5 };
	private final int busY[] = { 432, 480, 528, 576, 624 };

	public World() throws SlickException {
		// init that setups variable and objects stored
		buslist1 = new ArrayList<Sprite>();
		buslist2 = new ArrayList<Sprite>();
		buslist3 = new ArrayList<Sprite>();
		buslist4 = new ArrayList<Sprite>();
		buslist5 = new ArrayList<Sprite>();
		buslist = new ArrayList<Sprite>();
		waterlist = new ArrayList<Sprite>();
		this.player = new Sprite("assets/frog.png", 512, 720);
		this.PIXEL_SIZE = 48;
		this.WATER_COOR = 336;
		this.X_RESOLUTION = 1024;
		int i;
		int j;
		// water init and add to water arraylist
		for (j = WATER_COOR; j >= PIXEL_SIZE; j -= PIXEL_SIZE) {
			for (i = 0; i <= X_RESOLUTION; i += PIXEL_SIZE) {
				this.water = new Sprite("assets/water.png", i, j);
				waterlist.add(this.water);
			}
		}
		// bus init and add to bus arraylist for each diffrent row
		for (i = busarray[0]; i < X_RESOLUTION; i += (gap[0] * PIXEL_SIZE)) {
			this.bus = new Sprite("assets/bus.png", i, busY[0]);
			this.buslist1.add(this.bus);
			buslist.add(this.bus);
		}
		for (i = busarray[1]; i < X_RESOLUTION; i += (gap[1] * PIXEL_SIZE)) {
			this.bus = new Sprite("assets/bus.png", i, busY[1]);
			this.buslist2.add(this.bus);
			buslist.add(this.bus);
		}
		for (i = busarray[2]; i < X_RESOLUTION; i += (gap[2] * PIXEL_SIZE))

		{
			this.bus = new Sprite("assets/bus.png", i, busY[2]);
			this.buslist3.add(this.bus);
			buslist.add(this.bus);
		}

		for (i = busarray[3]; i < X_RESOLUTION; i += (gap[3] * PIXEL_SIZE)) {
			this.bus = new Sprite("assets/bus.png", i, busY[3]);
			this.buslist4.add(this.bus);
			buslist.add(this.bus);
		}

		for (i = busarray[4]; i < X_RESOLUTION; i += (gap[4] * PIXEL_SIZE)) {
			this.bus = new Sprite("assets/bus.png", i, busY[4]);
			this.buslist5.add(this.bus);
			buslist.add(this.bus);

		}
	}

	public void update(Input input, int delta) {
		// update for the player model-frog
		this.player.update(input, delta);
		// for each bus in each row a different update is done
		for (Sprite bus : buslist1) {
			bus.busupdate1(input, delta);
		}
		for (Sprite bus : buslist2) {
			bus.busupdate2(input, delta);
		}
		for (Sprite bus : buslist3) {
			bus.busupdate1(input, delta);
		}
		for (Sprite bus : buslist4) {
			bus.busupdate2(input, delta);
		}
		for (Sprite bus : buslist5) {
			bus.busupdate1(input, delta);
		}
		for (Sprite bus : buslist) {
			this.player.contactSprite(bus);
		}
		for (Sprite water : waterlist) {
			this.player.contactSprite(water);
		}
	}

	public void render(Graphics g) throws SlickException {
		int i;

		// Water rendering
		for (Sprite water : waterlist) {
			water.render();
		}
		// grass rendering

		for (i = 0; i <= X_RESOLUTION; i += PIXEL_SIZE) {
			this.grass = new Sprite("assets/grass.png", i, busY[0] - PIXEL_SIZE);
			this.grass.render();
			this.grass = new Sprite("assets/grass.png", i, busY[4] + PIXEL_SIZE);
			this.grass.render();
		}
		// player rendering
		this.player.render();

		// bus rendering
		for (Sprite bus : buslist1) {
			bus.render();
		}
		for (Sprite bus : buslist2) {
			bus.render();
		}
		for (Sprite bus : buslist3) {
			bus.render();
		}
		for (Sprite bus : buslist4) {
			bus.render();
		}
		for (Sprite bus : buslist5) {
			bus.render();
		}

	}
}
