drop table if exists addresses;
drop table if exists rsvps;
drop table if exists party_name_rel;
drop table if exists phoneNumbers;
drop table if exists names;
drop table if exists contact_info_phone_rel;
drop table if exists user_accounts;
drop table if exists contact_info;
drop table if exists parties;
create table addresses (
   id BIGINT NOT NULL AUTO_INCREMENT,
   streetAddress1 VARCHAR(255),
   streetAddress2 VARCHAR(255),
   city VARCHAR(255),
   state SMALLINT,
   zipcode VARCHAR(255),
   primary key (id)
);
create table rsvps (
   id BIGINT NOT NULL AUTO_INCREMENT,
   attending BIT,
   numberAttending INTEGER,
   responseDate DATETIME,
   primary key (id)
);
create table party_name_rel (
   partyId BIGINT not null,
   nameId BIGINT not null,
   idx INTEGER not null,
   primary key (partyId, idx)
);
create table phoneNumbers (
   id BIGINT NOT NULL AUTO_INCREMENT,
   areaCode VARCHAR(255),
   prefix VARCHAR(255),
   postfix VARCHAR(255),
   extension VARCHAR(255),
   type SMALLINT,
   primary key (id)
);
create table names (
   id BIGINT NOT NULL AUTO_INCREMENT,
   firstName VARCHAR(255),
   middleName VARCHAR(255),
   lastName VARCHAR(255),
   primary key (id)
);
create table contact_info_phone_rel (
   contactInfoId BIGINT not null,
   phoneNumberId BIGINT not null,
   idx INTEGER not null,
   primary key (contactInfoId, idx)
);
create table user_accounts (
   id BIGINT NOT NULL AUTO_INCREMENT,
   userName VARCHAR(255),
   password VARCHAR(255),
   partyId BIGINT,
   primary key (id)
);
create table contact_info (
   id BIGINT NOT NULL AUTO_INCREMENT,
   addressId BIGINT,
   primary key (id)
);
create table parties (
   id BIGINT NOT NULL AUTO_INCREMENT,
   contactInformationId BIGINT,
   rsvpId BIGINT,
   primary key (id)
);
alter table party_name_rel add index (nameId), add constraint FKFF401E1EC13F0D06 foreign key (nameId) references names (id);
alter table party_name_rel add index (partyId), add constraint FKFF401E1ED0BD02A1 foreign key (partyId) references parties (id);
alter table contact_info_phone_rel add index (contactInfoId), add constraint FK9A6B21F6136372A9 foreign key (contactInfoId) references contact_info (id);
alter table contact_info_phone_rel add index (phoneNumberId), add constraint FK9A6B21F6129F89D2 foreign key (phoneNumberId) references phoneNumbers (id);
alter table user_accounts add index (partyId), add constraint FK83A115DAD0BD02A1 foreign key (partyId) references parties (id);
alter table contact_info add index (addressId), add constraint FK4C268D6D3420782F foreign key (addressId) references addresses (id);
alter table parties add index (contactInformationId), add constraint FKD0BCCA04FDE9A327 foreign key (contactInformationId) references contact_info (id);
alter table parties add index (rsvpId), add constraint FKD0BCCA04C9145736 foreign key (rsvpId) references rsvps (id);
