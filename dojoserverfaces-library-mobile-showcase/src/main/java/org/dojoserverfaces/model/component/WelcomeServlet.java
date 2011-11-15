package org.dojoserverfaces.model.component;

import java.io.IOException;

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
        String hideAdressbar = "dojoserverfaces.mobile.hideaddressbar";
        String targetUrl = "/index.faces";
        if (agent.contains("iphone") || agent.contains("android")) {
            if (agent.contains("iphone")) {
                request.setAttribute(hideAdressbar, "false");
            }
            if (agent.contains("android")) {
                request.setAttribute(hideAdressbar, "null");
            }
            targetUrl = "/index-phone.faces";
        }
        request.getRequestDispatcher(targetUrl).forward(request, response);

    }

}
