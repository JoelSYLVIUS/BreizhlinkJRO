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


<script src="static/js/materialize.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
<script src="static/js/jquery-ui.js"></script>
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
		
		$('.Show1').click(function() {
			$('.target').hide(500);
	        $('.target1').show(500);
	        $('.Show11').removeClass("bgcn02");
	        $('.Show12').addClass("bgcn02");
	    });
	    $('.Show').click(function() {
	        $('.target1').hide(500);
	        $('.target').show(500);
	        $('.Show12').removeClass("bgcn02");
	        $('.Show11').addClass("bgcn02");
	    });
	});
</script>
<script>
$(document).ready(function(){
		    $('.collapsible').collapsible();
		    
		    
});
</script>

<script>
		  $(document).ready(function(){
			  $('.modal').modal();
			    //this are my init
			    $('.datepicker').datepicker({ 
			    	currentText: 'Aujourd\'hui',
					monthNames: ['Janvier','Fevrier','Mars','Avril','Mai','Juin',
					'Juillet','Aout','Septembre','Octobre','Novembre','Decembre'],
					monthNamesShort: ['Jan','Fev','Mar','Avr','Mai','Jun',
					'Jul','Aou','Sep','Oct','Nov','Dec'],
			    	dateFormat: 'yy/mm/dd',
			    	dayNames: ['Dimanche','Lundi','Mardi','Mercredi','Jeudi','Vendredi','Samedi'],
					dayNamesShort: ['Dim','Lun','Mar','Mer','Jeu','Ven','Sam'],
					dayNamesMin: ['Di','Lu','Ma','Me','Je','Ve','Sa'],
			    	}); 
		  });
		  
</script>

