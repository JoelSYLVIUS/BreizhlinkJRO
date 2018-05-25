<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="inc/header.jsp"/>
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
			<jsp:include page="inc/menu.jsp"/>
		</div>
	</header>
		<% if ((session.getAttribute("pseudo")) != null){ %>
	<section style="min-height:60vh;">
		<div class="container">
			<div class="row">
			
				<div class="col s5">
				
					<h1 class="white-text f40" style="text-shadow: 0 0 4px #000000;">Information de votre profil</h1>
					<form action="inscriptuser" method="post" class="col s12 inplink formgen">

						<div class="row">
				               <div class="input-field col s11 m11 l6">
				                     <input placeholder="Votre Prénom" name="prenom" id="first_name" type="text" class="validate white-text tshadb inplink" value="${prenomuser}">
				                     <label class="white-text" for="first_name">Prénom*</label>
				               </div>
				               <div class="input-field col s11 m11 l5">
				                     <input placeholder="Votre nom" name="nom" id="last_name" type="text" class="validate white-text tshadb inplink" value="${nomuser}">
				                     <label class="white-text" for="last_name">Nom*</label>
				               </div>
             			</div>
             			
             			<div class="row">
		                 	<div class="input-field col s11">
		                     	<input placeholder="Votre pseudo" name="pseudo" id="pseudo" type="text" class="validate white-text tshadb inplink" value="${pseudo}">
		                     	<label class="white-text" for="pseudo">Pseudo*</label>
		              		</div>
		              	</div>
					
						<div class="row">
			               <div class="input-field col s11">
			                     <input placeholder="Votre email" name="email" id="email" type="email" class="validate white-text tshadb inplink" value="${emailuser}">
			                     <label class="white-text" for="email">Email*</label>
			               </div>
						</div>
						
						<div class="row">
			               <div class="input-field col s11">
			                     <input placeholder="Votre mot de passe" name="password" id="password" type="password" class="validate white-text tshadb inplink" value="${password}">
			                     <label class="white-text" for="password">Mot de passe*</label>
			               </div>
		             	</div>
		             	
		             	<div class="row">
			                 <div class="col l12 center">
			                     <input type="submit" value="Modifier" class="btn btn-success amber hoverable">
			                 </div>
			         	</div>

					</form>
				</div>
				
				<div class="col s6 offset-s1">
					<div class="row">

					<table class="highlight responsive-table white-text inplink">
				        <thead>
				          <tr>
				              <th>Lien original</th>
				              <th>Lien raccourci<th>
				          </tr>
				        </thead>
				
				        <tbody>
				          <tr>
				            <td>${link}</td>
				            <td>https://localhost:8080/xf5s3</td>
				          </tr>
				          <tr>
				            <td>Alan</td>
				            <td>Jellybean</td>
				          </tr>
				          <tr>
				            <td>Jonathan</td>
				            <td>Lollipop</td>
				          </tr>
				        </tbody>
				     </table>

					</div>
				</div>
			</div> 
		</div>
	</section>
	
	<% } else { %>
	<section class="center">
		<h1 class="white-text tshadb">Vous n'êtes pas connecté</h1>
		<br><br><br><br>
		<p class="white-text tshadb f40">
			Veuillez vous connecter pour avoir accès au contenu de cette page!
		</p>
		<br><br><br><br>
		<p class="white-text margbot">
			<a href="login.jsp" class=" white-text hoverable tshadb f40">Connexion</a>
		</p>
	</section>
	
	<% } %>
	
	<jsp:include page="inc/footer.jsp"/>
</html>