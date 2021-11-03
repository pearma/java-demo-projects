DROP TABLE IF EXISTS systeminfo;

CREATE TABLE systeminfo (
  id                INT          AUTO_INCREMENT  PRIMARY KEY,
  system_id         VARCHAR(250) NOT NULL,
  system_full_name  VARCHAR(250) NOT NULL,
  system_short_name VARCHAR(250) DEFAULT NULL
);

INSERT INTO systeminfo (system_id,system_short_name,system_full_name) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');