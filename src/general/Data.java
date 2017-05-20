package general;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andres on 17/05/17.
 * DrApp
 * general
 */
public class Data {

    public static List<String> bloodType = new ArrayList<>();
    public static List<String> gender = new ArrayList<>();

    public static void Initializer() {

        bloodType.add("AB+");
        bloodType.add("AB-");
        bloodType.add("A+");
        bloodType.add("A-");
        bloodType.add("B+");
        bloodType.add("B-");
        bloodType.add("O+");
        bloodType.add("O-");

        gender.add("Masculino");
        gender.add("Femenino");
    }
}
