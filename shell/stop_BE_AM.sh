/usr/bin/ps -ef |grep PaaS-BE-AM|grep -v "grep"|awk '{print $2}'|xargs kill -9
