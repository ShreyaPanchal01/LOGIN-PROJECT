import java.util.HashMap;

public class IDandPasswords {
    HashMap<String, String> logininfo = new HashMap<String, String>();

    IDandPasswords() {
        logininfo.put("user1", "pass1");
        logininfo.put("user2", "pass2");
        logininfo.put("user3", "pass3");
    }

    protected HashMap<String, String> getLoginInfo() {
        return logininfo;
    }
}
