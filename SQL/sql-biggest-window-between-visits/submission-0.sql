-- Write your query below
select user_id,max(window_gap) as biggest_window from
(select user_id,
lead(visit_date,1,'2021-1-1'::date) over (partition by user_id order by visit_date)-visit_date as window_gap
from user_visits)
group by user_id
order by user_id;