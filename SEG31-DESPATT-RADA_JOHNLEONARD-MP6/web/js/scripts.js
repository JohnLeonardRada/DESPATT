var shoppingCart = (function() {

  cart = [];
  
  // CONSTRUCTOR
  class itemItem{
	  constructor(itemName,itemPrice,itemImage, count, itemQuantity){
		  this.itemName = itemName;
		  this.itemPrice = itemPrice;
		  this.itemImage = itemImage;
		  this.count = count;
		  this.itemQuantity = itemQuantity;
	  }
	  
  }
  
  // SAVE CART
  function saveCart() {
    sessionStorage.setItem('shoppingCart', JSON.stringify(cart));
  }
  
  // LOAD CART
  function loadCart() {
    cart = JSON.parse(sessionStorage.getItem('shoppingCart'));
  }
  if (sessionStorage.getItem("shoppingCart") != null) {
    loadCart();
  }

  var obj = {};
  
  // ADD ITEM TO CART
  obj.addItemToCart = function(itemName, itemPrice, itemImage, count, itemQuantity) {
    for(var item in cart) {
      if(cart[item].itemName == itemName) {
        cart[item].count ++;
        saveCart();
        return;
      }
    }
    var itemCart = new itemItem(itemName, itemPrice, itemImage, count, itemQuantity);
    cart.push(itemCart);
    saveCart();
  }
  
  // MINUS ITEM IN CART
  obj.removeItemFromCart = function(itemName) {
      for(var item in cart) {
        if(cart[item].itemName == itemName) {
          cart[item].count --;
          if(cart[item].count == 0) {
            cart.splice(item, 1);
          }
          break;
        }
    }
    saveCart();
  }
  
  // SET COUNT 
  obj.setCountForItem = function(itemName, count) {
    for(var i in cart) {
      if (cart[i].itemName == itemName) {
        cart[i].count = count;
        break;
      }
    }
  };

  // REMOVE ALL ITEM IN CART
  obj.removeItemFromCartAll = function(itemName) {
    for(var item in cart) {
      if(cart[item].itemName == itemName) {
        cart.splice(item, 1);
        break;
      }
    }
    saveCart();
  }

  // CLEAR CART
  obj.clearCart = function() {
    cart = [];
    saveCart();
  }
  
  obj.clearCart1 = function() {
	cart = [];
	saveCart();
  }

  // COUNT ITEM IN CART 
  obj.totalCount = function() {
    var totalCount = 0;
    for(var item in cart) {
      totalCount += cart[item].count;
    }
    return totalCount;
  }

  // TOTAL CART PRICE
  obj.totalCart = function() {
    var totalCart = 0;
    for(var item in cart) {
      totalCart += cart[item].itemPrice * cart[item].count;
    }
    return Number(totalCart.toFixed(2));
  }

  // LIST CART
  obj.listCart = function() {
    var cartCopy = [];
    for(i in cart) {
      item = cart[i];
      itemCopy = {};
      for(p in item) {
        itemCopy[p] = item[p];

      }
      itemCopy.total = Number(item.itemPrice * item.count).toFixed(2);
      cartCopy.push(itemCopy)
    }
    return cartCopy;
  }

  return obj;
})();


// *****************************************
// Triggers / Events
// ***************************************** 

function displayCart() {
  var cartArray = shoppingCart.listCart();
  var displayCartArray = [];
  var output = "";
  for(var i in cartArray) {
    output += 
    	`
		    <tr>
		    <input type="hidden" value="${cartArray[i].itemImage}" name="itemImage">
    		<input type="hidden" value="${cartArray[i].itemName}" name="itemName">
            <input type="hidden" value="${cartArray[i].count}" name="count">
            <input type="hidden" value="${cartArray[i].itemPrice}" name="itemPrice">
            <input type="hidden" value="${cartArray[i].itemQuantity}" name="itemQuantity">
            
		      <th scope="row">1</th>
		      <td><img src = "${cartArray[i].itemImage}" style = "width:100px" class = "imgthumbnail cart-img" alt = "..."></td>
		      <td>${cartArray[i].itemName}</td>
		      <td><div class='input-group'>
		      	<button class='minus-item btn btn-primary' input-group-addon data-itemName="${cartArray[i].itemName}" onClick = 'minusOneItem(this)'>-</button>
    				<input type='number' class='item-count form-control' min="1" max="${cartArray[i].itemQuantity}" data-itemName="${cartArray[i].itemName}" value="${cartArray[i].count}">
		        <button class='plus-item btn btn-primary input-group-addon' data-itemName="${cartArray[i].itemName}" onClick = 'plusOneItem(this)'>+</button>
    		  </div></td>
		      <td><h6 class = "d-flex align-self-end" style = "margin-left"; 4rem;"> Php ${cartArray[i].total}</h6></td>
		      <td><a class = "delete-item d-flex align-self-end" style = "margin-left: 8rem;" href = "#delete" onClick = 'deleteItem(this)'
					data-itemName = "${cartArray[i].itemName}"
					>Delete
				</a></td>
		    </tr>
    	`;
    
    displayCartArray.push(output);
  }
  $('.show-cart').html(output);
  $('.total-cart').html(shoppingCart.totalCart());
  $('.total-count').html(shoppingCart.totalCount());
}

// ADD ITEM BUTTON
function addItem(obj){
	var itemName = $(obj).attr('data-itemName');
	var itemPrice = (Number)($(obj).attr('data-itemPrice'))
	var itemImage = $(obj).attr('data-itemImage');
	
	console.log($(obj).attr('data-itemName'));
	console.log($(obj).attr('data-itemPrice'));
	console.log($(obj).attr('data-itemImage'));
	console.log($(obj).attr('data-itemQuantity'));
	
	shoppingCart.addItemToCart(itemName,itemPrice,itemImage, 1);
	displayCart();
}

// PLUS ONE ITEM BUTTON
function plusOneItem(obj){
	var itemName = $(obj).attr('data-itemName')
	shoppingCart.addItemToCart(itemName);
	displayCart();
}

// MINUS ONE ITEM BUTTON
function minusOneItem(obj){
	var itemName = $(obj).attr('data-itemName');
	shoppingCart.removeItemFromCart(itemName);
	displayCart();
}

//DELETE ITEM BUTTON
function deleteItem(obj){
	if(confirm("Are you sure you want to remove this item?")){
		var itemName = $(obj).attr('data-itemName');
		shoppingCart.removeItemFromCartAll(itemName);
		displayCart();
	}else{
		// CANCEL
	}
}

// CLEAR ITEMS
$('.clear-cart').click(function() {
	if(confirm("Are you sure you want to clear your cart?")){
		shoppingCart.clearCart();
		displayCart();
	}else{
		// CANCEL
	}
});

// CLEAR ITEMS WITHOUT ALERT
$('.clear-cart1').click(function() {
	shoppingCart.clearCart();
});

// ITEM COUNT DISPLAY
$('.show-cart').on("change", ".item-count", function(event) {
   var name = $(this).data('name');
   var count = Number($(this).val());
  shoppingCart.setCountForItem(name, count);
  displayCart();
});

displayCart();

