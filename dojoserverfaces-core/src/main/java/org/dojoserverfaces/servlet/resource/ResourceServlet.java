/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.servlet.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * The ResourceServlet class defines a servlet used to serve JWL2 resources.
 */

@WebServlet(name = ResourceServlet.JSF_DOJO_RESOURCE_URI,
		displayName = "DojoServerFaces Resource Servlet", 
		urlPatterns = { "/" + ResourceServlet.JSF_DOJO_RESOURCE_URI + "/*" })
public class ResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 6749184552913973533L;

	private static final String DOJO_RESOURCE_FOLDER = "dojotoolkit";

	protected static final String SERVLET_PATH = "/" + ResourceServlet.JSF_DOJO_RESOURCE_URI;

	/**
	 * The path for the resource servlet when serving code.
	 */
	private static final String DOJO_RESOURCE_SERVLET_PATH = 
		ResourceServlet.SERVLET_PATH + "/" + ResourceServlet.DOJO_RESOURCE_FOLDER;

	private static final byte buffer[] = new byte[8192];

	public static final String JSF_DOJO_RESOURCE_URI = "resource.dojoserverfaces.org";

	/*
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String pathInfo = request.getPathInfo();
		if (pathInfo.equals("")) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		// Try to load the resource from the classpath.
		String resourcePath = 
			new StringBuilder("META-INF/")
			.append(ResourceServlet.JSF_DOJO_RESOURCE_URI)
			.append(pathInfo).toString();
		
		InputStream input = getClass().getClassLoader().getResourceAsStream(resourcePath);
		if (input == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // Not found, so send a 404.
			return;
		}
		int read;
		OutputStream output = response.getOutputStream();
		// Serve up the resource.
		response.setContentType(ContentTypeMapper.getContentType(pathInfo));
		while ((read = input.read(ResourceServlet.buffer)) != -1) {
			output.write(ResourceServlet.buffer, 0, read);
		}
		output.flush();
		output.close();
	}

	public static String getDojoResourcePath(FacesContext context, String dojoResource) {
		return context.getApplication().getViewHandler().getResourceURL(context, 
				DOJO_RESOURCE_SERVLET_PATH + dojoResource);
	}
	public static Object getDojoResourcePath() {
		return DOJO_RESOURCE_SERVLET_PATH;
	}
}
