package fr.esiea.ex4A.fakebdd;

import fr.esiea.ex4A.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Fakebdd {

    private final List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }
}
