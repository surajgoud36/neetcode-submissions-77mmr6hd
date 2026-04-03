-- Write your query below
select distinct m.id,
case
    when m.p_id is null then 'Root'
    when t.id is not null then 'Inner'
    else 'Leaf'
end as type
from tree m left join tree t on m.id=t.p_id;