<nav class="transparent">
	<ul>
		<li class="col l2 center-align ambre-text"><a href="index.jsp">Accueil</a></li>
		<li class="col l2 center-align ambre-text"><a href="presentation.jsp">Pr�sentation</a></li>
		<li class="col l2 center-align ambre-text"><a href="inscription.jsp">Cr�ation d'un compte</a></li>
		<% if ((request.getParameter("pseudo")) != null){ %>
			<li class="col l2 center-align ambre-text"><a href="#!">Raccourcir</a></li>
			<li class="col l2 center-align ambre-text"><a href="#!">Mon compte</a></li>
			<li class="col l2 center-align ambre-text"><a href="logout">D�connexion</a></li>
		<%} else { %>
			<li class="col l2 center-align ambre-text disabled"><a href="#!"></a></li>
			<li class="col l2 center-align ambre-text disabled"><a href="#!"></a></li>
			<li class="col l2 center-align ambre-text"><a href="login.jsp">Connexion</a></li>
		<%} %>
		
		
	</ul>
</nav> 