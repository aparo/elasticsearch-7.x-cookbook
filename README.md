# elasticsearch-7.x-cookbook
Code for the Book - ElasticSearch 7.x Cookbook

## Changelog

2019/09/14 
            Upgrade docker to 7.3.1

            Upgrade Elastic4s to 7.3.1 version.

## Refactory of Elastic4s 7.x
Elastic4s was not released for 7.x during book writing. During 7.x Elastic4s had a code refactory. Main changes are:


### Moving imports 

Imports are changed and moved from 

```
import com.sksamuel.elastic4s.http.ElasticDsl._
```
to
```
import com.sksamuel.elastic4s.ElasticDsl._
```

### Different clients

To use the Elasticsearch Client you need to use the following entry in build.sbt

```
"com.sksamuel.elastic4s" %% "elastic4s-client-esjava" % elastic4sV
```

There are different cleints. You must provide one during initialization. 
The initialization should change from:
```
  lazy val client = ElasticClient(
    ElasticProperties(s"http://localhost:9200")
  )

```
to 
```
  import com.sksamuel.elastic4s.http._
  lazy val client = ElasticClient(
    JavaClient(ElasticProperties(s"http://localhost:9200"))
  )
```
