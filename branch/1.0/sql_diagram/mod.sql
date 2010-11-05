--update on Nov 5th 2010
ALTER TABLE entertain_service ADD movie_poster_link VARCHAR(255);


--update on August 19th 2010
insert into catalog (id, name, description ) VALUES('-5', 'Miscellaneous Product', 'Miscellaneous Product');
update  catalog description VALUES ('Miscellaneous Product') where id ='-5' ;


alter table product add (multiple_special_count int(11));
alter table product add (special_end datetime);
alter table product add (special_start datetime);


-- need to run this one on the sandbox.
alter table shopping_cart change shippingInstruction shipping_instruction varchar(255);
alter table shopping_cart change shippingType shipping_type integer;
alter table shopping_cart change trackingCode tracking_code varchar(255);
alter table shopping_cart add shipping_address_id integer;
alter table shipping_address drop user_id;
alter table entertain_product add (issn varchar(25));
create table side_banner (id bigint not null, display_order integer, is_enable bit, url varchar(255), primary key (id))



-- for dumb users
-- alter table app_user add (DTYPE varchar(31), firstName varchar(255), lastName varchar(255));
