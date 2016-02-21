package jmp.module11.web.servlets;

import jmp.module11.services.UserService;
import jmp.module11.services.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The Servlet
 */
public class UserServlet extends HttpServlet {

    private static final String HTML_TEMPLATE =
            "<html>" +
            "    <head><title>jmp module 11</title></head>" +
            "    <body>%s</body>" +
            "</html>";

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print(String.format(HTML_TEMPLATE, userService.findAll()));
    }

}