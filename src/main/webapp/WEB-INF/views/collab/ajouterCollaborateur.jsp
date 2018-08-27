
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Refresh" content="60"> 
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>Ajout collaborateur</title>
</head>
<body>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>



	
	<h1>Nouveau collaborateur</h1>
	<div class="container" id="top">
		<form  method="post" class="needs-validation" novalidate>
			<!-- 		<div class="form-row"> -->
			<div class="form-row">
				<div class="col-8">
					<label for="validationNom">Nom</label> <input type="text"
						class="form-control" id="validationNom" placeholder="Nom" required>
					<div class="valid-feedback">OK!</div>
					<div class="invalid-feedback">Le nom est obligatoire</div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-8">
					<label for="validationPrenom">Prénom</label> <input type="text"
						class="form-control" id="validationPrenom" placeholder="Prénom"
						required>
					<div class="valid-feedback">OK!</div>
					<div class="invalid-feedback">Le prénom est obligatoire</div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="validationDate">Date de Naissance</label> <input
						type="date" class="form-control" id="validationDate"
						placeholder="Username" aria-describedby="inputGroupPrepend"
						required>
					<div class="invalid-feedback">La date de naissance est
						obligatoire</div>
				</div>
			</div>
			<!-- 		</div> -->
			<div class="form-row">

				<div class="col-md-6 mb-3">
					<label for="validationAdresse">Adresse</label> <input type="text"
						class="form-control" id="validationAdresse" placeholder="Adresse"
						required>
					<div class="invalid-feedback">L'adresse est obligatoire</div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3 mb-3">
					<label for="validationNumeroSecu">Numéro de sécurité
						sociale</label> <input type="number" max="999999999999999" class="form-control"
						id="validationNumeroSecu" placeholder="Numéro de sécurité sociale"
						required>
					<div class="invalid-feedback">Le numéro de sécurité sociale
						est obligatoire</div>
				</div>
			</div>

			
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-primary" onclick="trouve()"
				data-toggle="modal" data-target="#exampleModal">Ajouter</button>
				
				<% Date dateHeureCreation = new java.util.Date(); %>
				
		</form>



		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Fenêtre de
							confirmation</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body" id="test">Vous êtes sur le point
						d'ajouter un nouveau collaborateur</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" onclick ="close1()" >Close</button>
						<button type="button" class="btn btn-primary">Save
							changes</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		// Désactiver le bouton de submission si valeur incorrect/vide
		
		function trouve() {
			//on récupère la valeur du formulaire
			var nom = document.getElementById("validationNom").value;
			// on crée un paragraphe
			var newP = document.createElement("p")
			// 			on récupère l'emplacement où l'on veut afficher notre texte
			monNode = document.getElementById("test");
			// 			On récupère la valeur 
			textnode = document.createTextNode(nom);
			// 			on ajoute la valeur au nouveau paragraphe
			newP.appendChild(textnode);
			// 			on ajoute le nouveau paragraphe au mode
			monNode.appendChild(newP);
			var nom = document.getElementById("validationPrenom").value;
			var newP = document.createElement("p")
			monNode = document.getElementById("test");
			textnode = document.createTextNode(nom);
			newP.appendChild(textnode);
			monNode.appendChild(newP);
			var nom = document.getElementById("validationDate").value;
			var newP = document.createElement("p")
			monNode = document.getElementById("test");
			textnode = document.createTextNode(nom);
			newP.appendChild(textnode);
			monNode.appendChild(newP);
			var nom = document.getElementById("validationAdresse").value;
			var newP = document.createElement("p")
			monNode = document.getElementById("test");
			textnode = document.createTextNode(nom);
			newP.appendChild(textnode);
			monNode.appendChild(newP);
			var nom = document.getElementById("validationNumeroSecu").value;
			var newP = document.createElement("p")
			monNode = document.getElementById("test");
			textnode = document.createTextNode(nom);
			newP.appendChild(textnode);
			monNode.appendChild(newP);
		}
	</script>

</body>
</html>