/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import entidades.Dados;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "processsaDadosCliente", urlPatterns = {"/processsaDadosCliente"})
public class processsaDadosCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        String nome = request.getParameter( "nome" );
        String sobrenome = request.getParameter( "sobrenome" );
        String cpf = request.getParameter( "cpf" );
        String data = request.getParameter( "data" );
        String email = request.getParameter( "email" );
        String logradouro = request.getParameter( "logradouro" );
        String numero = request.getParameter( "numero" );
        String complemento = request.getParameter( "complemento" );
        String cidade = request.getParameter( "cidade" );
        String estado = request.getParameter( "estado" );
        String cep = request.getParameter( "cep" );
        String sexo = request.getParameter( "sexo" );
        String filho = request.getParameter( "filho" );
        String observacoes = request.getParameter( "observacoes" );
        
        Dados dados = new Dados();
        
        dados.setNome(nome);
        dados.setSobrenome(sobrenome);
        dados.setCpf(cpf);
        dados.setData(data);
        dados.setEmail(email);
        dados.setLogradouro(logradouro);
        dados.setNumero(numero);
        dados.setComplemento(complemento);
        dados.setCidade(cidade);
        dados.setEstado(estado);
        dados.setCep(cep);
        dados.setSexo(sexo);
        dados.setFilho(filho);
        dados.setObservacoes(observacoes);
        
        request.setAttribute("dadosObtido", dados);
       
        RequestDispatcher disp = request.getRequestDispatcher("exibeDados.jsp");
        disp.forward(request, response);
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
