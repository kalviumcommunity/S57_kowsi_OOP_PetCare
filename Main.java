import java.util.Scanner;

abstract class Pet {
    private static int totalPets = 0; 
    private int id;
    private String name;
    private int age;
    private int hungerLevel;

    public Pet(int id, String name, int age, int hungerLevel) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hungerLevel = hungerLevel;
        totalPets++;
    }

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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public static int getTotalPets() {
        return totalPets;
    }

    public static void resetTotalPets() {
        totalPets = 0;
    }

    public abstract String getType();

    public abstract void display();
}

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
        System.out.println(getId() + "\t\t" + getName() + "\t\t" + getType() + "\t\t" + getAge() + "\t\t" + getHungerLevel());
    }
}

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
        System.out.println(getId() + "\t\t" + getName() + "\t\t" + getType() + "\t\t" + getAge() + "\t\t" + getHungerLevel());
    }
}

class PetCare {
    private static final int MAX_PETS = 100;
    private Pet[] pets; 
    private int numPets;

    public PetCare() {
        pets = new Pet[MAX_PETS];
        numPets = 0;
    }

    public void getData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of pets you want to store in PetCare: ");
        numPets = scanner.nextInt();
        scanner.nextLine();

        if (numPets > MAX_PETS) {
            System.out.println("The number of pets exceeds the limit.");
            numPets = MAX_PETS;
        }

        for (int i = 0; i < numPets; i++) {
            System.out.print("Enter Pet Type (Dog/Cat): ");
            String type = scanner.nextLine();

            System.out.print("Enter Pet ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Pet Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Pet Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Pet Hunger Level: ");
            int hungerLevel = scanner.nextInt();
            scanner.nextLine();

            if (type.equalsIgnoreCase("Dog")) {
                pets[i] = new Dog(id, name, age, hungerLevel);
            } else if (type.equalsIgnoreCase("Cat")) {
                pets[i] = new Cat(id, name, age, hungerLevel);
            } else {
                System.out.println("Unknown pet type! Defaulting to Dog.");
                pets[i] = new Dog(id, name, age, hungerLevel); // Default to Dog if type is unknown
            }
        }
    }

    public void display() {
        System.out.println("PetCare Pets");
        System.out.println("ID \t\t Name \t\t Type \t\t Age \t\t Hunger Level");
        for (int i = 0; i < numPets; i++) {
            pets[i].display(); 
        }
        System.out.println();
        System.out.println("Total Pets Created: " + Pet.getTotalPets()); 
    }

    public void resetPetsData() {
        Pet.resetTotalPets();
        numPets = 0;
        System.out.println("All pet data has been reset.");
    }
}

public class Main {
    public static void main(String[] args) {
        PetCare petCare = new PetCare();
        petCare.getData();  
        petCare.display(); 
        
        petCare.resetPetsData();  
        petCare.display();
    }
}
