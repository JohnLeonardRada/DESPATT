<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
	
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
	 <link href="css/form-validation.css" rel="stylesheet">
	 <link href="css/design.css" rel="stylesheet">
	 <link href="css/card.css" rel="stylesheet">

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
                  <a class="nav-link" href="#" tabindex="-1" aria-disabled="true" data-bs-toggle="modal" data-bs-target="#cart">Cart(<span class="total-count"></span>)</a>
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
	
		<div class="container creditCardForm">
            <div class="heading">
            	<img class="d-block mx-auto mb-4" src="images/icon.svg" alt="" width="72" height="57">
                <h1>Confirm Purchase</h1>
            </div>
            <form action="processcart.action" method="POST">
            <div class="payment container border">
                    <div class="form-group owner">
                        <label for="owner">Owner</label>
                        <input type="text" class="form-control" id="owner" name="owner" required>
                    </div>
                    <div class="form-group CVV">
                        <label for="cvv">CVV</label>
                        <input type="text" class="form-control" id="cvv" name="cvv">
                    </div>
                    <div class="form-group" id="card-number-field">
                        <label for="cardNumber">Card Number</label>
                        <input type="text" class="form-control" id="cardNumber" name="ccn" required>
                    </div>
                    <div class="form-group" id="expiration-date">
                        <label>Expiration Date</label>
                        <select>
                            <option value="01">January</option>
                            <option value="02">February </option>
                            <option value="03">March</option>
                            <option value="04">April</option>
                            <option value="05">May</option>
                            <option value="06">June</option>
                            <option value="07">July</option>
                            <option value="08">August</option>
                            <option value="09">September</option>
                            <option value="10">October</option>
                            <option value="11">November</option>
                            <option value="12">December</option>
                        </select>
                        <select>
                            <option value="16"> 2016</option>
                            <option value="17"> 2017</option>
                            <option value="18"> 2018</option>
                            <option value="19"> 2019</option>
                            <option value="20"> 2020</option>
                            <option value="21"> 2021</option>
                            <option value="22"> 2022</option>
                            <option value="23"> 2023</option>
                            <option value="24"> 2024</option>
                            <option value="25"> 2025</option>
                        </select>
                    </div>
                    <div class="form-group" id="credit_cards">
                        <img src="images/visa.jpg" id="visa">
                        <img src="images/mastercard.jpg" id="mastercard">
                        <img src="images/amex.jpg" id="amex">
                    </div>
                    <div class="form-group" id="pay-now" >
                        <button type="submit" class="btn btn-outline-success clear-cart1" id="confirm-purchase">Confirm</button>
                    </div>
                
            </div>
            
            <br>
            <div class="heading">
                <h1>Order Overview</h1>
                <div class="modal-body">
			        <table class="table">
		          		<thead>
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">Image</th>
			    		  <th scope="col">Name</th>
					      <th scope="col">Quantity</th>
					      <th scope="col">Price</th>
					      <th scope="col"></th>
					    </tr>
					  </thead>
					  <tbody class="show-cart">
					  	
					  </tbody>
		     	   </table>
		     	   <div>Total price: Php <span class="total-cart"></span></div>
			      </div>
            </div>
          </form>		
        </div>
  		
 		 <!-- MODAL -->
		<div class="modal fade" id="cart" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Cart</h5>
		        <button class="clear-cart btn btn-danger">Clear Cart</button>
		      </div>
		      <form action="processcart.action">
			      <div class="modal-body">
			        <table class="table">
		          		<thead>
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">Image</th>
			    		  <th scope="col">Name</th>
					      <th scope="col">Quantity</th>
					      <th scope="col">Price</th>
					      <th scope="col"></th>
					    </tr>
					  </thead>
					  <tbody class="show-cart">
					  	
					  </tbody>
		     	   </table>
		     	   <div>Total price: Php <span class="total-cart"></span></div>
			      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		        <button type="submit" class="btn btn-success">Checkout</button>
		      </div>
		      </form>
		    </div>
		  </div>
		</div>
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
		
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	  <script src="js/form-validation.js"></script>
	  <script src="js/scripts.js"></script>
	  <!-- <script src="js/jquery.payform.min.js" charset="utf-8"></script>
	  <script src="js/card.js"></script> -->
  </body>
</html>
