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
    
    <div class="row">
       <form action="inscriptuser" method="post" class="col s12 inplink formgen">
             <div class="row">
               <div class="input-field col s6">
                     <input placeholder="Votre Prénom" name="prenom" id="first_name" type="text" class="validate white-text tshadb inplink">
                     <label class="white-text" for="first_name">Prénom*</label>
               </div>
               <div class="input-field col s6">
                     <input placeholder="Votre nom" name="nom" id="last_name" type="text" class="validate white-text tshadb inplink">
                     <label class="white-text" for="last_name">Nom*</label>
               </div>
             </div>
             <div class="row">
               <div class="input-field col s12">
                     <input name="password" id="password" type="password" class="validate white-text tshadb inplink">
                     <label class="white-text" for="password">Password*</label>
               </div>
             </div>
             <div class="row">
               <div class="input-field col s12">
                     <input placeholder="Votre email" name="email" id="email" type="email" class="validate white-text tshadb inplink">
                     <label class="white-text" for="email">Email*</label>
               </div>
             </div>
             <div class="row">
                 <div class="input-field col s6">
                     <input placeholder="Votre pseudo" name="pseudo" id="first_name" type="text" class="validate white-text tshadb inplink">
                     <label class="white-text" for="first_name">Pseudo*</label>
               </div>
             </div>
             <div class"row">
                 <div class="col l12 center">
                     <input type="submit" value="inscription" class="btn btn-success amber hoverable">
                 </div>
             </div>
         </form>
  </div>

<jsp:include page="footer.jsp"/>
</html>