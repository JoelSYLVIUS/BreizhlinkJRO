<nav class="transparent">
	<ul>
		<li class="col l2 center-align ambre-text"><a href="index.jsp" class="hoverable">Accueil</a></li>
		<li class="col l2 center-align ambre-text"><a href="presentation.jsp" class="hoverable">Présentation</a></li>
		<li class="col l2 center-align ambre-text"><a href="inscription.jsp" class="hoverable">Création d'un compte</a></li>
		<% if ((request.getParameter("pseudo")) != null){ %>
			<li class="col l2 center-align ambre-text"><a href="#!" class="hoverable">Raccourcir</a></li>
			<li class="col l2 center-align ambre-text"><a href="#!" class="hoverable">Mon compte</a></li>
			<li class="col l2 center-align ambre-text"><a href="logout" class="hoverable">Déconnexion</a></li>
		<%} else { %>
			<li class="col l2 center-align ambre-text disabled"><a href="#!"></a></li>
			<li class="col l2 center-align ambre-text disabled"><a href="#!"></a></li>
			<li class="col l2 center-align ambre-text"><a href="login.jsp" class="hoverable">Connexion</a></li>
		<%} %>
		
		
	</ul>
</nav> 