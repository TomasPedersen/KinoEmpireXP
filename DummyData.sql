
INSERT INTO `kinoempire`.`Customers` (`E-mail`, `Name`, `Phone Number`) VALUES 
('Hans@email.com', 'Hans Hansen', '1234567'), 
('Jens@email.com', 'Jens Jensen', '9876543'), 
('Peter@email.com', 'Peter Petersen', '0123456'), 
('Jan@email.com', 'Jan Jansen', '23232323'), 
('Gerd@email.com', 'Gerd Gerdsen', '89348934'), 
('Ole@email.com', 'Ole Olesen', '12312312'), 
('Kurt@email.com', 'Kurt Kurtsen', '00110011'), 
('Bo@email.com', 'Bo Bosen', '34343434');

INSERT INTO `kinoempire`.`Movies` (`Title`, `Genre`, `Length`, `Description`, `Release Date`, `Numbers Sold`, `Price`, `Director`, `Copyright`, `Original Title`, `Versions`, `Age Restriction`) VALUES 
('En Mand Der Hedder Ove', 'Drama, Romantik', '116', 'x', '2016-05-26', '4', '80', 'Hannes Holm', 'Nordisk Film', 'En Mand Som Heter Ove', '2D', '11'), 
('Warcraft', 'Adventure', '123', 'x', '2016-05-26', '4', '80', 'Duncan Jones', 'Universal Pictures', 'Warcraft', '3D, 2D, IMAX 3D', '11'), 
('Mig Før Dig', 'Drama, Romantik', '110', 'x', '2016-06-02', '4', '80', 'Thea Sharrock', 'SF FILM', 'Me Before You', '2D', '0'), 
('Money Monster', 'Thriller, Drama', '98', 'x', '2016-06-02', '4', '80', 'Jodie Foster', 'UIP', 'Money Monster', '2D', '11');

INSERT INTO `kinoempire`.`Shows` (`Title`, `Date`, `Time`, `Theater`) VALUES 
('En Mand Der Hedder Ove', '26.05.2016', '1200', '1'), 
('Warcraft', '26.05.2016', '1200', '2'), 
('En Mand Der Hedder Ove', '26.05.2016', '1800', '1'), 
('Warcraft', '26.05.2016', '1800', '2'), 
('En Mand Der Hedder Ove', '27.05.2016', '1200', '2'), 
('Warcraft', '27.05.2016', '1200', '1'), 
('En Mand Der Hedder Ove', '27.05.2016', '1800', '2'), 
('Warcraft', '27.05.2016', '1800', '1'),

('Mig Før Dig', '28.05.2016', '1200', '1'),
('Money Monster', '28.05.2016', '1200', '2'),
('Mig Før Dig', '28.05.2016', '1800', '1'),
('Money Monster', '28.05.2016', '1800', '2'),
('Mig Før Dig', '29.05.2016', '1200', '2'),
('Money Monster', '29.05.2016', '1200', '1'),
('Mig Før Dig', '29.05.2016', '1800', '2'),
('Money Monster', '29.05.2016', '1800', '1');

INSERT INTO `kinoempire`.`Log` (`Show`, `Customer`, `Seat`, `Time`, `Status`) VALUES 
('1', 'Hans@email.com', '1', '1100', 'Sale'), 
('2', 'Jens@email.com', '2', '1300', 'Res'), 
('3', 'Peter@email.com', '3', '1500', 'Sale'), 
('4', 'Jan@email.com', '4', '1300', 'Res'), 
('8', 'Hans@email.com', '5', '1110', 'Res'), 
('7', 'Jens@email.com', '6', '1820', 'Sale'), 
('6', 'Peter@email.com', '7', '2200', 'Res'), 
('5', 'Jan@email.com', '8', '1430', 'Sale'), 
('9', 'Gerd@email.com', '1', '1540', 'Sale'), 
('10', 'Ole@email.com', '2', '1555', 'Res'), 
('11', 'Kurt@email.com', '3', '1337', 'Sale'), 
('12', 'Bo@email.com', '4', '1420', 'Res'), 
('16', 'Gerd@email.com', '5', '1650', 'Res'), 
('15', 'Ole@email.com', '6', '1850', 'Sale'), 
('14', 'Kurt@email.com', '7', '1830', 'Res'), 
('13', 'Bo@email.com', '8', '1230', 'Sale');
