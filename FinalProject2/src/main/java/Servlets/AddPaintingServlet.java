/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Java_Classes.PaintingArray;
import Java_Classes.PaintingList;
import Java_Classes.PaintingType;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dilbd
 */
public class AddPaintingServlet extends HttpServlet {

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
        //get the paintinglist form the session and store it in paintings 
        HttpSession session = request.getSession();
        PaintingList paintings = (PaintingList) session.getAttribute("paintinglist");

        //if the list has no paintings, the creates a new paintingslist 
        if (paintings == null) {
            paintings = new PaintingList();
        }

        //get the serialNumber and name of the paintings form the request
        String serialNumber = request.getParameter("serialNumber");
        String name = request.getParameter("name");

        //finding the paintingtype stored in the session
        PaintingArray allpaintings = (PaintingArray) session.getAttribute("paintingarray");
        PaintingType painting2 = allpaintings.getPaintingType(serialNumber, name);

        //PaintingType painting = (PaintingType)session.getAttribute("currentpainting");
        //adding the paintingtype in the painting cart and storing the modified cart into session
        paintings.add(painting2);
        session.setAttribute("paintinglist", paintings);

        getServletContext().
                getRequestDispatcher("/PaintingCart.jsp").
                forward(request, response);
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
