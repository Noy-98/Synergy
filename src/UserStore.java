import java.util.HashMap;
import java.util.Map;

public class UserStore {
    private static Map<String, String> userMap = new HashMap<>();

    public static void setUser(String email, String password) {
        userMap.put(email, password);
    }

    public static boolean isUserValid(String email, String password) {
        return userMap.containsKey(email) && userMap.get(email).equals(password);
    }
}
