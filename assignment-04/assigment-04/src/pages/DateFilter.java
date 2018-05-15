package pages;


import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/*for intercept and proccess requests before they are sends to servlet
  * servlet filter */

public class DateFilter implements Filter {

    public DateFilter() {
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("Filter init!");
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroy!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String servletPath = req.getServletPath();

        System.out.println("#INFO " + new Date()
                + " - ServletPath :" + servletPath + ", URL =" + req.getRequestURL());


        // Go to the next element (filter or target) in chain.
        chain.doFilter(request, response);
    }
}
