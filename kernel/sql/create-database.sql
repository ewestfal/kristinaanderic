drop table if exists Parties;
drop table if exists PartyNameRel;
drop table if exists Rsvps;
drop table if exists Addresses;
drop table if exists ContactInformations;
drop table if exists ContactInfoPhoneRel;
drop table if exists Names;
drop table if exists PhoneNumbers;

create table Parties (
   id BIGINT NOT NULL AUTO_INCREMENT,
   partyName VARCHAR(255),
   password VARCHAR(20),
   contactInformationId BIGINT,
   rsvpId BIGINT,
   primary key (id)
);

create table PartyNameRel (
   partyId BIGINT not null,
   nameId BIGINT not null,
   idx INTEGER not null
);

create table Rsvps (
   id BIGINT NOT NULL AUTO_INCREMENT,
   attending BIT,
   responseDate DATETIME,
   comments LONGTEXT,
   primary key (id)
);

create table RsvpRespondantRel (
   rsvpId BIGINT NOT NULL,
   nameId BIGINT,
   food VARCHAR(10)
);
   

create table Addresses (
   id BIGINT NOT NULL AUTO_INCREMENT,
   streetAddress1 VARCHAR(255),
   streetAddress2 VARCHAR(255),
   city VARCHAR(255),
   state VARCHAR(3),
   zipcode VARCHAR(10),
   primary key (id)
);

create table ContactInformations (
   id BIGINT NOT NULL AUTO_INCREMENT,
   addressId BIGINT,
   primary key (id)
);

create table ContactInfoPhoneRel (
   contactInfoId BIGINT not null,
   phoneNumberId BIGINT not null,
   idx INTEGER not null
);

create table Names (
   id BIGINT NOT NULL AUTO_INCREMENT,
   firstName VARCHAR(32),
   middleName VARCHAR(32),
   lastName VARCHAR(32),
   primary key (id)
);

create table PhoneNumbers (
   id BIGINT NOT NULL AUTO_INCREMENT,
   areaCode VARCHAR(255),
   prefix VARCHAR(255),
   postfix VARCHAR(255),
   extension VARCHAR(255),
   type ENUM('home','mobile','other','work'),
   primary key (id)
);

create table Identifiers (
   id BIGINT NOT NULL PRIMARY KEY
);