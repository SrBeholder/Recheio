package servlets;

import controles.FotoControle;
import entidades.Foto;
import entidades.Usuario;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

public class FotoServletS extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Captura arquivo da tela
        Part parteArquivo = request.getPart("foto");
        if (parteArquivo != null) {
            InputStream inputStream = parteArquivo.getInputStream();
            
            //Instancia foto e carrega informacoes
            Foto foto = new Foto();            
            foto.setFoto(IOUtils.toByteArray(inputStream));            
            foto.setExtensao(parteArquivo.getContentType());
            //Define usuario
            Usuario usuario = new Usuario();
            usuario.setId(201);
            foto.setUsuario(usuario);
            
            FotoControle.salvar(foto);
        }
              
        response.sendRedirect("fotolistarmaismais.jsp");
    }
}
