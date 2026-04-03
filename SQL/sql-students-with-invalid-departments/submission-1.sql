-- Write your query below
select s.id,s.name from students s left join departments d
on department_id=d.id
where d.id is null;