package shahmati;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by danil on 06.03.2017.
 */

public class Logic {
    private static final int BOUND = 8;
    public static List<Point> pathFinder(Point start, Point finish) {
        List<Point> path = new ArrayList<>();
        path.add(start);

        List<Point> preFinals = getPreFinishPoints(finish);

        algo: while (!path.get(path.size() - 1).equals(finish)) {
            Point curr = path.get(path.size() - 1);
            List<Point> allowedPositions = getAllowedPoints(curr);

            for (Point allowedPosition : allowedPositions) {
                for (Point preFinal : preFinals) {
                    if (allowedPosition.equals(preFinal)) {
                        path.add(allowedPosition);
                        path.add(finish);
                        break algo;
                    }
                }
            }

            double minDistance = 100;
            Point minPoint = new Point();
            for (Point allowedPosition : allowedPositions) {
                double distance = Math.sqrt( Math.pow((allowedPosition.x - finish.x), 2) + Math.pow((allowedPosition.y - finish.y), 2) );
                if (distance < minDistance) {
                    minDistance = distance;
                    minPoint = allowedPosition;
                }
            }

            path.add(minPoint);
        }

        return path;
    }

    private static List<Point> getPreFinishPoints(Point finish) {
        return getAllowedPoints(finish);
    }

    private static List<Point> getAllowedPoints(Point pos) {
        List<Point> res = new ArrayList<>();

        // TYPE 1
        res.add(new Point((pos.x - 1), (pos.y + 2)));
        res.add(new Point((pos.x + 1), (pos.y + 2)));

        res.add(new Point((pos.x - 1), (pos.y - 2)));
        res.add(new Point((pos.x + 1), (pos.y - 2)));

        res.add(new Point((pos.x + 2), (pos.y + 1)));
        res.add(new Point((pos.x + 2), (pos.y - 1)));

        res.add(new Point((pos.x - 2), (pos.y + 1)));
        res.add(new Point((pos.x - 2), (pos.y - 1)));
        validFilter(res);

        return res;
    }

    private static void validFilter(List<Point> toValidation) {
        for (int i = 0; i < toValidation.size(); ++i) {
            if ((toValidation.get(i).x > BOUND || toValidation.get(i).x < 1) || (toValidation.get(i).y > BOUND || toValidation.get(i).y < 1)) {
                toValidation.remove(i);
                i--;
            }
        }
    }
}
