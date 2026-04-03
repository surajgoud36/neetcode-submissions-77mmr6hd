-- Write your query below
select project_id,employee_id
from (
    select p.project_id,p.employee_id,
    rank() over (partition by project_id order by experience_years desc) as rnk
    from employee e join project p on e.employee_id=p.employee_id
)
where rnk=1;