
INSERT INTO `kinoempire`.`Customers` (`Email`, `Name`, `Phone_Number`, `Password`) VALUES
('Hans@email.com', 'Hans Hansen', '1234567', 'klsjdf'),
('Jens@email.com', 'Jens Jensen', '9876543', 'klsjdf'),
('Peter@email.com', 'Peter Petersen', '0123456', 'klsjdf'),
('Jan@email.com', 'Jan Jansen', '23232323', 'klsjdf'),
('Gerd@email.com', 'Gerd Gerdsen', '89348934', 'klsjdf'),
('Ole@email.com', 'Ole Olesen', '12312312', 'klsjdf'),
('Kurt@email.com', 'Kurt Kurtsen', '00110011', 'klsjdf'),
('Bo@email.com', 'Bo Bosen', '34343434', 'klsjdf');

INSERT INTO `kinoempire`.`Movies` (`Danish_Title`, `Original_Title`, `Genre`, `Filmlength`, `Filmdescription`, `Release_Date`, `Price`, `Director` , `Age Restriction`, `Versions`) VALUES
('En Mand Der Hedder Ove', 'En Mand Som Heter Ove', 'Drama, Romantik', '116', 'x', '2016-05-26', '4', 'Hannes Holm', '12',  '2D'),
('Warcraft', 'Warcraft', 'Adventure', '123', 'x', '2016-05-26', '4', 'Duncan Jones', '12',  '3D, 2D, IMAX 3D'),
('Mig Før Dig', 'Me Before You', 'Drama, Romantik', '110', 'x', '2016-06-02', '4', 'Thea Sharrock', '12',  '2D'),
('Money Monster', 'Money Monster', 'Thriller, Drama', '98', 'x', '2016-06-02', '4',  'Jodie Foster', '12',  '2D');

INSERT INTO `kinoempire`.`Shows` (`Title`, `Date`, `Time`, `Theater`) VALUES 
('En Mand Der Hedder Ove', '2016.05.26', '1200', '1'),
('Warcraft', '2016.05.26', '1200', '2'),
('En Mand Der Hedder Ove', '2016.05.26', '1800', '1'),
('Warcraft', '2016.05.26', '1800', '2'),
('En Mand Der Hedder Ove', '2016.05.27', '1200', '2'),
('Warcraft', '2016.05.27', '1200', '1'),
('En Mand Der Hedder Ove', '2016.05.27', '1800', '2'),
('Warcraft', '2016.05.27', '1800', '1'),

('Mig Før Dig', '2016.05.28', '1200', '1'),
('Money Monster', '2016.05.28', '1200', '2'),
('Mig Før Dig', '2016.05.28', '1800', '1'),
('Money Monster', '2016.05.28', '1800', '2'),
('Mig Før Dig', '2016.05.29', '1200', '2'),
('Money Monster', '2016.05.29', '1200', '1'),
('Mig Før Dig', '2016.05.29', '1800', '2'),
('Money Monster', '2016.05.29', '1800', '1');

INSERT INTO `kinoempire`.`Sales` (`Show`, `Customer`, `SeatIndex`, `TimeOfSale`, `Status`) VALUES
  ('1', 'Hans@email.com', '1', now(), 'Sale'),
  ('2', 'Jens@email.com', '2', now(), 'Res'),
  ('3', 'Peter@email.com', '3', now(), 'Sale'),
  ('4', 'Jan@email.com', '4', now(), 'Res'),
  ('8', 'Hans@email.com', '5', now(), 'Res'),
  ('7', 'Jens@email.com', '6', now(), 'Sale'),
  ('6', 'Peter@email.com', '7', now(), 'Res'),
  ('5', 'Jan@email.com', '8', now(), 'Sale'),
  ('9', 'Gerd@email.com', '1', now(), 'Sale'),
  ('10', 'Ole@email.com', '2', now(), 'Res'),
  ('11', 'Kurt@email.com', '3', now(), 'Sale'),
  ('12', 'Bo@email.com', '4', now(), 'Res'),
  ('16', 'Gerd@email.com', '5', now(), 'Res'),
  ('15', 'Ole@email.com', '6', now(), 'Sale'),
  ('14', 'Kurt@email.com', '7', now(), 'Res'),
  ('13', 'Bo@email.com', '8', now(), 'Sale');
