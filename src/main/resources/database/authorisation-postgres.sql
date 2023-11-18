CREATE ROLE "profile-matcher" NOSUPERUSER NOCREATEDB NOCREATEROLE NOINHERIT LOGIN PASSWORD 'profilematcherpass';
CREATE SCHEMA "profile-matcher" AUTHORIZATION "profile-matcher";
GRANT ALL PRIVILEGES ON SCHEMA "profile-matcher" TO "profile-matcher";
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA "profile-matcher" TO "profile-matcher";
GRANT USAGE ON ALL SEQUENCES IN SCHEMA "profile-matcher" TO "profile-matcher";