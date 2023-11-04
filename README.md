Creating Spring Boot REST API for Shopping Cart :

Create a very simple order management system similar to
a shopping cart model that is found on a typical consumer website.
Create REST end points :

1. GET : http://localhost:9090/shoppingcart/getAllProducts
   To get list of all the products

2. POST : http://localhost:9090/shoppingcart/placeOrder
   To place order

3. GET : http://localhost:9090/shoppingcart/getOrder/101


Entity Classes :

1. Customer : id, name, email
2. Order : id, orderDescription, Customer, List<ShoppingCart> cartItems
3. Product : id, name, availableQuantity, price
4. ShoppingCart : id, productId, productName, quantity, amount

Utility classes :

1. OrderDTO : orderDescription, List<ShoppingCart>, customerEmail, cutomerName





