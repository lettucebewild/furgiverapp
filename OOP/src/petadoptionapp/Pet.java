package petadoptionapp;

public abstract class Pet {
	private String name;
	private int age;
	private String description;
	private String imagePath;

	public Pet(String name, int age, String description, String imagePath) {
		this.name = name;
		this.age = age;
		this.description = description;
		this.imagePath = imagePath;
	}

	// Getters and setters (Encapsulation)
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getDescription() {
		return description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public abstract void displayDetails(); // Abstraction
}
