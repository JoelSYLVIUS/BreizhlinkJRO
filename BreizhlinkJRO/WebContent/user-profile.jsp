<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="inc/header.jsp"/>
<body>
<jsp:include page="inc/ads.jsp"/>
        <% if ((session.getAttribute("pseudo")) != null){ %>
    <section style="min-height:60vh;">
        <div class="container">
            <div class="row">
            
                <div class="col s5">
                
                    <h2 class="white-text f50 center" style="text-shadow: 0 0 4px #000000;">Information de votre profil</h2>
                    <form action="userprofile" method="post" class="col s12 inplink formgen">
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
                
                <div class="col s7">
                
                    <h2 class="white-text f50 center" style="text-shadow: 0 0 4px #000000;">Vos liens</h2>
                                    
                    <div class="row col s12 inplink formgen">
                    <table class="highlight responsive-table white-text">
                        <thead>
                          <tr>
                              <th>Lien original</th>
                              <th>Lien raccourci<th>
                          </tr>
                        </thead>
                
                        <tbody>
                        <c:forEach items="${listLink}" var="item">
                          <tr>
                            <td class="truncate" style="max-width:200px">${item.originalLink}</td>
                            <td><a href="http://localhost:8080/BreizhlinkJRO/${item.shortLink}">http://localhost:8080/BreizhlinkJRO/${item.shortLink}</a></td>
                          </tr>
                        </c:forEach>
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