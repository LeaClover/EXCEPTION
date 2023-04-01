package com.gb.java.view;
import java.util.logging.Logger;
import com.gb.java.data.User;

public class UserView {
    
    Logger log = Logger.getAnonymousLogger();

    public void sendOnController(User user) {
        log.info("Добавлен новый пользователь: " + user.toString());
    }
}
