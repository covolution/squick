package org.covolution.quick

import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

import com.datastax.spark.connector._
import com.datastax.spark.connector.cql.CassandraConnector

/**
 * @author Gethin James
 * Try this:
 * spark-submit --class org.covolution.quick.App /tmp/data/uber-squick-1.0-SNAPSHOT.jar
 */
object App {

  def main(args : Array[String]) {

    val conf = new SparkConf()
      .setAppName("The Squick Spark app listening 1")
      .setMaster("local[*]")
      .set("spark.cassandra.connection.host", "cassa")
    val sc = new SparkContext(conf)

    CassandraConnector(conf).withSessionDo { session =>
      session.execute("DROP KEYSPACE IF EXISTS ctest")
      session.execute("CREATE KEYSPACE ctest WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1 };")
      session.execute("CREATE TABLE ctest.kv(key text PRIMARY KEY, value int);")
      session.execute("INSERT INTO ctest.kv(key, value) VALUES ('key1', 1);")
      session.execute("INSERT INTO ctest.kv(key, value) VALUES ('key2', 2);")
    }

    val rdd = sc.cassandraTable("ctest", "kv")
    println(rdd.count)
    println(rdd.first)
    println(rdd.map(_.getInt("value")).sum)

    val collection = sc.parallelize(Seq(("key3", 3), ("key4", 4)))
    collection.saveToCassandra("ctest", "kv", SomeColumns("key", "value"))
  }

}
