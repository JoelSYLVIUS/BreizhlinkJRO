

	<html>
		<head>
            <title>Mot de Passe</title> 
            <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css"> 
            <link rel="stylesheet" href="static/css/materialize.min.css"> 
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"> 
            <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet"><style>
           
            
            body{
            	display: flex; 
                min-height: 100vh; 
                flex-direction: column; 
                background-image: url("static/img/bg.jpg"); 
                background-repeat:no-repeat; 
                background-size: 100% 100%; 
                background-position: fixed; 
            } 
            .margTopForH1{ 
                margin-top:-15vh; 
            } 
            .margTopForMainButton{ 
                margin-top:5vh; 
            } 
            .tshadb{ 
                text-shadow: 0 0 10px #000000; 
            } 
            a{ 
                color:white; 
            } 
            .ptot{ 
                padding: 10px; 
            } 
            .rad10{ 
                border-radius:10px; 
            }
            .formgen{
                background-color: rgba(0, 0, 0, 0.4);
                padding: 20px!important; 
                border-radius:10px; 
                border:1px solid #ffffff; 
             }
         </style> 
     </head>

<body>
	<% String ipuser = (String) session.getAttribute("ipuser");
	String url = (String) session.getAttribute("url");
	String deviceuser = (String) session.getAttribute("deviceuser");
	String navigateuruser = (String) session.getAttribute("navigateuruser");
	String date = (String) session.getAttribute("date");
	%>
	<% if ((session.getAttribute("mdpok")) == "OK" && (session.getAttribute("captchaok")) == "OK"){ %>
	
	<section style="min-height:60vh;">
		<div style="width: 40%;margin: auto;text-align:center">
         <h1 class="amber-text tshadb">Mot de passe</h1>
         <div class="row"> 
         	<form action="url2" method="post" class="col s12 inplink formgen"> 
            <div class="input-field col s12">
                 <input name="password" id="password" type="password" placeholder="${date}" class="validate white-text tshadb inplink"> 
                 <input type="hidden" name="url" value="${url}">
                 <input type="hidden" name="ipuser" value="${ipuser}">
                 <input type="hidden" name="deviceuser" value="${deviceuser}">
                 <input type="hidden" name="navigateuruser" value="${navigateuruser}">
            </div> 
         
         	<div style="width: 40%;margin: auto;text-align:center">
                <h1 class=" amber-text tshadb">Captcha</h1> 
                <div class="row">
                	<div class="g-recaptcha" data-sitekey="6Ld9Al0UAAAAAN3J_SXGMfKywC5M2pa4nYVYSaZI"></div> 
                </div> 
            </div>
         
         	<div class"row"> 
            	<div class="col l12 center">
                	 <input type="submit" value="Valider" class="btn btn-success amber hoverable"> 
            	</div> 
         	</div>
         	</form>
         </div> 
   </div>
   
	</section>
	<% } else if ((session.getAttribute("mdpok")) == "PASOK" && (session.getAttribute("captchaok")) == "OK"){ %>
		<section style="min-height:60vh;">
			<div style="width: 40%;margin: auto;text-align:center">
                <h1 class=" amber-text tshadb">Captcha</h1> 
                <form action="url2" method="post" class="col s12 inplink formgen"> 
                <div class="row">
                	<div class="g-recaptcha" data-sitekey="6Ld9Al0UAAAAAN3J_SXGMfKywC5M2pa4nYVYSaZI"></div> 
                	</div> 
                 <input type="hidden" name="url" value="${url}">
                <input type="hidden" name="ipuser" value="${ipuser}">
                 <input type="hidden" name="deviceuser" value="${deviceuser}">
                 <input type="hidden" name="navigateuruser" value="${navigateuruser}">
            
            	<div class"row"> 
            		<div class="col l12 center">
                	 	<input type="submit" value="Valider" class="btn btn-success amber hoverable"> 
            		</div> 
         		</div>
         		</form>
         	</div>
		</section>
	<% } else if ((session.getAttribute("mdpok")) == "OK" && (session.getAttribute("captchaok")) == "PASOK"){ %>
		<section style="min-height:60vh;">
			<div style="width: 40%;margin: auto;text-align:center">
         <h1 class="amber-text tshadb">Mot de passe</h1>
         <div class="row"> 
         	<form action="url2" method="post" class="col s12 inplink formgen"> 
            <div class="input-field col s12">
                 <input name="password" id="password" type="password"  placeholder="${date}" class="validate white-text tshadb inplink"> 
                 <input type="hidden" name="url" value="${url}">
                 <input type="hidden" name="ipuser" value="${ipuser}">
                 <input type="hidden" name="deviceuser" value="${deviceuser}">
                 <input type="hidden" name="navigateuruser" value="${navigateuruser}">
            </div> 
         
         	<div class"row"> 
            	<div class="col l12 center">
                 	<input type="submit" value="Valider" class="btn btn-success amber hoverable"> 
            	</div> 
         	</div>
         	</form> 
   </div>
		</section>
	<% } else{ %>
		<section class="center">
			<h1 class="white-text tshadb">Cliquer sur suivant pour accéder à votre lien</h1>
			<br><br><br><br>
			<form action="url2" method="post" class="col s12 inplink formgen"> 
            <div class="input-field col s12">
                 <input type="hidden" name="url" value="${url}">
                 <input type="hidden" name="ipuser" value="${ipuser}">
                 <input type="hidden" name="deviceuser" value="${deviceuser}">
                 <input type="hidden" name="navigateuruser" value="${navigateuruser}">
            </div> 
         
         	<div class"row"> 
            	<div class="col l12 center">
                 	<input type="submit" value="Suivant" class="btn btn-success amber hoverable"> 
            	</div> 
         	</div>
         	</form> 
				<p class="white-text tshadb f40">
					Veuillez vous connecter pour avoir accès aux contenue de cette page!
				</p>
				<br><br><br><br>
				<p class="white-text margbot">
					<a href="login.jsp" class=" white-text hoverable tshadb f40">Connexion</a>
				</p>
		</section>
	<% } %>
	</body>
	
	<script src="https://www.google.com/recaptcha/api.js"></script>
		
	
</html>
