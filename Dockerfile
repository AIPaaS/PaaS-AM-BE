FROM java:8-jre

ENV PAAS_HOME /usr/local/PaaS-BE-AM
ENV PATH $PAAS_HOME/bin:$PATH
RUN mkdir -p "$PAAS_HOME"
WORKDIR $PAAS_HOME
ADD PaaS-BE-AM.tar $PAAS_HOME

RUN chmod u+x $PAAS_HOME/bin/docker_start.sh

ENTRYPOINT ["/usr/local/PaaS-BE-AM/bin/docker_start.sh","run"]