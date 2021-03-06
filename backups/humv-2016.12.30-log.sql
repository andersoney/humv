PGDMP         9    
            u            humv_log    9.5.4    9.5.5     L           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            M           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            N           1262    16386    humv_log    DATABASE     z   CREATE DATABASE humv_log WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';
    DROP DATABASE humv_log;
             humv    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            O           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    6            P           0    0    public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    6                        3079    12361    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            Q           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    16453    logging_event_id_seq    SEQUENCE     v   CREATE SEQUENCE logging_event_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.logging_event_id_seq;
       public       humv    false    6            R           0    0    logging_event_id_seq    ACL     �   REVOKE ALL ON SEQUENCE logging_event_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE logging_event_id_seq FROM humv;
GRANT ALL ON SEQUENCE logging_event_id_seq TO humv;
            public       humv    false    181            �            1259    16455    logging_event    TABLE     �  CREATE TABLE logging_event (
    timestmp bigint NOT NULL,
    formatted_message text NOT NULL,
    logger_name character varying(254) NOT NULL,
    level_string character varying(254) NOT NULL,
    thread_name character varying(254),
    reference_flag smallint,
    arg0 character varying(254),
    arg1 character varying(254),
    arg2 character varying(254),
    arg3 character varying(254),
    caller_filename character varying(254) NOT NULL,
    caller_class character varying(254) NOT NULL,
    caller_method character varying(254) NOT NULL,
    caller_line character(4) NOT NULL,
    event_id bigint DEFAULT nextval('logging_event_id_seq'::regclass) NOT NULL
);
 !   DROP TABLE public.logging_event;
       public         humv    false    181    6            S           0    0    logging_event    ACL     �   REVOKE ALL ON TABLE logging_event FROM PUBLIC;
REVOKE ALL ON TABLE logging_event FROM humv;
GRANT ALL ON TABLE logging_event TO humv;
            public       humv    false    182            �            1259    16477    logging_event_exception    TABLE     �   CREATE TABLE logging_event_exception (
    event_id bigint NOT NULL,
    i smallint NOT NULL,
    trace_line character varying(254) NOT NULL
);
 +   DROP TABLE public.logging_event_exception;
       public         humv    false    6            T           0    0    logging_event_exception    ACL     �   REVOKE ALL ON TABLE logging_event_exception FROM PUBLIC;
REVOKE ALL ON TABLE logging_event_exception FROM humv;
GRANT ALL ON TABLE logging_event_exception TO humv;
            public       humv    false    184            �            1259    16464    logging_event_property    TABLE     �   CREATE TABLE logging_event_property (
    event_id bigint NOT NULL,
    mapped_key character varying(254) NOT NULL,
    mapped_value character varying(1024)
);
 *   DROP TABLE public.logging_event_property;
       public         humv    false    6            U           0    0    logging_event_property    ACL     �   REVOKE ALL ON TABLE logging_event_property FROM PUBLIC;
REVOKE ALL ON TABLE logging_event_property FROM humv;
GRANT ALL ON TABLE logging_event_property TO humv;
            public       humv    false    183            G          0    16455    logging_event 
   TABLE DATA               �   COPY logging_event (timestmp, formatted_message, logger_name, level_string, thread_name, reference_flag, arg0, arg1, arg2, arg3, caller_filename, caller_class, caller_method, caller_line, event_id) FROM stdin;
    public       humv    false    182   �       I          0    16477    logging_event_exception 
   TABLE DATA               C   COPY logging_event_exception (event_id, i, trace_line) FROM stdin;
    public       humv    false    184   �       V           0    0    logging_event_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('logging_event_id_seq', 1, false);
            public       humv    false    181            H          0    16464    logging_event_property 
   TABLE DATA               M   COPY logging_event_property (event_id, mapped_key, mapped_value) FROM stdin;
    public       humv    false    183   �       �           2606    16481    logging_event_exception_pkey 
   CONSTRAINT     t   ALTER TABLE ONLY logging_event_exception
    ADD CONSTRAINT logging_event_exception_pkey PRIMARY KEY (event_id, i);
 ^   ALTER TABLE ONLY public.logging_event_exception DROP CONSTRAINT logging_event_exception_pkey;
       public         humv    false    184    184    184            �           2606    16463    logging_event_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY logging_event
    ADD CONSTRAINT logging_event_pkey PRIMARY KEY (event_id);
 J   ALTER TABLE ONLY public.logging_event DROP CONSTRAINT logging_event_pkey;
       public         humv    false    182    182            �           2606    16471    logging_event_property_pkey 
   CONSTRAINT     {   ALTER TABLE ONLY logging_event_property
    ADD CONSTRAINT logging_event_property_pkey PRIMARY KEY (event_id, mapped_key);
 \   ALTER TABLE ONLY public.logging_event_property DROP CONSTRAINT logging_event_property_pkey;
       public         humv    false    183    183    183            �           2606    16482 %   logging_event_exception_event_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY logging_event_exception
    ADD CONSTRAINT logging_event_exception_event_id_fkey FOREIGN KEY (event_id) REFERENCES logging_event(event_id);
 g   ALTER TABLE ONLY public.logging_event_exception DROP CONSTRAINT logging_event_exception_event_id_fkey;
       public       humv    false    184    1997    182            �           2606    16472 $   logging_event_property_event_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY logging_event_property
    ADD CONSTRAINT logging_event_property_event_id_fkey FOREIGN KEY (event_id) REFERENCES logging_event(event_id);
 e   ALTER TABLE ONLY public.logging_event_property DROP CONSTRAINT logging_event_property_event_id_fkey;
       public       humv    false    1997    182    183            G      x������ � �      I      x������ � �      H      x������ � �     