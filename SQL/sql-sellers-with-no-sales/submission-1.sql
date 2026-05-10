-- Write your query below
select seller_name from seller 
where seller_id not in (select o.seller_id from orders o where extract(year from sale_date)=2020)
order by seller_name;