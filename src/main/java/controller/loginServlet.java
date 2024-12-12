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
            out.println("<font color=green size=20>LOGIN TRY</font>");
            //problemi da qui in poi


            RequestDispatcher rd;
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            HttpSession session = request.getSession();
            User usr = new User (user, pass);
            UserDAO udao = new UserDAO();
            out.println("<font color=green size=20>LOGIN TRY "+ udao.doCheckUser(user)+"</font>");
            //quello che fa se l'utente è registrato

            if(udao.doCheckUser(usr.getUser())==1){
                out.println("<font color=green size=10>utente trovato</font>");
                session.setAttribute("user", usr);
                rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);

            }
            else{
                out.println("<font color=red size=20>ERROR</font>");
                rd = request.getRequestDispatcher("login.jsp");
                session.setAttribute("loginError", "credenziali non corrette");
                rd.forward(request, response);
            }

        }
            catch (Exception e) {
            throw new RuntimeException(e);
        }

        }
    }


