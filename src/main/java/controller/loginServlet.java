package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.SyncFailedException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name="loginServlet", urlPatterns = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            //problemi da qui in poi


            RequestDispatcher rd;
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            HttpSession session = request.getSession();

            User usr = new User (user, pass);
            UserDAO udao = new UserDAO();
            out.println("<font color=green size=20>LOGIN TRY "+ udao.doCheckUser(usr)+"</font>");
            out.println("<font color=green size=20>LOGIN TRY</font>");
            //quello che fa se l'utente è registrato

            if(udao.doCheckUser(usr)==1){
                session.setAttribute("user", usr);
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
            else{
                rd = request.getRequestDispatcher("/login.jsp");
                session.setAttribute("loginError", "credenziali non corrette");
                rd.forward(request, response);
            }

        }
            catch (Exception e) {
            throw new RuntimeException(e);
        }

        }
    }


