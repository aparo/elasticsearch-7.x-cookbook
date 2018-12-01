curl -XDELETE "http://localhost:9200/mybooks"

curl -XPUT "http://localhost:9200/mybooks" -H 'Content-Type: application/json' -d'
{
  "mappings": {
    "_doc": {
      "properties": {
        "join_field": {
          "type": "join",
          "relations": {
            "order": "item"
          }
        },
        "position": {
          "type": "integer",
          "store": true
        },
        "uuid": {
          "store": true,
          "type": "keyword"
        },
        "date": {
          "type": "date"
        },
        "quantity": {
          "type": "integer"
        },
        "price": {
          "type": "double"
        },
        "description": {
          "term_vector": "with_positions_offsets",
          "store": true,
          "type": "text"
        },
        "title": {
          "term_vector": "with_positions_offsets",
          "store": true,
          "type": "text",
          "fielddata": true,
          "fields": {
            "keyword": {
              "type": "keyword",
              "ignore_above": 256
            }
          }
        }
      }
    }
  }
}'

curl -XPOST "http://localhost:9200/_bulk?refresh" -H 'Content-Type: application/json' -d'
{"index":{"_index":"mybooks", "_type":"_doc", "_id":"1"}}
{"uuid":"11111","position":1,"title":"Joe Tester","description":"Joe Testere nice guy","date":"2015-10-22","price":4.3,"quantity":50}
{"index":{"_index":"mybooks", "_type":"_doc", "_id":"2"}}
{"uuid":"22222","position":2,"title":"Bill Baloney","description":"Bill Testere nice guy","date":"2016-06-12","price":5,"quantity":34}
{"index":{"_index":"mybooks", "_type":"_doc", "_id":"3"}}
{"uuid":"33333","position":3,"title":"Bill Klingon","description":"Bill is not\n                nice guy","date":"2017-09-21","price":6,"quantity":33}
'

