# Use the official PostgreSQL image as the base
FROM postgres:14.1-alpine

# Set environment variables (optional)
ENV POSTGRES_USER adwebstart
ENV POSTGRES_PASSWORD adwebstart
ENV POSTGRES_DB adwebstart

# Expose the PostgreSQL port
EXPOSE 5432

# Copy initialization script into the container
COPY init.sql /docker-entrypoint-initdb.d/

# CMD is provided by the official PostgreSQL image to start the PostgreSQL server
CMD ["postgres"]
