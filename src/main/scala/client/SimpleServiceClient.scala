package client

import java.util.concurrent.{CountDownLatch, TimeUnit}

import io.grpc.ManagedChannelBuilder
import io.grpc.generated.{InputMessage, OutputMessage, SimpleServiceGrpc}
import io.grpc.stub.StreamObserver

/**
  * Created by acp on 11-01-2017.
  */
class SimpleServiceClient(host: String, port: Int) {

  val channelBuilder = ManagedChannelBuilder.forAddress(host, port)
  channelBuilder.usePlaintext(true)
  val channel = channelBuilder.build()
  val blockingStub = SimpleServiceGrpc.newBlockingStub(channel)
  val asyncStub = SimpleServiceGrpc.newStub(channel)

}

object ClientBoot {

  var no_of_iterations = 0
  var finishLatch: CountDownLatch = null


  def main(args: Array[String]) {
    println("Going to start GRPC  Client")

    if (args.length < 4) {
      println("Please enter <ServerIp> <port> <clientid> <no of mesages to send>")
      return
    }

    val client = new SimpleServiceClient(args(0), args(1).toInt)
    var observer: Array[MyObsrver] = Array()
    no_of_iterations = args(3).toInt
    finishLatch = new CountDownLatch(no_of_iterations)
    for (i <- 0 to no_of_iterations) {
      val in_message = InputMessage.newBuilder().setInMessage("ClientID=" + args(2) + " MessageId= " + i).build()
      //val output = client.blockingStub.getData(in_message)
      val callback = new MyObsrver()
      observer :+ callback
      val output = client.asyncStub.getData(in_message, callback)
    }

    println("Waiting for response")
    finishLatch.await()
    println("Out of client  wait")
    client.channel.shutdown.awaitTermination(5, TimeUnit.SECONDS)
  }

  class MyObsrver extends StreamObserver[OutputMessage] {
    override def onError(throwable: Throwable): Unit = {
      println("Got an Error", throwable.getMessage)
      finishLatch.countDown()
    }

    override def onCompleted(): Unit = {
      // println("OnCompleted")
      finishLatch.countDown()
    }

    override def onNext(v: OutputMessage): Unit = {
      println("On Next")
      println("Message from server is " + v.getOutMessage)
    }
  }

  //end class

}
