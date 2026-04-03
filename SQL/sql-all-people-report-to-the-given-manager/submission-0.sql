-- Write your query below

with level1 as (select employee_id from employees where manager_id in (select employee_id from employees where manager_id = 1)
),

 level2 as (select employee_id from employees where manager_id in (select employee_id from level1)),

 level3 as (select employee_id from employees where manager_id in(select employee_id from level2))

select employee_id from employees where manager_id in (select employee_id from level3) and employee_id!=1;