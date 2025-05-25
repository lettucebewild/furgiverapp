package petadoptionapp;

public class Cat extends Pet {
	public Cat(String name, int age, String description, String imagePath) {
		super(name, age, description, imagePath);
	}

	@Override
	public void displayDetails() {
		System.out.println("Cat: " + getName() + ", Age: " + getAge() + ", Description: " + getDescription());
	}
}
