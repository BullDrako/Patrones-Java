package proven.friends.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import proven.friends.model.User;
import proven.friends.model.persist.UserArrayDao;
import proven.friends.model.persist.UserDaoInterface;

public class LoginServlet extends HttpServlet {

    private UserDaoInterface users;
    private ServletContext context;

    public void init() throws ServletException {
        users = new UserArrayDao();
        context = this.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //HttpSession session = req.getSession();
        String user = req.getParameter("user");
        String password = req.getParameter("password");
        this.context.log(users + ":" + user + "/" + password);
        if (user != null && password != null) {
            if (users.login(new User(user, password))) {
                HttpSession session = req.getSession();
                User u = users.find(user);
                session.setAttribute("user", user);
                session.setAttribute("role", u.getRole());
                response(req, resp, "Login ok ");
            }
        }
        response(req, resp, "Invalid login");
    }

    private void response(HttpServletRequest req, HttpServletResponse resp, String msg)
            throws IOException, ServletException {
        req.setAttribute("message", msg);
        RequestDispatcher rd = 
                getServletContext().getRequestDispatcher("/WEB-INF/jsp/message.jsp");
	rd.forward(req, resp);
    }
}