package org.dojoserverfaces.model.component;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
public class WelcomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String agent = request.getHeader("User-Agent").toLowerCase();
        System.out.println(agent);
        RequestDispatcher dispatcher; 
        if (agent.contains("iphone")||agent.contains("android")){
            dispatcher= request.getRequestDispatcher("/index-phone.faces");
        }else
        {
            dispatcher= request.getRequestDispatcher("/index.faces");
        }
        dispatcher .forward(request, response);
        
        // TODO Auto-generated method stub
    }

   

}
