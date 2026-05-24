abstract class Vehicle {
    protected String name;
    protected int speed;
    protected int fuel;

    public Vehicle(String name, int speed, int fuel) {
        this.name = name;
        this.speed = speed;
        this.fuel = fuel;
    }

    public abstract void accelerate();
    public abstract void brake();

    public void showStatus() {
        System.out.println(name + " Speed: " + speed + " Fuel: " + fuel);
    }
}

// Inheritance + Polymorphism
class Car extends Vehicle {

    public Car(String name, int speed, int fuel) {
        super(name, speed, fuel);
    }

    @Override
    public void accelerate() {
        speed += 10;
        fuel -= 5;
    }

    @Override
    public void brake() {
        speed -= 5;
    }
}

// Inheritance + Method Overriding
class SportsCar extends Car {

    public SportsCar(String name, int speed, int fuel) {
        super(name, speed, fuel);
    }

    @Override
    public void accelerate() {
        speed += 20;
        fuel -= 10;
    }
}

// Interface
interface RaceActions {
    void startRace();
    void endRace();
}

// Encapsulation
class Player {
    private String playerName;
    private Vehicle car;

    public Player(String playerName, Vehicle car) {
        this.playerName = playerName;
        this.car = car;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Vehicle getCar() {
        return car;
    }
}

// Game Controller
class RaceGame implements RaceActions {

    private Player[] players;

    public RaceGame(Player[] players) {
        this.players = players;
    }

    @Override
    public void startRace() {
        System.out.println("Race Started!");

        for (Player p : players) {
            p.getCar().accelerate();   // Polymorphism
            p.getCar().showStatus();
        }
    }

    @Override
    public void endRace() {
        System.out.println("Race Finished!");
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        Vehicle car1 = new Car("Normal Car", 50, 100);
        Vehicle car2 = new SportsCar("Ferrari", 70, 120);

        Player p1 = new Player("Player1", car1);
        Player p2 = new Player("Player2", car2);

        Player[] players = {p1, p2};

        RaceGame game = new RaceGame(players);

        game.startRace();
        game.endRace();
    }
}
