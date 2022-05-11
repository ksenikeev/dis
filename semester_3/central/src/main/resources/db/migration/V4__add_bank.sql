CREATE TABLE IF NOT EXISTS public.bank
(
    id bigint NOT NULL,
    CONSTRAINT bank_pkey PRIMARY KEY (id),
    CONSTRAINT fkecd5wrsewjoxo98xvgdbt9fo9 FOREIGN KEY (id)
        REFERENCES public.organization (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);