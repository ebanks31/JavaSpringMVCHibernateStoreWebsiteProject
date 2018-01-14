package com.ebanks.springapp.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * The Class MetricFilter.
 */
public class MetricFilter implements Filter {

    /** The metric service. */
    private MetricService metricService;

	/**
	 * {@inheritDoc}
	 *
	 * @param config the filter config
	 */
    @Override
    public void init(FilterConfig config) throws ServletException {
        metricService = (MetricService) WebApplicationContextUtils
         .getRequiredWebApplicationContext(config.getServletContext())
         .getBean("metricService");
    }

	/**
	 * {@inheritDoc}
	 *
	 * @param request the HTTP servlet request object
	 * @param response the HTTP servlet response object
	 */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws java.io.IOException, ServletException {
        HttpServletRequest httpRequest = ((HttpServletRequest) request);
        String req = httpRequest.getMethod() + " " + httpRequest.getRequestURI();

        chain.doFilter(request, response);

        int status = ((HttpServletResponse) response).getStatus();
        metricService.increaseCount(req, status);
    }

	/*
	 * {@inheritDoc}
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}