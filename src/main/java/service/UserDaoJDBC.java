package service;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBC implements IUserDao{

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;

        String url= "jdbc:mysql://localhost:3306/useManager";
        String username= "root";
        String pass = "123456";

        try {
            connection = DriverManager.getConnection(url, username, pass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;


    }

    @Override
    public void insertUser(User user) throws SQLException {
         Connection co = getConnection();
         String add = "insert into users(name, email, country) value (?,?,?) ";

         PreparedStatement preparedStatement = co.prepareStatement(add);
         preparedStatement.setString(1,user.getName());
         preparedStatement.setString(2,user.getEmail());
         preparedStatement.setString(3,user.getCountry());

         int index = preparedStatement.executeUpdate();



    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();

        Connection co = getConnection();

        String list = "select * from users ";

        try {
            PreparedStatement preparedStatement = co.prepareStatement(list);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                users.add(new User(id,name,email, country));


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

     return  users ;

    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return false;
    }
}
