CREATE TABLE IF NOT EXISTS vehicle_configuration
(
  vehicle_configuration_id  SERIAL PRIMARY KEY,
  created_at                BIGINT NOT NULL,
  model                     VARCHAR(255) NOT NULL,
  country_ids               INTEGER[] NOT NULL,
  engine_types              TEXT[] NOT NULL,
  markets                   TEXT[] NOT NULL,
  structure_version         VARCHAR(255) NOT NULL
);