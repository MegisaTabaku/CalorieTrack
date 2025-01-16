package inxhinierisofti;

import java.util.HashMap;
import java.util.Map;

public class UserAccount {
    private Map<String, String> users = new HashMap<>();

    // Method to create a new account
    public boolean createAccount(String username, String password) {
        if (users.containsKey(username)) {
            return false; // User already exists
        }
        users.put(username, password);
        return true; // Account created successfully
    }

    // Method to validate user login
    public boolean login(String username, String password) {
        return users.getOrDefault(username, "").equals(password);
    }
}
