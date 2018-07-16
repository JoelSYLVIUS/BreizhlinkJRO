<jsp:include page="inc/header.jsp"/>
<body>
    <header>
        <div class="row margtop">
            <div class="col l4">
                <img src="../static/img/logo-BLJRO.png" alt="Logo Breizhlink JRO" width="100%" height="100%">
            </div>
            <div class="col l8">
                <img src="static/img/pubfrancetv.png" alt="" width="100%" height="100%">
            </div>
        </div>
        <div class="row">
            <jsp:include page="inc/menu.jsp"/>
        </div>
    </header>
    <div class="row center ">
    	<h1 class="white-text tshadb">Merci d'avoir utiliser notre solution </h1>
    	<p class="white-text f40">
    	<span class="tshadb">vous pouvez retrouver votre lien raccourcis ci-dessous :</span><br><br>
    	
    	
    		<a class="white rad10 ptot" href="http://localhost:8080/BreizhlinkJRO/${urlshort}">http://localhost:8080/BreizhlinkJRO/${urlshort}</a>
    	
    	</p>
    	<p>
    	<br><br><br><br>
    		<a class="grey-text text-lighten-4 hoverable center tshadb" href="index.jsp">Retour Accueil</a>
    	</p>
    </div>
    
    <jsp:include page="inc/footer.jsp"/>
</html>