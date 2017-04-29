SELECT partyName,password INTO OUTFILE '/home/krisanderic/export/party-info.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' LINES TERMINATED BY '\n' FROM Parties;
