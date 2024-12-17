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


            User usr = new User (user, pass);
            UserDAO udao = new UserDAO();
            //quello che fa se l'utente è registrato

            HttpSession session = request.getSession(false);
            if(udao.doCheckUser(usr)==1){
                //INVALIDO LA SESSIONE ESISTENTE
                if (session!=null) session.invalidate();

                //RICHIEDO UNA NUOVA SESSION E LE ATTRIBUISCO IL VALORE USER
                session = request.getSession();
                session.setAttribute("user", usr.getUser());
                session.setMaxInactiveInterval(5*60);  //setto il limite di inattività a 5 minuti
                session.setAttribute("successMessage", "utente trovato");
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
            else{
                rd = request.getRequestDispatcher("/login.jsp");
                session.setAttribute("errorMessage", "credenziali non corrette");
                rd.forward(request, response);
            }

        }
            catch (Exception e) {
            throw new RuntimeException(e);
        }

        }
    }


