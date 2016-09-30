# Engineering Candidate Evaluation

This is the remote coding challenge for engineering candidates with a Java bent. Below you will find details on the requirements for completing the exercise and particular details regarding certain requirements we have to validate the proposed solution.

**First and foremost the solution must satisfy the acceptance test defined in the `PayrollTest` file.**

####The Problem:
You are given a list of employees, there positions within the company, annual salary in AUD, and their required payment currency. Your job is to write the code that will take this information and output a list of employee names and their monthly payment (calculated in their required currency)

The exchange rates are supplied in a separate json file, these are the relative currency rates for converting from AUD to the specified currency.

If rounding is required then it should adhere to `half up`, all monetary values should be output to 2 decimal places.
    
####What We Are Looking For:
When you submit your solution we will be looking at the following aspects beyond just providing the correct output.
* Structure - clean, well structured code that can be easily changed or built upon (no `fragility` or `rigidity`)
* Commit History - we want to see more than just `"completed solution"`
* Unit Tests - the framework is in place to easily test your code, and we really want to see how you tackle this :-)