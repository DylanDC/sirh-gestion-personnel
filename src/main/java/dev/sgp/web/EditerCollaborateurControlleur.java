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

		// recupere la valeur d'un parametre dont le nom est avecPhoto
		// recupere la valeur d'un parametre dont le nom est departement
		String matriculeParam = req.getParameter("matricule");
		resp.setContentType("text/html");

		if (matriculeParam != null && matriculeParam.equals("M01")) {

			resp.getWriter().write("<h1>Edition de collaborateur</h1>");
			resp.getWriter().write("Matricule : " + matriculeParam);

		}
		if (matriculeParam == null || matriculeParam.equals("")) {
			resp.sendError(400, "Code matricule attendu");
		}
		HttpSession session = req.getSession(true);
		session.setAttribute("modif", 0);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// parametre le type de la réponse
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF8");
		// recuperer la valeur d'un parametre
		String matriculeParam = req.getParameter("matricule");

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

	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// création session d'une session / recuperation si deja existante
		HttpSession session = req.getSession(true);

		// resp.getWriter().write(id);

		String matricule = req.getParameter("matricule");
		String titre = req.getParameter("titre");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String matriculeMsg = "";
		String prenomMsg = "";
		String titreMsg = "";
		String nomMsg = "";
		if (StringUtils.isBlank(matricule) || StringUtils.isBlank(titre) || StringUtils.isBlank(prenom)
				|| StringUtils.isBlank(nom)) {

			if (StringUtils.isBlank(matricule)) {
				matriculeMsg = "Matricule";
			}
			if (StringUtils.isBlank(titre)) {
				titreMsg = "Titre";
			}
			if (StringUtils.isBlank(prenom)) {
				nomMsg = "Nom";
			}
			if (StringUtils.isBlank(nom)) {
				prenomMsg = "Prenom";
			}

			resp.sendError(400, "Les paramètres suivants sont incorrects : " + matriculeMsg + " " + titreMsg + " "
					+ nomMsg + " " + prenomMsg + "");

		}

		else {

			if ((int) session.getAttribute("modif") == 0) {

				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html");
				resp.getWriter().write("<meta charset = \"UTF-8\" />"
						+ " Modification d'un collaborateur avec les informations suivantes : ");
				resp.getWriter().write(" <ul><li>Matricule : " + matricule + "</li>" + "<li>Titre : " + titre + "</li>"
						+ "<li>Nom : " + nom + "</li>" + "<li>Prénom : " + prenom + "</li>");

				session.setAttribute("modif", 1);

			}

			else {
				resp.setCharacterEncoding("UTF-8");
				resp.setStatus(403);
				resp.getWriter().write("<meta charset = \"UTF-8\" /><h1>Vous avez déjà modifier le matricule : "
						+ req.getParameter("matricule") + "</h1>");
			}
		}

	}

}
