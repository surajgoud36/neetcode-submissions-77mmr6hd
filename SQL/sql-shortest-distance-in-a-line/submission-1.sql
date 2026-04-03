-- Write your query below

-- select min(abs(p1.x-p2.x)) as shortest
-- from point p1 join point p2 on p1.x<p2.x;

-- select x,
-- lag(x) over (order by x) as previous
-- from point;

select min(diff) as shortest
from(
    select x-lag(x) over (order by x ) as diff from point
)
where diff is not null;