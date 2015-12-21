package org.covolution.quick

import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

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
    val sc = new SparkContext(conf)

    val data = Seq(
      """{"user":"helena","commits":98, "month":3, "year":2015}""",
      """{"user":"jacek-lewandowski", "commits":72, "month":3, "year":2015}""",
      """{"user":"pkolaczk", "commits":42, "month":3, "year":2015}""")

    data.foreach (println)
  }

}
