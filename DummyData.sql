INSERT INTO `kinoempire`.`Customers` (`E-mail`, `Name`, `Phone Number`) VALUES 
('Hans@email.com', 'Hans Hansen', '1234567'), 
('Jens@email.com', 'Jens Jensen', '9876543'), 
('Peter@email.com', 'Peter Petersen', '0123456'), 
('Jan@email.com', 'Jan Jansen', '23232323'), 
('Gerd@email.com', 'Gerd Gerdsen', '89348934'), 
('Ole@email.com', 'Ole Olesen', '12312312'), 
('Kurt@email.com', 'Kurt Kurtsen', '00110011'), 
('Bo@email.com', 'Bo Bosen', '34343434');
INSERT INTO `kinoempire`.`Movies` (`Title`, `Genre`, `Length`, `Description`, `Release Date`, `Numbers Sold`, `Price 1`, `Price 2`, `Director`, `Copyright`, `Original Title`, `Versions`, `Age Restriction`) VALUES 
('En Mand Der Hedder Ove', 'Drama, Romantik', '116', 'x', '2016-05-26', '4', '80', '80', 'Hannes Holm', 'Nordisk Film', 'En Mand Som Heter Ove', '2D', '11'), 
('Warcraft', 'Adventure', '123', 'x', '2016-05-26', '4', '80', '90', 'Duncan Jones', 'Universal Pictures', 'Warcraft', '3D, 2D, IMAX 3D', '11'), 
('Mig Før Dig', 'Drama, Romantik', '110', 'x', '2016-06-02', '4', '80', '80', 'Thea Sharrock', 'SF FILM', 'Me Before You', '2D', 'A'), 
('Money Monster', 'Thriller, Drama', '98', 'x', '2016-06-02', '4', '80', '80', 'Jodie Foster', 'UIP', 'Money Monster', '2D', '11');
INSERT INTO `kinoempire`.`Shows` (`show_id`, `Title`, `Date`, `Time`, `Theater`) VALUES 
('0', 'En Mand Der Hedder Ove', '26.05.2016', '1200', '1'), 
('1', 'Warcraft', '26.05.2016', '1200', '2'), 
('2', 'En Mand Der Hedder Ove', '26.05.2016', '1800', '1'), 
('3', 'Warcraft', '26.05.2016', '1800', '2'), 
('4', 'En Mand Der Hedder Ove', '27.05.2016', '1200', '2'), 
('5', 'Warcraft', '27.05.2016', '1200', '1'), 
('6', 'En Mand Der Hedder Ove', '27.05.2016', '1800', '2'), 
('7', 'Warcraft', '27.05.2016', '1800', '1'),

('8', 'Mig Før Dig', '28.05.2016', '1200', '1'),
('9', 'Money Monster', '28.05.2016', '1200', '2'),
('10', 'Mig Før Dig', '28.05.2016', '1800', '1'),
('11', 'Money Monster', '28.05.2016', '1800', '2'),
('12', 'Mig Før Dig', '29.05.2016', '1200', '2'),
('13', 'Money Monster', '29.05.2016', '1200', '1'),
('14', 'Mig Før Dig', '29.05.2016', '1800', '2'),
('15', 'Money Monster', '29.05.2016', '1800', '1');

INSERT INTO `kinoempire`.`Log` (`sales_id`, `Show`, `Customer`, `Seat`, `Time`, `Status`) VALUES 
('0', '0', 'Hans@email.com', '1', '1100', 'Sale'), 
('1', '1', 'Jens@email.com', '2', '1300', 'Res'), 
('2', '2', 'Peter@email.com', '3', '1500', 'Sale'), 
('3', '3', 'Jan@email.com', '4', '1300', 'Res'), 
('4', '7', 'Hans@email.com', '5', '1110', 'Res'), 
('5', '6', 'Jens@email.com', '6', '1820', 'Sale'), 
('6', '5', 'Peter@email.com', '7', '2200', 'Res'), 
('7', '4', 'Jan@email.com', '8', '1430', 'Sale'), 
('8', '8', 'Gerd Gerdsen', '1', '1540', 'Sale'), 
('9', '9', 'Ole Olesen', '2', '1555', 'Res'), 
('10', '10', 'Kurt Kurtsen', '3', '1337', 'Sale'), 
('11', '11', 'Bo Bosen', '4', '1420', 'Res'), 
('12', '15', 'Gerd Gerdsen', '5', '1650', 'Res'), 
('13', '14', 'Ole Olesen', '6', '1850', 'Sale'), 
('14', '13', 'Kurt Kurtsen', '7', '1830', 'Res'), 
('15', '12', 'Bo Bosen', '8', '1230', 'Sale');
