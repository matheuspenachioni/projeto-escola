
package br.com.projetoescola.filter;

import br.com.projetoescola.utils.SingleConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns={"/*"})
public class FilterAutenticacao implements Filter {

    private static Connection conn;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            conn = SingleConnection.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(FilterAutenticacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (Exception ex) {
            System.out.println("Erro: "+ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Erro: "+ex.getMessage());
            ex.printStackTrace();
        }
    }

}