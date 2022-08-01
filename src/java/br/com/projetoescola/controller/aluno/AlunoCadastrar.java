
package br.com.projetoescola.controller.aluno;

import br.com.projetoescola.DAO.AlunoDAOImpl;
import br.com.projetoescola.DAO.GenericDAO;
import br.com.projetoescola.model.Aluno;
import br.com.projetoescola.model.Turma;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlunoCadastrar", urlPatterns = {"/AlunoCadastrar"})
public class AlunoCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        
        String mensagem = null;
        int idAluno = Integer.parseInt(request.getParameter("idaluno"));
        int idTurma = Integer.parseInt(request.getParameter("idturma"));
        String nomeAluno = request.getParameter("nomealuno");
        String telefoneAluno = request.getParameter("telefonealuno");
        
        try {
            Aluno oAluno = new Aluno();
            oAluno.setIdAluno(idAluno);
            oAluno.setNomeAluno(nomeAluno);
            oAluno.setTelefoneAluno(telefoneAluno);
            oAluno.setTurma(new Turma(idTurma,"",""));
            
            GenericDAO dao = new AlunoDAOImpl();
            if (dao.cadastrar(oAluno)) {
                mensagem = "Aluno cadastrado com suecesso!";
            } else {
                mensagem = "Falha ao cadastrar Aluno!";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("AlunoListar");
        } catch (Exception ex) {
            System.out.println("Problemas na servlet AlunoCadastrar! Erro: "+ ex.getMessage());
            ex.printStackTrace();
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
