public class Person implements Comparable<Person>
{
	/***** TODO: (Part 2) create helper inner class for Identity*****/

	// CONSTANT VARIABLES
	public static final String DEFAULT_NAME = "Jamie Doe";
	public static final String DEFAULT_STORY =  "Unknown";
	public static final int DEFAULT_PRIVILEGE = 100;

	// INSTANCE VARIABLES
	private String name, story;
	private Identity identity;
	private int privilege;

	// CONSTRUCTORS	
	public Person(String name, String story, int privilege) {
		this.setAll(name, story, privilege);
	}
		
	public Person() {
		this(DEFAULT_NAME, DEFAULT_STORY, DEFAULT_PRIVILEGE);
	}

	public static class Identity {
		private String story;
		private String pronouns;

		public Identity() {
			this.story = "Unknown";
			this.pronouns = "None";
		}

		public Identity(String story, String pronouns) {
			this.story = story;
			this.pronouns = pronouns;
		}

		public String getStory() {
			return story;
		}

		public void setStory(String story) {
			this.story = story;
		}

		public String setPronouns() {
			return pronouns;
		}

		public void getPronouns(String pronouns) {
			this.pronouns = pronouns;
		}

		@Override
		public String toString() {
			return "Story: " + story + ", Pronouns: " + pronouns;
		}
	}
	
	public Person(Person original) {
		if(original == null) {
			throw new IllegalArgumentException("Cannot copy null obect in Person copy constructor");
		} else {
			this.setAll(original.name, original.story, original.privilege);
		}
	}

	// MUTATORS/SETTERS
	public void setName(String name) {
		this.name = name;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public void setAll(String name, String story, int privilege) {
		this.setPrivilege(privilege);
		this.setName(name);
		this.setStory(story);
	}

	// ACCESSORS / GETTERS
	public String getName() {
		return this.name;
	}
		
	public String getStory() {
		return this.story;
	}

	public int getPrivilege() {
		return this.privilege;
	}

	// OTHER REQUIRED METHODS
	@Override
	public String toString()
	{
		return "My name is "+ this.name + " and "+ this.story + "\n"
				+ "According to this calculator I ended up with "+ this.privilege + " estimated privilege points";
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if(other == null || (!(other instanceof Person))) {
			return false;
		}
		
		Person otherPerson = (Person) other;
		return this.name.equals(otherPerson.name) && this.story.equals(otherPerson.story) &&
			this.privilege == otherPerson.privilege;	
	}

	// INTERFACE METHODS
	/***** TODO: (Part 1) override compareTo method to implement Comparable interface*****/

	@Override
	public int compareTo(Person other) {
		return Integer.compare(this.privilege, other.privilege);
	}
}