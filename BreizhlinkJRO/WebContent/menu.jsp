<nav class="transparent">
	<ul>
		<li class="col l2 center-align ambre-text"><a href="index.jsp" class="hoverable tshadb">Accueil</a></li>
		<li class="col l2 center-align ambre-text"><a href="presentation.jsp" class="hoverable tshadb">Pr�sentation</a></li>
		<li class="col l2 center-align ambre-text"><a href="inscription.jsp" class="hoverable tshadb">Cr�ation d'un compte</a></li>
		<%Integer iduser = (Integer) session.getAttribute("iduser");
			String prenomuser = (String) session.getAttribute("prenomuser");
			String nomuser = (String) session.getAttribute("nomuser");
			String emailuser = (String) session.getAttribute("emailmuser");
			String pseudo = (String) session.getAttribute("pseudo");
			String password = (String) session.getAttribute("mdp");
		 if ((session.getAttribute("pseudo")) != null){ %>
			<li class="col l2 center-align ambre-text"><a href="raccourcis.jsp" class="hoverable tshadb">Raccourcir</a></li>
			<li class="col l2 center-align ambre-text"><a href="userprofile" class="hoverable tshadb">Mon compte</a></li>
			<li class="col l2 center-align ambre-text"><a href="logout" class="hoverable tshadb">D�connexion </a></li>
		<%} else { %>
			<li class="col l2 center-align ambre-text disabled"><a href="#!"></a></li>
			<li class="col l2 center-align ambre-text disabled"><a href="#!"></a></li>
			<li class="col l2 center-align ambre-text"><a href="login.jsp" class="hoverable tshadb">Connexion</a></li>
		<%} %>
	</ul>
</nav> 