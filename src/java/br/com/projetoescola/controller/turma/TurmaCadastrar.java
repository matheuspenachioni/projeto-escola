
package br.com.projetoescola.controller.turma;

import br.com.projetoescola.DAO.GenericDAO;
import br.com.projetoescola.DAO.TurmaDAOImpl;
import br.com.projetoescola.model.Turma;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TurmaCadastrar", urlPatterns = {"/TurmaCadastrar"})
public class TurmaCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        
        int idTurma = Integer.parseInt(request.getParameter("idturma"));
        String siglaTurma = request.getParameter("siglaturma");
        String periodoTurma = request.getParameter("periodoturma");
        String mensagem = null;
        
        Turma oTurma = new Turma();
        oTurma.setIdTurma(idTurma);
        oTurma.setSiglaTurma(siglaTurma);
        oTurma.setPeriodoTurma(periodoTurma);
        try {
            GenericDAO dao = new TurmaDAOImpl();
            if (dao.cadastrar(oTurma)){
                mensagem = "Turma cadastrada com sucesso!";
            } else{
                mensagem = "Falha ao cadastrar Turma!";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("TurmaListar");
        } catch (Exception ex){
            System.out.println("Problemas na servlet TurmaCadastrar! Erro: "+ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
