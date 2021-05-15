# Write your MySQL query statement below
SELECT (
    SELECT DISTINCT Salary FROM Employee 
    ORDER BY Salary DESC 
    LIMIT 1 OFFSET 1) AS SecondHighestSalary;
    
    
    #     The SELECT DISTINCT statement is used to return only distinct (different) values.
    #     Inside a table, a column often contains many duplicate values; and sometimes you only want to list the different (distinct) values.
    
    # The ORDER BY keyword is used to sort the result-set in ascending or descending order.
    
    # The AS command is used to rename a column or table with an alias.
    
    # https://www.sqltutorial.org/sql-limit/
    # The row_count determines the number of rows that will be returned.
    # The OFFSET  clause skips the offset rows before beginning to return the rows.