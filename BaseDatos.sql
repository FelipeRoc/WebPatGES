CREATE TABLE JavaEj4(
	idpat int(3) not null,
    patología varchar(100),
    a2009 int(10),
    a2010 int(10),
    a2011 int(10),
    a2012 int(10),
    a2013 int(10),
    a2014 int(10),
    a2015 int(10),
    a2016 int(10),
    a2017 int(10),
    PRIMARY KEY (idpat)
);

LOAD DATA INFILE 'Ingresar la dirección del archivo .csv'
INTO TABLE `JavaEj4`
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

SELECT *FROM JavaEj4;

SELECT AVG(a2016) AS `Promedio` FROM JavaEj4;
