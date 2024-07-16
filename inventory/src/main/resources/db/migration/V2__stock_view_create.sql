create or replace view total_stock_view_product_and_unit as
select sum(thx.total_amount)                       as total_amount,
       sum(thx.piece)                              as total_piece,
       thx.product_id                              as product_id,
       thx.unit_id                                 as unit_id,
       count(*)                                    as count,
       md5(concat(random()::text, random()::text)) as id,
       tu.name                                     as unit_name,
       tp.name                                     as product_name
from t_transaction thx
         inner join public.t_unit tu on tu.id = thx.unit_id
         inner join public.t_product tp on tp.id = thx.product_id
group by thx.unit_id, thx.product_id, tu.name, tp.name;