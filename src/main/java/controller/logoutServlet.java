package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="logoutServlet", urlPatterns = "/logoutServlet")
public class logoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //richiedo l'oggetto session - false non crea la session se non è presente
        HttpSession session = req.getSession(false);
        if (session != null) {
            //PRIMA ELIMINARE OGGETTI SE AGGIUNTI AL CARRELLO
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }
}
