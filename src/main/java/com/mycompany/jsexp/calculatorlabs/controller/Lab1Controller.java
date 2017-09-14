/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jsexp.calculatorlabs.controller;

import com.mycompany.jsexp.calculatorlabs.model.CalculationType;
import com.mycompany.jsexp.calculatorlabs.model.Lab1Service;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vekivulic
 */
@WebServlet(name = "CalculatorController", urlPatterns = {"/calc"})
public class Lab1Controller extends HttpServlet {
    private int requestCount = 0;
    
    private static final String INDEX = "/index.jsp";
    
    private static final String CALC_TYPE = "calcType";    
    
    private static final String CALC_TYPE_RECT_AREA = "rectArea";    
    private static final String CALC_TYPE_CIRCLE_AREA = "circleArea";    
    private static final String CALC_TYPE_RIGHT_TRI_HYP_LENGTH = "rightTriHypLength";    
    
    private static final String RECT_AREA_ANS_NAME = "msgAreaRect";
    private static final String CIRCLE_AREA_ANS_NAME = "msgAreaCircle";
    private static final String RIGHT_TRI_HYP_LENGTH_ANS_NAME = "msgHypRightTri";
    
    private static final String WIDTH_INPUT_NAME = "width";
    private static final String LENGTH_INPUT_NAME = "length";
    private static final String RADIUS_INPUT_NAME = "radius";
    private static final String SIDE_A_INPUT_NAME = "sideA";
    private static final String SIDE_B_INPUT_NAME = "sideB";
    
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
        response.setContentType("text/html;charset=UTF-8");
        String destination = INDEX;  
        String calcType = request.getParameter(CALC_TYPE);
        Lab1Service calcService = new Lab1Service();
        String answerText = "";
        try {
            if(calcType.equalsIgnoreCase(CALC_TYPE_RECT_AREA)){
                String length = request.getParameter(LENGTH_INPUT_NAME);
                String width = request.getParameter(WIDTH_INPUT_NAME);
                String[] values = {length, width};
                answerText = calcService.getResultForType(values, 
                        CalculationType.RECTANGLE_AREA);
                request.setAttribute(RECT_AREA_ANS_NAME, answerText);
            }else if(calcType.equalsIgnoreCase(CALC_TYPE_CIRCLE_AREA)){
                 String radius = request.getParameter(RADIUS_INPUT_NAME);
                 String[] values = {radius};
                 answerText = calcService.getResultForType(values, 
                         CalculationType.CIRCLE_AREA);
                 request.setAttribute(CIRCLE_AREA_ANS_NAME, answerText);
            }else if(calcType.equalsIgnoreCase(CALC_TYPE_RIGHT_TRI_HYP_LENGTH)){
                String sideA = request.getParameter(SIDE_A_INPUT_NAME);
                String sideB = request.getParameter(SIDE_B_INPUT_NAME);
                String[] values = {sideA, sideB};
                answerText = calcService.getResultForType(values, 
                        CalculationType.RIGHT_TRIANGLE_HYPOTENUSE_LENGTH);
                request.setAttribute(RIGHT_TRI_HYP_LENGTH_ANS_NAME, answerText);
            }
        } catch (Exception e) {
            destination = INDEX;
            request.setAttribute("errMsg", e.getMessage());
        }
        RequestDispatcher view =
                request.getRequestDispatcher(destination);
        view.forward(request, response);
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