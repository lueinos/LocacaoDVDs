/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package locacaodvds.controladores;

import locacaodvds.dao.DvdDAO;
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.ClassificacaoEtaria;
import locacaodvds.entidades.Dvd;
import locacaodvds.entidades.Genero;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Octavio, Luana
 */
@WebServlet(name = "DvdServlet", urlPatterns = {"/processaDvd"})
public class DvdServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter( "acao" );
        
        DvdDAO dao = null;
        RequestDispatcher disp = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try {

            dao = new DvdDAO();

            if ( acao.equals( "inserir" ) ) {

                String titulo = request.getParameter( "titulo" );
                int anoLancamento = Integer.parseInt(request.getParameter( "anoLancamento" ));
                int idAtorPrincipal = Integer.parseInt(request.getParameter( "idAtorPrincipal"));
                Ator a = new Ator();
                a.setId(idAtorPrincipal);
                int idAtorCoadjuvante = Integer.parseInt(request.getParameter( "idAtorCoadjuvante"));
                Ator b = new Ator();
                b.setId(idAtorCoadjuvante);
                String dataLancamento = request.getParameter("dataLancamento");
                int duracaoMinutos = Integer.parseInt(request.getParameter( "duracaoMinutos" ));
                int idClassificacaoEtaria = Integer.parseInt(request.getParameter( "idClassificacaoEtaria"));
                ClassificacaoEtaria c = new ClassificacaoEtaria();
                c.setId(idClassificacaoEtaria);
                int idGenero = Integer.parseInt(request.getParameter( "idGenero"));
                Genero g = new Genero();
                g.setId(idGenero);

                Dvd d = new Dvd();
                d.setTitulo(titulo);
                d.setAnoLancamento(anoLancamento);
                d.setAtorPrincipal(a);
                d.setAtorCoadjuvante(b);
                d.setDataLancamento(Date.valueOf( 
                        LocalDate.parse(dataLancamento, dtf)));
                d.setDuracaoMinutos(duracaoMinutos);             
                d.setClassificacaoEtaria(c);
                d.setGenero(g);         
                
                dao.salvar( d );
                
                disp = request.getRequestDispatcher(
                        "/formularios/dvd/listagem.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));
                String titulo = request.getParameter( "titulo" );
                int anoLancamento = Integer.parseInt(request.getParameter( "anoLancamento" ));
                int idAtorPrincipal = Integer.parseInt(request.getParameter( "idAtorPrincipal"));
                Ator a = new Ator();
                a.setId(idAtorPrincipal);
                int idAtorCoadjuvante = Integer.parseInt(request.getParameter( "idAtorCoadjuvante"));
                Ator b = new Ator();
                b.setId(idAtorCoadjuvante);
                String dataLancamento = request.getParameter("dataLancamento");
                int duracaoMinutos = Integer.parseInt(request.getParameter( "duracaoMinutos" ));
                int idClassificacaoEtaria = Integer.parseInt(request.getParameter( "idClassificacaoEtaria"));
                ClassificacaoEtaria c = new ClassificacaoEtaria();
                c.setId(idClassificacaoEtaria);
                int idGenero = Integer.parseInt(request.getParameter( "idGenero"));
                Genero g = new Genero();
                g.setId(idGenero);

                Dvd d = new Dvd();
                d.setId(id);
                d.setTitulo(titulo);
                d.setAnoLancamento(anoLancamento);
                d.setAtorPrincipal(a);
                d.setAtorCoadjuvante(b);
                d.setDataLancamento(Date.valueOf( 
                        LocalDate.parse(dataLancamento, dtf)));
                d.setDuracaoMinutos(duracaoMinutos);             
                d.setClassificacaoEtaria(c);
                d.setGenero(g); 

                dao.atualizar( d );

                disp = request.getRequestDispatcher(
                        "/formularios/dvd/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));

                Dvd d = new Dvd();
                
                d.setId( id );
                
                dao.excluir( d );

                disp = request.getRequestDispatcher(
                        "/formularios/dvd/listagem.jsp" );

            } else {
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                Dvd d = dao.obterPorId( id );
                request.setAttribute( "dvd", d );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/dvd/alterar.jsp" );
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/dvd/excluir.jsp" );
                }
                
            }

        } catch ( SQLException exc ) {
            exc.printStackTrace();
        } finally {
            if ( dao != null ) {
                try {
                    dao.fecharConexao();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
                }
            }
        }

        if ( disp != null ) {
            disp.forward( request, response );
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
        return "DvdServlet";
    }// </editor-fold>

}
