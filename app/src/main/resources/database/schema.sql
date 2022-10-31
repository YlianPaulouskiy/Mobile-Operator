ALTER TABLE  mobile_operator.tariff MODIFY COLUMN date_creation datetime default now();
ALTER TABLE  mobile_operator.client MODIFY COLUMN date_creation datetime default now();
ALTER TABLE  mobile_operator.phone MODIFY COLUMN date_creation datetime default now();
