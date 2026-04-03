-- Write your query below
select player_id, player_name, count(title_winner) as grand_slams_count from
players join 
(select year, wimbledon as title_winner from championships
union all
select year, fr_open as title_winner from championships
union all 
select year, us_open as title_winner from championships
union all
select year,au_open as title_winner from championships)
on player_id = title_winner
group by player_id,player_name;