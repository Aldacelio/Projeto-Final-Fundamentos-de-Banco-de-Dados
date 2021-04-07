-- Table: public.login

-- DROP TABLE public.login;

CREATE TABLE public.login
(
    id integer NOT NULL DEFAULT nextval('login_id_seq'::regclass),
    usuario character varying COLLATE pg_catalog."default" NOT NULL,
    senha character varying COLLATE pg_catalog."default" NOT NULL,
    tipo character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT login_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.login
    OWNER to postgres;