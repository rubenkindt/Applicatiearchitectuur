/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlerPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionBeanPackage.administratieRemoteSessionBean;
import sessionBeanPackage.getGegevensDbBean;

/**
 *
 * @author r0656495
 */
public class ContolerServlet extends HttpServlet {
    @EJB
    private getGegevensDbBean ejbBean;
  
    @Override
    public void init(){
 
    }

    private administratieRemoteSessionBean beanMetDb;
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("submit").equals("Loginsucces")){//do change
           
            
            if(true){// Do change
               List lijstAlleMachines =ejbBean.getMachines();
               request.getSession().setAttribute("alleMachines", lijstAlleMachines);
               
               gotoPagina("overzichtDocent.jsp",request,response);
           }else{
               gotoPagina("overzichtStudentExtern.jsp",request,response);
           }
           
        }else if(request.getParameter("submit").equals("goToDocentDetailPagina")){
            String serieNr=request.getParameter("machineSerieNr");
            gotoPagina("DetailDocent.jsp",request,response);
            
        }else if(request.getParameter("submit").equals("goToStudentExtrnDetailPagina")){
            String serieNr=request.getParameter("machineSerieNr");
            gotoPagina("detailStudentExtern.jsp",request,response);
        
        }else if(request.getParameter("submit").equals("addNewMachine")){
            String serieNr=request.getParameter("machineSerieNr");
            
            gotoPagina("overzichtDocent.jsp",request,response);
        
        }
        
        
    }
   public void gotoPagina(String pagina, HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view;
    	view=request.getRequestDispatcher(pagina);
    	view.forward(request,response);

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
