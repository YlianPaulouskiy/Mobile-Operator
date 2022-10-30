ALTER TABLE  mobile_operator.tariff MODIFY COLUMN date_creation datetime default now();
ALTER TABLE  mobile_operator.tariff MODIFY COLUMN last_modified datetime default now();
ALTER TABLE mobile_operator.tariff ALTER COLUMN version SET DEFAULT 1;

ALTER TABLE  mobile_operator.client MODIFY COLUMN date_creation datetime default now();
ALTER TABLE  mobile_operator.client MODIFY COLUMN last_modified datetime default now();
ALTER TABLE mobile_operator.client ALTER COLUMN version SET DEFAULT 1;

ALTER TABLE  mobile_operator.phone MODIFY COLUMN date_creation datetime default now();
ALTER TABLE  mobile_operator.phone MODIFY COLUMN last_modified datetime default now();
ALTER TABLE mobile_operator.phone ALTER COLUMN version SET DEFAULT 1;
