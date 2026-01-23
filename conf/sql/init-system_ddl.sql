create table sys_gen_table
(
    table_id          bigint                            not null
        constraint sys_gen_table_pk
            primary key,
    data_name         varchar(200)  default ''::character varying,
    table_name        varchar(200)  default ''::character varying,
    table_comment     varchar(500)  default ''::character varying,
    sub_table_name    varchar(64)   default ''::character varying,
    sub_table_fk_name varchar(64)   default ''::character varying,
    class_name        varchar(100)  default ''::character varying,
    tpl_category      varchar(200)  default 'crud'::character varying,
    package_name      varchar(100)  default NULL::character varying,
    module_name       varchar(30)   default NULL::character varying,
    business_name     varchar(30)   default NULL::character varying,
    function_name     varchar(50)   default NULL::character varying,
    function_author   varchar(50)   default NULL::character varying,
    gen_type          char          default '0'::bpchar not null,
    gen_path          varchar(200)  default '/'::character varying,
    options           varchar(1000) default NULL::character varying,
    create_dept       bigint,
    create_by         bigint,
    create_time       timestamp,
    update_by         bigint,
    update_time       timestamp,
    remark            varchar(500)  default NULL::character varying
);

comment on table sys_gen_table is '代码生成业务表';

comment on column sys_gen_table.table_id is '编号';

comment on column sys_gen_table.data_name is '数据源名称';

comment on column sys_gen_table.table_name is '表名称';

comment on column sys_gen_table.table_comment is '表描述';

comment on column sys_gen_table.sub_table_name is '关联子表的表名';

comment on column sys_gen_table.sub_table_fk_name is '子表关联的外键名';

comment on column sys_gen_table.class_name is '实体类名称';

comment on column sys_gen_table.tpl_category is '使用的模板（CRUD单表操作 TREE树表操作）';

comment on column sys_gen_table.package_name is '生成包路径';

comment on column sys_gen_table.module_name is '生成模块名';

comment on column sys_gen_table.business_name is '生成业务名';

comment on column sys_gen_table.function_name is '生成功能名';

comment on column sys_gen_table.function_author is '生成功能作者';

comment on column sys_gen_table.gen_type is '生成代码方式（0zip压缩包 1自定义路径）';

comment on column sys_gen_table.gen_path is '生成路径（不填默认项目路径）';

comment on column sys_gen_table.options is '其它生成选项';

comment on column sys_gen_table.create_dept is '创建部门';

comment on column sys_gen_table.create_by is '创建者';

comment on column sys_gen_table.create_time is '创建时间';

comment on column sys_gen_table.update_by is '更新者';

comment on column sys_gen_table.update_time is '更新时间';

comment on column sys_gen_table.remark is '备注';


create table sys_gen_table_column
(
    column_id      bigint not null
        constraint sys_gen_table_column_pk
            primary key,
    table_id       bigint,
    column_name    varchar(200) default NULL::character varying,
    column_comment varchar(500) default NULL::character varying,
    column_type    varchar(100) default NULL::character varying,
    java_type      varchar(500) default NULL::character varying,
    java_field     varchar(200) default NULL::character varying,
    is_pk          char         default NULL::bpchar,
    is_increment   char         default NULL::bpchar,
    is_required    char         default NULL::bpchar,
    is_insert      char         default NULL::bpchar,
    is_edit        char         default NULL::bpchar,
    is_list        char         default NULL::bpchar,
    is_query       char         default NULL::bpchar,
    query_type     varchar(200) default 'EQ'::character varying,
    html_type      varchar(200) default NULL::character varying,
    dict_type      varchar(200) default ''::character varying,
    sort           integer,
    create_dept    bigint,
    create_by      bigint,
    create_time    timestamp,
    update_by      bigint,
    update_time    timestamp
);

comment on table sys_gen_table_column is '代码生成业务表字段';

comment on column sys_gen_table_column.column_id is '编号';

comment on column sys_gen_table_column.table_id is '归属表编号';

comment on column sys_gen_table_column.column_name is '列名称';

comment on column sys_gen_table_column.column_comment is '列描述';

comment on column sys_gen_table_column.column_type is '列类型';

comment on column sys_gen_table_column.java_type is 'JAVA类型';

comment on column sys_gen_table_column.java_field is 'JAVA字段名';

comment on column sys_gen_table_column.is_pk is '是否主键（1是）';

comment on column sys_gen_table_column.is_increment is '是否自增（1是）';

comment on column sys_gen_table_column.is_required is '是否必填（1是）';

comment on column sys_gen_table_column.is_insert is '是否为插入字段（1是）';

comment on column sys_gen_table_column.is_edit is '是否编辑字段（1是）';

comment on column sys_gen_table_column.is_list is '是否列表字段（1是）';

comment on column sys_gen_table_column.is_query is '是否查询字段（1是）';

comment on column sys_gen_table_column.query_type is '查询方式（等于、不等于、大于、小于、范围）';

comment on column sys_gen_table_column.html_type is '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）';

comment on column sys_gen_table_column.dict_type is '字典类型';

comment on column sys_gen_table_column.sort is '排序';

comment on column sys_gen_table_column.create_dept is '创建部门';

comment on column sys_gen_table_column.create_by is '创建者';

comment on column sys_gen_table_column.create_time is '创建时间';

comment on column sys_gen_table_column.update_by is '更新者';

comment on column sys_gen_table_column.update_time is '更新时间';


create table sys_dept
(
    dept_id       bigint not null
        constraint sys_dept_pk
            primary key,
    tenant_id     varchar(20)  default '000000'::character varying,
    parent_id     bigint       default 0,
    ancestors     varchar(500) default ''::character varying,
    dept_name     varchar(30)  default ''::character varying,
    dept_category varchar(100) default NULL::character varying,
    order_num     integer      default 0,
    leader        bigint,
    phone         varchar(11)  default NULL::character varying,
    email         varchar(50)  default NULL::character varying,
    status        char         default '1'::bpchar,
    is_deleted    char         default '0'::bpchar,
    create_dept   bigint,
    create_by     bigint,
    create_time   timestamp,
    update_by     bigint,
    update_time   timestamp
);

comment on table sys_dept is '部门表';

comment on column sys_dept.dept_id is '部门ID';

comment on column sys_dept.tenant_id is '租户编号';

comment on column sys_dept.parent_id is '父部门ID';

comment on column sys_dept.ancestors is '祖级列表';

comment on column sys_dept.dept_name is '部门名称';

comment on column sys_dept.dept_category is '部门类别编码';

comment on column sys_dept.order_num is '显示顺序';

comment on column sys_dept.leader is '负责人';

comment on column sys_dept.phone is '联系电话';

comment on column sys_dept.email is '邮箱';

comment on column sys_dept.status is '部门状态（0停用 1正常）';

comment on column sys_dept.is_deleted is '删除标志（0未删除 1已删除）';

comment on column sys_dept.create_dept is '创建部门';

comment on column sys_dept.create_by is '创建者';

comment on column sys_dept.create_time is '创建时间';

comment on column sys_dept.update_by is '更新者';

comment on column sys_dept.update_time is '更新时间';


create table sys_menu
(
    menu_id     bigint      not null
        constraint sys_menu_pk
            primary key,
    menu_name   varchar(50) not null,
    parent_id   bigint       default 0,
    order_num   integer      default 0,
    path        varchar(200) default ''::character varying,
    component   varchar(255) default NULL::character varying,
    query_param varchar(255) default NULL::character varying,
    is_frame    char         default '0'::bpchar,
    is_cache    char         default '1'::bpchar,
    menu_type   char         default ''::bpchar,
    visible     char         default '1'::bpchar,
    status      char         default '1'::bpchar,
    perms       varchar(100) default NULL::character varying,
    icon        varchar(100) default '#'::character varying,
    create_dept bigint,
    create_by   bigint,
    create_time timestamp,
    update_by   bigint,
    update_time timestamp,
    remark      varchar(500) default ''::character varying
);

comment on table sys_menu is '菜单权限表';

comment on column sys_menu.menu_id is '菜单ID';

comment on column sys_menu.menu_name is '菜单名称';

comment on column sys_menu.parent_id is '父菜单ID';

comment on column sys_menu.order_num is '显示顺序';

comment on column sys_menu.path is '路由地址';

comment on column sys_menu.component is '组件路径';

comment on column sys_menu.query_param is '路由参数';

comment on column sys_menu.is_frame is '是否为外链（0否 1是）';

comment on column sys_menu.is_cache is '是否缓存（0不缓存 1缓存）';

comment on column sys_menu.menu_type is '菜单类型（M目录 C菜单 F按钮）';

comment on column sys_menu.visible is '显示状态（0隐藏 1显示）';

comment on column sys_menu.status is '菜单状态（0停用 1正常）';

comment on column sys_menu.perms is '权限标识';

comment on column sys_menu.icon is '菜单图标';

comment on column sys_menu.create_dept is '创建部门';

comment on column sys_menu.create_by is '创建者';

comment on column sys_menu.create_time is '创建时间';

comment on column sys_menu.update_by is '更新者';

comment on column sys_menu.update_time is '更新时间';

comment on column sys_menu.remark is '备注';



create table sys_notice
(
    notice_id      bigint      not null
        constraint sys_notice_pk
            primary key,
    tenant_id      varchar(20)  default '000000'::character varying,
    notice_title   varchar(50) not null,
    notice_type    char        not null,
    notice_content text,
    status         char         default '1'::bpchar,
    create_dept    bigint,
    create_by      bigint,
    create_time    timestamp,
    update_by      bigint,
    update_time    timestamp,
    remark         varchar(255) default NULL::character varying
);

comment on table sys_notice is '通知公告表';

comment on column sys_notice.notice_id is '公告ID';

comment on column sys_notice.tenant_id is '租户编号';

comment on column sys_notice.notice_title is '公告标题';

comment on column sys_notice.notice_type is '公告类型（1通知 2公告）';

comment on column sys_notice.notice_content is '公告内容';

comment on column sys_notice.status is '公告状态（0关闭 1正常）';

comment on column sys_notice.create_dept is '创建部门';

comment on column sys_notice.create_by is '创建者';

comment on column sys_notice.create_time is '创建时间';

comment on column sys_notice.update_by is '更新者';

comment on column sys_notice.update_time is '更新时间';

comment on column sys_notice.remark is '备注';


create table sys_post
(
    post_id       bigint      not null
        constraint sys_post_pk
            primary key,
    tenant_id     varchar(20)  default '000000'::character varying,
    dept_id       bigint,
    post_code     varchar(64)  not null,
    post_category varchar(100) default NULL::character varying,
    post_name     varchar(50)  not null,
    post_sort     integer      not null,
    status        char         default '1' not null,
    create_dept   bigint,
    create_by     bigint,
    create_time   timestamp,
    update_by     bigint,
    update_time   timestamp,
    remark        varchar(500) default NULL::character varying
);

comment on table sys_post is '岗位信息表';

comment on column sys_post.post_id is '岗位ID';

comment on column sys_post.tenant_id is '租户编号';

comment on column sys_post.dept_id is '部门id';

comment on column sys_post.post_code is '岗位编码';

comment on column sys_post.post_category is '岗位类别编码';

comment on column sys_post.post_name is '岗位名称';

comment on column sys_post.post_sort is '显示顺序';

comment on column sys_post.status is '状态（0停用 1正常）';

comment on column sys_post.create_dept is '创建部门';

comment on column sys_post.create_by is '创建者';

comment on column sys_post.create_time is '创建时间';

comment on column sys_post.update_by is '更新者';

comment on column sys_post.update_time is '更新时间';

comment on column sys_post.remark is '备注';


create table sys_role
(
    role_id             bigint       not null
        constraint sys_role_pk
            primary key,
    tenant_id           varchar(20)  default '000000'::character varying,
    role_name           varchar(30)  not null,
    role_key            varchar(100) not null,
    role_sort           integer      not null,
    data_scope          char         default '1'::bpchar,
    menu_check_strictly boolean      default true,
    dept_check_strictly boolean      default true,
    status              char         default '1'::bpchar,
    is_deleted          char         default '1'::bpchar,
    create_dept         bigint,
    create_by           bigint,
    create_time         timestamp,
    update_by           bigint,
    update_time         timestamp,
    remark              varchar(500) default NULL::character varying
);

comment on table sys_role is '角色信息表';

comment on column sys_role.role_id is '角色ID';

comment on column sys_role.tenant_id is '租户编号';

comment on column sys_role.role_name is '角色名称';

comment on column sys_role.role_key is '角色权限字符串';

comment on column sys_role.role_sort is '显示顺序';

comment on column sys_role.data_scope is '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限 5：仅本人数据权限 6：部门及以下或本人数据权限）';

comment on column sys_role.menu_check_strictly is '菜单树选择项是否关联显示';

comment on column sys_role.dept_check_strictly is '部门树选择项是否关联显示';

comment on column sys_role.status is '角色状态（0停用 1正常）';

comment on column sys_role.is_deleted is '删除标志（0未删除 1已删除）';

comment on column sys_role.create_dept is '创建部门';

comment on column sys_role.create_by is '创建者';

comment on column sys_role.create_time is '创建时间';

comment on column sys_role.update_by is '更新者';

comment on column sys_role.update_time is '更新时间';

comment on column sys_role.remark is '备注';


create table sys_role_dept
(
    role_id bigint not null,
    dept_id bigint not null,
    constraint sys_role_dept_pk
        primary key (role_id, dept_id)
);

comment on table sys_role_dept is '角色和部门关联表';

comment on column sys_role_dept.role_id is '角色ID';

comment on column sys_role_dept.dept_id is '部门ID';

create table sys_role_menu
(
    role_id bigint not null,
    menu_id bigint not null,
    constraint sys_role_menu_pk
        primary key (role_id, menu_id)
);

comment on table sys_role_menu is '角色和菜单关联表';

comment on column sys_role_menu.role_id is '角色ID';

comment on column sys_role_menu.menu_id is '菜单ID';

create table sys_tenant
(
    id                bigint      not null
        constraint pk_sys_tenant
            primary key,
    tenant_id         varchar(20) not null,
    contact_user_name varchar(20)  default NULL::character varying,
    contact_phone     varchar(20)  default NULL::character varying,
    company_name      varchar(30)  default NULL::character varying,
    license_number    varchar(30)  default NULL::character varying,
    address           varchar(200) default NULL::character varying,
    intro             varchar(200) default NULL::character varying,
    domain            varchar(200) default NULL::character varying,
    remark            varchar(200) default NULL::character varying,
    package_id        bigint,
    expire_time       timestamp,
    account_count     integer      default '-1'::integer,
    status            char         default '1'::bpchar,
    is_deleted        char         default '1'::bpchar,
    create_dept       bigint,
    create_by         bigint,
    create_time       timestamp,
    update_by         bigint,
    update_time       timestamp
);

comment on table sys_tenant is '租户表';

comment on column sys_tenant.tenant_id is '租户编号';

comment on column sys_tenant.contact_phone is '联系电话';

comment on column sys_tenant.company_name is '联系人';

comment on column sys_tenant.license_number is '统一社会信用代码';

comment on column sys_tenant.address is '地址';

comment on column sys_tenant.intro is '企业简介';

comment on column sys_tenant.domain is '域名';

comment on column sys_tenant.remark is '备注';

comment on column sys_tenant.package_id is '租户套餐编号';

comment on column sys_tenant.expire_time is '过期时间';

comment on column sys_tenant.account_count is '用户数量（-1不限制）';

comment on column sys_tenant.status is '租户状态（0停用 1删除）';

comment on column sys_tenant.is_deleted is '删除标志（0未删除 1已删除）';

comment on column sys_tenant.create_dept is '创建部门';

comment on column sys_tenant.create_by is '创建者';

comment on column sys_tenant.create_time is '创建时间';

comment on column sys_tenant.update_by is '更新者';

comment on column sys_tenant.update_time is '更新时间';


create table sys_tenant_package
(
    package_id          bigint not null
        constraint pk_sys_tenant_package
            primary key,
    package_name        varchar(20)   default ''::character varying,
    menu_ids            varchar(3000) default ''::character varying,
    remark              varchar(200)  default ''::character varying,
    menu_check_strictly boolean       default true,
    status              char          default '1'::bpchar,
    is_deleted          char          default '1'::bpchar,
    create_dept         bigint,
    create_by           bigint,
    create_time         timestamp,
    update_by           bigint,
    update_time         timestamp
);

comment on table sys_tenant_package is '租户套餐表';

comment on column sys_tenant_package.package_id is '租户套餐id';

comment on column sys_tenant_package.package_name is '套餐名称';

comment on column sys_tenant_package.menu_ids is '关联菜单id';

comment on column sys_tenant_package.remark is '备注';

comment on column sys_tenant_package.status is '状态（0停用 1删除）';

comment on column sys_tenant_package.is_deleted is '删除标志（0未删除 1已删除）';

comment on column sys_tenant_package.create_dept is '创建部门';

comment on column sys_tenant_package.create_by is '创建者';

comment on column sys_tenant_package.create_time is '创建时间';

comment on column sys_tenant_package.update_by is '更新者';

comment on column sys_tenant_package.update_time is '更新时间';



create table sys_user
(
    user_id     bigint      not null
        constraint sys_user_pk
            primary key,
    tenant_id   varchar(20)  default '000000'::character varying,
    dept_id     bigint,
    user_name   varchar(30) not null,
    nick_name   varchar(30) not null,
    user_type   varchar(10)  default 'sys_user'::character varying,
    email       varchar(50)  default ''::character varying,
    phonenumber varchar(11)  default ''::character varying,
    gender      char         default '2'::bpchar,
    avatar      bigint,
    password    varchar(100) default ''::character varying,
    status      char         default '1'::bpchar,
    is_deleted  char         default '1'::bpchar,
    login_ip    varchar(128) default ''::character varying,
    login_date  timestamp,
    create_dept bigint,
    create_by   bigint,
    create_time timestamp,
    update_by   bigint,
    update_time timestamp,
    remark      varchar(500) default NULL::character varying
);

comment on table sys_user is '用户信息表';

comment on column sys_user.user_id is '用户ID';

comment on column sys_user.tenant_id is '租户编号';

comment on column sys_user.dept_id is '部门ID';

comment on column sys_user.user_name is '用户账号';

comment on column sys_user.nick_name is '用户昵称';

comment on column sys_user.user_type is '用户类型（sys_user系统用户）';

comment on column sys_user.email is '用户邮箱';

comment on column sys_user.phonenumber is '手机号码';

comment on column sys_user.gender is '用户性别（0女 1男 2未知）';

comment on column sys_user.avatar is '头像地址';

comment on column sys_user.password is '密码';

comment on column sys_user.status is '帐号状态（0停用 1删除）';

comment on column sys_user.is_deleted is '删除标志（0未删除 1已删除）';

comment on column sys_user.login_ip is '最后登陆IP';

comment on column sys_user.login_date is '最后登陆时间';

comment on column sys_user.create_dept is '创建部门';

comment on column sys_user.create_by is '创建者';

comment on column sys_user.create_time is '创建时间';

comment on column sys_user.update_by is '更新者';

comment on column sys_user.update_time is '更新时间';

comment on column sys_user.remark is '备注';



create table sys_user_post
(
    user_id bigint not null,
    post_id bigint not null,
    constraint sys_user_post_pk
        primary key (user_id, post_id)
);

comment on table sys_user_post is '用户与岗位关联表';

comment on column sys_user_post.user_id is '用户ID';

comment on column sys_user_post.post_id is '岗位ID';



create table sys_user_role
(
    user_id bigint not null,
    role_id bigint not null,
    constraint sys_user_role_pk
        primary key (user_id, role_id)
);

comment on table sys_user_role is '用户和角色关联表';

comment on column sys_user_role.user_id is '用户ID';

comment on column sys_user_role.role_id is '角色ID';

