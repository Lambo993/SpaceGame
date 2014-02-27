package io.github.lambo993.game;

/**
 * @author Lamboling Seans
 */
public enum Achievements {

	UNKNOWN(-1, null),
	BACK_WAY(1, "Back Way: Got ambused by an enemy from back of the ship"),
	MY_LOVE(2, "My Love: Shoots a power up"),
	RIGHT_CLICK(3, "Right Clicked: It wont do anything anyway");

	private int id;
	private String name;
	private boolean isUnlocked = false;

	private Achievements(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void unlock() {
		if (!isUnlocked()) {
			System.out.println("Achievements unlocked! " + getName());
			setUnlocked(true);
		}
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isUnlocked() {
		return isUnlocked;
	}

	public void setUnlocked(boolean unlocked) {
		if (isUnlocked() != unlocked) {
			isUnlocked = unlocked;
		}
	}
}