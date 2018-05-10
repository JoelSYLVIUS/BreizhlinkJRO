
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
	<% if ((session.getAttribute("pseudo")) != null){ %>
	<section style="min-height:60vh;">
		<div class="container padtop">
			<form action="raccourcisusr" method="post">
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
				<div class="row">
					<label>
				        <input id="indeterminate-checkbox" type="checkbox" name="check" value="1"/>
				        <span class="white-text tshadb f40">Ajouter un captcha à votre url</span>
				    </label>
				</div>
				<div class="row">
					<div class="input-field col s1 hei4">
						<input class="inplink" type="number" name="clicmax" id="clicmax" placeholder="ex:10" value="null">
					</div>
					<div class="input-field col s8 hei4">
						<label class="white-text tshadb f40">Définisser un nombre de clic pour utiliser votre url</label>
					</div>
				</div>
				<div class="row">
					<input type="hidden" name="iduser" value="${iduser}">
				</div>
				<div class="row">
					<div class="col s12 center">
						<div class="row">
							<div class="col s6 Show11 bgcn02">
								<h2 class="white-text tshadb f40 Show">Date limite</h2>
							</div>
							<div class="col s6 center Show12">
								<h2 class="white-text tshadb f40 Show1">Periode de validité</h2>
							</div>
						</div>
						<div class="row hei50">
							<div class="col s12 center target">
								<div class="row">
									<span class="white-text tshadb f40 tmdpp"> Définisser une date limite de validiter de votre url</span>
								</div>
								<div class="row">
									<div class="input-field col s2 offset-s5 hei4">
										<input type="text" class="datepicker white-text tshadb inplink" name="datelimit">
										<label class="white-text tshadb" for="dtp">Date limite</label>
									</div>
								</div>
							</div>
							<div class="col s12 target1">
								<div class="row">
								 	<div class="col s12 center">
										<span class="white-text tshadb f40 tmdpp"> Définisser une période durant laquelle votre url sera valide</span>
									</div>
								</div>
								<div class="input-field col s4 offset-S1 hei4">
									<input type="text" class="datepicker white-text tshadb inplink" name="datestart">
									<label class="white-text tshadb" for="dtp">Date de début</label>
								</div>
								<div class="input-field col s4 offset-S1 hei4">
									<input type="text" class="datepicker white-text tshadb inplink" name="dateend">
									<label class="white-text tshadb" for="dtp">Date de fin</label>
								</div>
							</div>
						</div>	
					</div>
				</div>
			</form>
			 
		</div>
	</section>
	<% } else { %>
	<section class="center">
		<h1 class="white-text tshadb">Vous n'etes pas connecter</h1>
		<br><br><br><br>
		<p class="white-text tshadb f40">
			Veuillez vous connecter pour avoir accès aux contenue de cette page!
		</p>
		<br><br><br><br>
		<p class="white-text margbot">
			<a href="login.jsp" class=" white-text hoverable tshadb f40">Connexion</a>
		</p>
	</section>
	
	<% } %>
	<jsp:include page="footer.jsp"/>
	
	
		
	
</html>
