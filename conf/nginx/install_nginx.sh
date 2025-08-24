#!/bin/bash
# author : Jalright

# modify the version variable ,there you need !
nginx_version="1.28.0"
openssl_version="3.0.12"
zlib_version="1.3.1"
pcre_version="8.45"

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
yum -y install gcc gcc-c++ make wget tar

# temp dir
mkdir -p /tmp/make_nginx

cd /tmp/make_nginx

# download nginx
wget -c -t 0 -T 1200 http://nginx.org/download/nginx-${nginx_version}.tar.gz
checkFile nginx-${nginx_version}.tar.gz

# download openssl
wget -c -t 0 -T 1200 https://www.openssl.org/source/openssl-${openssl_version}.tar.gz
checkFile openssl-${openssl_version}.tar.gz

# download zlib for gizp
wget -c -t 0 -T 1200 http://zlib.net/zlib-${zlib_version}.tar.gz
checkFile zlib-${zlib_version}.tar.gz

# download pcre for regular expression
if [ ! -f "pcre-${pcre_version}.tar.gz" ]; then
    wget -c -t 0 -T 1200 https://sourceforge.net/projects/pcre/files/pcre/${pcre_version}/pcre-${pcre_version}.tar.gz/download -O pcre-${pcre_version}.tar.gz 
fi
checkFile pcre-${pcre_version}.tar.gz

# Don't need install the dependent packages , we juse need source code .
# When we compile nginx , it will compile with other dependent source code auto.
tar zxf openssl-${openssl_version}.tar.gz || echo "unpack openssl fail" && exit 1

tar zxf zlib-${zlib_version}.tar.gz

tar zxf pcre-${pcre_version}.tar.gz 

tar zxf nginx-${nginx_version}.tar.gz

cd nginx-${nginx_version}

# default compile with http2 module 、ssl、status ...  If you need other module , you can modify it here.
./configure --prefix=${install_path} --user=www --group=www --with-http_ssl_module --with-http_v2_module --with-http_gzip_static_module --with-stream --with-http_stub_status_module --with-openssl=../openssl-${openssl_version} --with-pcre=../pcre-${pcre_version} --with-zlib=../zlib-${zlib_version}  && exit 1

make

make install

# crete work user
useradd -M -s /sbin/nologin www

# /usr/local/nginx/sbin/nginx  -V