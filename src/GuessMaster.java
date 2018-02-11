import java.util.ArrayList;
import java.util.Random;

public class GuessMaster {

	static ArrayList<Entity> entityList = new ArrayList<>(); // arraylist to store entities
	static ArrayList<Integer> nums = new ArrayList<>(); // Array list to determine if an entity has already been used
	private static int count = 0;
	private static int newNum = 0;

	public static void main(String[] args) {
		// creating new entities
		Entity Celine = new Entity("Celine Dion", new Date("March", 30, 1968));
		Entity Trudeau = new Entity("Justin Trudeau", new Date("December", 25, 1971));
		Entity usa = new Entity("United States", new Date("July", 14, 1776));

		GuessMaster gm = new GuessMaster();
		// generating the entities. Adds them to the entity list and the counter list
		gm.addEntity(Trudeau);
		gm.addEntity(Celine);
		gm.addEntity(usa);

		playGame();
	}

	// adds them to the entity list and increases the number of entities list
	public void addEntity(Entity entity) {
		entityList.add(entity);
		nums.add(0);

	}

	public static void playGame(Entity entity) {
		// get the birthdate of the entity
		Date born = new Date(entity.getBorn(entity));
		System.out.println("Guess " + entity.getName(entity) + "'s birthday!");

		// this stores the users entered date into a date variable.
		Date enteredDate = new Date();
		enteredDate.readInput();

		// checking if the entered Date is less than, greater than or equal to the
		// entities birthdate
		if (enteredDate.equals(born)) {
			System.out.println("BINGO!!!! You got it!");
			count++;
			nums.set(newNum, 1);
			if (count != entityList.size())
				playGame();
			else {
				System.out.println("You Won The Game!!! \n");
			}
		} else if (enteredDate.precedes(born)) {
			System.out.println("Incorrect.  Try a later date. \n");
			playGame(entity);
		} else if (born.precedes(enteredDate)) {
			System.out.println("Incorrect.  Try a earlier date. \n");
			playGame(entity);
		}

	}

	public void playGame(int entityInd) {

		// given an entity index, play the game using the entity at the index
		Entity newEnt = new Entity(entityList.get(entityInd));
		playGame(newEnt);
	}

	public static void playGame() {
		// pick a random entity and play the game using that entity.
		int index = genRandomEntityInd();
		Entity newEnt = new Entity(entityList.get(index));
		playGame(newEnt);

	}

	static int genRandomEntityInd() {
		// generate a number between 0-2 and use that as an index for the entity list.
		Random rand = new Random();
		newNum = rand.nextInt(entityList.size());
		// if the index has not been selected, it will use that # and store that # in
		// the nums arraylist to ensure there are no duplicate questions
		if (nums.get(newNum) == 1) {
			genRandomEntityInd();
		}
		return newNum;

	}
}
