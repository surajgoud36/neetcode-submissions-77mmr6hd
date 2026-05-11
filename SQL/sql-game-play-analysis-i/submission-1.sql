-- Write your query below
select distinct on (player_id) player_id, event_date as first_login 
from activity
order by player_id,event_date;