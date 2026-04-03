-- Write your query below
select product_name,o.product_id,order_id,order_date from
(select product_id,order_id,order_date,
    rank() over (partition by product_id order by order_date desc) as rnk
    from orders) o join products p on o.product_id=p.product_id 
    where rnk=1
    order by product_name,product_id,order_id; 