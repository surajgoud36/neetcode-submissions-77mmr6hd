-- Write your query below
with temp as (select distinct c.customer_id,product_id,
 count(product_id) over (partition by c.customer_id,product_id) as total_count from orders o right join 
 customers c on c.customer_id = o.customer_id)

 --select * from temp;
 
-- select customer_id,product_id,
--  rank() over (partition by customer_id order by total_count desc) as rnk from temp;


select customer_id,o.product_id,product_name from 
(select customer_id,product_id,
rank() over (partition by customer_id order by total_count desc) as rnk from temp) o
join products p on o.product_id = p.product_id
where rnk =1;

-- select customer_id,o.product_id,product_name from
-- temp o
--  join products p on o.product_id = p.product_id
--  where total_count = (select max(total_count) from temp group by o.customer_id,o.product_id);