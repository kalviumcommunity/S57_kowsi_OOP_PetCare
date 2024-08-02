import java.util.Scanner;

class Pet {
    private int id;
    private String name;
    private String type;
    private int age;
    private int hungerLevel;

    public void setData(int id, String name, String type, int age, int hungerLevel) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.hungerLevel = hungerLevel;
    }

    public void display() {
        System.out.println(id + "\t\t" + name + "\t\t" + type + "\t\t" + age + "\t\t" + hungerLevel);
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
            int id, age, hungerLevel;
            String name, type;

            System.out.print("Enter Pet ID: ");
            id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Pet Name: ");
            name = scanner.nextLine();

            System.out.print("Enter Pet Type: ");
            type = scanner.nextLine();

            System.out.print("Enter Pet Age: ");
            age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Pet Hunger Level: ");
            hungerLevel = scanner.nextInt();
            scanner.nextLine();

            pets[i] = new Pet();
            pets[i].setData(id, name, type, age, hungerLevel);
        }

        scanner.close();
    }

    public void display() {
        System.out.println("PetCare Pets");
        System.out.println("ID \t\t Name \t\t Type \t\t Age \t\t Hunger Level");
        for (int i = 0; i < numPets; i++) {
            pets[i].display();
        }
        System.out.println();
    }
}
