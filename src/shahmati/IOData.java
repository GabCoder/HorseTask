package shahmati;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * Created by danil on 05.03.2017.
 */
public class IOData {
    public static String createStringOfPath(List<Point> path) {
        String _path = "";

        for (Point point : path) {
            String _point = "";
            switch (point.x) {
                case 1:
                    _point += "a";
                    break;
                case 2:
                    _point += "b";
                    break;
                case 3:
                    _point += "c";
                    break;
                case 4:
                    _point += "d";
                    break;
                case 5:
                    _point += "e";
                    break;
                case 6:
                    _point += "f";
                    break;
                case 7:
                    _point += "g";
                    break;
                case 8:
                    _point += "h";
                    break;
                default:
                    return null;
            }

            _point += point.y;
            _path += _point + " => ";
        }
        _path = _path.substring(0, _path.length() - 1 - 3);

        return _path;
    }

    public static List<Point> inputFromScanner(Scanner in) {
        List<Point> res = new ArrayList<>();

        String input = in.nextLine();
        input = input.toLowerCase();

        String[] data = input.split(" ");

        if (data.length != 2) throw new IllegalArgumentException("Вы ввели позиций: " + data.length + "! Надо две!");

        if (!checkData(data)) throw new IllegalArgumentException("Данные введены в неверном формате!");

        Point _start = parsePos(data[0]);
        Point _finish = parsePos(data[1]);

        if (_start == null || _finish == null) throw new IllegalArgumentException("Данные введены в неверном формате!");

        res.add(_start);
        res.add(_finish);
        return res;
    }

    private static boolean checkData(String[] data) {
        for (String elem : data) {
            if (elem.length() != 2) return false;
        }
        return true;
    }

    private static Point parsePos(String pos) {
        Point _pos = new Point();
        if (pos.length() != 2) return null;

        String x = String.valueOf(pos.charAt(0));
        String y = String.valueOf(pos.charAt(1));

        _pos.y = Integer.parseInt(y);

        switch (x) {
            case "a":
                _pos.x = 1;
                break;
            case "b":
                _pos.x = 2;
                break;
            case "c":
                _pos.x = 3;
                break;
            case "d":
                _pos.x = 4;
                break;
            case "e":
                _pos.x = 5;
                break;
            case "f":
                _pos.x = 6;
                break;
            case "g":
                _pos.x = 7;
                break;
            case "h":
                _pos.x = 8;
                break;
            default:
                return null;
        }

        return _pos;
    }
}
