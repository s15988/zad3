package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(urlPatterns = {"person.jsp","adres.jsp","succes.jsp"})
public class FirstStepFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        chain.doFilter(request,response);
        if(session.getAttribute("number") == null) {
            httpResponse.sendRedirect(((HttpServletRequest) request).getContextPath() + "/index.jsp");
        }





    }
    @Override
    public void destroy() {

    }
}
