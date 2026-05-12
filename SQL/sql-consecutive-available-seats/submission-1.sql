-- Write your query below
select seat_id
from(select seat_id,free,lag(free) over(order by seat_id) as prev,lead(free) over(order by seat_id) as next from cinema) t
where free=1
and (prev=1 or next=1);