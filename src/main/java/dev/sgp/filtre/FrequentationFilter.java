package dev.sgp.filtre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;

public class FrequentationFilter implements Filter {
	int compteur;
	private FilterConfig visite = null;

	@Override

	public void init(FilterConfig visite) throws ServletException {

		this.visite = visite;

		visite.getServletContext().log("TimerFilter initialized");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain visite)
			throws IOException, ServletException {

		long before = System.currentTimeMillis();

		visite.doFilter(request, response);
		compteur++;
		long after = System.currentTimeMillis();

		String path = ((HttpServletRequest) request).getRequestURI();

		Integer timeExe = (int) (after - before);

		VisiteWeb status = new VisiteWeb(compteur, path, timeExe);

	}
}
