package model.catalogo;

import java.util.List;
import java.util.Optional;

public interface CatalogoDao <E extends Exception>{
    public List<Catalogo> fetchCategories() throws E;
    boolean createCatalogo(Catalogo catalogo) throws E;
    boolean updateCatalogo(Catalogo catalogo) throws E;
    boolean deleteCatalogo(Catalogo catalogo) throws E;

    Optional<Catalogo> fetchCatalogoWithArticolo(int idCatalogo) throws E;
}
