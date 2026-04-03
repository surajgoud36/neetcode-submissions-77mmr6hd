-- Write your query below
select name as warehouse_name, sum(
    b.volume
) as volume
from (select name,
    units*length*width*height as volume
    from warehouse join products on warehouse.product_id = products.product_id

) b
group by name;