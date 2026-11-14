CREATE DATABASE IF NOT EXISTS trip_war_room;
USE trip_war_room;

-- Spring Data JPA creates/updates the trips and venue_metadata tables
-- from the entity classes when the backend starts (ddl-auto=update).
-- This file creates the database only; do not manually maintain duplicate
-- table definitions while using Hibernate schema update.
