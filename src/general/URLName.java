package general;

/**
 * Created by andres on 26/05/17.
 * DrApp
 * general
 */
public class URLName {
    private static String ourInstance = "http://192.168.0.28:9080/MediServer";

    public static String getInstance() {
        return ourInstance;
    }

    private URLName() {
    }
}
