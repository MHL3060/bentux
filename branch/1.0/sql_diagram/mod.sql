create table share_friend (id bigint not null auto_increment, name varchar(255), email varchar(255), friend_name varchar(255), friend_email varchar(255), suggestion varchar(255), primary key (id));

--update on Dec 28th 2010
alter table entertain_service add (show_short_description varchar(255));
alter table entertain_service add (show_starring varchar(255));
alter table entertain_service add (show_plot varchar(750));
alter table entertain_service add (show_venue varchar(255));
alter table entertain_service add (show_date varchar(255));
alter table entertain_service add (show_ticket varchar(255));
alter table entertain_service add (show_booking varchar(255));
ALTER TABLE entertain_service ADD (front_movie_poster_link VARCHAR(255));
ALTER TABLE entertain_service ADD (show_movie_detail_link VARCHAR(255));


--update on Nov 16th 2010
update catalog SET name=('Miscellaneous') where id='-5';


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
