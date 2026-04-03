-- Write your query below
select distinct player_id, first_value(device_id) over (partition by player_id order by event_date
rows between unbounded preceding and unbounded following) as device_id
from activity;