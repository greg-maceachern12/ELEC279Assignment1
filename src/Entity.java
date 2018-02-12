//Property of Gregory MacEachern
//20011768

public class Entity {
	private String name;
	private Date born;

	// Empty Constructor
	public Entity() {
		name = "";
		born = new Date();
	}

	// Constructor to create a person given a string and date
	public Entity(String nameIn, Date dateIn) {
		name = nameIn;
		born = dateIn;
	}

	public Entity(Entity entity) {
		name = entity.getName(entity);
		born = entity.getBorn(entity);
	}

	// Checking if two entities are equal to one another. If they are
	// return true
	public boolean equals(Entity entity) {
		return entity.born.equals(born);

	}

	// accessor for the name of the specified entity
	public String getName(Entity object) {
		return object.name;
	}

	// simple print name method
	public void printPersonsName(Entity object) {
		System.out.println(object.name);
	}

	// The toString constructor
	// Returns the name, the birthdate (month,day,year)
	public void toString(String month, int day, int year, String namePrint, Date bornPrint) {
		System.out.println(namePrint + ", born on " + month + " " + day + ", " + year);
	}

	// accessor for getting the birthdate of the specified entity
	public Date getBorn(Entity object) {
		return object.born;
	}

	// if the date is before the current date
	public boolean precedes(Entity entity) {
		return entity.born.precedes(born);

	}
}