Task
====

The movie rental application computes total rental cost and total
customer points when a customer rents movies. The movie type can be in 
one of the three: Children, Regular, New Release. In the future, we
might want add more Movie types.  The logic for computing rental
cost and customer point is highly likely to be changed in the future.

-when a customer rents movies, we want to compute the total rental 
    cost and total customer points - Use the skeleton Customer
    and CustomerTest that are provided.
    
-rental amount gets computed as following
   	-Children's movie - $1 per day for the first 7 days and $2 after that
   	-Regular movie - $2 per day for the first 5 days and $3 after that
   	-New release - $3 per day for the first 3 days, $6 dollars after that
   	
-customer point is computed as following
	-each day a movie is rented, 1 point is added
	-for new release, extra 2 point is added for each day
	-for children movie, extra 1 point is added after 3 days
	
-for each 5 customer points, $0.30 discount gets applied

-we want to generate customer receipt that has customer name, the total 
   rental cost as a simple text. 
   
-make sure "computing individual rental cost" and "computing individual 
   customer point" methods are in the Rental class not in the Customer class 
   - if not, see how you can refactor

-Use a simple factory for creating Customer object
-Use strategy pattern for computing rental cost for each movie type
-Use strategy pattern for computing customer points for each movie type (optional)


Grading Criteria
================

-Working application 20 points
-Code coverage 10 points
-TDD/testing code 10 points
-Strategy pattern for computing rental cost 15 points
-Strategy pattern for computing customer points 15 points
-Simple factory 10 points 
-Clean code 20 points (no code smell, good naming schemes, 
             good packaging structure, method belong to proper class, etc)