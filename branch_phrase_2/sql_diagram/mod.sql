alter table product add (multiple_special_count int(11));
alter table product add (special_end datetime);
alter table product add (special_start datetime);
alter table product add (special_start datetime);


-- need to run this one on the sandbox.
alter table shopping_cart change shippingInstruction shipping_instruction varchar(255);
alter table shopping_cart change shippingType shipping_type integer;
alter table shopping_cart change trackingCode tracking_code varchar(255);
alter table shopping_cart add shipping_address_id integer;
alter table shipping_address drop user_id;
