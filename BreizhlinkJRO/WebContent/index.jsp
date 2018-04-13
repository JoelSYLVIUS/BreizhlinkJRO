<jsp:include page="header.jsp"/>
<body>
	<header>
		<div class="row margtop">
			<div class="col l4">
				<img src="" alt="" width="100%" height="100%">
			</div>
			<div class="col l8">
				<img src="" alt="" width="100%" height="100%">
			</div>
		</div>
		<div class="row">
			<nav class="transparent">
				<ul>
					<li class="col l2 center-align ambre-text"><a href="#!">Accueil</a></li>
					<li class="col l2 center-align ambre-text"><a href="#!">Présentation</a></li>
					<li class="col l2 center-align ambre-text"><a href="#!">Création d'un compte</a></li>
					<li class="col l2 center-align ambre-text"><a href="#!">Raccourcir</a></li>
					<li class="col l2 center-align ambre-text"><a href="#!">Mon compte</a></li>
					<li class="col l2 center-align ambre-text"><a href="#!">Déconnexion</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<section style="min-height:60vh;">
		<div class="container padtop">
			<form action="!#" method="post">
				<div class="row">
					<div class="input-field col s1 right-align hei4">
						<label class="white-text" for="url"><span class="typ">URL</span></label>
					</div>
					<div class="input-field col s8 hei4">
						<input class="inplink" type="text" name="url" id="url">
					</div>
					<div class="input-field col s3 hei4" style="padding-left:20px;">
						<a class=" right-align waves-effect waves-light btn-large amber" style="padding-top:-5px!important;">Raccourcir le lien</a>
					</div>
				</div>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"/>
</html>
