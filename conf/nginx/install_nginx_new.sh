#!/bin/bash
# author : Olsond

# modify the version variable ,there you need !
nginx_version="1.28.0"

# the default install path , you can change it here
install_path="/usr/local/nginx"

# check file if exists , if not exit script.
function checkFile() {
    if [ ! -f "$1" ]; then
        echo "$1 is not exitst"
        exit 1
    fi
}

# install complie tools
yum -y install gcc gcc-c++ make wget tar pcre pcre-devel zlib zlib-devel openssl openssl-devel

# temp dir
mkdir -p /tmp/make_nginx

cd /tmp/make_nginx

# download nginx
wget -c -t 0 -T 1200 http://nginx.org/download/nginx-${nginx_version}.tar.gz
checkFile nginx-${nginx_version}.tar.gz

tar zxf nginx-${nginx_version}.tar.gz

cd nginx-${nginx_version}

# default compile with http2 module 、ssl、status ...  If you need other module , you can modify it here.
./configure --prefix=${install_path} --user=nginx --group=nginx --with-http_ssl_module --with-http_v2_module --with-http_gzip_static_module --with-stream --with-http_stub_status_module   --pid-path=/var/run/nginx/nginx.pid     --lock-path=/var/lock/nginx.lock     --error-log-path=/var/log/nginx/error.log     --http-log-path=/var/log/nginx/access.log     --with-http_gzip_static_module     --http-client-body-temp-path=/var/temp/nginx/client     --http-proxy-temp-path=/var/temp/nginx/proxy     --http-fastcgi-temp-path=/var/temp/nginx/fastcgi     --http-uwsgi-temp-path=/var/temp/nginx/uwsgi     --http-scgi-temp-path=/var/temp/nginx/scgi
make

make install

# crete work user
useradd -M -s /sbin/nologin nginx

# /usr/local/nginx/sbin/nginx  -V