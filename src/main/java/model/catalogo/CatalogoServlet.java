package model.catalogo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet (name="controller", value="/catalogo")
public class CatalogoServlet extends HttpServlet {
    @Resource (name="jdbc/crochetique")
    protected DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String query = req.getParameter("query");
            switch(query){
                case "listar":

            }
        }
    }
}
