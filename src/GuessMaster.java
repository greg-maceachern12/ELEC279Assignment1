import java.util.ArrayList;
import java.util.Random;

public class GuessMaster {

	static ArrayList<Entity> entityList = new ArrayList<>();
	static ArrayList<Integer> nums = new ArrayList<>();
	private static int count = 0;
	private static int newNum = 0;
	
	public static void main(String [] args) {
		
		Entity Celine = new Entity("Celine Dion",new Date("March", 30, 1968));
		Entity Trudeau = new Entity("Justin Trudeau",new Date("December",25,1971));
		Entity usa = new Entity("United States", new Date("July", 14, 1776));
		
		GuessMaster gm = new GuessMaster();
		gm.addEntity(Trudeau);
		gm.addEntity(Celine);
		gm.addEntity(usa);
		
		playGame();
	}
	public void addEntity(Entity entity) {
		entityList.add(entity);
		nums.add(0);
		
	}
	public static void playGame(Entity entity) {
		Date born = new Date(entity.getBorn(entity));
		System.out.println("Guess "+ entity.getName(entity)+ "'s birthday!");
		
		Date enteredDate = new Date();
		enteredDate.readInput();
		
		if(enteredDate.equals(born)) {
			System.out.println("Correct!");
			count++;
			nums.set(newNum, 1);
			if (count != entityList.size())
				playGame();
			else {
				System.out.println("You Won The Game!!!");
			}
		}
		else if (enteredDate.precedes(born)) {
			System.out.println("To Low! Guess again");
			playGame(entity);
		}
		else if(born.precedes(enteredDate)) {
			System.out.println("To High! Guess again");
			playGame(entity);
		}
		
	}
	public void playGame(int entityInd) {
		Entity newEnt = new Entity(entityList.get(entityInd));
		playGame(newEnt);
	}
	public static void  playGame() {
		int index = genRandomEntityInd();
		Entity newEnt = new Entity(entityList.get(index));
		playGame(newEnt);
		
	}
	static int genRandomEntityInd() {
		Random rand = new Random();
		newNum = rand.nextInt(entityList.size());
		System.out.println(newNum);
		System.out.println(nums);
		System.out.println(entityList);
		if (nums.get(newNum) == 1) {
			genRandomEntityInd();
		}
		return newNum;
		
	}
}
