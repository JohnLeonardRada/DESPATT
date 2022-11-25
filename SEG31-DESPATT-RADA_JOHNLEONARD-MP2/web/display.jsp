<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

 <meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">

 <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
        crossorigin="anonymous">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <link href="css.styles.css" rel="stylesheet" />
 
 <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
 <style type="text/css">
 	.jumbotron{
 		background-image: url("images/jumbotron-bg.jpg");
 	}
 </style>
 
<title>SwallowTail Shop</title>

</head>

<body>
	<nav class="navbar navbar-dark bg-dark justify-content-between">
	  <a class="navbar-brand"><img src="images/icon.jpg" width="30" height="30" class="d-inline-block align-top" alt=""> SwallowTail Shop</a>
	  <a class="nav-link js-scroll-trigger" href="index.jsp">Home</a>
	  <form action ="searchphone.action" class="form-inline" method = "post">
	    <input class="form-control mr-sm-2" type = "text" placeholder="Search" aria-label="Search" name="searchPhone">
	    <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
	  </form>
	</nav>

	<br>
	
	 
	   <!-- ITEM -->
       <section class="page-section" id="item">
       	 <div class="container">
              <div class="text-center">
                  <h2 class="section-heading text-uppercase"></h2>
              </div>
              <div class="results">
				<%if(request.getAttribute("results")==null)  { %>
			
				<p align="center">ITEM NOT FOUND</p>
				
				<% }else{ %>
				<div class="text-center">
	                  <div class="col-lg-20">
	                      <div class="team-member">
	                          <b><img class="img-thumbnail" width="700" height="450" src = ${requestScope.results.getItemImage()}></b>
	                          <h4><b>${requestScope.results.getItemName()}</b></h4>
	                          <p class="text-muted"></p>
	                          <b></b><h4>Price:  ${requestScope.results.getItemPrice()}</h4>
	                          <b></b><h4>Storage:  ${requestScope.results.getItemSpecs()}</h4>
	                          <b></b><h4>Camera: ${requestScope.results.getCamera().getMegapixels()}</h4>
	                          <b></b><h4>Screen Size: ${requestScope.results.getCamera().getScreenSize()} </h4>
	                      </div>
	                  </div>
	              </div>
				<% } %>
             </div>
             
          </div>
        </section>
     
    <br>
	<!-- FOOTER -->
	<footer class="footer py-4 bg-light">
		<div class="container">
        	<div class="row align-items-center">
            	<div class="col-lg-4 text-lg-left">Copyright @ John Leonard Rada 2021</div>
                <div class="col-lg-4 my-3 my-lg-0"></div>
                <div class="col-lg-4 text-lg-right">
                	<a class="mr-3">Privacy Policy</a>
                    <a>Terms of Use</a>
                </div>
            </div>
        </div>
    </footer>
  
</body>
</html>