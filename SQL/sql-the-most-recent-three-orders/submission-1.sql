-- Write your query below
select c.name as customer_name,o.customer_id,o.order_id,o.order_date from
(select order_id,order_date,customer_id,
    rank() over (partition by customer_id order by order_date desc) as rnk from orders) o
join customers c on c.customer_id = o.customer_id 
where rnk<=3
order by customer_name,customer_id,order_date desc;