package ca.sait.finalproject.services;

import ca.sait.finalproject.dataaccess.UserDB;
import ca.sait.finalproject.models.User;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountService {

    public User login(String email, String password) {
        UserDB userDB = new UserDB();

        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                return user;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public boolean forgotPassword(String email, String path) {
        try {
            UserDB users = new UserDB();
            User user = users.get(email);
            String to = user.getEmail();
            String subject = "Forgot your password?";
            String template = path + "/emailTemplate.html";

            HashMap<String, String> tags = new HashMap<>();
            tags.put("firstname", user.getFirstName());
            tags.put("lastname", user.getLastName());
            tags.put("email", user.getEmail());
            tags.put("password", user.getPassword());

            GmailService.sendMail(to, subject, template, tags);

        } catch (Exception ex) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

}
