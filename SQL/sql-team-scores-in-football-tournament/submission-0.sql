-- Write your query below

select team_id,team_name, 
coalesce(sum(
    case
        when team_id=host_team and host_goals>guest_goals then 3
        when team_id=guest_team and host_goals<guest_goals then 3
        when host_goals=guest_goals then 1
        else 0
    end
),0) as num_points
from teams left join matches on team_id=guest_team or team_id=host_team
group by team_id,team_name
order by num_points desc,team_id;