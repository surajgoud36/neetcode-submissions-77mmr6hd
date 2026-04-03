-- Write your query below
select 
case
    when salary is null then e.employee_id
    when name is null then s.employee_id
end as employee_id
from employees e full outer join salaries s on e.employee_id=s.employee_id
where name is null or salary is null;