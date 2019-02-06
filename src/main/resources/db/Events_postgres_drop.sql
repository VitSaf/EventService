ALTER TABLE "Events" DROP CONSTRAINT IF EXISTS "Events_fk0";

ALTER TABLE "Event_localization" DROP CONSTRAINT IF EXISTS "Event_localization_fk0";

ALTER TABLE "Locations" DROP CONSTRAINT IF EXISTS "Locations_fk0";

ALTER TABLE "Cities" DROP CONSTRAINT IF EXISTS "Cities_fk0";

ALTER TABLE "Regions" DROP CONSTRAINT IF EXISTS "Regions_fk0";

DROP TABLE IF EXISTS "Events";

DROP TABLE IF EXISTS "Event_localization";

DROP TABLE IF EXISTS "Locations";

DROP TABLE IF EXISTS "Countries";

DROP TABLE IF EXISTS "Cities";

DROP TABLE IF EXISTS "Regions";
