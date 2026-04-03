-- Write your query below
select d.name as department,e.name as employee,e.salary from
(select name,salary,department_id, 
    rank() over (partition by department_id order by salary desc) as rnk
    from employee) e join department d on e.department_id=d.id
    where rnk=1;