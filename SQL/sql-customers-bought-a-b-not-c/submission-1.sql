-- Write your query below
select customer_id,customer_name from customers
where customer_id in (select distinct customer_id from orders o
where exists (select customer_id from orders os where o.customer_id=os.customer_id and product_name='A')
    and exists (select customer_id from orders os where o.customer_id=os.customer_id and product_name='B')
    and not exists (select customer_id from orders os where o.customer_id=os.customer_id and product_name='C')
)
order by customer_name;