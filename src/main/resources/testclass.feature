Feature: Customer uses site
		 As a Customer,
         I want to login, 
		 open page with T-Shirts, 
		 select only one product,
		 Add it to Card,
		 increase product quantity and delete product from cart,
         and verify alert
Scenario: Go through site to shopping cart
          Given The user opens site sees Home Page
          When He clicks Sign In link sees Login page
		  When He loging in sees account page
		  When He clicks to T-Shirts button sees T-Shirts Page
		  When He clicks to 'Faded Short Sleeve T-shirts' sees Product Details Page
          When He verify breadcrumb on Product Details Page
          Then Breadcrumb is '> Women>Tops>T-shirts>Faded Short Sleeve T-shirts'
          When He clicks to Add to Cart sees dialog with product
		  When He clicks to Proceed to Checkout button sees Shopping Cart Page
		  When He clicks to "+" button quantity should be increased by 1
		  Then Total price should be changed to '33.02'
		  When He deletes product from Cart
		  Then Alert is 'Your shopping cart is empty.'
          Then User closes browser