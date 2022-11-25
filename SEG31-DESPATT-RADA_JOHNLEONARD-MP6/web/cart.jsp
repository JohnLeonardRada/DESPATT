<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<%@ page import = "utility.*" %>
<%@ page import = "model.*" %>

<!DOCTYPE html>
<html lang="en" class="h-100">
  <head>
    <meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
	 <meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
	
	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
	 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
	 <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
	 
	 <!-- Custom styles for this template -->
     <link href="css/sticky-footer-navbar.css" rel="stylesheet">
	 <link href="css/design.css" rel="stylesheet">
	 
	<title>SwallowTail Shop</title>

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

  </head>
  <body class="d-flex flex-column h-100">
    
	<header>
	  <!-- FIXED NAVBAR -->
	  <nav class="navbar navbar-expand-xxl navbar-dark bg-dark">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              <img src="images/icon.svg" width="38" height="30" class="d-inline-block align-top" alt="Bootstrap" loading="lazy"
                   style="filter: invert(1) grayscale(100%) brightness(200%);">
                   SwallowTail Shop
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="items.jsp">Items</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#" tabindex="-1" aria-disabled="true">Cart</a>
                </li>
              </ul>
              <form action="searchphone.action" class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="searchPhone">
                <button class="btn btn-outline-secondary" type="submit">Search</button>
              </form>
            </div>
          </div>
        </nav>
	</header>

	<!-- BEGIN PAGE CONTENT -->
	<main class="flex-shrink-0">
	 
	</main>
	
	<!-- FIXED FOOTER -->
	<footer class="footer mt-auto py-3 bg-light">
	  <div class="container">
        	<div class="row align-items-center">
            	<div class="col-lg-4 text-lg-left">Copyright @ John Leonard Rada 2021</div>
                <div class="col-lg-4 my-3 my-lg-0"></div>
                <div class="col-lg-4 text-lg-right">
                	<a>Privacy Policy</a>
                    <a>Terms of Use</a>
                </div>
            </div>
        </div>
	</footer>
  
</body>
</html>