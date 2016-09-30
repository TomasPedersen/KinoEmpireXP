
INSERT INTO `kinoempire`.`Customers` (`Email`, `Name`, `Phone_Number`, `Password`) VALUES
  ('Hans@email.com', 'Hans Hansen', '1234567', 'klsjdf'),
  ('Jens@email.com', 'Jens Jensen', '9876543', 'klsjdf'),
  ('Peter@email.com', 'Peter Petersen', '0123456', 'klsjdf'),
  ('Jan@email.com', 'Jan Jansen', '23232323', 'klsjdf'),
  ('Gerd@email.com', 'Gerd Gerdsen', '89348934', 'klsjdf'),
  ('Ole@email.com', 'Ole Olesen', '12312312', 'klsjdf'),
  ('Kurt@email.com', 'Kurt Kurtsen', '00110011', 'klsjdf'),
  ('Bo@email.com', 'Bo Bosen', '34343434', 'klsjdf');

INSERT INTO `kinoempire`.`Movies` (`Danish_Title`, `Original_Title`, `Genre`, `Filmlength`, `Filmdescription`, `Release_Date`, `Price`, `Director` , `Age_Restriction`, `Versions`, `Poster`) VALUES
  ('En Mand Der Hedder Ove', 'En Mand Som Heter Ove', 'Drama, Romantik', '116', 'x', '2016-05-26', '4', 'Hannes Holm', '12',  '2D', ''),
  ('Warcraft', 'Warcraft', 'Adventure', '123', 'x', '2016-05-26', '4', 'Duncan Jones', '12',  '3D, 2D, IMAX 3D', ''),
  ('Mig Før Dig', 'Me Before You', 'Drama, Romantik', '110', 'x', '2016-06-02', '4', 'Thea Sharrock', '12',  '2D', ''),
  ('Money Monster', 'Money Monster', 'Thriller, Drama', '98', 'x', '2016-06-02', '4',  'Jodie Foster', '12',  '2D', '');

INSERT INTO `kinoempire`.`Shows` (`show_id`, `Danish_Title`, `Date`, `Time`, `Theater`) VALUES
  (DEFAULT , 'En Mand Der Hedder Ove', '2016.10.03', '1200', '2'),
  (DEFAULT ,'Warcraft', '2016.10.03', '1200', '2'),
  (DEFAULT ,'En Mand Der Hedder Ove', '2016.10.03', '1800', '2'),
  (DEFAULT ,'Warcraft', '2016.10.03', '1800', '2'),
  (DEFAULT ,'En Mand Der Hedder Ove', '2016.10.04', '1200', '2'),
  (DEFAULT ,'Warcraft', '2016.10.04', '1200', '2'),
  (DEFAULT ,'En Mand Der Hedder Ove', '2016.10.04', '1800', '2'),
  (DEFAULT ,'Warcraft', '2016.10.04', '1800', '2'),

  (DEFAULT ,'Mig Før Dig', '2016.10.05', '1200', '2'),
  (DEFAULT ,'Money Monster', '2016.10.05', '1200', '2'),
  (DEFAULT ,'Mig Før Dig', '2016.10.05', '1800', '2'),
  (DEFAULT ,'Money Monster', '2016.10.05', '1800', '2'),
  (DEFAULT ,'Mig Før Dig', '2016.10.05', '1200', '2'),
  (DEFAULT ,'Money Monster', '2016.10.05', '1200', '2'),
  (DEFAULT ,'Mig Før Dig', '2016.10.05', '1800', '2'),
  (DEFAULT ,'Money Monster', '2016.10.05', '1800', '2');

INSERT INTO `kinoempire`.`Sales` (`Show`, `Customer`, `SeatIndex`, `TimeOfSale`, `Status`) VALUES
  ('1', 'Hans@email.com', '1', now(), 'Sale'),
  ('2', 'Jens@email.com', '2', now(), 'Res'),
  ('3', 'Peter@email.com', '3', now(), 'Sale'),
  ('4', 'Jan@email.com', '4', now(), 'Res'),
  ('8', 'Hans@email.com', '5', now(), 'Res'),
  ('8', 'Hans@email.com', '6', now(), 'Res'),
  ('8', 'Hans@email.com', '7', now(), 'Res'),
  ('8', 'Hans@email.com', '8', now(), 'Res'),
  ('8', 'Hans@email.com', '45', now(), 'Res'),
  ('8', 'Hans@email.com', '54', now(), 'Res'),
  ('8', 'Hans@email.com', '150', now(), 'Res'),
  ('8', 'Hans@email.com', '151', now(), 'Res'),
  ('8', 'Hans@email.com', '152', now(), 'Res'),
  ('8', 'Hans@email.com', '56', now(), 'Res'),
  ('8', 'Hans@email.com', '36', now(), 'Res'),
  ('8', 'Hans@email.com', '26', now(), 'Res'),
  ('8', 'Hans@email.com', '25', now(), 'Res'),
  ('8', 'Hans@email.com', '15', now(), 'Res'),
  ('8', 'Hans@email.com', '35', now(), 'Res'),
  ('8', 'Hans@email.com', '45', now(), 'Res'),
  ('8', 'Hans@email.com', '55', now(), 'Res'),
  ('8', 'Hans@email.com', '65', now(), 'Res'),
  ('8', 'Hans@email.com', '75', now(), 'Res'),
  ('8', 'Hans@email.com', '85', now(), 'Res'),
  ('8', 'Hans@email.com', '95', now(), 'Res'),
  ('8', 'Hans@email.com', '21', now(), 'Res'),
  ('8', 'Hans@email.com', '22', now(), 'Res'),
  ('8', 'Hans@email.com', '23', now(), 'Res'),
  ('8', 'Hans@email.com', '24', now(), 'Res'),
  ('8', 'Hans@email.com', '25', now(), 'Res'),
  ('8', 'Hans@email.com', '26', now(), 'Res'),
  ('8', 'Hans@email.com', '27', now(), 'Res'),
  ('8', 'Hans@email.com', '29', now(), 'Res'),
  ('7', 'Jens@email.com', '12', now(), 'Sale'),
  ('7', 'Jens@email.com', '31', now(), 'Sale'),
  ('7', 'Jens@email.com', '13', now(), 'Sale'),
  ('7', 'Jens@email.com', '15', now(), 'Sale'),
  ('7', 'Jens@email.com', '16', now(), 'Sale'),
  ('7', 'Jens@email.com', '17', now(), 'Sale'),
  ('7', 'Jens@email.com', '27', now(), 'Sale'),
  ('7', 'Jens@email.com', '37', now(), 'Sale'),
  ('7', 'Jens@email.com', '38', now(), 'Sale'),
  ('7', 'Jens@email.com', '39', now(), 'Sale'),
  ('7', 'Jens@email.com', '57', now(), 'Sale'),
  ('7', 'Jens@email.com', '45', now(), 'Sale'),
  ('7', 'Jens@email.com', '135', now(), 'Sale'),
  ('7', 'Jens@email.com', '134', now(), 'Sale'),
  ('7', 'Jens@email.com', '123', now(), 'Sale'),
  ('7', 'Jens@email.com', '124', now(), 'Sale'),
  ('7', 'Jens@email.com', '125', now(), 'Sale'),
  ('7', 'Jens@email.com', '126', now(), 'Sale'),
  ('7', 'Jens@email.com', '127', now(), 'Sale'),
  ('7', 'Jens@email.com', '128', now(), 'Sale'),
  ('7', 'Jens@email.com', '139', now(), 'Sale'),
  ('7', 'Jens@email.com', '143', now(), 'Sale'),
  ('7', 'Jens@email.com', '153', now(), 'Sale'),
  ('7', 'Jens@email.com', '163', now(), 'Sale'),
  ('7', 'Jens@email.com', '173', now(), 'Sale'),
  ('7', 'Jens@email.com', '183', now(), 'Sale'),
  ('7', 'Jens@email.com', '193', now(), 'Sale'),
  ('7', 'Jens@email.com', '113', now(), 'Sale'),
  ('7', 'Jens@email.com', '111', now(), 'Sale'),
  ('7', 'Jens@email.com', '114', now(), 'Sale'),
  ('7', 'Jens@email.com', '115', now(), 'Sale'),
  ('7', 'Jens@email.com', '116', now(), 'Sale'),
  ('7', 'Jens@email.com', '117', now(), 'Sale'),
  ('7', 'Jens@email.com', '118', now(), 'Sale'),
  ('7', 'Jens@email.com', '119', now(), 'Sale'),
  ('7', 'Jens@email.com', '161', now(), 'Sale'),
  ('7', 'Jens@email.com', '162', now(), 'Sale'),
  ('7', 'Jens@email.com', '163', now(), 'Sale'),
  ('7', 'Jens@email.com', '164', now(), 'Sale'),
  ('7', 'Jens@email.com', '165', now(), 'Sale'),
  ('7', 'Jens@email.com', '166', now(), 'Sale'),
  ('7', 'Jens@email.com', '167', now(), 'Sale'),
  ('7', 'Jens@email.com', '168', now(), 'Sale'),
  ('7', 'Jens@email.com', '169', now(), 'Sale'),
  ('7', 'Jens@email.com', '170', now(), 'Sale'),
  ('7', 'Jens@email.com', '171', now(), 'Sale'),
  ('7', 'Jens@email.com', '172', now(), 'Sale'),
  ('7', 'Jens@email.com', '173', now(), 'Sale'),
  ('7', 'Jens@email.com', '174', now(), 'Sale'),
  ('7', 'Jens@email.com', '175', now(), 'Sale'),
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
