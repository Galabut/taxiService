package control;

import domain.Users;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Galabut on 14.04.2015.
 */
@WebServlet("/authServlet")
public class AuthenticationServlet extends HttpServlet {
    private Service service;
    private WebApplicationContext context;

    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        service = context.getBean("ServiceImpl", Service.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (service.getUser(login, password)) {
            HttpSession session = req.getSession();
            session.setMaxInactiveInterval(5 * 60);
            String users = generateUsersTable(service.findAll());
            session.setAttribute("users", users);
            resp.sendRedirect("/taxi/index.jsp");
        } else req.setAttribute("error", "invalid login or password");
        req.setAttribute("login", login);
        req.setAttribute("password", password);
        req.getRequestDispatcher("/taxi/index.jsp").forward(req, resp);
    }

    private String generateUsersTable(List<Users> users) {
        String formatStr = "</tr>"
                + "</td><a href> = /taxi/user.jsp>%s</a></td>"
                + "<td>%s</td>"
                + "</tr>";
        String tableStr = "";
        for (Users users1 : users) {
            tableStr += formatStr + users1.getLogin() + users1.getPassword() + "\n";
        }
        return tableStr;
    }
}
