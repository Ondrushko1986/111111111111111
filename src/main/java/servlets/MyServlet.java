package servlets;

import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class MyServlet extends HttpServlet {

    private static Map<String, Object> createPageValueMap(HttpServletRequest request) {
        Map<String, Object> pageValue = new HashMap<>();
        return pageValue;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {


        String newValue = request.getParameter("value");

        if (newValue == null || newValue.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            boolean flag = newValue.chars().allMatch(Character::isLetter);
            if (flag) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.sendError(400);
            } else {
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().println(new PageGenerator().getPage("page.html",pageValue);
                response.setContentType("text/html;charset=utf-8");
            }

        }
        Map<String, Object> pageValue = createPageValueMap(request);
        pageValue.put("doubleValue is", Integer.parseInt(newValue) * 2);
    }
}

