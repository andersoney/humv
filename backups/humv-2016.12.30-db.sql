PGDMP     &    8    
            u            humv_db    9.5.4    9.5.5 Y    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           1262    16385    humv_db    DATABASE     y   CREATE DATABASE humv_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';
    DROP DATABASE humv_db;
             humv    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    7            �           0    0    public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    7                        3079    12361    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    16487    animais    TABLE     z  CREATE TABLE animais (
    rghumv numeric(19,2) NOT NULL,
    datacadastro date,
    especie character varying(255),
    idade integer NOT NULL,
    nome character varying(255),
    pelagem character varying(255),
    peso double precision NOT NULL,
    porte character varying(255),
    raca character varying(255),
    sexo character(1) NOT NULL,
    dono_id numeric(19,2)
);
    DROP TABLE public.animais;
       public         humv    false    7            �            1259    16495    animais_grandes    TABLE     �  CREATE TABLE animais_grandes (
    dtype character varying(31) NOT NULL,
    rghumv character varying(255) NOT NULL,
    cpfdono character varying(255),
    datacadastro date,
    especie character varying(255),
    idade integer NOT NULL,
    nome character varying(255),
    peso double precision NOT NULL,
    raca character varying(255),
    sexo character(1) NOT NULL,
    pelagem character varying(255)
);
 #   DROP TABLE public.animais_grandes;
       public         humv    false    7            �            1259    16503    atendimentos    TABLE     �  CREATE TABLE atendimentos (
    id numeric(19,2) NOT NULL,
    extra boolean NOT NULL,
    horariomarcado timestamp without time zone,
    motivo character varying(255),
    observacoes character varying(255),
    porcentagemdesconto integer,
    retorno boolean NOT NULL,
    status integer,
    tipocobranca integer,
    valorcobrado double precision,
    animal_rghumv numeric(19,2),
    medico_email character varying(255),
    procedimento_codigo numeric(19,2),
    projeto_id numeric(19,2)
);
     DROP TABLE public.atendimentos;
       public         humv    false    7            �            1259    16511    atendimentos_sociais    TABLE     7  CREATE TABLE atendimentos_sociais (
    id numeric(19,2) NOT NULL,
    data timestamp without time zone,
    observacoesanimal character varying(255),
    observacoesdono character varying(255),
    percentualdescontocirurgias integer NOT NULL,
    percentualdescontoconsultas integer NOT NULL,
    percentualdescontoexames integer NOT NULL,
    situacaoanimal character varying(255),
    tipocobrancacirurgias character varying(255),
    tipocobrancaconsultas character varying(255),
    tipocobrancaexames character varying(255),
    animal_rghumv numeric(19,2)
);
 (   DROP TABLE public.atendimentos_sociais;
       public         humv    false    7            �            1259    16673    documentacao    TABLE     6  CREATE TABLE documentacao (
    iddocumento numeric(19,2) NOT NULL,
    dataentrega timestamp without time zone,
    na boolean NOT NULL,
    nomedocumento character varying(255),
    nomeusuariorecebinte character varying(255),
    vistoassistentesocial boolean NOT NULL,
    questionario_id numeric(19,2)
);
     DROP TABLE public.documentacao;
       public         humv    false    7            �            1259    16519 
   documentos    TABLE     4  CREATE TABLE documentos (
    iddocumento numeric(19,2) NOT NULL,
    dataentrega timestamp without time zone,
    na boolean NOT NULL,
    nomedocumento character varying(255),
    nomeusuariorecebinte character varying(255),
    vistoassistentesocial boolean NOT NULL,
    questionario_id numeric(19,2)
);
    DROP TABLE public.documentos;
       public         humv    false    7            �            1259    16527    donos    TABLE     w  CREATE TABLE donos (
    id numeric(19,2) NOT NULL,
    cep character varying(255),
    cidade character varying(255),
    cpfcnpj character varying(255),
    email character varying(255),
    endereco character varying(255),
    estado character varying(255),
    nome character varying(255),
    telefone character varying(255),
    tipodocumento character varying(255)
);
    DROP TABLE public.donos;
       public         humv    false    7            �            1259    16537    hello    TABLE     S   CREATE TABLE hello (
    id bigint NOT NULL,
    content character varying(255)
);
    DROP TABLE public.hello;
       public         humv    false    7            �            1259    16535    hello_id_seq    SEQUENCE     n   CREATE SEQUENCE hello_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.hello_id_seq;
       public       humv    false    189    7            �           0    0    hello_id_seq    SEQUENCE OWNED BY     /   ALTER SEQUENCE hello_id_seq OWNED BY hello.id;
            public       humv    false    188            �            1259    16670    hibernate_sequence    SEQUENCE     t   CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public       humv    false    7            �            1259    24679    material    TABLE     �   CREATE TABLE material (
    id numeric(19,2) NOT NULL,
    discriminacao character varying(255),
    tipo integer,
    unidade character varying(255),
    valor double precision NOT NULL
);
    DROP TABLE public.material;
       public         humv    false    7            �            1259    16543    parentes    TABLE       CREATE TABLE parentes (
    idparente numeric(19,2) NOT NULL,
    escolaridade integer,
    idade integer,
    nome character varying(255),
    ocupacao character varying(255),
    parentesco character varying(255),
    renda double precision,
    questionario_id numeric(19,2)
);
    DROP TABLE public.parentes;
       public         humv    false    7            �            1259    16551    procedimentos    TABLE     �   CREATE TABLE procedimentos (
    codigo numeric(19,2) NOT NULL,
    nome character varying(255),
    tipo integer,
    valor double precision NOT NULL,
    setor_codigo numeric(19,2)
);
 !   DROP TABLE public.procedimentos;
       public         humv    false    7            �            1259    16556    projetos    TABLE     �  CREATE TABLE projetos (
    id numeric(19,2) NOT NULL,
    datacadastro timestamp without time zone,
    datafim timestamp without time zone,
    datainicio timestamp without time zone,
    finalidade character varying(255),
    nome character varying(255),
    nomeresponsavel character varying(255),
    publicoalvo character varying(255),
    setor bytea,
    siaperesponsavel numeric(19,2),
    tipo character varying(255)
);
    DROP TABLE public.projetos;
       public         humv    false    7            �            1259    16564    prontuarios    TABLE     <   CREATE TABLE prontuarios (
    id numeric(19,2) NOT NULL
);
    DROP TABLE public.prontuarios;
       public         humv    false    7            �            1259    16445    proprietarios    TABLE       CREATE TABLE proprietarios (
    cpf character varying(255) NOT NULL,
    cep character varying(255),
    cidade character varying(255),
    endereco character varying(255),
    estado character varying(255),
    nome character varying(255),
    telefone character varying(255)
);
 !   DROP TABLE public.proprietarios;
       public         humv    false    7            �            1259    16569    questionarios_socioeconomicos    TABLE     �  CREATE TABLE questionarios_socioeconomicos (
    id numeric(19,2) NOT NULL,
    analisebreveresumo character varying(255),
    analiseconclusoes character varying(255),
    analiseobservacoes character varying(255),
    bensfamiliares character varying(255),
    bolsaoubeneficio character varying(255),
    condicaomoradia character varying(255),
    dataresposta timestamp without time zone,
    emprestimos character varying(255),
    escolaridade integer,
    estadocivil integer,
    estudante boolean NOT NULL,
    fontcusteio character varying(255),
    gastosmensais double precision,
    idade integer,
    impossibilidadescusteio character varying(255),
    nis character varying(255),
    observacoesdadosdono character varying(255),
    ocupacaoatual character varying(255),
    profissao character varying(255),
    programatransferenciarenda character varying(255),
    rendaformal double precision,
    rendainformal double precision,
    rendapercapta double precision,
    rendatotal double precision,
    riscossociais character varying(255),
    temenergia boolean NOT NULL,
    temsaneamento boolean NOT NULL,
    tipocobrancacirurgias integer,
    tipocobrancaconsultas integer,
    tipocobrancaexames integer,
    tipoconstrucao character varying(255),
    validade6meses boolean NOT NULL,
    valoraluguel double precision,
    valordescontocirurgias double precision,
    valordescontoconsultas double precision,
    valordescontoexames double precision,
    dono_id numeric(19,2)
);
 1   DROP TABLE public.questionarios_socioeconomicos;
       public         humv    false    7            �            1259    16679 *   questionarios_socioeconomicos_documentacao    TABLE     �   CREATE TABLE questionarios_socioeconomicos_documentacao (
    questionarios_socioeconomicos_id numeric(19,2) NOT NULL,
    documentosentregues_iddocumento numeric(19,2) NOT NULL
);
 >   DROP TABLE public.questionarios_socioeconomicos_documentacao;
       public         humv    false    7            �            1259    16577 (   questionarios_socioeconomicos_documentos    TABLE     �   CREATE TABLE questionarios_socioeconomicos_documentos (
    questionarios_socioeconomicos_id numeric(19,2) NOT NULL,
    documentosentregues_iddocumento numeric(19,2) NOT NULL
);
 <   DROP TABLE public.questionarios_socioeconomicos_documentos;
       public         humv    false    7            �            1259    16580 &   questionarios_socioeconomicos_parentes    TABLE     �   CREATE TABLE questionarios_socioeconomicos_parentes (
    questionarios_socioeconomicos_id numeric(19,2) NOT NULL,
    parentes_idparente numeric(19,2) NOT NULL
);
 :   DROP TABLE public.questionarios_socioeconomicos_parentes;
       public         humv    false    7            �            1259    16583    setores    TABLE     ]   CREATE TABLE setores (
    codigo numeric(19,2) NOT NULL,
    nome character varying(255)
);
    DROP TABLE public.setores;
       public         humv    false    7            �            1259    16588    usuarios    TABLE     �   CREATE TABLE usuarios (
    email character varying(255) NOT NULL,
    ativo boolean NOT NULL,
    nome character varying(255),
    perfil integer,
    senha character varying(255),
    siape numeric(19,2)
);
    DROP TABLE public.usuarios;
       public         humv    false    7                       2604    16682    id    DEFAULT     V   ALTER TABLE ONLY hello ALTER COLUMN id SET DEFAULT nextval('hello_id_seq'::regclass);
 7   ALTER TABLE public.hello ALTER COLUMN id DROP DEFAULT;
       public       humv    false    188    189    189            �          0    16487    animais 
   TABLE DATA               q   COPY animais (rghumv, datacadastro, especie, idade, nome, pelagem, peso, porte, raca, sexo, dono_id) FROM stdin;
    public       humv    false    182   
{       �          0    16495    animais_grandes 
   TABLE DATA               y   COPY animais_grandes (dtype, rghumv, cpfdono, datacadastro, especie, idade, nome, peso, raca, sexo, pelagem) FROM stdin;
    public       humv    false    183   ��       �          0    16503    atendimentos 
   TABLE DATA               �   COPY atendimentos (id, extra, horariomarcado, motivo, observacoes, porcentagemdesconto, retorno, status, tipocobranca, valorcobrado, animal_rghumv, medico_email, procedimento_codigo, projeto_id) FROM stdin;
    public       humv    false    184   �       �          0    16511    atendimentos_sociais 
   TABLE DATA               
  COPY atendimentos_sociais (id, data, observacoesanimal, observacoesdono, percentualdescontocirurgias, percentualdescontoconsultas, percentualdescontoexames, situacaoanimal, tipocobrancacirurgias, tipocobrancaconsultas, tipocobrancaexames, animal_rghumv) FROM stdin;
    public       humv    false    185   "�       �          0    16673    documentacao 
   TABLE DATA               �   COPY documentacao (iddocumento, dataentrega, na, nomedocumento, nomeusuariorecebinte, vistoassistentesocial, questionario_id) FROM stdin;
    public       humv    false    200   ?�       �          0    16519 
   documentos 
   TABLE DATA               �   COPY documentos (iddocumento, dataentrega, na, nomedocumento, nomeusuariorecebinte, vistoassistentesocial, questionario_id) FROM stdin;
    public       humv    false    186   \�       �          0    16527    donos 
   TABLE DATA               j   COPY donos (id, cep, cidade, cpfcnpj, email, endereco, estado, nome, telefone, tipodocumento) FROM stdin;
    public       humv    false    187   ��       �          0    16537    hello 
   TABLE DATA               %   COPY hello (id, content) FROM stdin;
    public       humv    false    189   ��      �           0    0    hello_id_seq    SEQUENCE SET     4   SELECT pg_catalog.setval('hello_id_seq', 1, false);
            public       humv    false    188            �           0    0    hibernate_sequence    SEQUENCE SET     <   SELECT pg_catalog.setval('hibernate_sequence', 1481, true);
            public       humv    false    199            �          0    24679    material 
   TABLE DATA               D   COPY material (id, discriminacao, tipo, unidade, valor) FROM stdin;
    public       humv    false    202   ܃      �          0    16543    parentes 
   TABLE DATA               o   COPY parentes (idparente, escolaridade, idade, nome, ocupacao, parentesco, renda, questionario_id) FROM stdin;
    public       humv    false    190   ��      �          0    16551    procedimentos 
   TABLE DATA               I   COPY procedimentos (codigo, nome, tipo, valor, setor_codigo) FROM stdin;
    public       humv    false    191   .�      �          0    16556    projetos 
   TABLE DATA               �   COPY projetos (id, datacadastro, datafim, datainicio, finalidade, nome, nomeresponsavel, publicoalvo, setor, siaperesponsavel, tipo) FROM stdin;
    public       humv    false    192   �      �          0    16564    prontuarios 
   TABLE DATA               "   COPY prontuarios (id) FROM stdin;
    public       humv    false    193   ��      �          0    16445    proprietarios 
   TABLE DATA               T   COPY proprietarios (cpf, cep, cidade, endereco, estado, nome, telefone) FROM stdin;
    public       humv    false    181   ݔ      �          0    16569    questionarios_socioeconomicos 
   TABLE DATA               �  COPY questionarios_socioeconomicos (id, analisebreveresumo, analiseconclusoes, analiseobservacoes, bensfamiliares, bolsaoubeneficio, condicaomoradia, dataresposta, emprestimos, escolaridade, estadocivil, estudante, fontcusteio, gastosmensais, idade, impossibilidadescusteio, nis, observacoesdadosdono, ocupacaoatual, profissao, programatransferenciarenda, rendaformal, rendainformal, rendapercapta, rendatotal, riscossociais, temenergia, temsaneamento, tipocobrancacirurgias, tipocobrancaconsultas, tipocobrancaexames, tipoconstrucao, validade6meses, valoraluguel, valordescontocirurgias, valordescontoconsultas, valordescontoexames, dono_id) FROM stdin;
    public       humv    false    194   K�      �          0    16679 *   questionarios_socioeconomicos_documentacao 
   TABLE DATA               �   COPY questionarios_socioeconomicos_documentacao (questionarios_socioeconomicos_id, documentosentregues_iddocumento) FROM stdin;
    public       humv    false    201   ��      �          0    16577 (   questionarios_socioeconomicos_documentos 
   TABLE DATA               ~   COPY questionarios_socioeconomicos_documentos (questionarios_socioeconomicos_id, documentosentregues_iddocumento) FROM stdin;
    public       humv    false    195   ŕ      �          0    16580 &   questionarios_socioeconomicos_parentes 
   TABLE DATA               o   COPY questionarios_socioeconomicos_parentes (questionarios_socioeconomicos_id, parentes_idparente) FROM stdin;
    public       humv    false    196   �      �          0    16583    setores 
   TABLE DATA               (   COPY setores (codigo, nome) FROM stdin;
    public       humv    false    197   �      �          0    16588    usuarios 
   TABLE DATA               E   COPY usuarios (email, ativo, nome, perfil, senha, siape) FROM stdin;
    public       humv    false    198   �      "           2606    16502    animais_grandes_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY animais_grandes
    ADD CONSTRAINT animais_grandes_pkey PRIMARY KEY (rghumv);
 N   ALTER TABLE ONLY public.animais_grandes DROP CONSTRAINT animais_grandes_pkey;
       public         humv    false    183    183                        2606    16494    animais_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY animais
    ADD CONSTRAINT animais_pkey PRIMARY KEY (rghumv);
 >   ALTER TABLE ONLY public.animais DROP CONSTRAINT animais_pkey;
       public         humv    false    182    182            $           2606    16510    atendimentos_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY atendimentos
    ADD CONSTRAINT atendimentos_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.atendimentos DROP CONSTRAINT atendimentos_pkey;
       public         humv    false    184    184            &           2606    16518    atendimentos_sociais_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY atendimentos_sociais
    ADD CONSTRAINT atendimentos_sociais_pkey PRIMARY KEY (id);
 X   ALTER TABLE ONLY public.atendimentos_sociais DROP CONSTRAINT atendimentos_sociais_pkey;
       public         humv    false    185    185            @           2606    16684    documentacao_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY documentacao
    ADD CONSTRAINT documentacao_pkey PRIMARY KEY (iddocumento);
 H   ALTER TABLE ONLY public.documentacao DROP CONSTRAINT documentacao_pkey;
       public         humv    false    200    200            (           2606    16526    documentos_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY documentos
    ADD CONSTRAINT documentos_pkey PRIMARY KEY (iddocumento);
 D   ALTER TABLE ONLY public.documentos DROP CONSTRAINT documentos_pkey;
       public         humv    false    186    186            *           2606    16534 
   donos_pkey 
   CONSTRAINT     G   ALTER TABLE ONLY donos
    ADD CONSTRAINT donos_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.donos DROP CONSTRAINT donos_pkey;
       public         humv    false    187    187            ,           2606    16542 
   hello_pkey 
   CONSTRAINT     G   ALTER TABLE ONLY hello
    ADD CONSTRAINT hello_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.hello DROP CONSTRAINT hello_pkey;
       public         humv    false    189    189            D           2606    24686    material_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY material
    ADD CONSTRAINT material_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.material DROP CONSTRAINT material_pkey;
       public         humv    false    202    202            .           2606    16550    parentes_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY parentes
    ADD CONSTRAINT parentes_pkey PRIMARY KEY (idparente);
 @   ALTER TABLE ONLY public.parentes DROP CONSTRAINT parentes_pkey;
       public         humv    false    190    190            0           2606    16555    procedimentos_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY procedimentos
    ADD CONSTRAINT procedimentos_pkey PRIMARY KEY (codigo);
 J   ALTER TABLE ONLY public.procedimentos DROP CONSTRAINT procedimentos_pkey;
       public         humv    false    191    191            2           2606    16563    projetos_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY projetos
    ADD CONSTRAINT projetos_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.projetos DROP CONSTRAINT projetos_pkey;
       public         humv    false    192    192            4           2606    16568    prontuarios_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY prontuarios
    ADD CONSTRAINT prontuarios_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.prontuarios DROP CONSTRAINT prontuarios_pkey;
       public         humv    false    193    193                       2606    16452    proprietarios_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY proprietarios
    ADD CONSTRAINT proprietarios_pkey PRIMARY KEY (cpf);
 J   ALTER TABLE ONLY public.proprietarios DROP CONSTRAINT proprietarios_pkey;
       public         humv    false    181    181            6           2606    16576 "   questionarios_socioeconomicos_pkey 
   CONSTRAINT     w   ALTER TABLE ONLY questionarios_socioeconomicos
    ADD CONSTRAINT questionarios_socioeconomicos_pkey PRIMARY KEY (id);
 j   ALTER TABLE ONLY public.questionarios_socioeconomicos DROP CONSTRAINT questionarios_socioeconomicos_pkey;
       public         humv    false    194    194            <           2606    16587    setores_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY setores
    ADD CONSTRAINT setores_pkey PRIMARY KEY (codigo);
 >   ALTER TABLE ONLY public.setores DROP CONSTRAINT setores_pkey;
       public         humv    false    197    197            :           2606    16599    uk_2bh34bhrnit8h5hpdjf3h0ykn 
   CONSTRAINT     �   ALTER TABLE ONLY questionarios_socioeconomicos_parentes
    ADD CONSTRAINT uk_2bh34bhrnit8h5hpdjf3h0ykn UNIQUE (parentes_idparente);
 m   ALTER TABLE ONLY public.questionarios_socioeconomicos_parentes DROP CONSTRAINT uk_2bh34bhrnit8h5hpdjf3h0ykn;
       public         humv    false    196    196            8           2606    16597    uk_7n4ho7aogrtgbom48d1h6mbee 
   CONSTRAINT     �   ALTER TABLE ONLY questionarios_socioeconomicos_documentos
    ADD CONSTRAINT uk_7n4ho7aogrtgbom48d1h6mbee UNIQUE (documentosentregues_iddocumento);
 o   ALTER TABLE ONLY public.questionarios_socioeconomicos_documentos DROP CONSTRAINT uk_7n4ho7aogrtgbom48d1h6mbee;
       public         humv    false    195    195            B           2606    16686    uk_mlol88tikxmrmxhp7vaop34qc 
   CONSTRAINT     �   ALTER TABLE ONLY questionarios_socioeconomicos_documentacao
    ADD CONSTRAINT uk_mlol88tikxmrmxhp7vaop34qc UNIQUE (documentosentregues_iddocumento);
 q   ALTER TABLE ONLY public.questionarios_socioeconomicos_documentacao DROP CONSTRAINT uk_mlol88tikxmrmxhp7vaop34qc;
       public         humv    false    201    201            >           2606    16595    usuarios_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (email);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public         humv    false    198    198            Q           2606    16660    fk_2bh34bhrnit8h5hpdjf3h0ykn    FK CONSTRAINT     �   ALTER TABLE ONLY questionarios_socioeconomicos_parentes
    ADD CONSTRAINT fk_2bh34bhrnit8h5hpdjf3h0ykn FOREIGN KEY (parentes_idparente) REFERENCES parentes(idparente);
 m   ALTER TABLE ONLY public.questionarios_socioeconomicos_parentes DROP CONSTRAINT fk_2bh34bhrnit8h5hpdjf3h0ykn;
       public       humv    false    196    190    2094            E           2606    16600    fk_2g8lhs614f3s60jqi832osskw    FK CONSTRAINT     u   ALTER TABLE ONLY animais
    ADD CONSTRAINT fk_2g8lhs614f3s60jqi832osskw FOREIGN KEY (dono_id) REFERENCES donos(id);
 N   ALTER TABLE ONLY public.animais DROP CONSTRAINT fk_2g8lhs614f3s60jqi832osskw;
       public       humv    false    182    187    2090            F           2606    16605    fk_3bny5nvkhnbsuym1pmrkkjf8j    FK CONSTRAINT     �   ALTER TABLE ONLY atendimentos
    ADD CONSTRAINT fk_3bny5nvkhnbsuym1pmrkkjf8j FOREIGN KEY (animal_rghumv) REFERENCES animais(rghumv);
 S   ALTER TABLE ONLY public.atendimentos DROP CONSTRAINT fk_3bny5nvkhnbsuym1pmrkkjf8j;
       public       humv    false    184    182    2080            I           2606    16620    fk_563repum7yydd8n7951dyqb39    FK CONSTRAINT     �   ALTER TABLE ONLY atendimentos
    ADD CONSTRAINT fk_563repum7yydd8n7951dyqb39 FOREIGN KEY (projeto_id) REFERENCES projetos(id);
 S   ALTER TABLE ONLY public.atendimentos DROP CONSTRAINT fk_563repum7yydd8n7951dyqb39;
       public       humv    false    184    192    2098            H           2606    16615    fk_58d4xa1etjp614iok5yguoasc    FK CONSTRAINT     �   ALTER TABLE ONLY atendimentos
    ADD CONSTRAINT fk_58d4xa1etjp614iok5yguoasc FOREIGN KEY (procedimento_codigo) REFERENCES procedimentos(codigo);
 S   ALTER TABLE ONLY public.atendimentos DROP CONSTRAINT fk_58d4xa1etjp614iok5yguoasc;
       public       humv    false    184    191    2096            O           2606    16650    fk_7n4ho7aogrtgbom48d1h6mbee    FK CONSTRAINT     �   ALTER TABLE ONLY questionarios_socioeconomicos_documentos
    ADD CONSTRAINT fk_7n4ho7aogrtgbom48d1h6mbee FOREIGN KEY (documentosentregues_iddocumento) REFERENCES documentos(iddocumento);
 o   ALTER TABLE ONLY public.questionarios_socioeconomicos_documentos DROP CONSTRAINT fk_7n4ho7aogrtgbom48d1h6mbee;
       public       humv    false    186    195    2088            N           2606    16645    fk_9m1rkr68faysvpoo79672bl2q    FK CONSTRAINT     �   ALTER TABLE ONLY questionarios_socioeconomicos
    ADD CONSTRAINT fk_9m1rkr68faysvpoo79672bl2q FOREIGN KEY (dono_id) REFERENCES donos(id);
 d   ALTER TABLE ONLY public.questionarios_socioeconomicos DROP CONSTRAINT fk_9m1rkr68faysvpoo79672bl2q;
       public       humv    false    2090    194    187            G           2606    16610    fk_iqjk9ac9wwutkbl18kt8upuy4    FK CONSTRAINT     �   ALTER TABLE ONLY atendimentos
    ADD CONSTRAINT fk_iqjk9ac9wwutkbl18kt8upuy4 FOREIGN KEY (medico_email) REFERENCES usuarios(email);
 S   ALTER TABLE ONLY public.atendimentos DROP CONSTRAINT fk_iqjk9ac9wwutkbl18kt8upuy4;
       public       humv    false    184    198    2110            R           2606    16665    fk_jbfjcmq68wh39lindy506iryf    FK CONSTRAINT     �   ALTER TABLE ONLY questionarios_socioeconomicos_parentes
    ADD CONSTRAINT fk_jbfjcmq68wh39lindy506iryf FOREIGN KEY (questionarios_socioeconomicos_id) REFERENCES questionarios_socioeconomicos(id);
 m   ALTER TABLE ONLY public.questionarios_socioeconomicos_parentes DROP CONSTRAINT fk_jbfjcmq68wh39lindy506iryf;
       public       humv    false    196    194    2102            J           2606    16625    fk_jm56nudk5fy7pqah02rda4k8b    FK CONSTRAINT     �   ALTER TABLE ONLY atendimentos_sociais
    ADD CONSTRAINT fk_jm56nudk5fy7pqah02rda4k8b FOREIGN KEY (animal_rghumv) REFERENCES animais(rghumv);
 [   ALTER TABLE ONLY public.atendimentos_sociais DROP CONSTRAINT fk_jm56nudk5fy7pqah02rda4k8b;
       public       humv    false    185    182    2080            M           2606    16640    fk_l8c3b6f2qcwrhnog50rert2o2    FK CONSTRAINT     �   ALTER TABLE ONLY procedimentos
    ADD CONSTRAINT fk_l8c3b6f2qcwrhnog50rert2o2 FOREIGN KEY (setor_codigo) REFERENCES setores(codigo);
 T   ALTER TABLE ONLY public.procedimentos DROP CONSTRAINT fk_l8c3b6f2qcwrhnog50rert2o2;
       public       humv    false    197    191    2108            S           2606    16687    fk_mlol88tikxmrmxhp7vaop34qc    FK CONSTRAINT     �   ALTER TABLE ONLY questionarios_socioeconomicos_documentacao
    ADD CONSTRAINT fk_mlol88tikxmrmxhp7vaop34qc FOREIGN KEY (documentosentregues_iddocumento) REFERENCES documentacao(iddocumento);
 q   ALTER TABLE ONLY public.questionarios_socioeconomicos_documentacao DROP CONSTRAINT fk_mlol88tikxmrmxhp7vaop34qc;
       public       humv    false    201    2112    200            L           2606    16635    fk_nii3pim3kcnjfi3e77e44tpbp    FK CONSTRAINT     �   ALTER TABLE ONLY parentes
    ADD CONSTRAINT fk_nii3pim3kcnjfi3e77e44tpbp FOREIGN KEY (questionario_id) REFERENCES questionarios_socioeconomicos(id);
 O   ALTER TABLE ONLY public.parentes DROP CONSTRAINT fk_nii3pim3kcnjfi3e77e44tpbp;
       public       humv    false    194    2102    190            P           2606    16655    fk_nvjxgpv9e5ugyp81t22vidoi2    FK CONSTRAINT     �   ALTER TABLE ONLY questionarios_socioeconomicos_documentos
    ADD CONSTRAINT fk_nvjxgpv9e5ugyp81t22vidoi2 FOREIGN KEY (questionarios_socioeconomicos_id) REFERENCES questionarios_socioeconomicos(id);
 o   ALTER TABLE ONLY public.questionarios_socioeconomicos_documentos DROP CONSTRAINT fk_nvjxgpv9e5ugyp81t22vidoi2;
       public       humv    false    195    194    2102            K           2606    16630    fk_wjc3tldelurr2t70q0iy2kuh    FK CONSTRAINT     �   ALTER TABLE ONLY documentos
    ADD CONSTRAINT fk_wjc3tldelurr2t70q0iy2kuh FOREIGN KEY (questionario_id) REFERENCES questionarios_socioeconomicos(id);
 P   ALTER TABLE ONLY public.documentos DROP CONSTRAINT fk_wjc3tldelurr2t70q0iy2kuh;
       public       humv    false    186    194    2102            �      x����r$G��y&��ݞCU�}���1�$�L&��	4���]q ��3� �]��c����-ҧ�S˞/��aj��f@�N��R������W5����WL���?q��w}����M��ɰ|���cyݷG�||���_~V��Mk���]�t�\|z��`1�r�u�ݬ�"� ?7�"�����ߥ��vX=t��	WG���a����v1,�W}�'la/�����_�Ѱ�]�629��m��s@:������հ�&�98�U�G�י�E�|j�~X>���l3,���@c��гvy}��	����Շ2kV#n��O�X�5H�Zn8�0��Fi�ĈxBEu�7w�����R�z\ ����X�J��w�ۙ$C��g������9\��5:�c;��ሩ�x��ȴ�+;i�0���0��_ם���0�<�hf�y�X�z��"7CQr�j�ݵ����Xo6��V�O���o��ݫf4�f�a��0�|}��Ӑ�a�Yt3�#��ߜvǹ�Rc���nc�j��IM���~賏�7�޵���~��:�0F��<�7���ez-���z�� ��pMb� >"��y*��[�w�;��K`��D�}�iU cm�r�����Im��[YE��O�1�o%�4O�0����uI�&�:��E�0`<�9E�s��.e��{����V"`��X�ZH<���*��_���W��V*�1��=���l&+y�9]�s�d??���f������=�}�����|W#�f���c�b��oG�f��9�8i��6�XJw<�t2�����[<��,f��56eq���E�;o^}�V�������Ϭڧ��m��o��;}�O�U��w���m�L~\�������������;�V������_��#�
����=���-�ժ�V#m3Y4x�?��_��7>������F�4��4��Dܘ�ƪC}���~Z���;R�sk��eE��Z��f�Q�0��=�8�E_�7�^g��~��Ǽ ���̼�9m3+u �f�U�@��\�́h�ݕ�D���f�m�A���1�W��6���h_���h_�q��`��f��V�i���7�������4^b��,S��"ڴm��}wm�]�f��A�b�'/���!!o	cU�=�w�vq��o������Yw��-��6[����[��bЇ~��rO���"<K���6��7�����:_�wfV"���6� �9��)g7��tOwïݲ�%o��oY�욇�֭���\��UȠ�v�C��d��0:U���-�U �V���c�'��x�?���5	9�ǲ�����k>kM��Q��X��E/�F��U�"��^[�`��c#�`�	��/�O�V�dX��#����uh���<v���)�j���L������~1�0�h&#�4y�)�$����ZP�t���xˡa��~�o��x��n�c
Q��Ξ���i"��o��"y�pvg�"'c���~eʌ�W!���2 g��.�e�5�v�'>�q��n�*�S�!7�x�!�ǲ/�T�l��:��8�V�>?�V�.oBS�5�7ev��,�\x����ݐF���:�ց�[|=��q2i�������qS�����%7�l��G�C'�0l���6[�k�~����8ت,d~��'���ۜ�;[/����ƹ�@��$�����;��~��.oۣ�����/v�3��!�� P��ơ���R�k���w�1����^�5�4��a��	��nȧ���v�4t�t-�1�01]��Ɂ�_�՗ǻ~s1n
����uƙI���ǃ����v�LҚ���?%��*D$�3���U;���{�y�Ð[��X�[��*�Mku�6_��a�{{5r؟�W���c:�������ƭ���F�a���ݲ]���3� �E!�x�ZQׇ�5��b$����P��Z����ȁ�,Lp7�jy��?�u7�t]�����_{	|�H��*��dX�C{��͌�YX�^�Dav�yEn���\��t�O�o�W���c�%{�pQ<�2�����5Ta���om"��G��

9	��,���d��������7�ņ��[
��KN.8hi�9^��p!A�C.����RuG�xg��o� :}��'��z�o��E�K�-"q!S��H�*���+�.E�������k�|�������񻿰fi"tqA�1�=�J���������x� wcn����O+�����9J� E�(�P�%��vf��^˵�.��7��F�]��N�̭�aZZ�U���n�L���J��-�#���{��)A��HrK�A�;�N�s�bJ��σ��������-����i�&J�l�A�37ɧ>�ӭ�FG���P'��2m�W���9	�c����~�~����߀���G�r���#�g�zQ5��
9���[d�subU}`�;T�YU����Ux�H�Nt��_l�Jv�`>c�%!*��$�E:�#3�=��4�31���H��O�8r�0�vޯ��u�Z3��:������g�SM���}����DuQ8,�H�Ox���Ep����nq��}��_/oF������,p�܂e�g�����}�yAe�ї8 ����7��.�ڇ!bx��,w.cŹ�H{v��9�	�O�����)��eW�yC=g2��\NӒ�W��/�ݲ����5�9�]^_���c"�AJ�EQ'�z����z��*?@7!	F>hY:�%C-ٽ`��������Ix8A�ʤ�GF�yXu������iX����yS�岪���ϾӪw�.�ڛd�|G��0{�y�ֱ��"���nV%u�.��-���떃0�с����lռ�[��(����0󾁽F����;~��n�-v	mK4%�!�4<=�[�/�d��y�#׸�yHn6���P���r�tylKn�!�.�=D'\:��l7���S�Mb�Qߎ�S��nF��M�5�6�@��/X�\	�+���aX,�^�
�x�H�_�vZ�rx�H�.5���P���a��2b{�� �x��3#W����>���W�kd�a��}�#p]k
s��=��]��RLD9L[��T���Xd�a��C��3����p��].ۻ,���g��/��oG��+���l�a�<I��r�;����+6h~���d!k���vr�c�+�㍢0�J����M>X���y2wew�1��ܦ��-��(��H���� W���P��w�������L�ߺ[���p��w�ج�r��7������ظ�#V�ޯʦcW��UC�2ݗ�O��ٸ�/"9/V�e�7�sŐ}��[��c����k��FW��>��\�ל�F)�W˻��!�C�g}j1@&�,\#��/.BuY|˫�sƮ����b�¼9��U��2I�+��Zo�e�	;@SQ���v�?�l�]�7,~N�%���������i�u�+�`k����E���̞��)��B����Ib����.�����+a�&�v�\6��ղ�R�D�F��sl���s��K�(���O^^��@֩�+�+\U7�B]������rW#*l���z�~�Kݜ���Xۯ�ۉ,�Sc:�W�AM��BD��>ԁW��GfB��v��E�5.5}���t\+,p�˫)�y����M2
s��'����a�3Q���CY��ۅ�h�9�0��zZ��䯧14�����]�u�U4��YZ��LL�>�#��"@0IQ�����l�a���O>z?N�aq��oKi~"d�����ǧ��)}v�Q��w�-�]F�ht�3Ԉ>��.kN�1>���fz4ϭ��v7$���%G�i�� ���0=�|�\�GW�b��M}��[p���.;u���6l\rS�n���{7���cx�M�i�kr�d��c����n5�Y�/뤰���T���7�=��Ӻ]=��z���N��D�BT/l#3��%�\��t��`�C�|�)nO"8E)k�ɝZTA���>�09�V.#ɠ嶤8gm7n�v]y�y��˙	5%�IA��8�űfy�)}.�����H�iq    ������QMQ.��/�3���QC�.���l��)O���8�ߒ����N�&�
*:߯�}*�w2\��`�s��z�<B���ő!�B���Rg�x]Qcw�dG��8��x��@�i@����ط)�8���h����^6,*���='�T��Ƽd�)����[��6��ʱ_�uH!�W�M�(�k9QW���ʞ~k�Y������s��Q������o�����x�~��P8ō��s�^�
�QNhcA2M����^n��?��v2K��tS��q��N�s�ŢOLe���ƚ��?sD�㵢���8��p��&�&����=NB%jd��@�K4UD���Kחis݁Ϣ�����hS8��·N��G�����Ȣ�����U����97j$E)m��t;�TӤ���i�D�lA�t�vM����I~D���|wUp���X�q.í�*�α��	t,�P���v�]��UQ��%� g݊Q����1�l��u����&�(F(AQ�t
0���o��q��8Qخ��4��
ĝ�I��������c~8 R�S{�%��q��t�)�� ���F�d(қ��`w��!9_�Uzu�@'B�dvp����Ovn���/ۧ���4;BK�x��vQ�q������)�GuQ^a��B��m2���Jk���`�p��M�>v�R�?�����s�ىb�a�U�G���S�;_���IcD��fUX���-�SɈ q��A9�cB��jN&#�̵CMs\�� A��:�	R�Ѩ>t��9��R�#%�9v�C�q� c�8s*����������H��ĪG�pa>��md���X֩A�Ǟ�p��v<N�R�}�'"޼xە�0(+I�*)���8HM�x�^9���}���
���|�zj��˼s�)�߭��v��_Y,��7`��S����n���
v֮��������7�=k�ӯ�`����	�8syp��K�SL$�$��n���X���:�W�$��޷)	��+wa!�)ʻ�`�sz+ɰ����tɗ�;�)
�O�޺L*c�+S'����᩿۫n�	�$�V���kr�z�+
�����EJ��/�nKrтj��aQ����"��^���c�L�U(YTp�+�&Q�����[nvCNP&9��P�Z_�CVN?!ya
�TlN\Q��a��?Rs�tc�I��P)���Pc�jӫ���f3@7���~c�����U���+(2v2N�A����oJ3;N�&��Xo�Y"?"gBF��P�x�ѝ1�8�55����s���KN�"���%�;��:�FJղ�өA-�P���}Rٻ��U�za�k����E�yf��!���p�R��������IA���x��4���>� �L�NIj)uDy��I�&���TbS����)T-�@��[��l<ؗ�n�#T�z��;�,�lBjT�,'����v�*YWԨ��:��cr�E��=�Vy׭R������$�10�d���#���/ŁH�9���F����*y�C|Z��<���8�8^�~ɺ�(��Ǹ)�F~���[/R���]�nҨ5���bf�kjL煆�tZ�6�KZ��1�5U��OrCVy�4����N�
�g�6�P��e]V�焳%H�C�ɧS&��0k�Sr����Vw̣��ylءH"W�8��S}�[wx[$T��|3e0�����{��k��'y�MaJo���Ɛ���dR!3QaA��S�Z�@�������@�ŻNdkA:d��נ�r���귒��	䤎?C̺�K��&�b�G&�O������<�Ez�2�t��,�!&7s�N|&uMQޏ+�S�����n��~������/I}��;��E)���[r4�:��2~1��
s�N*li��}�x=\�'E��A�/�d:�9��+� �QޮSu�~,�u�T�HA	�UW��� Y��c��N�d֏�y`��Ô�q6�U���đ�R�R�r��v�>�������g8�2�b�֩���8�2؂��睬���7���ů���4eu�"L��'0�z�-�S�hM6�	�!�-�+l�*��V���}%��$[���{��C]u����7 ��ԧv>_)����^0sBb�QƎ??M9�Y]!�?�Xue�uJ�M�T�"'	;z\���NMmQ�BwI	�Nr~�P5C����Y�U��W���B�_�j��W_�ʾ
�G�ɥ�_�(�.�U(X� I��K2#R�C�t�(�?�b�	��|1�+����U�j��� ������Hv'P�(�_��] O��v$��>�v��;�a�!n#$X	�Ջ�؉~k�)����s�?�x� GS�O�8آ�TF2��%���r�=��&�����~Hn�%�5�������v"�Z(jP�w��FOq�-��9(���������	��}5\�ʷu�G�H���d�կX
Cԍ?�,/��;%p�9��?�[��?�{�0�Q��C���[ގ�!��W�S�ƣ�J��g�4[t�ۂЭ��$ى��$�4���/�"��(lẛ:��XH��D��Z
�!y��4�8�t]W��߹+� F����'�@/�rt�B��l�1t���S���ە
Y��7���O��ۚ�:�b���M�غ�#�iB4���y�+<��(��ɮI�]�I�e8�ZS��y���oG��L�?:��n6��,
�9�u=ek;s���Y��"
����7�ɢB�M 2���!�~��,���P���]����z�;�y�S=��	�����:{����4�S�У�8]6�����(�}SvС:R\秗��o�nH���ͪO�\�Hֈt�3���%w�Y{p*�z�nq��dx~�N��(���o���Q��:���Y���
x,���g%�\�g@�4M^��DD��{����\�B2�#���/K�d��� GN���wN�Z+�/��Jvl�|����
;J�wQ.�`�)̱}[����87(��2�n�q]Qñ�����5v���f�ZU�ԜE9�r�y�z�i����5���(�՜D�֒�\���dϛ�����l�k�S �1n���)�<>�sA�"��y?0�p[wx����@�M�!A���n8�g*wf�w�;δ�H�e�zjW�]-w��j�͔M�o�\�`P�l�j��a#)�ǮO�:�La撹��3M�ξ�p60���][Wc�l��8��`�:]��mQ��d����舆nB�^�q��++����9*���-�~9WX�mSUgv��
Cd����RXD��[�����`�Cq
u֏�� �@b�5�&Z��0�֞AҠ�j���z�p����~,f���A��8�S��g��~��;Z��H��y�%K�\2ޚ��,^�A���Ǒ�k�S��_���TSa��@%Q�3�o����m�۽�N��E)��Y�S&7���v1��F9�q�݇}��f+"F
<��(����-;�kXM!ϬG$�^��]�bcn�a�O���tSS䈺���v��,PM��-y���]E�� ���|?����(��P����>�N����2ѣ��ܖ�T߮����$��<�aa�s.關<uL�,W�iIت�e��X��/(�5o(�&�Y��l�3m�M;��o����gܡ�D�
Oឈ������.ۧu{���H�!=�9ʸ&�-xkpN'*�r9�;N����e���jxܱ��;!'�m�8S����hw$�|��[��]9�o#:�7���p�H̄Cƀߵ�����t�jU-���>�4�d��]Ld��D����>GD�}'n������6�}��Hh�x<�����4ȍ����Yt[�,7O�*b���ϩ߅J1�j���ai�{[[��;��?��k)"�l����I��Cr�-eD�;5����dG�sm�>�%_�i�h��j�ػPA�!��k~�]u��)
���KC7R�OZttrr�Fb�ߧ�Ɂ�bЦ�"М�����=75�0iu��Cs���\�#��]�9�Z��#(̇.�Si�3�ZR��~��sߺ�P��1?�u� a]����rm9ϭJV���r�[k����h�    1[�D7�A�:d�c����&L�b���+�v�9��ڴ ����y5�4�XnJB��Yx#"��ʵ�!��I��Ҟ�3YoW��T�5MMQ/�׫dt} �8��&<�����y��D ~�Y}�]<�@�i4Źl���;َ��\�11�9�H煪"��>�hN�(d���?�2��gs2�F!c���4�HqާDD	D����0�*JRC�L*c�x�S�5��Fc��\���q��I������I!�F!�vuU`� i��@'�s�_͹�2�{z��q|]��tE�.�¸x�8,���|�:iW����`�R�0������y
���`'%k��(sFf�ͅ��p����ؾsʨO<����#Lx�JťÀx�n(����z%����ՊB��n���%Dl���5s�����ۼ�&��T�������SQ���9Y9��x�1��&]��튾���f-�)�>
��'��n�i�+�S�5�A�(�>��I��kLq���pU0g\FQ�P�>
�hܔe4���>�U0{��S�5�P���>��C����s�	�י �.S�0�� �@��X��f8	:U����st�`Z��_�pq���j�4��x�$|�B���>��)��-���";硶��ȔںV��"r�!u{Zu/�ӥ�>��T�jJ�8q��*9{9m�bU	��K���e�\�9}�b���"�x��Y�a//#���0�dZ�	
w�-�	��?�RK1I���w�Oj���l)V��\��|�5�c���ќ��m{�y��1"��`� l��_�=>�s9^Q��|��#�9G�w��c9��<!yO��"����#��G���������q��m��큣�ͩ?�(�Pcz7�։�?M���"P���]^��F��R��1}h��G?���O�7X��"���v�Џ=�'58���8,4>�����)e�0]_�h�E���\c�	�]��
J���r��J%*S<Ζp[
�7^#J T8���1�����ġ���CV���<X��0��,p=,IG��c�M��[9��
�s���t�9�W�d��ʒn�-+!���*̀JW~W�t�Ϸ�/L�J,�J��8�LX��0����M��*%�I�o���2��K8'�5E����h+��:TX$2�0���v�Z*��������_��(���mjg='ZϾal�P��ƈ��;}�������#�M5r��}�������ǬyD	5�Q,���r�y����GY�:KUKr@�Ñk�a!�ޱء�\0Z�����jSţ��:kX6���4�ʪ�_�j"�<��@a4�8ME��O���a䐆���ң��9�����H�8p"	��n�%
���������f��}����\v�XP���XNCqޯ��	)ν����:��+����CV%�D���?ط�?��rJ��b��2�rJaWs�k��]�d�?�/�i�w2���Du䚰X��8��np���t�%�b�89���kc)���Ԝ�.%J!���#L�2�U=*]�7]�@�-L�6ÿ;�)
_>�b�HPx1E&(�x�D��^���|z�_���Mٺ�8{�x{�s�3�C<�����^Z]qܵ����k]dA����.׻�[e*
�q�Tpfu��,�Q���U����L��`8�:�ʧ#(ʇ�����b�g1L�Cr����	U�/�O���JԸ^O��P��*��>����S~)�(�X��
��l��ɲ������a��-���𰳀�>�;��2&�驤��uMA�������q��eI,"�V��O�~����qjX����ξ��ѧ�涻��T��$w9�[v�u�Q]a��He�M'�UMa.����t�9�q���o%w���G:��H/��hW�h�´��ð+��4��D�ɾJ�y�� �*
t�/~�X`�Np�����:[���UY
�Ft\�9q�f���e���A�X���ۮq#��&1�� ����0a�a���]� 	��}:�8���eX�+0����$g:̞n��2;w�S�Q�S��ϖ����a*��Z�����[fQ1en���q�vW�(XI|��t�C����<	n&Q�,K�	N٩96���>��͙���)J6v3��\U�IԈUp���8����l.�)�ƻ�X�)��6��o�8�����|2����|X'�Z��K.i���.�cr~&�U�����J��Z����v�pB�WG�@T�U�CG]-jP�*��Eqe#���d���6�G��;����%�N�NE�eEa~j��q�F2���GG��I�#^ \��h�}�x�~�p��&�����'I��n61whq��,	tX�a7�O��{�T�d�Z6�kW�Q�B}�lr���NR���X_Z���i���fMi"��.�Y��tt3]��T���kd���^����8:7׌��3ݐ���&h��*�����5���)�3�V7c<�_G��im��9;Q��%E.,�u��,�������)�56������޴�>��3G�u����瞪�
�|jS}*�*T�U��P�W��_�J9��_ŷ���[��0�ɶ��NB�UE/���^�¤���_f�pG�[��(��ZSօ}Ĺ�^a�	�k��|���k�]m�V%�5��ת�8Y���'NCqʫ]3K�RkJf���sN����ԐJ�!�N��d(RY�n��h�{��-�&�Ռ�
Sٵ;�(Ұy"'�bb0����R�I�+�&��X{~�R�r����e{4Wz�uC������6��r �SԂ�h���)(�����pTޞ�� ��\i�ֆ��o��O�u{U�Ӧ�X�����RXDyq��5@�D~�U6��@I�$Y3�)IѦ>Л�i"b��l�T���Z��h��pke0�0;��1~}�¾���."=L;
�(A����s�\�Ym�k�kY�b%&���PA`��&)ʛe>�!u�{Q�W��ܴ8ٍ��
ЄQ�_ڼ\��!�Mq
k<\b2�C[�5�5�ְ������-=���u �4F�Jr���p�r9����peB�	�M$�F�pq��64�q]/@5Dޑ{_�t�&�Z�����T���)
�[>��l��8.xNl��z��'tm�-���k���|'ry��5����ڻ�U9���vgu�G��p�� �|j�	a�Rق�n�m�y�t�-CF�l�]Se˪����_S��L�Y��
�~�Z_u���k�lI
����k��o�K�ξaI#Ph���cפ�b��9y�'l��߄�\L9���"��T�J6���V�޺�U��u��TNQ�SMY�B���r�����B����KYzx0-�`�5���:�Wz\�U`ܢ��rZ �rͫ-6k^���OBG�y���nڝ�-$�����"F�~����*��E��\�nKdq�.2�[wN"v�_�!HDS��$bǕq���q�0{���"�r1\�Ր�P50SIE������^.�U\����QO�eZ���}\�t�3/-=�Ϯ���ȬQw�6Yh�^����h�.w{)W�djd��>�h�s%M�F��\�2ͮ7�刈�����Ʈ���~#Rj�wS���	�#�U��!{GB���\wvQ[�}�e�p��4e�	\�ZA؅��J�T&m1�t��߹皾k�,�B����v�4&fըH��c�+�=�}&]�x��'P�[ȹ��"%T�E�]�xˑ�Lz�}y���0��ƽ�4���OG2'51a>U�M�7̫��G�����c��+W!�U���n�9L��;�>��-9w>rm�-�P���<D9oV���,�wM�-�QkysreF�2�Uҍ�a0�n�(d�+�S�������$I��Q2x+Wu��`�$d��Ӌj6gWj�8��R[��:�a�������c6��:�[2�0d|2<>�̾gS RW�|(�D�B�YD�s�����Q�JD}]Q��<���@�Djtfo��pÌ��'O���o��hM��������R牦S�a�1-��� �ؗfb?i;
�34�Aa��U~�wUQ�����V���Sw߄a@7    �\s�q�+l~/�âh�������iA�nO4��P?��74��q���
Y_�%Y8WVe2�_Z�g�L`���O�%�˅=Yf;1�ǧ�t��̲$F��RC�4�b8�y�.Ʀ�yR$�H�&���j ##�߲��l �%,��F���>���-Go�؛�@�m�MĜ�=����m�-JE�)�v�^�Ć�Zqwy�,�X�+�V0cZ���aw������|�޿$��n�ag��:x[`�S����Ao
�Be6���h�82�����w������w��TF`M�ư3Q>���w��Hl"��o�쌵����,d�,�J��Ckב<	&R�#R0o�j��̢�P�O�dW޸嗢��92w��[��������ǻ1�C_I��.��`��F��.X�88��|�.I��S%���e�	���ȡ��p��C�C�8��-��R���~�iL>��b����~R����PE{�IT�{J�d7��̦V�]�3=��4��ID`�P�ð��ŭ��iE
|r�����W��NH�UVd>��T�q�k��[��&�C@�! ��Q��UA�@�d*�)��x��V���� �+Y�������c`6����W�$l��A�ܥڧ���R$E9��_���(oYؐ��w�%-���I#��@{,�S�T��z���l�>Wj���� �m`�����+��2��jd�<l����2�401�,"���T�-�p` 5�(o�Q��_z����%oxཱུ�xg�z׋ߒ�O��z��D��E����[{p�`�
!���5�jd��aOQ�:�x,KG��##\�F��ͭ
���k�,��HP�$�i�Fq�VpwA�����o�}��1b�o[ζ]v� �j����.Vr�M�����7�K�FLMCq���#�T�ᮛQ�΃�A&:/����<�nW��p�J�$�j�p��l���N�b��`�rYp]��Ljİ蹦��ݽ��c�[�F��R���]-52���h�A�)d���V��i�	�&^���u:v�K��&M�L��Ȇ�bjD*jl�>f]M$�I)?���2��>I[����,*̼|]z����]5b���~|̩��.&]Mt|Ar��^5r�'ȋv�������j��ƅ3��}$\�u_c�G���c63�.�9��T�o��H���"V��U�>��uk��f��=��+ �Қ�����`��z5��;��|���]�L��,^�'����]~5�_��)�,�ۯF�P��`��F���z�����H���w�[�A�Ƭ��I�I|dȿ��;�<�9�d�aF�ݡ5R�Ԭ����D8�p2��1�J�ȘS�M���o�VY�|"����/=Ttu��Xǫ��P�#�]�5�8;�5�������k�|?Jw׈��:��ʿ������X��!<a����OAV)
����!:w����U>{�#k�2&R	�&Nh�C捊��֋��)�1F�N�'����|���#�,j-�Cܐ1d�|OɄ��=c�.��.�����X�W�s��ɉa���#��bLQ�M�"5�O�|	��+��ϝޒ!9մ�b6��ؾ�UZ�Si(xEe�mq^YS�n{ќb���]�6b�aG8�a���h<��]�7�qf�ʞ�^�i�7��;b�`�\Q�4tS�±c�l��f����RZ����0QQ��>�VYA �	��m��w�L �@-�۫t�yF�aF
��Buޅ����0�yZ�����~�U)�o����I�~IX�=�S�����yCqF��ч�=z��5yS��n�t��n�Lki���`��n�i�ֿt�|���U����VL_ H����G���o=Aˤ�j��]G��pd�F����1_z�@"̤�H'}Q��k8��~�g�qH����{^P4��cV���k3N?,N'��_�?Es�o�O�X�k���?��Ym��y��$ر�{�!ٱk��پE򘬉]l&��_�o�`��ľ�/``o�G���
����E�5�c�A}(9S�򝩊�ɢ$}u��C�瘣�Q%5��F�4�X=��o�+:N�D�;DP�)d��4c��ʓ�t=�|�$
��L5Ԉ>����R&���R����u�z�n���~��3Ra�P��y7�_^yr�߭[��7�.���xQQ�U���N[�Àyá�T/�H��@K�4�������M\$��Ƽ�iA����(ә���
x�
,�k
s֧;��)\?�|S�&*�&M��1(
U�mVڿqMqN�/�l���6��[��c�p�W�}b��)U�����sr��#|�`�W���5lf8���/H�J�afe�k�]Y|�
ؖ�Ԑ~�Cʥ[���lj��^�@��6�0�.��1�p����N��	ҳ����x^͋ػnu�N���vtm������W}��\���WU44T;^r{��s=���8�XZ�|�p<��I�Ө5��Uwӭ�j�y��3���o���pf��\���3��ɇ9͋�s>�@�̫���7i�'�JQ�����3����~Cc@�-���3�݆��%�k2eΰ��f7CⒿ�(aX�n֓�o4(�9c�+�v� J��h+��2����$a%�7k�sV��EWv�G�5-�����V�w��XM~�#��0l�a�朖1��5�93o4��'u	�U�;qݘ�a�9�FTxӐ�S����AL�96v��\${�=���������׋�4��|0.)���LO�A�yM�Қ��>Fj`�
��Z��� �(��I��.��Pe�c4�9Ǧ
S���oG�]a7�7DpNQQ���C_��ӠY�Q��D���\p
�@�9c`��9誰jo׿�L�"��(�ĘuiM4��9u�A��(�i&���;�F� ��a�Sާ�mfM(�Y�Ƭ=���0�I��>ާD��%�$�}1(�����i�h�0ߋQ?���X�[p��a��λ���5����m2^�w����z�]�r�Z6�=��7�5Ez�>mz���7�E�vI�WX�js�(X��08>iPks����>��k��P�\1D���w�F���f����"�@��K��z��E��@v���� ��x��C^s56��%H�^�K�t^�C�-��D�Lp �����P0�"C�!�Y�V���E�a0i�������/ۻ�IT�6o�6V>�ě�֙=&��P�;AA�F����!U�K��c�袿O�KB�{o����7vq�&=5��y#�a������ak�)��4"5R�?eDR�{*=aF�t�h
v�nO�u�]����f-r������&�\�Oc(�3�&�(�&�7x?4q��~Z�����K�5H��Ԁ�K�4h������O�FjA t�\�j�R&mq7W������ԉ��Eє&�w3EG������h�ʿm�V:KW�W��
N
KP��#
�(�pxg��Lm�����z���7o���h�ƿ�9}��� ��:6���]4� ��:��y���(�-���kl�� 
h��[�,���\��3�6�r��f�5�ݹ�(��j(x,�.��P��|:ˁ���BN4�vi�1��T:�{3ERVXҡA���k�cJN���禡P�݇#��$�w�� I17���oK�)ڇS��H����ԍ:`Q�P����� �bQUnJ�&c���{\uO����-� ����l�Bf�8h��S��L�`x�
8"�)����"��\\�>��
�{�-/�yQ�nOTMD
�R�YU�ݞ�5���i�X��HO��L�>����}��$SBA�
�&�U[,��HU���j�	��di�Zc��c~��6"��6cYaDD{�	
���l8�c
��LR���\Zb|Hp°^w��~:����/�O
?�Ȱ�;!��gvx"L���,�u�nO1�S�u��yH7C���5h�D�VŬ���=C~�X�ϷQ"v���}2    � 4h�D�_�C+�&K��M��U� ���Ϋ ���F�{�`�����+�4��D�MŬ�ǲ�P5�z3�4
��M�KŠ�þ���?�R���=X�J�5��������~���E�|MpC��Nmu?$#��8�E;k��E�K	��"Ȩ@r[{�X�&&}�Xh���BP���MI�	b8!���5w��=*,iР<��h%�b:8!
S<�A0N���WUP�	��>��'}�+� a^s�e@�&da�$�o�S���?�	ɨ%���	ՀNHN�F�C��?P�	)"֞}��?��@߷y�ᚐ�����}Z7��ݚ�MĚN]?w�`��a��!�w%����ד�b�F��r
�(TpB
���M��f���7"᢮(�q��=�R��Q���(u�F��P[ǧ6��%�H�D-(�i�:]���a��e�{���$v��#��J?�C�㘨��LQ��r(ؙP��{A�I�n�FyL��8��b��R��QF����`%�\$~�a&�F�h�D�iVj�Z:�`�����G���x����J������N��։�հyTp󦦰'��}b�9K^�g�ؿ
�i(j&�0��j@�'�� �u��Z�z��Ԩ�d��� �?$��p�[�̀bO����^k@�'�(��.���T{Bq�ٺ��:���VfBav�on�������s���5�c��n����]�k��R5����]�Rk
!�W���!��!S��+\��A�C �7���P3�L2#o'��L��fl=��	Eu/��bʴ:P��-PN�)ߺ{�\+!@{�`��n�!��?�]�s�����zJ�n��C�y�]�z���##<I!R0[��ǴvI�I��2�[�O��&O��zJ�nQΆ�SA��x;�2�[����䷜� 3�!X����~ۆ��m�_ʜ�V��׈�D�
��~gm$5���l>#��Q�:"��34�9
�P��>ο��i?a���W�&s�sxȀhOM�ޭ&A�H
c(L��ԍ���X��	�/+d���Ԟ��eApvٲ�j���%�GD�p�RrɈ�d��$E�x
j���2�P�z��ǢO�M���M
�F!�%+E�RY3�������v�����D�y^x�nw���"h@r)YE>WA��@TH2Fa6�.��;݅0I�)�x\)��6 ��LD���ɺ���cS��PP]J�M\���D���*Wn4��c9�d�`�|�D2E�+�t&wP�J�)V.+8mj��&B��b��\o��*B��=)��/�|�c���ߍ�{1�8���y&�$4&�ʙ�/4}�K�u�-�E���>ɱ���t��g϶��ʛ5�א��:���aj�W���눳W�d�<���;��Ni>���O����mS]p����	l��]����Џ�9�&RA)8�:n���T�P	J!"V�W�R*J��3`RHj����PJQS�q7�,��J��|���?�ҋ�[�ĂR(j`?u�\*lLBS���_M�-�P��a���{����o�.
��^P����"۫�MQ���t�4�����D���Yz4�)#�lK�]���P~:�u|��vǳ�AC������~&+��)U��d7��R���[�{QSʺ�Xoҡ��K@C)k����E���Q�#�2�h�U��$T���������VK
u�~J�%{�o5��&�f�]�l@�)�&B��ڂ�^��W%��:�;Gx��؞���a%pק��R����]eéa����.:ᇆ�#���?���~�����xXG��Z_E뇈ݥTN��AMCQ�iU"9�lE�ХZ���H�FS�K�.���	�����=E�{�6 �*���a�S�����Z���BT*N�gg>$�v��6 ��J XZz�V�O���J%)�=kt�NP�JUG�=Ý��R5Ԉ�W�]'��Φ�y?d�}f
i�c�;[�o@['�lױ�|�<l����ج����@g+5�hw��&պ���Ms����1�oZla|$��z�x�ǭr�G�򰸚|]E�3���y��9��9�g@N,��`��c�O�%�S���qg�oG��_�.��b�7��M5�ټ&�'Wnemgm_w�'\�-�����>�@.-�h����<�=z7,G'������[�nA~��S�h́���L����O�����'�Cm(�]�?��r�Gr�0}��m\ڵ�[�m�����1`�5:B�����ُa9�5�Kk�I_���ۺB�@�\:>��-J�Q��u���-N�S������ #�g�AW ��+Ia>��%��ZXM��vɻ������i#�7wBd����JE��N�e{]���tD�*��q�L���%���IU�ۮ[��+ȏkVQ��.�+��=;�P�T؜a���8�-�P��Ђ�LD� \�ߘ٧�/
{@p���
80M0l��N��p_R'�k��"ā����R��S�`��E05���"_����"����T."�Q�0ּ�p;sB;����5g$�J^�M� 7�9��/�Z"��?��w�wo�@�]s�ʣ_�u55�tz���Ñ��"?��Sbi��\Q���倇sMqƾ��]4-��
W��r��DE>^w�j�����r��hA���}�.^����i��o�����n�k����S�(�?��ʶ>��Q�B�s�nz8AA��5Ey��u���c��h(�e��%��В����H�N8~n��BM�N��ߺ��,���ׅ�_�����O���������e��X���l7�~/�Wd�����G-U�	仵�ɮ�C�5'�)ػ��%?*P�ֲ�@�v!.<���D*���E�k�qԭ��m�������;JX�])��tTP�e���uE꟞�g2��2З�aBX�����͕tx����ì0���2��E��Ya���*ũZϲ�´�@����-
| L���^��j��aX�`����ZgV՞e(V&�:(L�0�kX\6�A�T7��i��`�h����g��BA�Z7��w�,<oD�~L��o��ox�����RSla���Cl�nŹ�
�~�4��M�~��fp-�[��8v�-�_͢�*��Մ�dw>?[L#�E�9��=u�Q��Y�e��F��er"��+A�ތ�Y�\A�Z+���yy��.@*Z��b}��m6z>MG��8�z�d��;J�4�n��֮Y]c��,��n��֚��5rN]'妔m��S�<J*c��`��5E*��4 5hsHη|�Z+���F�e{�N��A�-;,iuVy��&����v�6��QUK��r��˧�w�걛k�k�""�H���)����ĺ4ߓ�*�G%��l������j��$��F�k�]Z�ŠA�]���{�#wS,:�4�6�+��B�H�ڋv�FS�\�>o.�p���H�P�0C��*���u��t��Հ�>60씛�w ��%6@�1����®Vz�%s�ѳz��p�ǭ{7��\G�8}X0}�෩�����G��|OgV�L���/�`.��ͭX��8?�>����E �A����Nd��D�aچU��Neɖ��9�C^�*�e�y��{�ņ
��xD�˭���mX���G}[ޚ�oMF��և��-�s�T�a�꣛4K#u��mX��~��3��gn��S$����9gGo=��`U��9���c���	��W	����`KGՄ)-�nC����\޻*+Q����ߺ���̤\R��J�y��5�p����,d�b��/>�E���"RP�ܯv�������@�݄yc��홫d��h��y�j�t�_$p޸*UN�0���^�OR!�}�f�3%��镅6�����a�;�o�����,���(ȞMmP�0�Yb�T���3�-%�˛0Y,Q$���Ֆl80O	M,}�q�c �uf�1����>u��{]$�M�"Ƥ�2�>"�s&�%��/���M�ưc.�����7���;:wcN��@4�HAq/�T�r$b n$��ѱ    l�` nd�����1����i�������^Ʋ�m���4E�r>N�&��ir|W�������W�y���[�"��C*��=�~S�p�����o���l�k��9E�R�\M��H��ޗ%�&���ZR����2$�M]G�i���-HI0��{CklOs➹&�{�(f:�6�����,��_�E^ʭ&�2Ԁ��,�ZX�6� ��Z���������7,��|5�qh���S�Vv~�o��~�F�(��{1�<!�Q#)���I-=�@�����cM�z��5��Z�������f�ݏ�����v�i	MMh�N��f�i4Ee<Gy��fX��v�����Ω���*��c<���]Ho���_�Sq
eW��Y$����t������7��Б�k-��}�������KF	��j
s^,/f nTC�.���^���˔R�Ⱥ�����3(��#
��.�e�A�_��e�s��E#?{��r�(pM�(T�eg8,�%�#�����'K�|q�<A�i�|;pH-��]'�ם@����ty�گ��	(]�P����sB	:>��5Z�[�fCɛQ�;kMB;�Iޑ�UnɄ!2{TM�R�0�^c���f/e�,�%�`����O�K>�f�>}�w�FR��v�~ɟ�7�|�`W	oĸ+�fbA~T�L�G��b�mgq07E����V>b�&�)�Y�'������`y�e�ӳ�	FUի�m��Gn���H����#��(~3B,���'*��?U	�S�p��*�I
V��pWU��{(������/���~�� �U�C�"#��$�ΰx�/�� 1M��^9�o��y��OS�aTކ�t˹�b���n��5�(��<��ݗ�)�E5�((b2�����ULR�����Q�����M�R�v:c��,i�@ϫ����\ ����vY�~i �Ua�ƺ���=ǚ��I@ѫ��1Fe�UT�*� �Q�#W���a��]S���i:�<UP@8C��-�ރ�#Nq��=��LD���&=�.Р�0g�uV�e �S��H��U~� p�0u\�TR�|ܵ��0 �R\E���J6l��T\G��*������d
�4�ぉ@T���V$��Y�|�����S�ˢ,�� !(Ni�f�@m��|�5M��Da���
�7��+P��Ê�\��	����b�\Pf �T�D��u9���E���)K2��%�=J���X�o��$��MnşE��ǌ�u�]��G�4.N��+��s\&h�W�����;�־s���.Q*��a���cޣ��VIM�ƒ�܌��qQ�D���V�߿����t��?��)jF=kى���5�8���4W�z\��4��Es:,W5��pۺ*��@t����%mN�1��X�M�
.�������K�U�(����ݎMy4�����ہ�ӞI��/e��W�5�;랶^>L�ME�*���r� bV#s���l���(*;��$Z5"������]ߎů������yv�0~v\����K7�f���b�5K��\�Q*��L7��U���4�G�p�ޮ�E�߲D߽E5��Ó�XL�MN��hd�ݰ'C���y9,v$��G)�A��uP(�A��hP(���֞����0���f�V5���+�pL��So����f�����y�_�����Qp��~d��|l�L]��� W��z¢�ʏg�0���V��xP�+�)�>ui��T�M����,��:������x5���n�����J7�+j��@M�4��f釿��7
��[iM�>�t�c�6Cq��QY�|0���B�ԭ��>��ak|��!g�Hg��~3�A&ΑL>Q���of(#)�X�Z����3�V���;E�(�7�T��8���]�wm^���m�,L�q��+��q�7�0� ��s��jWb���
~�.��pP��E�0G�](H�늿hH�H!���`'�/���,��\W�B]tW��S�7�CV�!��+�b�[�y�̄C�����>+#˂�8*�]��rW/olCIS#:��3�J�}��2���,�9�XE���K��c�����i����e��ˡXB3N���:�Ӗ�C��f��e}R�r���9�@����q/��8Ar�P���yYڌ�ʆ���8�ȍ����EP��i�{��t�/�%4NЊ����*��@�u
t6
I8�Jh����++c���a���/Q:��� -#�j	�k#�=��	�9��t��mp��)�	����t��m���d�3kQ���Vo��Ѝ�Ҳ����Üm�a���;&l�k���w�M������P�n�P��ô-}jӃ��X'X��m�U?�U�������m	�敱(M��[�SϘ�&��,vZ`�o�3C\йs2����/���ӿ�zk��1Z?Ae��2�u�*��G��%+%*Zh�u<,��l�|��P�a�9%���,�h��!�����T�dݏQ�P��%v�b9��e:���-�0�gY>��-e�����l���.k�t��@��G�l(�O��ܤ��L��2y�l3JS/{<��r��K�-��\�9�5���"���[m��5������(�M���i�#����i����_GlQ0Մ�Y�ޯS��9��!I�����;��{�|\���F��'�����CA����4G����n�غ�	3G��1}�;m��v���H�)��ny;,s�q�6�#�k�ͧ�aJk�c�2��]��e��rt�(�骽/�ޠLF7<"MOyrח�����Q��Q#[/�H��/cȹtՄj�`��}c����������@g��PP+͡�E��[5��^zO��FSc�9y��ǀs7��QR�@0¡�D�*��-������h����`�%'Z!��aGԱ�O>����Z	�tyצ/`q�qXP���$a%�N'Tu
d��}�"Z5i����L��P�����B&�.�*>2@a�V�bew?A��r���Zn�ʃ�@�C��,[����9AsjX�m��ӂ��O���^7JP������u���Ň�D��T�!��b���6���nX?���V��κ�2�����C�mٻ�z��ͣ�mҬ���m*
��x��Sɼ5yv��U{0kM3�
�O����Ľi6of
#"�||��e���w"�j�aBW�H��~W<g�;��&tU|N�g����������*=/d ��FQ4�{h/xD�0���J��$�o@��d�B��;6�;��P��0a"��(d��ܢH���^�6�:ږL���H{���RL%)ԇLn!�R�M1U��מ�X6��A*L�P^8z���m)���F�����P&� E)�2Ԉ�ˊ8D�æ��/��|��7�j��(ҙ���|����8IZ_���?��=X"b�&Ov��A�o���7J�G��D8��}����1�j2���JQ/�����?C��a����^�C��a��fwEu���u�W(Xk�%�!��-��*W椤��+0�gf�v�P�`��hi��nX��sr�f��7ԠʧI(�0GrPiLQLhZN�&I�-ۂ\�2��n�l`��E���ε��F0�(l��� �N��Z{���"����L�9�m=����|��1a3fòKBK�*���P$b���]3�����O�P���o�����aX=��]Z��F�~b� Z4��(ԇ|����^���a#95���?�[Ao$r�0�[R0?��0���@�;=\M�ǧ"%#��#
��ǂÈ�`�P��+�T�Cـ�:�̋��P ПA�e�qx�ya0�����}tާ�<�[(?-���9E]���[��c��V�s���Z��)�Ю��n���iR�{���ǡ�������ߍ��P�`j�a��Κ�?|�n-1S..S����?���9�E�Μ�áj�4UĉJ�h�V~:=5,b�-�K��*L�#��uJL#��]0�6؇��l�
�曦�Psn{X�*��5�i�a�!����Q���Ӿ<TVV�p�j�������#�Go��X%�o�~�:�P�qգT��xOQwr"�5����ܗ��� �  ���k�ܨQ�"��Ɍ�$MP/`��md~�P0`T�J�^sxz��0�kP�褽�Dx
!����(���3�l����]�eZx�w���B��R��� ���&�5�Yd"����&L k��lX��Cـ	3�%dޯ�}��R@��	3�ћ�\x96��0L����$�V��	`�z�ܕ\r+@Lo���fLs���l��C�N��hE����d�|��`�ZG�@X�������;�6�m�<�
�rc������rc�-�$y%@n�P���-�_M$���YI�2�7FR���.����#T0Y_��T��`@����0���rV�.��S��no�������3�7f�#���Ά�u�8%@xnr�5+w��6�j��H��Q�ÒE:{������϶Oi����@/�ty��0��^�N�oa5��ޞ^s�)ݱ�r��!��9y�8Eq�ǍV�����!Ž����m=�u\TmO'� l�(	~�ڧS�e0���~vze8��|�3-�w=��hE�ئ��䋲&�=�!TM}��w6aز�8���S�n�Uؿ��ݔ�'�Ӛ�����W�P����W$�{|Lm¶���X&��e����)���Mi���0�rA��S�-(�-�{r�o�x^�5��oW{4���BM1P��+�L>l3^����F�e��4Kҟ�X�ܺZ�2*ۤ|<������O��ƨq�
eZ����}̇u�F�p���dzHD�����&�����	�-EM�>�P����S=��,Tę3B���L�:1���45����?�Wų�0���?촼KV�]��&����������,N��$[w����G

�:yj{����,] �e���G"�Ui����T6�8�;��j���X�	sg�p�!���F�,��i⒆"eZ���UWh���(�]��B���!��a:��T�s׼�ټ}�Q�L/�����e����fz
�~�W��ca�>f�{1�D�5�0��ŘO]���FQ�Io�vd�E�G����M�8%&�{,�V�0�k�5}j�?i��8��v�j��5H��n��%q���G������ݤ�Z��6 ?*���|w�Ok`^n$AIX;��]40I7�䃕��a��}�D.Ԑ٪��A3N�(�YvS���\�h��/�خ߽50�4�ԑ�mU֚lAU�m�|Z?�}�X�{��q2E'4�SU�؇�s�G?8����2~����ļ`T��:-����@��e�8��@Ư�JQ�WԢ-N�ߗ&��T�(&�0�b(�'��(Կ7���Ik>�������I�E�`&Ԝ�٣S�Q�o"��8�E9s���2/v���������}���Ӡ��޺4�^l8�ZQ���i���%Me�Ԛ����g��0{U~	�g�3�س]р���H���3�zG��H��h�#��U���ni48��&�8�=.g\��o�����e9�YMĚӚ�vo�k��LB����>cǚ�7G7cj�6��=�-<�h�I?����%����!Ƿ	�e��X�s"VU԰��ԽGG��/���ե�d`��*NYا������{`
�����;rXRl��������J,,�}|�{j�A�W�`q�{�������߸�#RQ�˾(!��ߒtD��F&����U�P��^�0�|��pӗ����Zd�Ltk���2�����H���'�:��]��v�&l�>9��L���2ypb}pb絹[v�!w���t<�l˳��*)���=���]!�
x2��!�ƫ�Kxi�(ؽu`�Qc*�J��!�h�V�Q�9�]�
���
\�K��}���}�Ve�9�IV[�l����*��ʯ{\Q��U�G��ql�{�9��S�����}K�O��˸�nP��*B�w9������&���v�z��~�	N=�ݟ�p��9K���&WC��v޸Pr��`�u���J;���m ���~�BQ_�f���ͦ����B��FX��6�>R=���**Cy��Ptr3`������9C��}ۅBtY�*W)�t�<��?w��0$X�b�㌓2��!��:B��7|�ǡ��Q�6ݍ�J+	u?�X�
g.�H�E��ɓN]Z��3mp���Z��A��6:�d�}'7P	K���b$�~G��O�/"-�M�N?$~���v���Y���IבNo2�s'�����`/G@�����I��t�L�5p*�3a����d�8Q���׷M�<�6�	$l끖��NM�Y��k��ݛ�	gxp�*�PY*��C0o�L"7������}+�p��,�h׵9��B�3;p�v�q{'��u�վ�0Up�*<�E����2n����q�ysG�P�0/GX��rn�L��A�ʕǙ���f��`Rs.T<h@g̙ٳ����=�C������3v�2�����~>b�G���3	d����=%�*ϥ��d�,W��2��X�|w�ס���&L)���R���5�<y%���3�jL�����h!['�u�	���?�D����/U�#����%L��N��&�����P��
���9&b#��"����a��m��\B.�b"m�ByUp{ח?�9���8	�ܭl�?o�'{q=�<���b�-jԥ�2�P�p�����:�>�5�F��*A�}��:��F��*�G����r4
�U�%�M�x�($Ve&��jMiT�2�@��#&�@(���(�Ue)���քj����jĪ��;KtQ6B�VU�ǹ`Xh앒X���㟘�rg�
$�9c�Nh�U*��#�؜0Z���0I�*�?^�uF����&��T9��[���O�\U��>q�w^1��w����vxǜ��ە|�T�f��!���j6���ը ��9K��txDA��	%񂧣������D\��M*k��B����٬���hm��h	�����f���e-\bd�ż����Ӽ[U���?�ۍ�1�|��b 1^��+�%�@b��2�,ɕ�,�E���C���3���}8�ڀ�t�G���4a吅�:����#N!��>��zU;r��յ�̿�ۯ�McVr��i��x�$�;�l��9��>QZ��Nj-[�^F�t��Y�r�t�s0ֲ"��f�1���=��wW.[��3����r�s$	�����h�I���'�Ɵ�g�� �+2�SD�'��" �T4oz���x\��}?U� �^�����c݄o��I�Dq%�x��Lcq���r	fe2˅�5���|=P�c�
��s�8��7f�8�����E*�h_���&���2�,���י�훲�_WE�_�\���w���8�P����u�d�T�Q�8R�	Lf��c��P�)s��{��i�T���熔��)�:�_�n�P�)_�X�1����SZZ��wGy� ����^��Et���{9��?]]]�Z��      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �   ?   x�341��30�4204�50�56T02�20 "�4� w��| ���4424715
��q��qqq iX%      �      x�ĽKwG�.��~E.��L ��8�A�"�xA�v���!0ԉV&#�ߨ�N�9��w6���1�G<3-���UI���n���g�	v��3��e�׳����bU����b���_��k���������z{_��g�ŷ���_��-..�ϟ?{^|��������u!�����?�x����S������..�a{��P��zqYn�e�-�bN�<�9,�����a���O�r����-�?���A�V���pE5Ê�۪����~r��?}��_��T���~S�V_�u\~���v��ؔ�]�x^��}�ù���I7>�v�%����W��Ƥ{¹͸dr����ӎ�ϥ:���߶7ŶX�oV�bU�r�2%s�������<'��ޖpR�xWlʴ-�3'�nK�au.��-��b��l�;P�M�9��Ym������uuo��9��9,��b[m�g�r#K'�悏�����������鷇�v�����JgE�y�.�W�C�XջŇ���j��Г�G��=.��Ã�y~|k�`Z?��r.G�eY&�b�UHä�9���x����X�Y����u\	��K��I�s����u�{�K�[|�w�38&�F�����C��6������¯��E���������r�/��z�x�\�w�O�G�k���J�+5�� �Z�aK?��G\c�؂5I�Q�\�[���W�~[=�h�pE�r�)����E^c&r�,tI�bS���u��Kqg3��r�p��#H�mq�y<(��<�k�]�b[�ָ����KQ5�[��Z'��~�q�����s<Rsܽ75\�Ņ�p����7�\�u�9����c��^�����a�<��|�[�]O8�Ý��ݞ-.��������og`|>����S��a
�c����w{[�nk�!N�?��[��_o�~��]/�z�'���a7^�n��zz��h����w�q� �����o��ͻ5�w�r��h�9l՛�Z��M��'��9������_7p� ���s��z�Lf�:�� 9x�̱1r�s���K0��`���9ً
����Y�S��a����_
g��O}�sخ�����Ѥ��I�rg�ټ���!<��ma��Yn�F�H��s;�5;Um�߽D��\d�*֘�4\�a���b��q,�i��z��0�$%0.Z�=Jl�-Vh�rä�f#��j� f�U]�|H	��he�h1��+8V|�:�+|���A��+3�g�0����
�Rr�M�b��ʘ������h3������n@�f����ѣU�Ep� x���[���Y�Z��c��������²����y��̹�O=��=�S}�.ϭ6*�v���]�ÒWN��SR��ː�x���{��1�9�\�y}�d�2�6�gf_oV���r��}�Zq�2��e�����J*��,n��5��Op:��ٸ��r~�	k�b"����#�x~�	�p���2�(;�}����� �7g)�:u���1���|���ݮ�-ok���~��l��5awSy<g&܏��b�cx~Zf<�0S>��y��#o-���=�Z��}�\|�Y'�Qc"f�y=5���pN���~���&&,�2S���諓�B������f�-n+�]���LaJZ�嘱��0�sh�B���>R�#t7<G� D�ʜ�(A7G��]6�������F�Ȅ�̘����q���o ^��W5���њ��������0�_�+Koa�Vy� /0��R��>V�UIq`�Y��bS��rq�����_V��eR�,',;O,T��73�:i��8��s��7�C��6�\����q7���\܇h�M���p��;�L4�=}JW��r�u=��>&,k`��s�n�ih��/JCآ��8p6��-�_z��*��.��t��9�Ç��=�>��o��]I`�;�BK)z_<���3@�Q���s>����rS-p��(�gp�F�=�s$��_�_���b8ʽt��y��+��S������jʭr>����'��v]���Zb%������}�_׋����b0~�M�)���h�u�߇%_՛�b�XNek9'm�UR뜹|f����Ǘ`���w`����s�[�w��9i���p� D {�u]`�㼗��'Vd
�AXH��{-r��Gi�.^^{3]�2a�t.T\`"&7 ߵ�G�_WUH���?��gf9��ø�}�m2l>���9����%D`a��(���5�
m�+��\ �=���[�7z���i��HS\�;c�8�\��o�X�z~֖I,�"c��q!Ҡp���b�\�ko��CS��2>���\ٱe�p� >Gڈ�P�:�TƕL�p���bm_�YC [��`r3v��0�|_nL�4<� ���)bF"���C�PxJ�U���������=3
��Y��Д��!����ho��ظ�˅����8�*4�*�1�w��ӻ-�u�[\�S~(���X#�J�A�D����^n��\<�V	g�2�;��9 Û���ɕH>��lC�rv<�h�s�9�-��߸9�+%�2R�v���)�U�ߧ�Lw�90����=!�H�2��M G�q�����hy�`����5�2_�{�m��������0^�|��͒���]E��q.��NM0� }8 ��St�xw-�p����mь>��)�rw�]]�o�]�Ʌ��.�r����}��\�s"$˄b&�=q����)�\�!���z/�M�����I��Ƥ�*~�]����b�����T��'H�L�rC=�7e�y��D^�%R���1��*�*�@��CcsMT��X�*bv��c�RR8�&2��	�Ѐ+��G!`�u=�g��ad��Rg°x���__�7/*�/�X�~�Ḋ�:a�i"#8u�bK�K�Ҕ��%jAsf30�S��%��"����F���$�[�6��c |�4qP�f�rw�1|��sd�����C'��	E1�Ɋ�
��N�6��:� ����"\	QH\n
0��l�`��EwQ��h���ע���1�)3��j�e����@�'�GkF���	q��de2�Co^6�e��g��1 q�a<=>��H�����U���W����U��~"�]�Xq�4ېK�r����jW��·⮋��j�2�.�5K	d]����r���x4�o����r]�(��,����Qg��m����%��n�ύ��u����º	��(�٨��)Xkc��}c7 �0��M����q}9~QUְ
��!\r84+�q�i���Qf+.+��[@�`й��YVa��Jn4��QQi�|����/��-��3�;L�Z�'X��W���b� Dr�`���e�H� �e�$4N��P"I@�DѺx��A��v[/�{�FؙR�5)�Es�_-��8U��F�Իr�n o�'���ik4�@��d�h��ַ���^>"\���;�Nl�����_&HW�e*�q1��+�1�8�c���PC������<E4Ϗ	��"xI�u�%��Iݗ���IO�1�W��h���f��"�`<Ă/'� �	�r�:����G�ț;�	ޗ+��dMBk
�i2���z�T�0��
������U����Et�4�@�7�7t�����z�^!-VZ�5���`��C��#|t��"D��ݍ�0��K�����f���S�[e�د"q�i�"����`�1��(L�Dr�>bz4%��e��e)6�����渇k����n����Ylī���̤�&��`ds8�l*���{L �2L��0�[��w�u8��x�jOY|>e�Y*���/��K�¦Tc�(�ى'.y��3V;&�H�e���oË���N���X�xD&8V`�p	�H�~�f��O��Į'��~3�e��O']���#_} ��Ӏ�oK��=���ox����cQ�և���$�e Ҧ��G0U�"&������`��H�e �-�	�L9�F�"�_�W�;�    [����[a7��&FB,�k�S6���#>X�k�i�n�7�R(J�$=0J����OvQ/��b�#Z�R���XEJ%�"�
��w�i�z�+o������,�9S��oN]��`�0V��C��/���L��ZbYU?�ʟ��W�8�0*,W1�0.�VǳGS3��s�"�x��@�m��%� *��fl"��@�6����9�X;�ZaM���~#�u�P-±/��:���i�(\�P�2W��������N�z���u���UH0���5�PV��$�(ˌ���f��t
O)q����1����E�X�o}�x:B�:�YA�C��hC�g\�����/p߭'� bzi9�4AEaIǤ��X�b]��}�S]�X��>��<)�Z���i�C<�}�)�k�w�ZKC�e)�"mk �������xU��{0����e�		%��b���||/����AL��~H5�s;�b45��F� gH�f��	�b,25M�'	�����#3N�Z<?��t��/��	؍U&�CX����و�F�T#{�b�o�ףa+���g�q�WۮMyK��y̠�Yx��4�3e9C�+I�R��'��y?J;��g�E	�O
ׇ9�����N8TW�Q���:3��e�N�1�4�����w��Լt�.Bc��Y?Z���KD)AI�*��PG�/�U�e�j��k�4�������V1��٤�I��G��~��ok���I�r&�+:����e좈ǂ敂�X�"�T�s����}��4EX�k�|sWB���݆.Ґ�b2c`��*sy.��#dPT���cn��1
���s��BSMbRSx*��tE��kb)4�|�w���m��Y�@��l�47�q�z�Ȉ{��BJm��s<|h�Myo�z���&c�J�dR�$�8XR�E�=m�bH��X�4m�2�4H�(��Q�P��-��w����gĎp��̰P�"���J3{�0MX�캼��U���ܐ�]Z����Bw"���׫���]]���K�i���j؛�b	w#L��-� ��0�)����[�#��`�},��<�+���3z�`�+.P��(	�|,��2uq�t��������hB)��L�tā���pJT���n�5��Kg��&��9�¹~�_�HBl��z�0��
�qk�ŕiJ�q�H',���7��`5�U��L��	�2ʸ�b 2�z����l!C+����#��Ci�(WL�����u[U��t���yY=��[[���.�:Zj���2��J� ɣ�g��.+�˘��~�`����]�.4u#$��Qכ��a5����H�&����0G���k�<��̦#2]K�4k�)0&wT�!'�7L#��<I�H|Hn8��,�6K�]l���p6�C���P���f�;��Z���UC�o��R�%�@9��{HC�k�N���=|Q�w�0������g46�#C�Y�A'kHj�U	��e�ݗ~�i�-a�)�O|�H�������r���cC��:@������r(&ȬRh���qK��v�����[�5��a�f�8%�Ms
�\U�U�͕5���-���f~ASZ1?���Q��M�B�}%�AY��@�M.�?:���xL�a�3����&s&p�d.��׏xcv���NOHH�Ȉ4��a���9�|�1��,W`�D�0���9;0D����H��ep��R�՞�tP!���>���Ѧ�hF*l 9�Tp��]8�s{�S�y�tG@s֌�t�κ�ȹ?nCFs�ZF���5)�6AK��?�#	s�w���H���y6��s0�&9m���8�m���S�;EwO�!����'����vc��_��LR �b����2��r ���u�	!@
���`ǵɰ_2n��&Xz�`'%o;��*�y6� I*>��,j���B��1��h���)�|�GqZ�R���;Lzǰ���2)��@��*z,Z4�tW�� �}9�Y��߹�?]�WЬYp�ҁ����uyS������Sn�o� ���}bI�H&��^tr�p�T�����M����0Q�5�5�`d[�п�fѲ�u�`N;�hT��@������`�J�$��G�"�H/��>�$��@�V�1�1�*�e��hxZJ�9^�L�	')̪Y�_E�F�n��,�?s����t��{����A��X�[�(,��EU��fΗ�:h�q�2�#��h�-�Q�Z�Q	ͫ!(��H���]HI0%��V�N~c�{����#(e�r���[!M.mND��9`���Cl�j_�ۧ�Q��b�"�DL(n28[�Ax0��O��*�~\�4>��hQ��􈋡D�Hv���H˃<T� �&b�K$�>LĤ��0�	% �y:����\I�:���%�����dq!>�͢i����Jm��r���}H	�W竲a!'�#b|�g�����$-�yۆCi!,�]�r��!�1��@(0$��}�u�9�F0b3 �q�gVA38�f4����0�P��@���s �q5ڤ(q3�1{W ���]��n]Lˉ�:��R���i�	H��4�޻�۷��f�[?Z!�@E��2M��91\2����T�5�>u}�eR���2���e��X�ܯ�b}���KU�@m�Z*Tr��G��L7�M��$0�ќ�<UM&�@%��"D!_����u�e���t"��mH����q$�5� ��O��N���� ��;��:�lk�;Cۮ�1&��͑ϕG>���:��{-�`|`w��Gx�f�2�w9D�/�o1C��Zp�u���f�"wŠ��Hb����u�j��0���b�+71+2�SV�f�~g�bw�⇠����Lأ׍#z "��5e49�1@~N+"�4ɪ���S���ؙx=h�n�nCb�������Q"�t|\�����\�[f�����m,���:��*�]�,��t~�l��P�U�����C:��D��ɜI�f�bV����3����Nw�C�s�4E�Je)#�[�.i*�����r]�ζ���"��2�G=�$i^.�5��S�_�3m��!a��C������dFл>! k�`?��^�����Y����(R���o��zտ	��[��&�2�k$b�;�E?����ct�L*i�-טE�pS&2�(�� �c_k�r��Ƅ��`�jT1�$�?�_��.[FR�G5>���	�\�ҧ:���E,A�Ӂ�5կ)\�*�˛��v9�J��Nq�p�Bf+h���?��E��౲('���r�+J'|��V%�O庸/[vF��K���r��,�_󶨶=���P�l�J�n�0˒��
2	!�J��B��C��!I���4�l,,tܨ���'{ݲؤ�۰$���\[;y|�]\����U�7)�ݘ`�*XIhF%@_o�ժ	`b�"F�8�1��Y4]/q?F�[m&p��ɷ������`B�t�/X�,9>���ݣ�9�#f�U6���dƥ'I�l]�pW�;����{���m�*��`1�4��w�X��+�h�~��ǒ��AN�s���,��{`#7Πz�� 箻Ee,�K�=�Ba��\�,(�H�������~�|/�ӡ���*k���a�k׹����v�Z�P�V8� �:R��7W1i��L�{�����ۈWb�E$81!���$�Y���b�	Hb m��	�}Qt��υ��w!�y]T���ĊLq���6:�h�M���r�p׽��$^R=%\>�H��t�/i.��ٸ��$ȹ,�\\ry����Űԟ!iN.�Cp|��L�c���rF�	q��k�����p%)M6�WS�����7!w�����f�u����0Ki���2>)
���}-R��\��,L�̍��J�NzQ,���~(�[4��@'0(V�pV:�2��+�X{ѹ�m�u-3�̈��RsP_b��M��M|�[�
�)�ʎ�t��ΉZ�d�E;�84_~R��1��5(����4ֺq�.ҵ$M��j�!5���[a���ׁ"��6�AFځ]Qd'�5���!�d�^�d�?!.FZ    n-����y��y[�6}���Y���	mY���hI��t$��k�'�Bd.��	..j��P�q/�
��뿡�p�)zΕc�&���	"���28D�9(>�}���'4(&)c�c�Q�<�SF�-⬻���B�P�)�TG;y>�2'ǃ;$M�X�GR)��CvM�*x���c�k�*�xdzȩ��Ơ��]�c��ա]�J���a�)]'n�("R�85�;=H�hlr�4#�
��PƩӓ~����U-�.e",����@�10�*���6�5)ʈ�gM-�g���S,]�]H;>��u��J�>���irB16��>�a�9fd6hF.��Aة9�_�o۹�6�q��,mgB�Ea�A˜z�6��U��m��IBY�\���
���b]���l����fݶ��Vi�������^\���ց��D$c��*|�/Pe����:��	�-w�KC�>�!���j�A�6�oB��1�-	O���-�?��,B�P��i�B8�0�D6v��i�6�ԊKU(��Հ��e����|[Ƭ�^!��F�;��*b�X�4
�O4v��5'p<��9�w$�]'��){�`����d[�,7�v�%X��!-���9T.NA5M���� U��]�i4	�Jc'9�J�"��I�a�@��lo�{���y�v%ͩEe�&c������l�yƎ�<6��)ƬS�r�ƠJF�o�����]��ɓ�ݮ�NE�/��|�rD���e�_�SUn�Mu_w��=J��V�0-��RC���Vp�W��?���b�F�H��g�)���"���)����6s*%iF���S�,��h��s#�Y�bǕ�-M�"3��qcT�*��3��z�|�2n"�X�dXvDcHM��>�k�u����CD"����|�5gq�	u�.BK�[�,&گWHM��R�)"�~8%A+�,(BlȎ�F�?�<�}S�Q�:��:����DYpa��:_y:,6�{�����f�Un�v<?KĹ��\�\������w������4��竐eor�I��`�򔉢���S�2}g�-�+��=������kx�(���@9��,�ǆ��f�
kp��������S�y��i��� ܲ8�xp����o��p���ˡ#�y�LX��Q�ز�u��;��7�RJ��/5+i,zr��0Rb��R���A� ��EM��i�"4�莁�����^IotU�b�*/M�š$8�p������o]ѿCA��,� 0d=�6<t�8��+��ATK/}n����ٰ�h�Q>��V�v��t�?�j���I�`�C�M�?F �S���>c4��	)Z�U����gO��lzlͲqw|፵l�M~�,+I��7uT��h"Q�Z4I�q_������:��t`��iJN4������i�o�����"m:%sD7������Њ��V$Q(�����56:GJQݜ��a�f�X�k��	�ԉ���TVQښ����4u��c^ZMp_s@�`mIQ�1�5��W��C��Dr|R�	�|]��@6�b�Aj�E�Gk;��B��Y�k�9V�Y�E��
��h�p��o+����r��'�	�+���#��qdtCCh��%�������4��KN��C8�	I�:�η�]��\��U�T'�.�btĄ��'L�6bw~}�1��tp��z���>6qAK����U�.qK�6��h>,��3�6p��2V�N�x���Uj�TR��I|�n�a��R���lPC�
3ĕ��N�G�E@���w^[1�W�w'��Ŕ��$��M�a���e��RO���i����PVFO�h���/�m읃�-��	��t9
.̀��;m����/_/�|hA]��h$ڵ	9Z�si�}���~+����فC)��V�W������)�����o��[T~��{U�n�X�@���w75FLCT�(Q���m�8����ܘ���kq��i���a&��HDM�nӀ��<�Mv=� �/����tƈ� +O���A�Tj*�����F�!�����~��ϩ�cPmT�,+H�sJ�M+��Pc��D�n���hً��_�jd#�;nqJ��jm��UlX��p��;��۬�s��+㵘 ��{Fm/*����J�w�y`xQ�=:�	���~K:��Ѩ����9��F��W�@!��9�o���?wpR� �QK�O��֋��ޛ1���K+��h��we��pL¡\X�p$)c����	��N������Ϧ�����ة������]4I�TфX�s���ʩ4Z�1WݼM� T��"�{���(�Dʠ��:ˆ�b(�#�I���ǘ�ܬ�Z��0��R4Y�0LLMD��wi�'f[nt6�X�I+-P���?�S����['#��-�B}��~��2�,�殸����O�E��iB�'��6�U��k�9� �x�h����*燲�A�4���_�gA�Q&cMdOa�E��N�
�r8u:G�S�S���pb?W��xm1�!���s�E�G���YNԌ,�,����yl��V<ն�RNI�JY��Mq�߈�x��n_<�y��ⷞ�b�Wu�͓�3.��_�����խ��ӭ��R5!Y�� �D�,BC'}[?�2��3��	5A��� �K���r�'���e���#PP�J��"�NMPe�Fⴥ��Q�����&�۽�B\���é.d��X���0<47�q�E��4]'�K$SAt���z�ёD�'��I����۳^Ɯ��^��}��H��]{���ߔ�݁/Exj28�9O��9Nb��� -�A.��0g���)o9�9�g�u'is�9u�<ݵ�
摱fc$����*�O�>�9�=ͦ=�Qs[a���mW8��!� �_�2C�'�`#|A�j����H��խOm��1
w�V4Z��
�1K�j�-̅������Q[MqhO�}�*B���2h{ʆM���(�rAm'�<b���b)f� D8�$���
�6J�)�>��{ �'A�����!��ܳ4PB�fJ5!Z{r�h�=����+�%!B5z�uTEjt�;{e2��b���j�5B3�,�UԖ�x��m�<�a(�:{j�Q��ɑ�ޚ9ꈁ��|�W8���\jD�.���3��fѰ}_�k0a�"^p�U�xS��P#�	k��;$����/�-�����/( 7�e*MW��׾~��r ���]bϚ7�+�\{j2r[�Tsϼ@�lv@�V�[{,����T
���rd�Sȵ��d����?���/��ד/g�)7�+�]��;��"&20?����b�(��{⒗kd�>�7ŷo�ߢ�H�' �zs��8�W먁;��LnB���<�t�?ū��׍�/qa�
���g��G&�)�]��yuX��*)'�ir�M�\טd��N:�4�ܤ&�l�Τ&8w���*RU��L�;��ɻG��@C�T�~D�[�;Μcn)mkB��	,��Wo���].]�|p �P)�3��uڋ,T���� $���ڡ�+J�E��ҭ���Pr��_p�,�6,"�����	��I�� ��s���ַ�($	����j��F�[���S>-o\�����q�[�d�P��+O����"��� |o<"ҵ� c�R2���(�X`We�&zrL�F�����P8��8��c��������e20;���L]�-�X�pĸD@e��ȿ;����*6wq��<��	��ߙ[9�@pu=��`=���2��O�N4�쿮�im�}��o��ѳ�v��寻��	ɽ�	��U���;��ޗ�U�Dh��g�&����Z��C�ဵ�v�����`���ej�U �.gqJi�c��lε���9��\�Xڏe�7;�Ԁ��l5�qvT�SJyX&y[l[��b5R�Ĥ ��I�&DjsL��<WǏa�)������h4x�a�-�E�	f.W�3,�P\�ҷ����.�D���Qa)y�I�ye8�s$<��w'�u�<�Sԓ�I�����!9�8��������ZڪF�HSq7L;�H    ~Ij雡z����Q)�MSqO����t���@�����ƀ����R�:��aʹ��"X'�j�>U@{���hZ����M����D�\@�4!7�Vԣ Rp��#��53pI�X�W1`�i.���HzGY�<%!���K.s���]������[�X���yHp�t��0G[ћ�+�Ѻ���c�nE��L!s��6�T§��g#�dk�<���e%�G�DZH�)�v�.`�p���0Y��+�;���� U�8���H�E���ƻ�� ��L\�f�+&}a�ȹڱ��u�8�}{W� ��񆈅2����ϋ���b �G?+�B�9�4�a���xS��F�@���c�2�$[z���F�n��f��nR�ɪ�y��Օ�"�D��Q��]��6���I�0���V�|n.�� �����np��(k����S�ߺ��͌⣢#�<���k-5=)Lg>©H��֜fꞜ�e��W�e<��'�� !��dn%��/pRn�����8�a���wi�C�A��1>
D ��8�w8���c���O��6Q�q"xm%�pTN�y��?�h\�Xz�O��h�3'�j{t�Y� .�؉�zRHJّ1�pF4��]�iGҤ�}�L�ڭ��ƢnTNt����Ԏ�x�ˮ؎�B��	�.W`1#r��}��?e&m�H�m������b�=�f{W��)��[B��3֛�D�p�����^�h�`OG�`{S$��C���#�[Tس���ۢ*R�%��Ko}oj4l�])��XT^<^T	K��N?c컧���&t8����U��5|�A'3��
�<��|F��\C)T�h&
#>t�IKh��̏EW����8L��������?BNҊ�x�L6��f6�N����EzZ7afW+��yIeg�L�|��Q���R3QpP�}Ȅ��Z�)��RߠtK��~9�; \�O~(������OJ�s�����[6����/�ġV��4���S�K�'PXi㥣i��%�5��m~F�a���������vSԧ�y����ǣ�@N������kpQ���:�HK�^v�\�cעxo��� �a>��j�?�m�Q�6I��d��TN��J@v���Ǉ#�͸�^�&�9O����K��u�������7��P�cOQ>`�fSC(��m$?�T>�����(�3i"��	��(�����da �C�r�y�F#iũ7{L�W�n���KۈL�|�m�r��	I�?aH����1Ǻ�Pפ�K��8�	�Z�嫯���F}�c� 
����;� �*���:��� ��6Y�).��^Õ�,u�^�J�1�T��4�+Y�4]J�ܕ�
\�#�%d�|XțChX�r]})�9�?G�Ir����BdS��QN��Α���5d?�J�q,;уx���fR�h*bŮ���4Z�6=�3�F��nB&���Dr3q$h>ɦu���W��q/ͭzf�܊b���hEZ|b�I��ٺ	F9h�BŊ>ŧU ��Qn�1�P��q �p���K���d'����%kZA���j_lUЮ[��
uK�	�Z�Q�є�
»~{�=�E��I�k�QB0��u|2�-X�b[bB���	�Z�
�5�X�tJS��9�N�s�]:8�T�<����.�Wې�� ,����Q��,�FD�p6�ɶ�ܸ@e$��)VhBtݙ!�M[*��D-�@	l�����T��V�!�(핛j�4�A�xG!�S�m��i1%��*7��&u��@�C��JsD2~�����due��LÂ� ��iZ{7uF�tD1�BͲ�*�4��hģ��P��EfM�T�ʶ��q62���Ag��%�5�xK��i6-6�k-'f�b�2&{c��υ��2�(�R��L����*6�vr�Q�&�W�_d�R7!j+P*Z�e�� �'�^��k_h�\!B��F�Ȅ��1���NR�>���wh#��q��6E&UN�g��.�r���g��/Sf��x쨲��lY�.��O_�כ����&]����զ������ʹ��)�h���(2K��B69�s{2�a��[�Z�i�G" ������Ш���-~�\��%���ro�]`�Z��M���О�_e��\1��,	#�H��6i܂�#D.��,�C�N��x�26�/�Բ�O�j�UA��
��xh:���=��8�Ȥ�&�nQjMK�NCZ�Zz�Hyh� ��@�
�;ͩ=��>���A˧(wK��B��ٱ�n� �b;�2�s�`�\9r���p�`�����E��2��퀃;L��666P��j��]6A7������'�.9N9d�@�o���u������܀M�A7	0K��4��V��~r�[��8��Gj6���P.v/3�;&J˯։Յ�1��F�����z�8D~�+����D��Dh�-W='[��hJC�ܣ�|��zIr��u�V��ûF��0�P��("~�H���5���vB`����i
�ŜB)vH��"�hHGmL��I&�rOeu<�Fn���;�%Uf�����^�$��pA����cV��I�{��L�f�Y�3���� ����E<9�S��X\�oU�����O\��r��[���D�1���\x��
�((u��Tㄷ������>�\���1��8Un_a��r�}�ZW��r˼Z{\�w�������_�����e��=L���������rmݎA�,�m���v�rN7�@�*���ΚH���/.Ǭ�^�M�'Z��j���c��|�l��M�#a���<_��wźj��c�iz���I�HB^� ����ϲű�:�i����=X�����/���P��i3��&�N߂šk���V�0��Pծ^�4�������s�#�/
wu��x3�$F�����m=��t�����7�����A6$��#R�ЏC�i`�t*�ҹ�E�xzI�{u��b7�	��pƦ� ��:�aS��(zL�%��x+���cFn�d���D.Dl`c���i�Q��=��*�~�R�!1{�i.��P���N�����O��'/Ǵ{=`�v+���˄�$��R����/� PJ�t���8��8P��iq�`��V�h�������������ה�����G����It��Yl�1�	�$�k,N�ǡ���l��Q����B)��Jx�xԨ�q���[�;�l���ִ�/�ZU�E�{��jtX����wj�aB����n3f�k��z��}^c�#Ԏ�_��S��r>��j�90,Z�qy�9Z��	�W��a�uۙ��P���t����š�R0J����u���D��ۖ3ĹƄ�ay���	z�4�S�����]U���h�ʐ�2�5���j��cל�eu9ֺ�$�Ǽ4�K�l��L�_��i���7m49b�S� ���ݾ�u��p�� 5��T�D�D= �B�;8gR�eQ�c	a����B'",��d���_�1���9[����� ��8��B (7�:�i�]�4�2t���[E������(*� b�M�8=��.�h����Ϙ�ٜ������{<D4�W�_�,G_�al�`������H�c����q?��!c��ؖ�;�1G�\\��G��a�}����=ܐ�;�pK�T�����_셢\���*�`�q&_�_E޻��p東�<Ti�*\�u��*-�"���L�Xִ/Ҭl�Ɇ�N�'�}�%@Q	^�_8E�IK�_?"-%�����bp�Q��}g�S�a�zB��s��}��e��q
��%a65|j��)`�K�1�&R���VS玦��Xa�H���5r*85�j��m,<))�#��wawp��A�iFInc�J=��bh�Q��@,E��UuJ*m�7,�EKNӌOƘUݐ�:�cY�R>JYk�{|ⲗ�7��`�����o�y9�L���gf��U:����-��U
�R�]O�ddݍ2�\}����0��Z�"����    ��Uw,3�0G��J��K25�w��HlERi]z� ����"l�E��!1];9���� �N��2�)j��,1���D��þ4���vw�ʼ`â���%��_��п©��#�NGJ�c*e,iֲ�� ��j���D�� V8+`$%�:\�ۄbi�2֋�xa��)^Y�򖼓���R�M�2����	��9��ĥ��&9��b�5c�J�I!ҚZXRIL�0!�wϴ1��˳ŏu
O 9[@X8�Cg�r�7cQ�[�\g֡��$Y�
wh2��ʛi�z��l5<b��	G��$<�8��NY&d��ȓIp��Aӕ5p�����K_Q�'��`n7��8�����uM��s�)M0%��>��~�n<�L���
�ó���:���nH80y*C�Y�Љ|ݐ���E��	���;�l�g\���m�2�綊	�soB��!�I8��A���^Gzr�~g�G���� �cZ|[�?{:�p���b�(n�� '����}(ڈ�3���c��ep&�	�� 10�N�����Pj+{(�ߜ�/Zj؋�q��dŭX�r�m6
�	NYZ��g�\V��@+cPJ�h,z�c����X��S%��B3�5R�$!q҈�yv؏�/_��n�&` �m|�\�c�+6DaF�8��Q���LC�4�:���_�)iLs�����JS>k|Z�Nu�}�A�4/��f��T�:�T�����~ ��Q�%�	�h&��N#*g$����=c�skA��Ȉf.=��JS�6�q��
v{�BJ��.�f��U�=z�6����G�T&�D&j����d��Z���QmO�D���f�|ɧ�� h9�ih��+`�1���L��ya�-P�̴	���~N,�4߭��E�F+�㽰NϚ�H��0X ��
"�NKYZ���l�EƄM�N���K��������J-�a{M��kn]����p�p
e���ş �Z8�jfC$1Lf1�Rޙ�H+���K�7�]�%RB]0�!���DM�) ��s$�]���d��I�iD�0"�kp�ur�'��
� 8cC���"�����I�򡬈��"1&&(ҰC�:��&[�&���-�e�X�k�-,�N�Q���]�Ơ��.b�0�gtBv8ǌ�v�vm�����*�ahZm�d�HA9�>5#��[�p��B��	笹�iƳ�`�79���}�F�;e���h��RV%W�6��M��l�����`��>�pA`B�QXO�=��Q'�����]]���X"㔪�E�J�#� 0Ï�v��� 7����j�ۥ/��R�����NP0�� ����.P��R��J%MM�NJ�b*�G�B�[�-b��c7̩��������墣��C^�klt_5M�%���R�T�����O�]x-%����J �OP�F��q{��,��KD_e� �{����$6z�^w����Jb��cNs
�OV����|@��ܺ���`��U�C��?q������@����'�1��a�T��\J�� �-�4�ۃqL8<��F�媈��x)�'}�ۍ�H	"���G�'5D?��$"��,}D��Q�7�iN6W�ܐAl�6i�jX5�:Tc� d�8l'��`��A'U��]U��X :�x]�=��f���]��qN��&��
���d���[�^��Z���Jfp�-�!D�zHi��+���q���dy�D64#�s�Q���}�9Q?��$*
6-Gw�B o'�'� �%������W�3��!8B�#ҰC���z� Snr ��<�&�Q�A}.d�n&D�%�w�cۉ�o83�T��Vb� �0*��3|m�36aʗ����oh�B�:$V��J�L��4�$ ��f;�`Pr�c!
�54mO��d|\�4?�;��%T�8h$�c�>e�_՛oA�Σ.��&'�\�}<��T���m�Gh$2�V3Aφh�D�ĉ����GFᡜ�.��-�*�ue3`k�~���P���[$j9�q.�����	� �4a�@h,�*�͔�:n��j3a���\']����W#ף��`zC#�_baY�4��̢���R�|�05��V�Ч�����̒^v;eHT�=ʧQ���&�EC��O��4t�e��>�[zp�����4n�^ �����^��!�_��� ��nQ.UCӞ'< L�T��0!�'RԱQݎ�c��b�k�Ӕ»�N�-�" m���'�ٟ�E(�a3Z��TO>1N꠆d�b�z��Ɠ�7�LPD��k����;ט�Ҕ��x����s�mTmlrSj��:�!��g�V\�(\�-�D1��}�ك�,����j��OTN�۴���+�����m+�ܲQp����MP���(�<9L5<o��q �D��*��$�1ZH+��t�������M��H��R)�j,��TCl7�o���ۢS=�s��;�&���;�_l�}�)>�F�g�̈́(3Ċ��C�5x�z���n�I\)��\���\Tz�6
I���v��n'Q*we���5J �M�����Ď��@�h�f~��%$�vZX��`αwұTY�s�wL�'����!y���CCP�T���b�N���Z;��9�������p� `T��$�C��r�Ac��z�cV��"ms �G��=���8� ���g�ŷ!�3;ڎfhz7��Ԅ�$�BN��8��Uf?z�	g��Nmu�u�)���&��^ gU§��z}K�q.�~&!>đh$4C�]�z�m��>����(�&tp�
�6S�u�3�P������B"�?v�L�f[G��)�/(DL��l��ߔ��}Q�v��S�{��Ƿ�d�6k��k"�RZI�f���F����s=��Y:*4�V�L;R��:���]*G�è`�U���k��;j��Eq�C+aS��`������;�P����Q8�C^�/���r?�T�(��S!�U哃=�g�鈫i�P �v��̦��ZE�&�
�V�QF��	�ҲЌ�\�b���5D�e;.�Ox�6����M�Cc�V�z����3���]�	;	�X�C��=�:�14����	?�l��khN4�� o�(io���A�x�*��e�>8�l�o /"��d��M�2���,	�q�Kz��D����х#���J9_#��O\M���|��Lj�2�s�ԉ/�]y��ښh��<������=k^�]�6o�[�4�
��ǋʃ�"�;ר��̾(�t�[�m?5ltD�n�u� �c��_�qxzN����X�ڒ����l$t���h_�M��x,�z֩��L�Q�,M�28�,7�^��QF3����yqT*K��̈́�3��j���y�b��v� ��|(��[8���<3H���L?�y(|<���e=�/btI�Lp��R��EHc�e�`8���0ߋ�F����lh�@�g#H)���`Lի�Q�Q�kh���?,.E&�L�O̈��?��zBG��_��?_w����h���el	y��^�������3�p p��D��P�pH)��O��\�k���
�;�A�mQ�[����"I��ø���q��~������<��Id���_�8���cT��P�är��
=X�	�3�D��O�p�LR�ih6�uH3Q���!Q.���#bý���Mkv^���!~����1C�!IKTqJ�fC��s�~�Z~�.V_w#]��a���]�~�k�S�Y8B��!i^2ڝ*f1��;���Y:�1:��we�nF:�̙w���i-Ҕ��y��;��
3;��fa���y�x��Vz�]p�-�}�n�C�m��LE�ȓ�f@F�8�6N�i���4�&�2Al��ȇ/|?LGT�~�SMc�SK2K/�o4�կ��7���*��5J�~8ky����O]�p�`��u�������;����զ��kPX��v����9j`Q�07/Wa�a�vt��J�"�|	C�C�<���mq[��Ix�/(�:2M�>q�WQM8v]�E#�K�d0�H�waG�9�H2��Ȼ��J����W    4vq�  5��si"�;l�:A6p��'C��O]-��<:rl����rs�T��X?��A9��u�$q���h�1Z i;(e`��}�h�\������TY�Er�4-���&���p1qT`ݢ}�1y5���ί���֖���'�,�=�4��>Ð;}L��d3��<0jޞa�ѧ��P>%�M�>9A����QX8�e��`a:�Q ��rUl�@����o�T��iʏq'�X�Ŭ��u����A�Rc%�N��ZM��B���^�jx3�����?�I:��Ϙ �p=n�0��q�9Q���b�vJ�7,O���/�8��8�#�Z�uo��CR��f+P*Ir�b17K��W�1��۔EGU6���b[��z�A����>�.ki�����j�-ґ��d�G0��j��c1b����'y*�e6#�ɤ�!l���u��(¡��>�O��e=�L\��"���͸�D?�]�m�z�zNv���(�IbX���7�MÀ�� Pa `(�d�AE���4k|���\"�V=<�O�����!�/���s`�2�Z���������oi޳c{ZHAdч�ϷE֊�CR����Χ�S�
Cu|�5�d'���~�j���� ��	�A>��SZ��ĝ�~(pM��o8�S��4�d:,<B
u��$�e��dB_uQ\����	�f��
2�g.� �N��`Z��b����0d	�Ac��<m+�X�֞��� ��"��(op����c���r7�Ls�3 ��ҬgL�K ]�ѳ"1"���t
���f\�4K�y�����(B�:��F���R��[��Ufm�K�)�3�m)�I����+���}u�K�a,�7�Lo��P�f/�[�		
�������-Mm��@P!Ia��^VmOˇr��A<<�-�f>� ��2pCA�)�K���cy ˱+lG	'Q$�u2�P��3AW; <w�NN�l}C���p�����6���׌��������Ke(YQ>e!�ê�?+Ə�E/�@����[}��^8j���Y�E�����m�
�;�N-Mr^��"����r�����Ge�&3�萉g6�{�V�u�p(�L��=�׏a/�)sA|)l���*�/9|�.a�C�i=�v(o��z��@�LП��o�q�e�a ��,��)yk�S�ƦO1ǈƹ��P��b+�d��|�z~0�[3�����ilgH��y^T����%#ե?��*�������	3Yw�M���=0�L%�&K�$�H��k�hJ./�Y&Y���z�&;�
�B	)�.\�8������|��n��� �ޕa�v����[�;���@�����(�U��xX���ҧ.�a:�^#[����O؅�"�@��x�@�̧�P(鱥f�@0��t������=6Rkd�ȿ��6��p
�Q�z�h�56��B�^+�I�T�������c����je�SS��v��o}�W��Lc���M��-	a��xv��n���$D)����M�����cA��E����c���W$�>G]�>U�&����b���Ӗ�%G�c���<�7(�5Qo�3�m##�H#,c,��Q��K��K7%��g�M������H�����
%�>�̴�g0��V���Ԭ�G-�]}� Y�D���B=�ci���K�+��s��r���D�r�ªG:<��b������b�ǘ06�2�wNR9sD����3܄'�ŬO��������S(���>97���)\��
ܑZ�QV�%�H���[o�����r8k
V��L	�Iz\��d7��+��W���L�T��I=�s��a����2��5~�}[t�P�O9��V��+�7+�_�|~6T�uǷr8K>�V�E�X퐎���U	�8�vG)Y�]&��H��O� m�
�=uSG{n� )�އ��NEm���vm�o�n�P\(�vL����vX��Mq��\a�7�_ ��z��ؽ�e��I���.#ܡi� �����
ϫ��~�Sj�d(�ט�X�<�N���Y�zc�G�O5��ٓZ�&lT`W,ӯƐ���>���G��1��*�Y��o<C'93��4ԡ^Q�s�Tl0G�9 �K�8b#Y��w#������Ō��鯻�����av_����fX~s�f�)��ݼa��(��_* ��霘�&�c8y�x���'p���M>�`g���k'���Y��#$1��?��t�b���&���,c*3�[�o�D�
�qļP?�%I�fN�/���HZF���^����ci:�����T��EU�usOQ'���!�i��mOH���<B��}_�E��i��^qMe���Hj+����3��|d"M_�4']q��	��G)=>6��@:��=��1�hm��ѢۧFN����#����O�rv`�|�9���bw_m�r�mی8�/@H�O���@.k�:��FKN��h t��M���R">¢���:Gg���S61�^�,4��k��48u��(��*��Y8�/B���߅ 2e�Iz�VV*���`a��5>���ͺ� ֓�@�6J^��s���@����|�q�tB��K��a��{�����x���bJǦ���d���&/r��7�C9T��2:L�d��(�+���'��B�mqu���o03��T�8�R�k���Î]��؞u���&AQ�p�(��G3�a�9�X�.?n+��V��ӔE��Y'~�?�Z���x#X�b�kM�[?�D�����\��>��U8�+Vŧ�gv^��0k$4�u��<K'N�z�;��?��7��X���Xo�v���y���OO��U��غ���[��

��*<|���3GTvjݧ��HkH\���lL; �r4����q�`�9��H��"{�e:LX�C�Ƕh�}H����f�cZ��V�e�)��Woc!?�΋������F���#Uw�? �<!3����	Yl?66�u�X��<�B,7-�o3��c�����d��|�3zW�~IňQ��A!���,���0�n~R�I����DQ�#bL�d��T��3eG3l����礝��.�O�=Vazt�	<�=�p4[��W�!V�����)�9�s��`�����8����6��T~�x�G��w����==�тs���Q��7s�&��)(��\��0�uW��>�pl\n��#��s ��5����j�Pm��6L��t,�7�K��Uu������O�*�up�̈�`��B;�1(M��W8�8S�O��ƃ<��p���B�(�Pt�K���.a����&�TzԦ�f!���|��n�~ϵ��{ei��c1 �~(���43�� �$z��Z����-��*���_]���l��l���������_����ǟ����OrJ�O�	~}_F"����W�L�y�-��.�$�^�Źҹ����>��ó�x��)3���\m��7���a���m.���;��2�*m�c����>�Z�q��߁�8S����.����%>r�P��C5ʁ��sX��E���Z3���3�N�;�l>�M{��1�al$�BΡ�T����h�YZ�*U>��i���6�x���q��>7K��u���B���J�!�5� R.�ɫB�F��l�2؛|�BJ�\��2�`R�/�Dv۩9�U����M���O�	��#-�b ��&��(8�$E�ܛ#gA)&ET��ID���x: *d��r>�}S>|^��?�e�E��e�b_l�$�N�.��̳��.����N>�7x��AC���Tv��M���ܯ��C5�L/��;d�{5+�v�1���gg=����j��;H��e���LԈ7��aS�?����s$�1ܔ�F�YX�u~`u�S������]'yTDm�+�Ί0B�%�Y� �l�����>:5d�� �_�c�`�L�����<�p�h����(��u�
��VW���%��An���_<��)9���Q�FFG���ɴ���O~�����UO
�    �fc��͈��ؕt?=u�b���7�Η91?�Sr:�(�7Z��l\.���Io���� +=bؔw�ĭ�ԗ�x�&�Vs��Q-+q��Dq >�͚�16�81ՠTG��(c=����H�k�U{�Ji2TZ������cL�@�?�h&��qB`�I��վCrY��}^�0D]���W�]�2ʘ:�!�T����m
��_׀�q�\����'���>
���A�̿|,�aZ�h��'����;s��}C܇�_ь���'>	�Tn����v�r]��s����F� �c
�Bti���,�!�f��v�U�R����%8�~�^����s�^{��:�p�]��Kͳ�H[�����1L�P�|P�,_��'7���sĵ���R�T��~[�Z���95c17��O�ڮ+��Q�����,��$���ө��;|*ַ_a��x���Zo]��MSc�1c�׍.���!b�x�����@`K7>h�-0&����������#����Dnt� s�)2f�&v��0-/I8DX�� %�A����~�Bcs*������|˽����+g,n}��]:����$��gT����!�Id(��f�(h�
�m��j��H�B<ܥ5
�Qɸ�9���������X41���Lf��!���`��^���4~����X�@�b������qU�~v�qRo�n� �c�=���v���f0�Z�0xӰ13��a���Q�^��a/��	w)����Pv4�֝#�J]���8(l��i2(3���a�5� u��K���z�u��Ѣ�Ԡ+%���q���݁���N�3�S��!J�a�Kѓ����J�ѐ�n`�+���Abg8|�����_�&�le7K�C�&S�>�,P�b��+���];k?ן����*�w�9��I�`�kQ����֣���a�6��4#\3hsLe�h1���&���,�
�H�������� :AD��K��D�?r�:�����j��_ٙ��C�񋦛Nt�^A��
ȓ���z����a��`kIG�k�Za1q�&�6�Ypt�é�>�z�b�E�h��k��2㰔���q��n���~4&�p�P�p �qj�x��/��;6_�
��Kl�mm'&�X�n웇��@b�=��l��������F߈ud��q����)�|��r��1�~v�Ŷx����XafVI���R�r�5�o��3vdN�����)>�p��(��Ŧ���tO7�� ]I6�o�,��J�@]�eW����	�y�A��}��C��w���ه�B�b.q�R���vy�扱 n�����q��e<@�%�k�v�@A��Rs�ƋJ���pv���~S��FS��G���RȊѓ�
�����V�:����̷�z(0KW��\�+���m�֫BW5<b��*�/W�P���,�����Qp�k)ݾŵH5%����7��8�-$|������~�
��J�N{�66K���zB�S|�,ZN��-?��3��@ 2���~�-~��L�����.n�0ά�(�Wy�?�y���f<}��3�i8��OT4z�d��q�i��w�J�3��gt�����ֶ����⇨.\v��b�`3�]}���NL?N�TK-�k����t�G31K�����3�#���S8�"R0�Xg�� {q�e�Q� P�S@ �u�W ��~����6�T�Ot`B��9,hd�jo�0����́0#�|�	��t!��L�Y�iv �2���7�l���d�<K<����G*L���U �prS,�ʫ�:a7�_V�Ȁ���,���}���e�0��e;� @�u�*�4��I��6ϫݗ:I�����NZB��4R
J��Fh���f�4h.$���r���c�ay��	�u�iJ�"L������R����AG	�R��@-����D������\c�w8>�(`	�
d��������DM��S'ʎ�AQ�f��c���4��G�Q9��>�,�,��a���4��i(F���Y���9�A>q\��O2��0���A�:/¦%����q��3z��0 �9�w֨[^ ��S�u�υ��iu����?�m��l�I��t�D8��e�ܲ����m{`R"|�9�e�.���һ���d�\�H�7f���BZN�S A��dO�#�O��M6v��U��\8L��a�Y���U�~�:��[�qg �KOh�iR�2�_�*}��U ֊������q�QB���a_�=k;��BU�������Y[�U?��W��>M�Z���4ʥ��4(ĹI[�e�
��R��c����%�2�2���#����i]��齄��������
�ay!x�-�s�4
F��5����W7����O�f�D]`��k`Ӛe�E�s�1>G��m�H9�U�(2õ�Bh{Ȅ�9�֏�J�A��ʜ��a�9b�s/"�`�l�_�-0�53&O->n<�>i���A�K7� ����-����6�u��Dm�����oi����\�E.�;A |`)K�lYvk$����P��DwV�:�Raiw���?�q�����| �$AVR���m�%$������0�U�R�m(�|yz��J%��f1-ǖyp��[������$^��aU�)j�%麉.rx����M��4�>Y�N�����W����+��	�H�B�
7!�D,8̌�n��m���w��\<K�`�d���t���y�D^�BQ�1�^5��3�Bt
wt�����6�AMF�͟!��� �ݓ/�T�ZVO[QX�F��Aj�E�I�E	����m]|�Q&&�>�|��E���(�׻�ڸ���C� �i�'���y��m�l���qc�����?�yt�ji^@$���=������C���/�&�-�NU:2��"�C�3����L�jkɖ]�s�c��3�T���T{R�)U�w���ҹ�2�x�4�}A%A)LB��ϰ���� ��k���fN��i��J実�$�\�Q�c�P+m���g��UU9y'�b�}�1���d"p:Mr=J߱�K�/���5�>z^i���,@�T��̙,BD����Q��E���:\=�C� ��v��&)
zah����c� ZD��yvz������CsM�h*�)���Q�k��ns�:0����3Q*֝���P(����;��,���"��e1���4�����v]���% KNaÌ���%����l+�L�[n8!�kC��R�gI��7�:�>��SSxBi�=�%�RP��8��~�w�,-�ԅ&�j���ģ(TN`�ћ�0��Ih�� �zG�[�s�T/8fK�o���N�t�QO�TO���������鶭�������I�
�m���0:à�̵� 9�􁞒�v�Z�R��6Ԍ���-h�t{��|ٺ��v��_��Ǩ���W�z��ֶY��*Rz�h�S��w:j|�)���ڗ�	��mS�Kȍo?j�	3��x��33r��<ǔ��C��М'
�����'<��*�0We�
ʱ�]6���gK�#�\�^�#!r(K�Vq��<Ozޱ����>G�����T�&Z�srF�Lb
c�.�Ra����T����(��m7��v����T��c�>4}�݀#	\6F��ö~{�1p_��7�ʒ5<�JX@���wf�2f�c4����WtN�,0L��l�Z��kg*#WbW�`��c|�j��X��-�O�^ч,�20B�e�q�On>��(�!������c�]P�W�%(����H���)=	x$^H!�1M�\c�=6�:7y]�"1阊C't�@���g;0,@}k��Z�K�VY���>�ţ��,^~��o?	����1t����c[7�v��o;��C��9�-釺��~�Cu[����hV���"3��(���ݿEZx㲡�#˅\��Ae"����M��� ��Kl��D�A?Y��eh�ſ�ǆQM����D�Z)�r�D��p��G�ӿ������m��;�ӵσ�z����J�/{��T@    f߲➖IY�M�BzJ`%u��n�5�O<�p�3��YD���S�8\��Hq6����~��V����nZ���Q.�P��3c���5D�������́Ynq`R�Y�F��d,�
m�Nĕ�fc�o��P�'
?������眒�J�}y)_���������+��j�T.�NNX�(�u�2�d��I�Y^��C�R�.�ê���k
�h�q$av�S�x�<o>�
�v![]L+�������:)�X��#K������M�ڔ
�"��)���X�G����4�5�j�/K��Y�����6�@��^��L���1⠯Z솕ߤ���^� qGC	b�
�h�ʑ�1�ŧrG9⾃켤��d���߫��zzgX���\���)]nUY��׭ɚN�ӆ0��a\=ݞ��K꿶3�oP�qD� 0�Sn���<�[�Ε)):	*��*���џMO�r��ƅ�;����=}�M/;����U�5����<%E Z[�yVN��`��p8�u��a����rtM�G>'��s`X�X�F�F�YBy�3
M!s��ܯ#������O�}����?z���'e��Y~h��uRr +X����T�O�-��~�<kv0KOׇ�5-d����I@	��0�B����i8$wi?����9I;��e�F����� %�r��\d# ^ �����H'���d����Q�$y���.��g8��*mZx���ꨐ2P���,���
�瀔~V��O���Ԕ�穿���<�%���t:׆+�ﴄ�a8U&)�D��l�K��긩�����M׫f��K���¬��
�������pS9,��Elz���j��>/P�u&A�(}VYf�9g��b�T]���$��:$n��<����?/W0yv��A�F`�'To�5�`' ��yd�(1��/��w��:�GY/%eU��<'����X�D��(����e� J�wP*�+��_q�>U�/��xP����9����E�"�}�;��SHC�(<0�(s��)�E7�x�zp�،4��TN!6�nM���&�8V����>�8�*�MWϲ�<"�b},�yJsv��@+�-0?p?_ٖh�m��l����ܯ�i�}�wm(G���)�����l�>Q��ڽ�����'[�R�aw;���Ⱦ�AJ� #�j��֙�ܕB�47*��9����M����#6`�vz�K�NQG�hc�Ի�y,}-��g�/t�URyj���G��a���@�ߪo��X�z�>|yq%Vڕ�7 /������kyvl�=��2P�A���x�%��P �N�O��鏫foǌ��v�eCړ��"t�LO*��F*�u쿃~�H�ݪ����E��FQ&������Kp>yU���/�	彬J*S�"e-J�d�p���dђ�r�^��t۴HK���g��ZW>�=
�f��`�+$�:'J0(vA�!WZ��锇����Ah~��������d�/0�i���ˬК�Ȩ?�.�����7j5�)�c�J������dѽ?��n=?�Y�������"\Y����n��1GKU�Gܩ�I�����Nk2fE�a8��x"����Ω���Ȃ
������ꁉ�צ��2�j�k��~�������N��y}jgF&���y�0z����E>o���~�?B��^Rz�Ą_�LT�(,��H�aV�`p%l� 3�������3��O��G;��	�O:e��ho�`�]����O�E{~�����R]��1C�re��)e:�y`{���ګ�Q�K����1EY����q��퀧	L���sA�b�l;]$A�m: �,��{xmq��;�>yK|�b�̱�)��e��"�РM:�$�BKן�{���L�j�]�S��� z��9��Â=,��_�����?�_S�ܢ�Ս�S�j�CW ��:��[z�y�k��	���c�g��P�iHX���c^�|���'���,m��ֵ��F*e"C��t� ���?q����gRC幤�(�n`eF�H`Q��Meuh�NE�L���`�_	��"b�W���zgC�nlg��
,�<Ľin�d�6b�ylt�8��-8[���W�Y�Rs�A3�,Y��~C��{�f1������ pߠ��(dn�w�A�܎����cR���%��ǪŴ���.�&M!04}����0���������&�Cǌvڬ�+fo�/|n9�l,.~�����C���s����J:Iqf���,��:�5���IG(<�s;��Zi`Q���C�%�Rjwd��8�NM���.}���jۛ�:z���T!-O�P��Bh�t�ʱ�5L�C)���C	�Qf�	��!�c����wu��{��g��I�S&�k�N�6���m�N�g-5KbA�Q���:@ZK�H+v;�p~u�ϛ��k?�*�ɬ���r&�ً�J�N�TL��Y�]�e�8wˤH�^wz�"Ԟ��Y��l���D�2:�U�#�{�	��š��nn!]���g�)ǲ�F�X��)��)B�ҝ(�"��;�G���:�i)�ց�Hgq��3�����G�}��,��u$]8F||�����?zd���+sIҕJ�X3.����}҄w���O��W�bmA��^2$���Έ�[�X�����>���	J�-r%7��y]β�����=K)�P"��-����c=�U�P�iu�T�������/�2[�H6h�e��@�.`خ��s�
��(�i+4+�*>�(�Z�짶*��IF;V����@���y�@m�\��Z3}���n�r����Ł��C� `_�Y{�9���#f8�����3��,�"8͘�k,;�*����	��Y~8���@����|��.��L,�A��y4������x������f�FjU�c� �%b$���'�E�},��s�Sp�MG�ӠU!�ΐ�qez�onO\�.��Z�߾�S:���A9��Xz2����{�� ;g��p��t(��bq,�0�m0�r�W�\H�����дGe����张�����~���4�ܾxx�ޝXr.M�B�F�o�]'1�*k��V�m}����G��If��T2�
�E��.�R��1�I���6-ř�/{���t���o�ho��T�m��a�$�E>�s��!T�O�5��b�\O�5s���Zd$ �Rv&�"�(S|�e�i�n�9�	��6@�C�W���)�����w�q/�m1���p�ָ�ϓ?�[���-w5ڣ����ds>)$�1�}z?
N����C��V�*eV�J3�Bx���=��;4��
+��LQ� ���,� ��Cǔ$��c]Jᦹ�-�a��FݘS�[�yI�`�����2sSK9O�|�^7���8)��dp9:�j�}�y^���VF�߈3��9\NO�,��hmȼ�Z�d9�s�3�ë`�U�s��= 2�[��<�Cn/�<����]5���֯W����_��������~6U� (��
��Bo:�׷�����+�Gz��~n����m�(ޔ���c��c2�0�R�uFAD�s��fă����:���=��5][Ku����?�������І}q}H�9�&6\�bM�P�y�?FR�$F~=�z�]}s�_��]}�x���M	��w�����E_b�on�r�X�:�.�ZxF�h;Z��,�\d���da����,�xc)'���0d;*�iSXv�������,� �8��p/i��ڷ���Qxt�<J���pR�ZD����qۜ� ���Nk���S"4�dIT�=�{^2���Y=M��-�Z���&�pLl�����▥*:.�[NI��9�1Y8>������[����J�2	��̅�tl�]B/�q�A�^I�?��)�#�J�_sN��&�J�&�G���q��"����N(�[��,aE��A_|)� ��I!M`�$�pN^��ރ�㧼?��d��5/�]�E"T��HNY�,č����{^$p��t����/y~�Q�OgVBC]"p�D!�8�Ҧ�Z�8���@�Hd�R�z��GtI�Ʌa5���    �k���M���ycm>)�Fj�XC�ph�d��D`�겄���rʱd���xQo�5ƨ�4gh��1K蛌I:�4���$��5c�.gWHM�65�
�J2��;��m�h�h��)��)u��c@'�R����Oծ��i�)�KD�\%e�+�y�K�ނi�L{t<`[�<{C� GƱ5�#��� p�)�N�D���v������[k���"Y��-���/O���}}��C��"9�/B�<F���X�m��n����o(a��l'	Y�6 ��J.������y?��gV�LkD�%�*s尢p�M�0V�e�]��B�,7�� d\Fa���[����BY�i��&W�o���2,>'�x"˾o�Ad�3�C�w�[J����-��2��"ÌM��Y��I&���B�ar��W�����N���f�\.�zz�t\tUȒ�'e�w�e��Q���ߡTb���\��~#nt%��Gn���!�k���|�WbY�n@�*ׅmTR2A�S$_���in��=	H@!R w+��$D 	"�PLN��\���o}�LG=��F��`�g�0h8�B�?�&����	D�)���@�
s?�ٷX�۴�
�Ǡ�:PGL��,��!x���:��pP�LЙK����\C�1𸣸�@w+�He7:X1:� %I�59�ˀ��)�����V[��5Z֫ޯ��TY��+��'~~��U���eg��*E E�������<�Lw%�� �ň�/i��Z�:A+�.�
�2��	��{�fd���S�uGj�r�u��/�_nK���p�lSXe �!1����E`%1❋�����Z�~���(�T��b`5����b@;��֏��XD��0����By�W��2�s�Ǖm�ہ�W�`�K�s�S*Sz��b6ⵌl��z�mW��R&
���cT�����M�����J ��YJ	��@���5���K�=3�;.P��s�YI6�P��Y�(�F�E:��:����M_�X�8C�}p�&� ��O�N�F����Q�+��r�Q��H;�fQ���� P��a`11�'k'���ᜡ��Ȅ�iR�80��#��F>=����b�,P�МA�R0��q�i(W�"�,�(Q�I�,�}>�!r�Laӌ	��θ`qŕ�����W3�M��!��wH�YF!�x׻��vL��X��2��b�qSHh��@�.�X�������y1)���`�+����/j-6l�� Aؓy�1�^'�	�`���8��.��J�En��D�!`Rc��,K���������|���5�'���ړ�rOO��+��<�X��@�Ŧ�gK�z�W�h��:Ԗ�Bxy�	q�|n�g�m[�$�bL�R���Q�.?�����X�8EYiL���#4�1�˽�m��[�,_U��&y_s�����^Rp��М;�Y�Z�K+�EIm��M�.����L�3{�z9CtЧN�I�2ͪ}J?��B�FտC��RZ�w���b����C��G
�����
����	�������Gv�k����e���EN���{�z�C{ʪd�
f�Nѭ�:�J���NV:S�TMF�@��iw��ƥI.�g(q(L���G�*gh.�mL	��TźT�O�hU�y�˅KyC?MA����ܵ�)/Y̳_.~Ƞl��Kߠ�Q���e��!����~S�nz�Ԏς4Tf��3P��8.�-L�B(���`�}y�n����)e�x�rޤD@jBB�aZs�g��z
!��k�b���g4d��egSE��*q��J�>�	� �k�>Ir:�vxښAHs?wK!�÷�P��'TZIS�##���ε�HC?�80��8�C���M �t\�T3,�ӿ�!���cs�X�.9{	��jC����ߵ�2o�� Uhb#��S����G�/ �<����R�z�~�*�u�23I���PSd�K��Pab�����2��EX�}�짍�	l5Em��p�)����k�{E���@�6ڻY'��Ej�5S;dnD:j�Ҳ���v�9��S��R[����Q ~��Cj�V�EA��݆��9X���8����g�\z�Cxq[�s7��J4��ӱ���Ώ�bb�E�����RL"dJuK��y�KKwx��ݢ,��(�&�i��� @͛�hX=�Y:(��X�	^T�o���L��s�QQlT��?4}�Z� �K$2m�H,�msn�����*��(�3���+��J�R�y��3o˺%�
�q`(���V�M[� d81E�IoA�_���)
ˢ��|�:�HEöB�>F��"gi��wzǭ_cY .i?9#($oUz�6�K�b�����8
%Q���S��UC�V��7��_1���t�_���F����f���\�[��3x���&t�D���G(�;�q0�����oe>�y�w��MSA@uU�<5�&�TSL����oM�0U��]RYT�@GR����˺j��bo�L3_�l��t����]s�|���|{�,r��D�t�݀��m<zLdPߒrlp{��Zu�����ٰ)JG�9%�G�@�ȏ���f(���ĘD�Cuh���9����ִ�s�Mo4����y��vmì��������h�e��3:��b�lP����є�AdJ?˶��c���=�> My�����)2�����EkH�<�~W��ҳ�ym'� �v!l2��c=0\0��Pάh�
�-��'��IYk@�KE!�t �z[CT�++�j8ڂ�Υ�B5�T�n\ϹnuF���C���dY��D��7�O�n��(����އL��Q؂�*��J�=R�I:�C-5�L��,�y���a�ʞ��P���U�!��'�ȼ,K]�bF	�/��~�K�;�0��D'����%�1%�����I�B;R*��[�,�Z���+s:���ݱ���	!S3~�QLG�(�v������*ɂ�:��ȫO�
��է�S��>�wxWY���F�#���tX\�[KO��wa��O�(y(F�(�2b�/�+n��f?3$�IF�9�#׎�L�}'o:���ʫ(,�� �t)M���J%L�v���� �T��c�����G�)�*�����@�7 �X$��9��G���Kk���^��c�e�<��D�bs�ƫ6��"�,�y�����NM�+�S ޤ��#�V��-�ΏU-V��W(?L9���
T�{�^,A�c����,��<c�&
C�"/S��^L�W��|M��������1.Lx�I��Ê48)8D5��Li�-���1Ҷ4�.��LjM��<9��QS�Ņ���;�V�z��&�m����Z�l��Ax�H�9eKg	�j��k���@}�S2Ʋ%Њ>��B>�oĹ�w��:1:]�L=U �������צ�}�[>��Xz�//x�������[����>BN%�8�ev{Q:[���}th:���._�
nA�V��վKY&�5�9�(!�P��r�@Z���Wӳy��/��3]�d	 ����ݪ���b�����9���*���O6�u�*��&(��LT��*c9K �4X�y�~}��v��W�?|�d%EA��t0��ao�~�hر�O"
��yu<06��NJܳ;s=���+�y�����D��g�o0
���Lκ���������^��aQ�,�3�WD�_��&c�VAi������T�\7[�����;�������{Ր��e<��my��� ��	�e��j%�T�I��Ӷ@v2$��K��yU�졕}gSv�[�;�^�1Di�E��®�"�,��qL��=4@sU
����9N;%|Ot�P��S'nS����-�z_�z����6�u82#]Xƕ 1��UQ�Z�pr�
��tn�B;��V���OJ��(��8�cI1RZם8���;��sGlz,p2v�I�Bm��eihȁv�О�Qsh��P~��W�>.�F�Cs�R�D�+�a�������e���%� Ow�������n��w� �(�^�Uf����i"�v~���)���r�)|�B���~���p���~R�̗��"5'�{>
� �	  ����KCGR*T����q�����;���Z�*Q�+�-����s|�[Ϟ��Ҷ�1<�yh�G1n	*�N+��)��/���c���/�	QS|�ec�ꭕ�u��`�4!�\Yܦ2Jb���g_s��$FGAP9��|�G	7�R
�B��\w ���$��[�Sd�	�̓��k�9�oYu閦��a�P�+R�0��wl�������G.Q���fv!/����
v_���-,Jɼ߂K�ob�w���I��	 ��5D�l�on�w\}3�Ѿ�)�R_BJ���?Mw�Ỿ�).�²��3��ա�*��w�Gך�)w0P��3Q�+x��Ǫ���~;}���8��~�UĈ��<��MC�*�A��,�"ԣ��\�YmO�i �V�(�l!C�LX���+�3��Wb83�K�����d@f�W��;��P�Z����و*���C&1'�"�՛�\��P����f��GE�<�s�Ƒ�f��UO�Ҭ�)j��/˗��[f��wЖe��İ�Q���x��Q|X�~� M9�ƪ�<ٛv�s��t�d���E@�N�{�\����d�U�v�+ה2��4�I��J�<��(Yf�9��S�����M���O=�5#������;˥�������"wØH��y��'cr4��-�W-?D���b����j���,�XR�z��"�62��9�e��r�m���h+�̈.���1>��U\4���8�o�ˮ�%�s
�����Q.(��m���?җ�';�!О�aF&HXI�3@�h��[C9E���yn˅W~z���§X%���^?X'6Xi;JK� �1^QL_��7?�υ}��)��v-�-��C~LaWȂR�2�F����&t!� ��%l�>�WU8ԙ���x0Pa8�,���[s���6�.�zJ��K���s>�(ZԻ�%�=1l�r��\J��vC���f�83�7}��>�#չ�o � ;FGaǸ��A{X(-�"(��)����^��QfIA��ځ�L����<^��V����ǡ��;Xq��cM\C��
�@����V�y����V+����G����2Eڃ�������f@�B�_)+��:|�B����;C�i�C�pqaT���Q�2������xh�2y�Ӗ�li�z!E���xY��oP��ю�^�Z��(5}�)�+�
 �XO�z��0HzU�y�������l�x"<EE�T&���52��'�,:��d���z�z(3}-�9�>�s��|��L!��ג���,k�[�����͟�(�i��.w�
6wG�����aR)��ǥ����,��j�)���_��\��qpB�ڤ�=�߲��gv��p��#��'��j8�^���D7W���? �+S)���Ԫ�����9)�zK.�'5�x6��B��:�}�۞×"@M�Q�[<����,bx�-(m\8�ك�ݑ�qp��Y���:Y�2T�M�l�϶��Qw�����1̽ /���}�*�D`��r��N:@B���*A��0��#^���`4s�`�&�*�TYGa߸-�[��퇚 ��� �r�ť����bE*z��^*����7��TT�K��t���j���� �t%^}��0���ZϋƦd��l�|��ҏ�(�}���H�T�U��8���)�#��$�w�eTTÚͰ�8Ʒ�'��}��������w,�*�*��<����<�F�g-�LM�l2����o��ʺ��?z�d�L��;|N�9݇�ql ���͊�ꢠ#���F�ܢ]"��ή۷HfMy�~���J��o?`�msz�DC�e�ζǽ �g��4âK�2eN�K!�p�^W�w��^��[L�C���o�$-����)fː ��7b�)�ϊltN���G�$��Y.����V�Z��G�+|��3���+dO���a7����su�ieY[W����gY ��*�Lx0z�#DNeִ
���nFJ��S�Q|�ߢ
:0�����B�q5hb��������� � �}K�~Ҷ[:$����yI�`�WA���@?f��k߮���<�֩�6Ǒ~���Tzv����ebT�O6�*dNh�1���l�&���P��6bK@�'����7�pD 諁���}�ז~��[�p�:����r�#7���D�[2�+�x�%B"�z��������Cw��W��0�[��l��*��v�9|q_z68�HXr#�t`�6D�r,�Y�(v������Y!N��j�jW����7��I��lRB��#��ۗ��}��������T|4}�V������\��O�(��~��#�uoS��e���wu�c�����!������}���v���] �J��a1�����
`�ŠV�JeT��a�<�����c����?F/���@������\L��կ�b;%����>���������;�5T���أ��}}!%C���ߟf�%p,���׿��/�xW F      �      x������ � �      �      x������ � �      �   %   x�34�30�4�44BA1~\�&�P98
��qqq �{,      �   �  x��:�r9�g�W�HF�%2��o�J��m�
I�����itg&X�(�>�?�����s��S�O�K�- HRtE�b1�mx�{��������ꦔ�\��*�,�8��L&sU��T��?�֩����F(!��R�M)s)z�V�RW/��u�^��RUU���Q��U��O����d>��͇!��o�x ��A0�)*��̣.L%N�'���8A�$����A &bAܪ��Dd�s�9"6>Z6�.�Ȫ��-����G&H���J��Z��ES�2x/�4�_)q��,X��w.�|!R�5�@�>mI�G���-'��5?F�~�4��É�y�4/�Z�O�}U�b�Z[�*���*�e�N�G.�!�>R8�}Z{�=B,6���v��ߴ��������!Ԑ\�A>��Z7FC%�M��R(�,�&���?�"vcO�<v��|8=�N�H����)8pB>�1@|���c��7���lQ�|�d�6xB�D����.�8�	G])k�h�Vm/��?5�6SOz%W
�������O{��af�@��}^�=������%p��&�:;�%=ֽF�H�M���Q�h�\��J��͉����D���Y�-���C/��U�eU�����t&
Y���L!��/ �R`p�d|�r�l$�S��G��|%��rF+A&+����ē�eN�qY�+��pL�1j��*k�
�@n�a
7r�7V�������ހ��G�f�<��;�𕴰}�c���Sn2/WڤX+�!��m
V�b�2XS2�`�D@�2�}��1et�Ѩ��D~4朶���e� 7̓%��mE��&F�|�A�Qx�����q��X�� �=�,�u���܄A2��W�sE'�xBd�S�4P�=&�,�%�n�d:�7d�ś��!g���!g^��l�@J�/�����~ʭ��Mf6:�*�@Pg6	Z`��&��z��)�Zr�eK	���O�,u]r�/��%i�J/�F�ݯ�6�wu}ޏ�HuW�ZC$B������^eX��8���u3de��N�|�	b�RSm8�ٷ#����lu����F5�?�Wۄ��C{G����BLC�
"�Q���`��i��*���B�gP5w�R8�Q���KS�٫,���V�o�ߑ�oe)+t��Whf)ʮ�G���w7��o�ݪ�g�1���D~��֚�2Gyw���xRrݸ�??�"5zr�/:�t���d��;��k�^CV)�Jw�����IQ6�zw��J�㢩w�U(ӏ��9-W`c�1\�>�@���l����!ǻ�$H̯�/O�� 9�
Z@)0��W%��ȗ��s�S����,B�|�?���e���?����W�hղ�s"������s�T���za�JY�\8��=��%O�Ƙ�
�~^�����d����d3�Lb|��$Η�ĕ������M�㕊N8#z_�>kJ1>9���B�� ��D��I���˾�Ό�^6)�=�'7�}�yJ�M; �Ń�`���� p[��Ą➝�*a�vP�	R��Vg�*�v�&m��[���ڢ�#�Ƚ)m�B_ot�%0���U�@,�.A/�ƒ�%�=4KU����G+Ӆ*�i:h�9)��	<F��U�壙L989�q��V��e��$�{�Y���1U6��~x�e�p���29( �k{��pI��l��y�Imw6��Ԭt���Z(vg;_��U�n�݉?_�yG.9q�d��#��5��e/���
j?p�l�:#����x�Ta��83��'��!��3���b�j�6o}��	N��j�Ɋ&�'#�*oH�aH$�1ۣaDZB9����y�d ��Qĳ.��kU���QI	W�G	�ٻl"ō�q��a�7ڣ1�x��i��U��S<�b\BR_��o�>�(��G�w���hxޱm�7{nAC�vY�X������2���ř8�ʠ�f*ש4W�G��|[�f��Zg96�-�4l��8/E���b�9��E�j\(@�@]%�X����U61�M�C�=1���и�{bk`p�)pq4NMC9�A/�x_�d���M���L�Xv�j.Y��!��6�b���}I6tt�S��;h��b�
U'>�?����r����Oᩉ����)!�҂'=�r��$����
��_���L�u��zµ'��G��} 0�OZ���mS�$V�/wFP:^���ʗ��pv�r6�D�m���Q@`~�@@�j�)����%4�BsSc}ݤp�h�D��XvzQ)���Wrp����U��$�$\@m!�B�$�e�y��ơ��i���!x#�m�W�F�d�Ǩ$	@&>/ڳvwI�SקݺYS%jh�?�j-3+n�R��B�b����AlwX��3]�%n{-a����bZr( /�b�w�q��EG�}�mg$z��
��Ѐ؅�8��P|#��4���!GɿO��Ƭ�	���z6�iɹD�'] C����w����F�g�C��5U�_��y��[8X�v�}��l���i����`N��d3	�g޺j'����h�LY�<��_)�À�uZ��`C��[��NM�������e�����k)le�Qƭ/�� �?�ݒ�s�t�`�c2�"�^A�S9ɧ Y�
<������U�����W`o+�h�GxOG�Gp(��}�EI���k��P� �۞*&�5���ZV�t�;����pWZ�K�q���6/B�v��D�rI��8@�/%���lx�[ȸB�}Fkb�����*H6��m��O[�������v���8��ϻ��ha��j�y�U$�?y��C֝"����;·f��#����0o9Z�������A���(�.d��N�]���ݻ�ׇ�?/��+��ˉ{lD�~���#�k��	e�e�69^m�]��~@�:Pڄ����U��_�F� ���5���ޔݳ�:-̚'�nq�}�^�Te-)���M��!�V����47�5��)��Qq	{ޟ�59:-�wM��L
z��n	b���ע�5/lx�ƻ?���7���[7����}�A��*q��5R~J�Ӿx���(n�Rz�� 3fME���'y(q��FA��΂�O�/jà^���'a���� �������eS�2�D�AF0��w��3(������J��
\q�ـ��h���U�8�"�X�wK;@h�)��;���G�2��ӈ�OB��H��\��}�T�V
�l�B�G���R�J�m�鬾˪XK���x6Mn��^
陓{
4?�b?�i����h�a�
�O��p�m����g����Ƴ�������E�E����~��9�ف��Y�P}�юL�6ʮ.��Y�������Um�t6��W��%�ń�/�v�����)�R,�����r�}���Z���\�vDwx��Z�2�uZ:����R�F��AϞ�fu�?�@�Z}t���h���J�����^@��sM��#Z�j^5^i;�P1u���WЫ�@��|���5�)��P��L_��N��
&����q+�DȤ�E�r��(�D�ԉ[�*�}�b_��Ǿ�l���(=��+u�����G�����^��	5�7ʲh|�afQq�����~{�O� Rq�?����4�EP�`���4C.�-��ܻ��1��YuP�6�XSL�j�S#onBY���y��tЃ�1
ٌl�Ƌi�~14.�xY�_{B~��� ��z(G~5��yOq�,���$��~aS�!���D�'�IU[��|�^�E�+Gx�<a��ޅ�]3��֚:3��u���@V�"l�0�_:F�K-��-�N^ˋh�����d-^Z2�m`/8/���me�uS��FA�L���7{���!��QV~�i�0�Y?6�cНFDxi�����ʀ���ܺ�ŷ���~v8��74`Ӈ��>����v��7�[?	:*�g�`���7^|A� �ϝ�a��X�Q{^f�-.�9���:�DKGm�����Y�2�Ș�uG�����RF^���������+h�      �   �   x�5�M�0��u{��@�iA�]j�+6���R�o�Y��%��3��L��
��FЅ-�E%+�[��*��"����e�J��E�<$����(����ѽ�1@?���)%�Jώ��x�Fq��{VO�ͅ���.$����aJ�f��mx+9�?��3      �      x������ � �      �   ^   x��4566�42454�411�0 N�̔ĔT+��*���bǜ��bΠ�DN�Č�DNǔ��ļD����T�RNsCMK#]c3KC�=... C��      �   M   x�3417�30�4��? ad`h�k`�k`�`h`e`aed�gajU�RVg��B�%@h�i e�T��%�.�=... ްN      �      x������ � �      �      x�3417�30�441� �\1z\\\ *]      �      x�3417�30�441��\1z\\\ *g�      �   �   x�m�1�@Ek�{�"����D��6�d�e��,��XXYy���@b������t6��IAN:�A��G���4���ÓD�ڪ���P�b9�����7#��ÚT���AГ�A-�C�.����o�g��l>f��o�}�.[hL��(� w<8�d����t��3<Ho+��sxՃa>�Z9�C��i��� ��^      �   w  x�]��n�0�g�S�	��Di�HI� C�N]��8�v.C�>��.��O?R��L�yܦ�y�q[_��|_W�n��k��9E�9U�D|��5�*�(ɳ���H���M>�$2�A�L!�֞�N�r}d�vR+�`�y�Jv��V�f�
���Ų�	JFeP%���ڴ�����{m��?7ִ.��%��@�ʒ�������H�N(i�j�گ�Bv�Y��ާm[n��ty��uT�߽ҙ���͒��-#x�� �����K�j+XG䂀w����iv�u޶�����ӭ�v~���p�����c^�i0dBN���"�F�.ږ�1�l�'Tu�W�!�Lʮ?��M�
L��}�O��7��t     