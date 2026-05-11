-- Write your query below
select name as warehouse_name,sum(volume) as volume
from (select name,(units * width * length * height) as volume from warehouse w join products p on 
p.product_id = w.product_id)
group by name;