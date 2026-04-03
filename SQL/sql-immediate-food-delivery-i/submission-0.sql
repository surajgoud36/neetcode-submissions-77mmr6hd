-- Write your query below
select round((urgent*100.0/total),2) as immediate_percentage from
(select count(*) as total, sum(
    case
        when order_date=customer_pref_delivery_date then 1
        else 0
    end
) as urgent from delivery);