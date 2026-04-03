-- Write your query below
select c.customer_id,c.name from customers c 
join orders o on c.customer_id = o.customer_id
join product p on o.product_id=p.product_id
where extract(year from o.order_date) = 2020 and extract(month from o.order_date) in (6,7)
group by c.customer_id,c.name
having
    sum(
        case
            when extract(month from o.order_date) = 6 then o.quantity * p.price
            else 0
        end
        ) >=100
   and sum(
    case
        when extract(month from o.order_date) = 7 then o.quantity * p.price
            else 0
    end
   ) >=100;