package shahmati;

import java.awt.*;
import java.util.Scanner;
import java.util.List;

/**
 * Created by danil on 05.03.2017.
 */
public class Runner {
    private static Scanner in = new Scanner(System.in);

    private static Point start = new Point();
    private static Point finish = new Point();
    public static void main(String[] args) {
        System.out.print("Введите позиции через пробел (a1, e4): ");
        List<Point> points = IOData.inputFromScanner(in);

        start = points.get(0); finish = points.get(1);

        List<Point> path = Logic.pathFinder(start, finish);
        System.out.println(IOData.createStringOfPath(path));
    }
}
