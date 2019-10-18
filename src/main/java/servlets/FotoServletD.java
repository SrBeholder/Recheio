/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controles.FotoControle;
import entidades.Foto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FotoServletD extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Captura id da tela
        String idtext = request.getParameter("pid");
        
        //Cria instancia do usuario com id informado
        Foto foto = new Foto();
        foto.setId(Integer.parseInt(idtext));
        
        //Chama de funcao para apagar usuario
        FotoControle.deletar(foto);
        
        //Redireciona pagina
        response.sendRedirect("fotolistarmaismais.jsp");
    }
}
