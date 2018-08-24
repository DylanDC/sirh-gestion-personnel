package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

public class EditerCollaborateurControlleur extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// creation d'une session
		HttpSession session = req.getSession(true);
		String id = session.getId();

		// parametre le type de la réponse
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF8");
		// recuperer la valeur d'un parametre
		String matriculeParam = req.getParameter("matricule");
		session.setAttribute("test", matriculeParam);

		// recupere la valeur d'un parametre dont le nom est departement
		String titreParam = req.getParameter("titre");

		// recupere la valeur d'un parametre dont le nom est departement
		String nomParam = req.getParameter("nom");

		// recupere la valeur d'un parametre dont le nom est departement
		String prenomParam = req.getParameter("prenom");

		// verif parametre vide / remplit
		if (StringUtils.isBlank(matriculeParam) || StringUtils.isBlank(titreParam) || StringUtils.isBlank(nomParam)
				|| StringUtils.isBlank(prenomParam)) {
			String matMsg = "";
			String titreMsg = "";
			String nomMsg = "";
			String prenomMsg = "";

			if (matriculeParam == null || matriculeParam.equals("")) {
				matMsg = "Un matricule est attendu";
			}
			if (titreParam == null || titreParam.equals("")) {
				titreMsg = "Un titre est attendu";
			}
			if (nomParam == null || nomParam.equals("")) {
				nomMsg = "Un nom est attendu";
			}
			if (prenomParam == null || prenomParam.equals("")) {
				prenomMsg = "Un prenom est attendu";
			}

			resp.sendError(400, "Les prametres suivants sont manquant : " + matMsg + " " + titreMsg + " " + nomMsg + " "
					+ prenomMsg);
		}

		resp.getWriter().write("<html><head><meta charset=\"UTF-8\"></head><body><h1>Edition de collaborateur</h1>"
				+ "<ul>" + "<li> Matricule =" + matriculeParam + "</li>" + "<li> Titre =" + titreParam + "</li>"
				+ "<li> Nom =" + nomParam + "</li>" + "<li> Prénom =" + prenomParam + "</li>" + "</ul></body></html>");
		resp.setStatus(201);
	}

}
