/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletNoticiasB;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author GS-Server
 */
@WebServlet(name = "ServletNoticias", urlPatterns = {"/ServletNoticias"})
public class ServletNoticias extends HttpServlet {

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
            throws ServletException, IOException, ParseException, JSONException {
        response.setContentType("application/json; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {

            String option = request.getParameter("option");
            switch (option) {
                case "loca":
                    out.println(codificar(selectLocal(request, response).toString()));
                    break;

                case "nacio":
                    out.println(codificar(selectNacional(request, response).toString()));
                    break;
            }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletNoticias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ServletNoticias.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletNoticias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ServletNoticias.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private JSONObject selectLocal(HttpServletRequest request, HttpServletResponse response) throws ParseException, JSONException, UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        DAONoticias not = new DAONoticias();
        String json = null;
        JSONObject n = new JSONObject();
        not.emptys(not.noticias2("https://www.elsoldetoluca.com.mx/rss.xml"));
        not.emptys(not.noticias2("https://www.elsoldetoluca.com.mx/rss.xml"));

        not.emptys(not.noticias2("http://www.bbc.com/mundo/ultimas_noticias/index.xml#sa-link_location=story-body&intlink_from_url=http://www.bbc.com%2%E2%80%A6"));

        not.emptys(not.noticias2("http://www.elnuevoheraldo.com/search/?q=&t=article&l=25&d=&d1=&d2=&s=start_time&sd=desc&c[]=noticias*&f=rss"));
        // System.out.println("ismael "+ not.emptys(not.noticias2("https://www.elsoldetoluca.com.mx/rss.xml")));

        n.put("results", not.emptys(not.noticias2("http://diario-puntual.com.mx/category/cultura/feed/")).toString());
        return n;
    }

    private JSONObject selectNacional(HttpServletRequest request, HttpServletResponse response) throws ParseException, JSONException, UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        DAONoticias not = new DAONoticias();
        String json = null;
        JSONObject n = new JSONObject();
        not.emptys(not.noticias2("http://trespm.com.mx/category/c12-locales/feed/"));
        not.emptys(not.noticias2("http://www.radioformula.com.mx/read/portadas/politica.rss"));
        not.emptys(not.noticias2("https://www.elsoldemexico.com.mx/rss.xml"));
        n.put("results", not.emptys(not.noticias2("http://www.unomasuno.com.mx/feed/")).toString());
        return n;
    }

// convertir a centos
    public static String codificar(String texto) {
        try {
            texto = new String(texto.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return texto;
    }

}
