-- Write your query below
select distinct on(a.sale_date) a.sale_date,coalesce((a.sold_num-b.sold_num),
    case
        when a.fruit='oranges' then -1*a.sold_num
        else a.sold_num
    end
) as diff 
from sales a left join sales b on a.sale_date = b.sale_date and a.fruit='apples' and b.fruit='oranges';