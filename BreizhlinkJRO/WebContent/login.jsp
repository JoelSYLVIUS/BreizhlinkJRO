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
    
    <div class="row">
       <form action="login" method="post" class="col s12 inplink formgen">
             <div class="row">
                 <div class="input-field col s12">
                     <input placeholder="Votre pseudo" name="pseudo" id="first_name" type="text" class="validate white-text tshadb inplink">
                     <label class="white-text" for="first_name">Pseudo*</label>
               </div>
             
               <div class="input-field col s12">
                     <input name="password" id="password" type="password" class="validate white-text tshadb inplink">
                     <label class="white-text" for="password">Password*</label>
               </div>
             </div>
             <div class"row">
                 <div class="col l12 center">
                     <input type="submit" value="Me connecter" class="btn btn-success amber hoverable">
                 </div>
             </div>
         </form>
  </div>

<jsp:include page="inc/footer.jsp"/>
</html>