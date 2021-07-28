Implement a solution to the following problem in Java. We are looking for clean, well-factored, OO code with
unit tests and comments. You do not need to provide any form of persistence in this program. Your project
should contain some way of running automated tests to prove it works, whether you use jUnit or some other
way is up to you. The program should be an API. You can opt to put a user interface on it or not, but we will
only be evaluating the API portion.
Requirements
Consider a grocery market where items have prices per unit but also volume prices. For example, doughnuts
may be $1.25 each or 3 for $3 dollars.
Implement a point-of-sale scanning API that accepts an arbitrary ordering of products (similar to what would
happen when actually at a checkout line) then returns the correct total price for an entire shopping cart based
on the per unit prices or the volume prices as applicable.

The invocation of the top level PointOfSaleTerminal service should look something like this. You are free
to design/implement the rest of the code however you wish, including how you specify the prices in the system:
PointOfSaleTerminal terminal = new PointOfSaleTerminal();
terminal.setPricing(...);
terminal.scan(A);
terminal.scan(C);
...
BigDecimal result = terminal.calculateTotal();
