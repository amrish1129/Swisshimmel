#Property 

CREATE TABLE swisshimmel.Property
(
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
propId varchar(255),
propertyName varchar(255),
location varchar(255),
phoneNumber varchar(255),
country  varchar(255),
city  varchar(255),
nearestAirport varchar(255),
nearestStation varchar(255),
howToReachAirport varchar(255),
howToReachStation varchar(255),
email varchar(255), 
PRIMARY KEY (`id`)
)
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

#Country
CREATE TABLE swisshimmel.OCCASION
(
`occasion_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
 occasionName varchar(255) NOT NULL,
 city varchar(50) NOT NULL,
 country varchar(50) NOT NULL,
 comment varchar(255),
 wikiLink varchar(1000),
 repeatsEveryYear boolean,
 timeEnteredBy varchar(255),
 PRIMARY KEY (`occasion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


#OCCASION TIMINGS
CREATE TABLE swisshimmel.OCCASION_TIME
(
`occasion_time_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
 dateTo date , 
 dateFrom date NOT NULL ,
 timeEnteredBy varchar(255),
 comment varchar(50),
 wiki varchar(1000),
 `occasion_id` int(11) unsigned NOT NULL,
 primary key (`occasion_time_id`),
 FOREIGN KEY (`occasion_id`) REFERENCES dbperson.OCCASION(`occasion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


#Country

CREATE TABLE swisshimmel.COUNTRY
(
`countryid` int(11) unsigned NOT NULL AUTO_INCREMENT,
 countryName varchar(70) UNIQUE,
 currency varchar(4) NOT NULL,
 shortCountryCode  varchar(4) NOT NULL,
 countryEnteredBY  varchar(100) , 
 primary key (`countryid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


