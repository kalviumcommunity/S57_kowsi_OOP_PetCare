import java.util.Scanner;

// Abstract base class representing a Pet
abstract class Pet {
    private static int totalPets = 0;
    private int id;
    private String name;
    private int age;
    private int hungerLevel;

    // Constructor to initialize Pet attributes
    public Pet(int id, String name, int age, int hungerLevel) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hungerLevel = hungerLevel;
        totalPets++;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    // Static method to get total number of pets created
    public static int getTotalPets() {
        return totalPets;
    }

    // Static method to reset the total count of pets
    public static void resetTotalPets() {
        totalPets = 0;
    }

    // Abstract methods to be implemented by subclasses
    public abstract String getType();
    public abstract void display();
}

// Class representing a Dog (inherits from Pet)
class Dog extends Pet {
    public Dog(int id, String name, int age, int hungerLevel) {
        super(id, name, age, hungerLevel);
    }

    @Override
    public String getType() {
        return "Dog";
    }

    @Override
    public void display() {
        System.out.printf("%d\t%s\t%s\t%d\t%d%n", getId(), getName(), getType(), getAge(), getHungerLevel());
    }
}

// Class representing a Cat (inherits from Pet)
class Cat extends Pet {
    public Cat(int id, String name, int age, int hungerLevel) {
        super(id, name, age, hungerLevel);
    }

    @Override
    public String getType() {
        return "Cat";
    }

    @Override
    public void display() {
        System.out.printf("%d\t%s\t%s\t%d\t%d%n", getId(), getName(), getType(), getAge(), getHungerLevel());
    }
}

// Class representing a Bird (inherits from Pet)
class Bird extends Pet {
    public Bird(int id, String name, int age, int hungerLevel) {
        super(id, name, age, hungerLevel);
    }

    @Override
    public String getType() {
        return "Bird";
    }

    @Override
    public void display() {
        System.out.printf("%d\t%s\t%s\t%d\t%d%n", getId(), getName(), getType(), getAge(), getHungerLevel());
    }
}

// Class representing a GuideDog (inherits from Dog)
class GuideDog extends Dog {
    private String serviceType;

    public GuideDog(int id, String name, int age, int hungerLevel, String serviceType) {
        super(id, name, age, hungerLevel);
        this.serviceType = serviceType;
    }

    public String getServiceType() {
        return serviceType;
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("\tService Type: %s%n", getServiceType());
    }
}

// Class to manage Pet operations
class PetCare {
    private static final int MAX_PETS = 100;
    private Pet[] pets;
    private int numPets;

    public PetCare() {
        pets = new Pet[MAX_PETS];
        numPets = 0;
    }

    // Method to collect pet data
    public void getData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of pets: ");
        numPets = scanner.nextInt();
        scanner.nextLine();

        if (numPets > MAX_PETS) {
            System.out.println("Exceeded max pets. Storing only " + MAX_PETS + " pets.");
            numPets = MAX_PETS;
        }

        for (int i = 0; i < numPets; i++) {
            System.out.print("Enter Pet Type (Dog/Cat/Bird/GuideDog): ");
            String type = scanner.nextLine();

            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Hunger Level: ");
            int hungerLevel = scanner.nextInt();
            scanner.nextLine();

            switch (type.toLowerCase()) {
                case "dog":
                    pets[i] = new Dog(id, name, age, hungerLevel);
                    break;
                case "cat":
                    pets[i] = new Cat(id, name, age, hungerLevel);
                    break;
                case "bird":
                    pets[i] = new Bird(id, name, age, hungerLevel);
                    break;
                case "guidedog":
                    System.out.print("Enter Service Type: ");
                    String serviceType = scanner.nextLine();
                    pets[i] = new GuideDog(id, name, age, hungerLevel, serviceType);
                    break;
                default:
                    System.out.println("Unknown type, defaulting to Dog.");
                    pets[i] = new Dog(id, name, age, hungerLevel);
                    break;
            }
        }
    }

    // Method to display pet data
    public void display() {
        System.out.println("ID\tName\tType\tAge\tHunger Level");
        for (int i = 0; i < numPets; i++) {
            pets[i].display();
        }
        System.out.println("\nTotal Pets Created: " + Pet.getTotalPets());
    }

    // Method to reset pet data
    public void resetPetsData() {
        Pet.resetTotalPets();
        numPets = 0;
        System.out.println("All pet data has been reset.");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        PetCare petCare = new PetCare();
        petCare.getData();
        petCare.display();
        petCare.resetPetsData();
        petCare.display();
    }
}
