-- Write your query below
select n.name as country
from 
calls c join person p on p.id=c.caller_id or p.id=c.callee_id
join country n on n.country_code = substring(p.phone_number,1,3)
group by n.name
having avg(c.duration) > (select avg(duration) from calls);