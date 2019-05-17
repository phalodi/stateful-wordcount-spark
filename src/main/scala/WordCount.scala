
import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._

object WordCount extends App {
  val updateFunc = (values: Seq[Int], state: Option[Int]) => {
    val currentCount = values.foldLeft(0)(_ + _)

    val previousCount = state.getOrElse(0)

    Some(currentCount + previousCount)
  }
  val conf = new SparkConf().setAppName("myStream").setMaster("local[*]")
  val sc = new SparkContext(conf)
  val ssc = new StreamingContext(sc, Seconds(10))
  ssc.checkpoint("./checkpoints/")
  val lines = ssc.socketTextStream("localhost", 9999)
  val words = lines.flatMap(_.split(" "))
  val pairs = words.map(word => (word, 1))
  val windowedWordCounts = pairs.reduceByKey(_+_)
  windowedWordCounts.saveAsTextFiles("result/result")
  ssc.start()
  ssc.awaitTermination()
}
