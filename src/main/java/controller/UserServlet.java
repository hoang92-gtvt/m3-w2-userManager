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
                showFormEdit(request,response);
                break;
            case "delete":
                showComfrim(request, response);
                break;
            case "detail":
                showDetail(request, response);
                break;

            default:
                showAllUser(request,response);
                break;
        }

    }

    private void showDetail(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users/detail.jsp");

        int id = Integer.parseInt(request.getParameter("id"));

        User user = userDao.getUserById(id);

        request.setAttribute("user", user);

        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showComfrim(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users/confrim.jsp");

        dispatcher.forward(request,response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users/formEdit.jsp");

        int id = Integer.parseInt(request.getParameter("id"));

        User user = userDao.getUserById(id);

        request.setAttribute("user", user);

        dispatcher.forward(request,response);


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
            case "edit":
                editUser(request,response);

                break;
            case "delete":
                deleteUser(request, response);
                break;

            default:
                showAllUser(request, response);
    }
}

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)  {
        int id = Integer.parseInt(request.getParameter("id"));


        try {
            userDao.deleteUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            showAllUser(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User  editUser = new User(id,name, email, country);

        try {
            boolean check = userDao.updateUser(editUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        try {
            showAllUser(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
