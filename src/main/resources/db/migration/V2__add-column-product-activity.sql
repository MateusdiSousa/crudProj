ALTER TABLE product ADD COLUMN active BOOLEAN;

UPDATE product SET active = 1;