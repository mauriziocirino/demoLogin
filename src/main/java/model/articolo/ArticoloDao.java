package model.articolo;

import java.util.List;
import java.util.Optional;

public interface ArticoloDao <E extends Exception> {
    List<Articolo> fetchArticoli(int start, int end) throws E;
    Optional<Articolo> fetchArticolo(int id) throws E;
    boolean createArticolo(Articolo articolo) throws E;
    boolean updatePriceArticolo(Articolo articolo) throws E;
    boolean deleteArticolo(int id) throws E;
}
