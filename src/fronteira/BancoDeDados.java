package fronteira;

import java.util.ArrayList;
import java.util.List;
import entities.Usuario;

public class BancoDeDados {
    List<Usuario> usuarios = new ArrayList<>();

    public void salvarUsuarios(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> resgatarUsuarios() {
        return usuarios;
    }
}
