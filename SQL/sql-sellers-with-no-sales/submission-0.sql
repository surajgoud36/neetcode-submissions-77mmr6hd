-- Write your query below
-- select seller_name from seller
-- where seller_id not in (select orders.seller_id from orders where extract(year from orders.sale_date) = 2020)
-- order by seller_name;

select seller_name from seller
where seller_id not in (select orders.seller_id from orders where extract(  year from orders.sale_date) = 2020)
order by seller_name;