create table t_temp
(
    id          bigint not null
        constraint t_temp_pk
            primary key,
    status      char default '1'::bpchar,
    is_deleted  char default '0'::bpchar,
    create_dept bigint,
    create_by   bigint,
    create_time timestamp,
    update_by   bigint,
    update_time timestamp
);

comment on table public.t_temp is '表名称';

comment on column public.t_temp.id is '主键';

comment on column public.t_temp.status is '状态（0停用 1正常）';

comment on column public.t_temp.is_deleted is '删除标志（0未删除 1已删除）';

comment on column public.t_temp.create_dept is '创建部门';

comment on column public.t_temp.create_by is '创建者';

comment on column public.t_temp.create_time is '创建时间';

comment on column public.t_temp.update_by is '更新者';

comment on column public.t_temp.update_time is '更新时间';


create table base_client
(
    id             bigint not null
        constraint base_client_pk
            primary key,
    client_id      varchar(64)  default ''::character varying,
    client_key     varchar(32)  default ''::character varying,
    client_secret  varchar(255) default ''::character varying,
    grant_type     varchar(255) default ''::character varying,
    device_type    varchar(32)  default ''::character varying,
    active_timeout integer      default 1800,
    timeout        integer      default 604800,
    status         char         default '1'::bpchar,
    is_deleted     char         default '1'::bpchar,
    create_dept    bigint,
    create_by      bigint,
    create_time    timestamp,
    update_by      bigint,
    update_time    timestamp
);

comment on table base_client is '系统授权表';

comment on column base_client.id is '主键';

comment on column base_client.client_id is '客户端id';

comment on column base_client.client_key is '客户端key';

comment on column base_client.client_secret is '客户端秘钥';

comment on column base_client.grant_type is '授权类型';

comment on column base_client.device_type is '设备类型';

comment on column base_client.active_timeout is 'token活跃超时时间';

comment on column base_client.timeout is 'token固定超时';

comment on column base_client.status is '状态（0停用 1正常）';

comment on column base_client.is_deleted is '删除标志（0未删除 1已删除）';

comment on column base_client.create_dept is '创建部门';

comment on column base_client.create_by is '创建者';

comment on column base_client.create_time is '创建时间';

comment on column base_client.update_by is '更新者';

comment on column base_client.update_time is '更新时间';


create table base_config
(
    config_id    bigint not null
        constraint base_config_pk
            primary key,
    tenant_id    varchar(20)  default '000000'::character varying,
    config_name  varchar(100) default ''::character varying,
    config_key   varchar(100) default ''::character varying,
    config_value varchar(500) default ''::character varying,
    config_type  char         default 'N'::bpchar,
    create_dept  bigint,
    create_by    bigint,
    create_time  timestamp,
    update_by    bigint,
    update_time  timestamp,
    remark       varchar(500) default NULL::character varying
);

comment on table base_config is '参数配置表';

comment on column base_config.config_id is '参数主键';

comment on column base_config.tenant_id is '租户编号';

comment on column base_config.config_name is '参数名称';

comment on column base_config.config_key is '参数键名';

comment on column base_config.config_value is '参数键值';

comment on column base_config.config_type is '系统内置（Y是 N否）';

comment on column base_config.create_dept is '创建部门';

comment on column base_config.create_by is '创建者';

comment on column base_config.create_time is '创建时间';

comment on column base_config.update_by is '更新者';

comment on column base_config.update_time is '更新时间';

comment on column base_config.remark is '备注';


create table base_dict_data
(
    dict_code   bigint not null
        constraint base_dict_data_pk
            primary key,
    tenant_id   varchar(20)  default '000000'::character varying,
    dict_sort   integer      default 0,
    dict_label  varchar(100) default ''::character varying,
    dict_value  varchar(100) default ''::character varying,
    dict_type   varchar(100) default ''::character varying,
    css_class   varchar(100) default NULL::character varying,
    list_class  varchar(100) default NULL::character varying,
    is_default  char         default 'N'::bpchar,
    create_dept bigint,
    create_by   bigint,
    create_time timestamp,
    update_by   bigint,
    update_time timestamp,
    remark      varchar(500) default NULL::character varying
);

comment on table base_dict_data is '字典数据表';

comment on column base_dict_data.dict_code is '字典编码';

comment on column base_dict_data.dict_sort is '字典排序';

comment on column base_dict_data.dict_label is '字典标签';

comment on column base_dict_data.dict_value is '字典键值';

comment on column base_dict_data.dict_type is '字典类型';

comment on column base_dict_data.css_class is '样式属性（其他样式扩展）';

comment on column base_dict_data.list_class is '表格回显样式';

comment on column base_dict_data.is_default is '是否默认（Y是 N否）';

comment on column base_dict_data.create_dept is '创建部门';

comment on column base_dict_data.create_by is '创建者';

comment on column base_dict_data.create_time is '创建时间';

comment on column base_dict_data.update_by is '更新者';

comment on column base_dict_data.update_time is '更新时间';

comment on column base_dict_data.remark is '备注';


create table base_dict_type
(
    dict_id     bigint not null
        constraint base_dict_type_pk
            primary key,
    tenant_id   varchar(20)  default '000000'::character varying,
    dict_name   varchar(100) default ''::character varying,
    dict_type   varchar(100) default ''::character varying,
    create_dept bigint,
    create_by   bigint,
    create_time timestamp,
    update_by   bigint,
    update_time timestamp,
    remark      varchar(500) default NULL::character varying
);

comment on table base_dict_type is '字典类型表';

comment on column base_dict_type.dict_id is '字典主键';

comment on column base_dict_type.tenant_id is '租户编号';

comment on column base_dict_type.dict_name is '字典名称';

comment on column base_dict_type.dict_type is '字典类型';

comment on column base_dict_type.create_dept is '创建部门';

comment on column base_dict_type.create_by is '创建者';

comment on column base_dict_type.create_time is '创建时间';

comment on column base_dict_type.update_by is '更新者';

comment on column base_dict_type.update_time is '更新时间';

comment on column base_dict_type.remark is '备注';

create unique index base_dict_type_index1
    on base_dict_type (tenant_id, dict_type);


create table base_logininfor
(
    info_id        bigint not null
        constraint base_logininfor_pk
            primary key,
    tenant_id      varchar(20)  default '000000'::character varying,
    user_name      varchar(50)  default ''::character varying,
    client_key     varchar(32)  default ''::character varying,
    device_type    varchar(32)  default ''::character varying,
    ipaddr         varchar(128) default ''::character varying,
    login_location varchar(255) default ''::character varying,
    browser        varchar(50)  default ''::character varying,
    os             varchar(50)  default ''::character varying,
    status         char         default '1'::bpchar,
    msg            varchar(255) default ''::character varying,
    login_time     timestamp
);

comment on table base_logininfor is '系统访问记录';

comment on column base_logininfor.info_id is '访问ID';

comment on column base_logininfor.tenant_id is '租户编号';

comment on column base_logininfor.user_name is '用户账号';

comment on column base_logininfor.client_key is '客户端';

comment on column base_logininfor.device_type is '设备类型';

comment on column base_logininfor.ipaddr is '登录IP地址';

comment on column base_logininfor.login_location is '登录地点';

comment on column base_logininfor.browser is '浏览器类型';

comment on column base_logininfor.os is '操作系统';

comment on column base_logininfor.status is '登录状态（0失败 1成功）';

comment on column base_logininfor.msg is '提示消息';

comment on column base_logininfor.login_time is '访问时间';

create index idx_base_logininfor_s
    on base_logininfor (status);

create index idx_base_logininfor_lt
    on base_logininfor (login_time);



create table base_oper_log
(
    oper_id        bigint not null
        constraint base_oper_log_pk
            primary key,
    tenant_id      varchar(20)   default '000000'::character varying,
    title          varchar(50)   default ''::character varying,
    business_type  integer       default 0,
    method         varchar(100)  default ''::character varying,
    request_method varchar(10)   default ''::character varying,
    operator_type  integer       default 0,
    oper_name      varchar(50)   default ''::character varying,
    dept_name      varchar(50)   default ''::character varying,
    oper_url       varchar(255)  default ''::character varying,
    oper_ip        varchar(128)  default ''::character varying,
    oper_location  varchar(255)  default ''::character varying,
    oper_param     varchar(4000) default ''::character varying,
    json_result    varchar(4000) default ''::character varying,
    status         integer       default 1,
    error_msg      varchar(4000) default ''::character varying,
    oper_time      timestamp,
    cost_time      bigint        default 0
);

comment on table base_oper_log is '操作日志记录';

comment on column base_oper_log.oper_id is '日志主键';

comment on column base_oper_log.tenant_id is '租户编号';

comment on column base_oper_log.title is '模块标题';

comment on column base_oper_log.business_type is '业务类型（0其它 1新增 2修改 3删除）';

comment on column base_oper_log.method is '方法名称';

comment on column base_oper_log.request_method is '请求方式';

comment on column base_oper_log.operator_type is '操作类别（0其它 1后台用户 2手机端用户）';

comment on column base_oper_log.oper_name is '操作人员';

comment on column base_oper_log.dept_name is '部门名称';

comment on column base_oper_log.oper_url is '请求URL';

comment on column base_oper_log.oper_ip is '主机地址';

comment on column base_oper_log.oper_location is '操作地点';

comment on column base_oper_log.oper_param is '请求参数';

comment on column base_oper_log.json_result is '返回参数';

comment on column base_oper_log.status is '操作状态（0异常 1正常）';

comment on column base_oper_log.error_msg is '错误消息';

comment on column base_oper_log.oper_time is '操作时间';

comment on column base_oper_log.cost_time is '消耗时间';


create index idx_base_oper_log_bt
    on base_oper_log (business_type);

create index idx_base_oper_log_s
    on base_oper_log (status);

create index idx_base_oper_log_ot
    on base_oper_log (oper_time);



create table base_oss
(
    oss_id        bigint                                     not null
        constraint base_oss_pk
            primary key,
    tenant_id     varchar(20)  default '000000'::character varying,
    file_name     varchar(255) default ''::character varying not null,
    original_name varchar(255) default ''::character varying not null,
    file_suffix   varchar(10)  default ''::character varying not null,
    url           varchar(500) default ''::character varying not null,
    ext1          varchar(500) default ''::character varying,
    create_dept   bigint,
    create_by     bigint,
    create_time   timestamp,
    update_by     bigint,
    update_time   timestamp,
    service       varchar(20)  default 'minio'::character varying
);

comment on table base_oss is 'OSS对象存储表';

comment on column base_oss.oss_id is '对象存储主键';

comment on column base_oss.tenant_id is '租户编码';

comment on column base_oss.file_name is '文件名';

comment on column base_oss.original_name is '原名';

comment on column base_oss.file_suffix is '文件后缀名';

comment on column base_oss.url is 'URL地址';

comment on column base_oss.ext1 is '扩展字段';

comment on column base_oss.create_dept is '创建部门';

comment on column base_oss.create_by is '上传人';

comment on column base_oss.create_time is '创建时间';

comment on column base_oss.update_by is '更新者';

comment on column base_oss.update_time is '更新时间';

comment on column base_oss.service is '服务商';


create table base_oss_config
(
    oss_config_id bigint                                     not null
        constraint base_oss_config_pk
            primary key,
    tenant_id     varchar(20)  default '000000'::character varying,
    config_key    varchar(20)  default ''::character varying not null,
    access_key    varchar(255) default ''::character varying,
    secret_key    varchar(255) default ''::character varying,
    bucket_name   varchar(255) default ''::character varying,
    prefix        varchar(255) default ''::character varying,
    endpoint      varchar(255) default ''::character varying,
    domain        varchar(255) default ''::character varying,
    is_https      char         default 'N'::bpchar,
    region        varchar(255) default ''::character varying,
    access_policy char         default '1'::bpchar           not null,
    status        char         default '1'::bpchar,
    ext1          varchar(255) default ''::character varying,
    create_dept   bigint,
    create_by     bigint,
    create_time   timestamp,
    update_by     bigint,
    update_time   timestamp,
    remark        varchar(500) default ''::character varying
);

comment on table base_oss_config is '对象存储配置表';

comment on column base_oss_config.oss_config_id is '主键';

comment on column base_oss_config.tenant_id is '租户编码';

comment on column base_oss_config.config_key is '配置key';

comment on column base_oss_config.access_key is 'accessKey';

comment on column base_oss_config.secret_key is '秘钥';

comment on column base_oss_config.bucket_name is '桶名称';

comment on column base_oss_config.prefix is '前缀';

comment on column base_oss_config.endpoint is '访问站点';

comment on column base_oss_config.domain is '自定义域名';

comment on column base_oss_config.is_https is '是否https（Y=是,N=否）';

comment on column base_oss_config.region is '域';

comment on column base_oss_config.access_policy is '桶权限类型(0=private 1=public 2=custom)';

comment on column base_oss_config.status is '是否默认（0=否,1=是）';

comment on column base_oss_config.ext1 is '扩展字段';

comment on column base_oss_config.create_dept is '创建部门';

comment on column base_oss_config.create_by is '创建者';

comment on column base_oss_config.create_time is '创建时间';

comment on column base_oss_config.update_by is '更新者';

comment on column base_oss_config.update_time is '更新时间';

comment on column base_oss_config.remark is '备注';


create table base_social
(
    id                 bigint        not null
        constraint pk_base_social
            primary key,
    user_id            bigint        not null,
    tenant_id          varchar(20)   default '000000'::character varying,
    auth_id            varchar(255)  not null,
    source             varchar(255)  not null,
    open_id            varchar(255)  default NULL::character varying,
    user_name          varchar(30)   not null,
    nick_name          varchar(30)   default ''::character varying,
    email              varchar(255)  default ''::character varying,
    avatar             varchar(500)  default ''::character varying,
    access_token       varchar(2000) not null,
    expire_in          bigint,
    refresh_token      varchar(2000) default NULL::character varying,
    access_code        varchar(255)  default NULL::character varying,
    union_id           varchar(255)  default NULL::character varying,
    scope              varchar(255)  default NULL::character varying,
    token_type         varchar(255)  default NULL::character varying,
    id_token           varchar(2000) default NULL::character varying,
    mac_algorithm      varchar(255)  default NULL::character varying,
    mac_key            varchar(255)  default NULL::character varying,
    code               varchar(255)  default NULL::character varying,
    oauth_token        varchar(255)  default NULL::character varying,
    oauth_token_secret varchar(255)  default NULL::character varying,
    create_dept        bigint,
    create_by          bigint,
    create_time        timestamp,
    update_by          bigint,
    update_time        timestamp,
    is_deleted         char          default '1'::bpchar
);

comment on table base_social is '社会化关系表';

comment on column base_social.id is '主键';

comment on column base_social.user_id is '用户ID';

comment on column base_social.tenant_id is '租户id';

comment on column base_social.auth_id is '平台+平台唯一id';

comment on column base_social.source is '用户来源';

comment on column base_social.open_id is '平台编号唯一id';

comment on column base_social.user_name is '登录账号';

comment on column base_social.nick_name is '用户昵称';

comment on column base_social.email is '用户邮箱';

comment on column base_social.avatar is '头像地址';

comment on column base_social.access_token is '用户的授权令牌';

comment on column base_social.expire_in is '用户的授权令牌的有效期，部分平台可能没有';

comment on column base_social.refresh_token is '刷新令牌，部分平台可能没有';

comment on column base_social.access_code is '平台的授权信息，部分平台可能没有';

comment on column base_social.union_id is '用户的 unionid';

comment on column base_social.scope is '授予的权限，部分平台可能没有';

comment on column base_social.token_type is '个别平台的授权信息，部分平台可能没有';

comment on column base_social.id_token is 'id token，部分平台可能没有';

comment on column base_social.mac_algorithm is '小米平台用户的附带属性，部分平台可能没有';

comment on column base_social.mac_key is '小米平台用户的附带属性，部分平台可能没有';

comment on column base_social.code is '用户的授权code，部分平台可能没有';

comment on column base_social.oauth_token is 'Twitter平台用户的附带属性，部分平台可能没有';

comment on column base_social.oauth_token_secret is 'Twitter平台用户的附带属性，部分平台可能没有';

comment on column base_social.create_dept is '创建部门';

comment on column base_social.create_by is '创建者';

comment on column base_social.create_time is '创建时间';

comment on column base_social.update_by is '更新者';

comment on column base_social.update_time is '更新时间';

comment on column base_social.is_deleted is '删除标志（0未删除 1已删除）';