package training.animals;

public class Dog implements Animal {

    private String name;
    private String breed;

    public Dog(String breedName, String name) {
        this.breed = breedName;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public void speak() {
        System.out.println("Woof!");
    }
}
