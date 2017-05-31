package proven.friends.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import proven.friends.model.persist.UserArrayDao;
import proven.friends.model.persist.UserDaoInterface;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

	private ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
                this.context.log("FILTRE AuthenticationFilter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		this.context.log("Requested Resource::"+uri);
                //this.context.log("FILTRE DE DADES");
		
		HttpSession session = req.getSession(false);
		
                // Si no hi ha sessió o demanem una pàgina != html o !=LoginServlet 
                // fer la prova demanant l'imatge penguin.jpg
		if(session == null && !(uri.endsWith("html") || uri.endsWith("login")) ){
			this.context.log("Unauthorized access request");
			res.sendRedirect("login.html");
		}else{
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		
		
	}

	

	public void destroy() {
		//close any resources here
	}

}