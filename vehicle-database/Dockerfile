FROM postgres:13.4

ENV POSTGRES_USER vc
ENV POSTGRES_PASSWORD secret
ENV POSTGRES_DB vehicle

COPY scripts/*.sql /docker-entrypoint-initdb.d/

EXPOSE 5432