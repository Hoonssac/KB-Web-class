package designpattern.Command;

import java.util.Scanner;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("종료할까요?(Y/n) ");
        String answer = sc.nextLine();

        sc.close();
        if (answer.isEmpty() || answer.equalsIgnoreCase("Y")) {
            System.exit(0);
        }
    }
}
