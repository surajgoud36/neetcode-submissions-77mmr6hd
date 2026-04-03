-- Write your query below
select customer_number
from(select customer_number,count(order_number) as total from orders group by customer_number)
order by total desc
limit 1;