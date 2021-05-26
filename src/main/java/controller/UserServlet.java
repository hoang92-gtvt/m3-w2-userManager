package controller;

import model.User;
import service.IUserDao;
import service.UserDaoJDBC;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    IUserDao userDao= new UserDaoJDBC();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch(action){
            case "add":
                showFormAddUser(request,response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "detail":
                break;

            default:
                showAllUser(request,response);
                break;
        }

    }

    private void showFormAddUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users/creat.jsp");

        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users/list.jsp");

        List<User> users = userDao.selectAllUsers();

        request.setAttribute("users", users);

        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch(action){
            case "add":
                AddUser(request,response);
                break;

    }
}

    private void AddUser(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User newuser = new User(name,email,country);

        try {
             userDao.insertUser(newuser);
             showAllUser(request,response);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
