	<footer class="page-footer inplink">
        <div class="container">
            <div class="row center-align">
              <a class="grey-text text-lighten-4 hoverable" href="mailto:contact@breizhlinkJRO.com?subject=Devenir Partenaire">Devenir Partenaire - </a>
	            <a class="grey-text text-lighten-4 hoverable" href="#!">CGV - </a>
	            <a class="grey-text text-lighten-4 hoverable" href="mentionsLegales.jsp">Mentions Légales</a>
            </div>
        </div>
        <div class="footer-copyright center-align">
            <div class="container">
            © 2018 Tous Droits Réservés 
            
            </div>
    	</div>
	</footer>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script src="static/js/materialize.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#addmdp').click(function(){
			var disp = $("#mdpadd").css("display");
			var disp1 = $("#tmdp").css("display");
			
			
			if(disp == "none"){
				//alert(disp);
				$("#tmdp").css("display", "none");
				$("#mdpadd").css("display", "block");
			}
			else{
				//alert(disp1);
				$("#tmdp").css("display", "block");
				$("#mdpadd").css("display", "none");	
			}
		});
	});
</script>
<script>
$(document).ready(function(){
	 $(document).ready(function(){
		    $('.collapsible').collapsible();
		  });
});
</script>
