/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Java_Classes.PaintingType;
import Java_Classes.PaintingErrorList;
import Java_Classes.PaintingList;
import Java_Classes.PaintingValidation;
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
public class ValidatePaintingServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        String nextPage = "/AdditionalDetails.jsp";

        // getting the information from the form.
        String serialNumber = request.getParameter("serialNumber");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        String date = request.getParameter("date");

        //creating a new object for all the error messages we might have to send back to JSP page
        PaintingErrorList errors = new PaintingErrorList();

        //Passing all information form the form to validate and keeping record if anything went wrong
        boolean isNameValid = PaintingValidation.validateName(name, errors);
        boolean isserialNumberValid = PaintingValidation.validateserialNumber(serialNumber, errors);
        boolean isPriceValid = PaintingValidation.validatePrice(price, errors);
        boolean isTypeValid = PaintingValidation.validateType(type, errors);
        boolean isDescriptionValid = PaintingValidation.validateDescription(description, errors);
        boolean isDateValid = PaintingValidation.validateDate(date, errors);

        //if valid information is entered in the form then adding a new painting to the list
        // Otherwise redirecting back to create painting page
        if (isNameValid && isserialNumberValid && isTypeValid && isPriceValid && isDescriptionValid && isDateValid) {
            PaintingList paintings = (PaintingList) session.getAttribute("paintinglist");
            if (paintings == null) {
                paintings = new PaintingList();
            }
            //paintings.add(type, name, date, description, serialNumber, price);
            PaintingType t = new PaintingType(serialNumber, name, Double.parseDouble(price),type, date, description);
            paintings.add(t);

            session.setAttribute("currentpainting", paintings.getPaintingTypes(serialNumber, name));
            session.setAttribute("paintinglist", paintings);
        } else {
            nextPage = "/CreatePainting.jsp";

            //Adding the validation object to the session for use by the JSP
            request.setAttribute("errors", errors);
        }
        getServletContext().getRequestDispatcher(nextPage).forward(request, response);
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
