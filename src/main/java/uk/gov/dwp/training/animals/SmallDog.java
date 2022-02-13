package uk.gov.dwp.training.animals;

public class SmallDog extends Dog {

    public SmallDog(String name) {

        super("SmallDog", name);
    }

    public void yap() {
        System.out.println("Yap yap!");
    }
}
