package Websocket;

import java.util.HashMap;

public class dataRepository {
    private static dataRepository instance;
    public static dataRepository getInstance() {
        if (instance == null) {
            instance = new dataRepository();
        }
        return instance;
    }

    private final HashMap<String, user> users = new HashMap<>();
    public final String DUMMY_SESSION = "SOMEVALIDSESSION";

    private dataRepository() {
        initDummyUser();
    }

    private void initDummyUser() {
        user user = new user("jan", "234");
        users.put(user.username, user);
        user = new user("Patrick", "24");
        users.put(user.username, user);


    }

    public boolean isValid(user user) {
        user item = users.get(user.username);
        if (item != null && item.password.equals(user.password)) {
            return true;
        }

        return false;
    }

    public boolean isValid(String session) {
        if (DUMMY_SESSION.equals(session)) {
            return true;
        }
        return false;
    }
}
