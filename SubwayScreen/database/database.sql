-- Standard procedure to check if the database already exists
DROP DATABASE IF EXISTS ads;
CREATE DATABASE ads;

-- Connect to the ads database
\c ads;

-- Create the table and check if exists to avoid errors
DROP TABLE IF EXISTS adtable;
CREATE TABLE adtable (
    id SERIAL PRIMARY KEY, --This makes it so that the id will iterate every time
    name VARCHAR(255) NOT NULL, --Varchar(255) = store string up to 255 char long
    file_path VARCHAR(255) NOT NULL
);

-- Insert data into the table
INSERT INTO adtable (name, file_path)
VALUES
    ('ALLINORNOTHING', 'data/Ads/AllInOrNothingAd.jpg'),
    ('FANTABREVAD', 'data/Ads/FantaBrevAd.jpg'),
    ('GATORADEAD', 'data/Ads/GatoradeAd.jpg'),
    ('JEEPAD', 'data/Ads/JeepAd.jpg'),
    ('LEBRONAD', 'data/Ads/LebronAd.jpg'),
    ('POWERADEAD', 'data/Ads/Powerade.jpg'),
    ('RONALDOAD', 'data/Ads/RonaldoAd.jpg'),
    ('TABASCOAD', 'data/Ads/TabascoAd.jpg');
-- No need to add id because Serial primary key takes care for me
-- Select all data from the table
SELECT * FROM adtable;
