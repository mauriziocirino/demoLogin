package model.catalogo;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.articolo.Articolo;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet (name="controller", value="/catalogo")
public class CatalogoServlet extends HttpServlet {
    @Resource(name="jdbc/crochetique")
    protected DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String query = req.getParameter("query");
            CatalogoDao<SQLException> catalogoDao = new CatalogoManager(ds);
            switch(query){
                case "select":
                    List<Catalogo> cataloghi = catalogoDao.fetchCataloghi();
                    Catalogo catalogo = new Catalogo();
                    req.setAttribute("cataloghi", cataloghi);
                    req.getRequestDispatcher("/selectCataloghi.jsp").forward(req, resp);
                    break;
                case "insert":
                    String nome = req.getParameter("nome");
                    String stagione = req.getParameter("stagione");
                    catalogo = new Catalogo(nome, stagione);
                    if (catalogoDao.createCatalogo(catalogo)) {
                        req.setAttribute("catalogo", catalogo);
                        req.setAttribute("msg", "Catalogo inserito con successo!");
                    }
                    else{
                        req.setAttribute("msg", "Errore di inserimento catalogo!");
                    }
                    req.getRequestDispatcher("/createCatalogo.jsp").forward(req, resp);
                    break;
                case "update":
                    String id = req.getParameter("id");
                    nome = req.getParameter("nome");
                    stagione = req.getParameter("stagione");
                    catalogo = new Catalogo(nome, stagione);
                    catalogo.setId(Integer.parseInt(id));
                    catalogoDao.updateCatalogo(catalogo);
                    break;
                case "delete":

                default:
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
