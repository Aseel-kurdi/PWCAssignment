CREATE TABLE Client(
	phoneNumber varchar(10) primaryKey,
	clientFirstName varchar(255) not null,
	clientLastName varchar(255) not null,
	email varchar(255) not null,
	pass varchar(255) 
);

CREATE TABLE Complaint(
	complaintNumber int primary Key,
	status varchar(255),
	clientName varchar(255),
	type varchar(255) not null,
	AdditionalNote varchar(1000) not null,
        branch varchar(255) not null,
 	criticalOrNot varchar(30) not null,
	phoneNumber varchar(10)
);
	
	
	
	
	
	