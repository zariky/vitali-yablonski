package jmp.module13.web.servlets;

import jmp.module03.beans.Person;
import jmp.module03.dao.impl.DatabasePersonDAO;
import jmp.module03.services.PersonService;
import jmp.module03.services.impl.PersonServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PersonServlet extends HttpServlet {

    private PersonService personService;

    @Override
    public void init() throws ServletException {
        personService = new PersonServiceImpl(new DatabasePersonDAO());
    }

    @Override
    public void destroy() {
        personService.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print(personService.findAll());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name != null && ! name.isEmpty()) {
            personService.save(new Person(name));
        }
        response.sendRedirect("/module-13/index.html");
    }

}