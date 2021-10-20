create schema Market;

use Market;

create table market_details(id int primary key, name varchar(50), location varchar(50), numberOfShop int);

insert into market_details values(2,'jalahalli','bangalore',20);

select * from market_details;
select * from market_details where location='bangalore';

update market_details set numberOfShop=10 where name='jalahalli';

delete from market_details where id=2;