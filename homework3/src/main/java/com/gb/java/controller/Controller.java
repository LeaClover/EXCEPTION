package com.gb.java.controller;
import com.gb.java.data.User;
import com.gb.java.service.FileService;
import com.gb.java.view.UserView;

public class Controller {

    private final UserView uv = new UserView();
    private final FileService fs = new FileService();

    public void addUser(User user) {
        fs.writeFileCSV(user);
        uv.sendOnController(user);
    }
}
