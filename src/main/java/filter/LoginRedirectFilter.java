/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A filter class that handles filteration of diffrent pages based on the users roll. Makes it possible to restric certain pages from none users or none admins. 
 * @author Anton Ekman
 */
@WebFilter({"/temp.xhtml", "/accountpage.xhtml"})

public class LoginRedirectFilter extends HttpFilter {

    @Inject
    private ServletContext context;

    @Inject
    private SecurityContext securityContext;

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        if (securityContext.getCallerPrincipal() != null) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(context.getContextPath());

        }
    }

}
