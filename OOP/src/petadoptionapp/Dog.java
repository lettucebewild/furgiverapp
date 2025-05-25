package petadoptionapp;

public class Dog extends Pet {
	public Dog(String name, int age, String description, String imagePath) {
		super(name, age, description, imagePath);
	}

	@Override
	public void displayDetails() {
		System.out.println("Dog: " + getName() + ", Age: " + getAge() + ", Description: " + getDescription());
	}
}