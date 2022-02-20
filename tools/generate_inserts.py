f = open('inserts.sql', "w")

for x in range(1, 101):
  country_ids = ', '.join(str(i) for i in range(x, x + 10))
  for y in range(1, 1000):
    print('bla')
    f.write(f"INSERT INTO vehicle_configuration (created_at, model, country_ids, engine_types, markets, structure_version) VALUES (20211201183122, 'P 8', ARRAY [{country_ids}], ARRAY ['V6', 'V 8', 'Elektro', 'Elektro 4x4'], ARRAY ['Deutschland', 'Frankreich', 'China', 'Japan', 'USA'], '3.15.2');\n")
f.close()