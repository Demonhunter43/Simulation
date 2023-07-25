import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Type 'start' or 'exit'");
        Scanner scanner = new Scanner(System.in);
        String command = "";
        command = scanner.nextLine();

        switch(command) {
            case ("start"):
                System.out.println("Ok, let's go");
                Simulation currentSimmulation = new Simulation();
                currentSimmulation.start();
                break;
            case ("exit"):
                System.out.println("Bye(");
                System.exit(0);
                break;
            default:
                System.out.println("Don't know this command");
                System.out.println("Type 'start' or 'exit'");
        }
    }
}