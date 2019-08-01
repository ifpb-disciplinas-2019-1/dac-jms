package br.edu.ifpb.mensagem;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Job
 */
@WebServlet(name = "ControladorDeMensagens",urlPatterns = {"/mensagem"})
public class ControladorDeMensagens extends HttpServlet {

    @Inject
    private ProdutorDeMensagens produtor;

    @Inject
    private ConsumidorDeMensagens consumidor;

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {

        String mensagem = consumidor.lerMensagen();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorDeMensagens</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Mensagem: " + mensagem + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        String texto = request.getParameter("corpo");
        this.produtor.enviarNovaMensagem(texto);
    }

}
