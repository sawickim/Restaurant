CREATE TABLE public.credit
(
    id bigint NOT NULL,
    "creditName" character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT credit_pkey PRIMARY KEY (id)
);

CREATE TABLE public.customer
(
    id bigint NOT NULL,
    firstname character varying(255) COLLATE pg_catalog."default",
    pesel character varying(255) COLLATE pg_catalog."default",
    surname character varying(255) COLLATE pg_catalog."default",
    credit_id bigint,
    CONSTRAINT customer_pkey PRIMARY KEY (id),
    CONSTRAINT fk8gv68y8f5fs3ywgaqvg2wwvg FOREIGN KEY (credit_id)
        REFERENCES public.credit (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE public.product
(
    id bigint NOT NULL,
    product_name character varying(255) COLLATE pg_catalog."default",
    value numeric,
    credit_id bigint,
    CONSTRAINT product_pkey PRIMARY KEY (id),
    CONSTRAINT fk874v8exweavn7fp1c74ik3afa FOREIGN KEY (credit_id)
        REFERENCES public.credit (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)