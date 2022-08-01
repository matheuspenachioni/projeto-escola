
package br.com.projetoescola.DAO;

import java.util.List;

public interface GenericDAO {
    public Boolean cadastrar(Object object);
    public Boolean inserir(Object object);
    public Boolean alterar(Object object);
    public Boolean excluir(int idObject);
    public Object carregar(int idObject);
    public List<Object> listar();
}
