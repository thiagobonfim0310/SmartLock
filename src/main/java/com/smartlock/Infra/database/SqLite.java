package com.smartlock.Infra.database;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.smartlock.Business.entities.Admin;
import com.smartlock.Business.entities.Enviroments;
import com.smartlock.Business.entities.User;
import com.smartlock.Infra.util.DataToJson;

public class SqLite implements Database {
    private Connection conn = null;

    private Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:database.db");
    }

    public SqLite() {
        try {
            // Conectar ao banco de dados ou criá-lo se não existir
            conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            System.out.println("Conexão com o banco de dados SQLite estabelecida.");

            // Criar uma declaração
            Statement stmt = conn.createStatement();

            // Criar tabelas

            String sqlCreateAdminTable = "CREATE TABLE IF NOT EXISTS admins (" +
                    "id TEXT PRIMARY KEY," +
                    "name TEXT NOT NULL," +
                    "email TEXT NOT NULL," +
                    "password TEXT NOT NULL)";
            stmt.execute(sqlCreateAdminTable);
            System.out.println("Tabela 'admins' criada com sucesso.");

            String sqlCreateUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                    "id TEXT PRIMARY KEY," +
                    "name TEXT NOT NULL," +
                    "email TEXT," +
                    "cpf TEXT," +
                    "type TEXT," +
                    "perms TEXT)";
            stmt.execute(sqlCreateUsersTable);
            System.out.println("Tabela 'users' criada com sucesso.");

            String sqlCreateLocksTable = "CREATE TABLE IF NOT EXISTS locks (" +
                    "id TEXT PRIMARY KEY," +
                    "numberOfSerie TEXT," +
                    "userId TEXT," +
                    "enviromentId TEXT," +
                    "protocol TEXT," +
                    "FOREIGN KEY (userId) REFERENCES users(id)," +
                    "FOREIGN KEY (enviromentId) REFERENCES enviroments(id))";
            stmt.execute(sqlCreateLocksTable);
            System.out.println("Tabela 'locks' criada com sucesso.");
            String sqlCreateEnviromentsTable = "CREATE TABLE IF NOT EXISTS enviroments (" +
                    "id TEXT PRIMARY KEY," +
                    "name TEXT NOT NULL)";
            stmt.execute(sqlCreateEnviromentsTable);
            System.out.println("Tabela 'enviroments' criada com sucesso.");

            String sqlCreateEnviromentsRelationshipTable = "CREATE TABLE IF NOT EXISTS enviroment_relationship (" +
                    "enviromentId TEXT," +
                    "childEnviromentId TEXT," +
                    "FOREIGN KEY (enviromentId) REFERENCES enviroments(id)," +
                    "FOREIGN KEY (childEnviromentId) REFERENCES enviroments(id))";
            stmt.execute(sqlCreateEnviromentsRelationshipTable);
            System.out.println("Tabela 'enviroment_relationship' criada com sucesso.");

            String sqlCreateUsersEnviromentsTable = "CREATE TABLE IF NOT EXISTS users_enviroments (" +
                    "userId TEXT," +
                    "enviromentId TEXT," +
                    "FOREIGN KEY (userId) REFERENCES users(id)," +
                    "FOREIGN KEY (enviromentId) REFERENCES enviroments(id))";
            stmt.execute(sqlCreateUsersEnviromentsTable);
            System.out.println("Tabela 'users_enviroments' criada com sucesso.");

            String sqlCreateTypeOfUsersTable = "CREATE TABLE IF NOT EXISTS typeOfUsers (" +
                    "id TEXT PRIMARY KEY," +
                    "name TEXT NOT NULL)";
            stmt.execute(sqlCreateTypeOfUsersTable);
            System.out.println("Tabela 'typeOfUsers' criada com sucesso.");

            // Inserir dados com na Tabela Admin
            String sqlInsertAdmin = "INSERT INTO admins (id, name, email, password) VALUES ('"
                    + UUID.randomUUID().toString()
                    + "', 'Admin', 'admin@admin.com', 'admin')";
            stmt.execute(sqlInsertAdmin);
            System.out.println("Dados do tipo 'Admin' inseridos com sucesso.");
            // Inserir dados com na Tabela TypeId
            String sqlInsertProfessor = "INSERT INTO typeOfUsers (id, name) VALUES ('" + UUID.randomUUID().toString()
                    + "', 'Professor')";
            stmt.execute(sqlInsertProfessor);
            System.out.println("Dados do tipo 'Professor' inseridos com sucesso.");

            String sqlInsertAluno = "INSERT INTO typeOfUsers (id, name) VALUES ('" + UUID.randomUUID().toString()
                    + "', 'Aluno')";
            stmt.execute(sqlInsertAluno);
            System.out.println("Dados do tipo 'Aluno' inseridos com sucesso.");

            String sqlInsertColaborador = "INSERT INTO typeOfUsers (id, name) VALUES ('" + UUID.randomUUID().toString()
                    + "', 'Colaborador')";
            stmt.execute(sqlInsertColaborador);
            System.out.println("Dados do tipo 'Colaborador' inseridos com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
            }
        }
    }

    List<User> usuarios = new ArrayList<>();

    public void saveUser(User user) {

        DataToJson format = new DataToJson();
        String sql = "INSERT INTO users (id, name, email, cpf, perms) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getId().toString());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getCpf());
            pstmt.setString(5, format.serializeEnviroments(user.getPerms()));

            pstmt.executeUpdate();
            System.out.println("Usuário inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
        }
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        DataToJson format = new DataToJson();
        String sql = "SELECT * FROM  users";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                String name = rs.getString("name");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                // Aqui você precisará desserializar a string 'perms' para obter os ambientes
                List<Enviroments> perms = format.deserializeEnviroments(rs.getString("perms"));

                User user = new User();
                user.setId(id);
                user.setCpf(cpf);
                user.setName(name);
                user.setEmail(email);
                user.setPerms(perms);
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuários: " + e.getMessage());
        }

        return users;
    }

    public void updateUsers(User user, UUID id) {
        DataToJson format = new DataToJson();
        String sql = "UPDATE users SET name = ?, email = ?, cpf = ?, perms = ? WHERE id = ?";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getCpf());
            pstmt.setString(4, format.serializeEnviroments(user.getPerms()));
            pstmt.setString(5, user.getId().toString());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário atualizado com sucesso.");
            } else {
                System.out.println("Nenhum usuário foi atualizado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
        }
    }

    public void deleteUser(UUID id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id.toString());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário removido com sucesso.");
            } else {
                System.out.println("Nenhum usuário foi removido com o ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover usuário: " + e.getMessage());
        }
    }

    public boolean autenticarAdmin(String email, String password) {
        String sql = "SELECT * FROM admins WHERE email = ? AND password = ?";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Retorna true se o admin foi encontrado, false caso contrário

        } catch (SQLException e) {
            System.out.println("Erro ao autenticar admin: " + e.getMessage());
            return false; // Retorna false em caso de exceção
        }
    }
}
