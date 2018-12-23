# https://github.com/elastic/elasticsearch-docker
FROM docker.elastic.co/elasticsearch/elasticsearch:7.0.0-alpha2

ADD config/elasticsearch.yml /usr/share/elasticsearch/config/elasticsearch.yml

# Add your elasticsearch plugins setup here
RUN elasticsearch-plugin install analysis-icu
RUN elasticsearch-plugin install analysis-smartcn
RUN elasticsearch-plugin install analysis-kuromoji
RUN elasticsearch-plugin install --batch ingest-attachment
RUN elasticsearch-plugin install --batch mapper-size
RUN elasticsearch-plugin install --batch mapper-murmur3
