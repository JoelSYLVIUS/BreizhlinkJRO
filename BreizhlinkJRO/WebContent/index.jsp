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
			<jsp:include page="menu.jsp"/>
		</div>
	</header>
	<section style="min-height:60vh;">
		<div class="container padtop">
			<form action="raccourcis" method="post">
				<div class="row">
					<div class="input-field col s1 right-align hei4">
						<label class="white-text" for="url"><span class="typ">URL</span></label>
					</div>
					<div class="input-field col s8 hei4">
						<input class="inplink" type="text" name="url" id="url" placeholder="Votre url à racourcir" required="">
					</div>
					<div class="input-field col s3 hei4" style="padding-left:20px;">
						<button type="submit" class=" right-align waves-effect waves-light btn-large amber" style="padding-top:-5px!important;">Raccourcir le lien</button>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s2 right-align">
						<a id="addmdp" class="btn-floating amber pulse"><i class="material-icons">enhanced_encryption</i></a>
					</div>
					<div id="tmdp" style="display:block;"><p class="white-text tmdpp">Sécurisée avec un mot de passe</p></div>
					<div id="mdpadd" class="input-field col s7 hei4" style="display:none;">
						<input class="inplink" type="password" name="mdp" id="url" placeholder="Veuillez saisir un mot de passe">
					</div> 
				</div>
			</form>
			<div class="row center">
				<p class="white-text tmdpp" style="text-shadow: 0 0 4px #000000;">Créer un compte pour voir nos autres options possibles</p>
			</div>  
		</div>
	</section>
	<jsp:include page="footer.jsp"/>
</html>
