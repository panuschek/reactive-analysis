FROM postgres:13.4

ENV POSTGRES_USER vc
ENV POSTGRES_PASSWORD secret
ENV POSTGRES_DB vehicle

COPY scripts/*.sql /docker-entrypoint-initdb.d/
COPY scripts/postgresql.conf /etc/postgresql/postgresql.conf

EXPOSE 5432
CMD ["-c", "config_file=/etc/postgresql/postgresql.conf"]