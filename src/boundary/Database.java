package boundary;

import java.util.ArrayList;
import java.util.List;
import entities.User;

public class Database {
    List<User> usuarios = new ArrayList<>();

    public void saveUser(User usuario) {
        usuarios.add(usuario);
    }

    public List<User> getUsers() {
        return usuarios;
    }
}
