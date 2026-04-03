-- Write your query below
select left_operand,operator,right_operand, 
case
    when operator='>' and lv.value > rv.value then 'true'
    when operator='<' and lv.value < rv.value then 'true'
    when operator='=' and lv.value = rv.value then 'true'
    else 'false'
end as value
from expressions join  variables lv on left_operand = lv.name
join variables rv on right_operand = rv.name;