-- Write your query below
select u.name,coalesce(sum(distance),0) as travelled_distance from rides r right join 
users u on u.id=r.user_id
group by u.name
order by travelled_distance desc,u.name;