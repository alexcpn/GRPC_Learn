package server

import java.io.File
import java.security.cert.X509Certificate

import io.grpc.ServerBuilder
import io.grpc.generated.{InputMessage, InputMessageRange, OutputMessage, SimpleServiceGrpc}
import io.grpc.stub.StreamObserver
import io.grpc.ServerBuilder
import io.grpc.netty.{GrpcSslContexts, NettyServerBuilder}
import io.netty.handler.ssl.{ClientAuth, SslContextBuilder, SslProvider}

/**
  * Created by acp on 11-01-2017.
  */
class SimpleServer(port: Int, delay: Int) {
  val serverbuilder = ServerBuilder.forPort(port)
  serverbuilder.addService(new SimpleServiceImpl(delay))
  val server = serverbuilder.build()

  def start(): Unit = {
    server.start()
    server.awaitTermination()
  }

  def serverBuilder(port:Int, serverCertChainFile:File,
                     serverPrivateKeyFile:File, serverTrustedCaCerts:Array[X509Certificate])  {
    val sslContextBuilder:SslContextBuilder
      = SslContextBuilder.forServer(serverCertChainFile, serverPrivateKeyFile);
    GrpcSslContexts.configure(sslContextBuilder, SslProvider.OPENSSL);
    sslContextBuilder.trustManager(serverTrustedCaCerts:_*)
      .clientAuth(ClientAuth.REQUIRE);

    return NettyServerBuilder.forPort(port)
      .sslContext(sslContextBuilder.build());
  }
}

class SimpleServiceImpl(delay: Int) extends SimpleServiceGrpc.SimpleServiceImplBase {

  override def getData(request: InputMessage, responseObserver: StreamObserver[OutputMessage]): Unit = {
    println("Got a request", request.getInMessage)
    val reply = OutputMessage.newBuilder().setOutMessage("Hello Client Blocked Mode--> " + request.getInMessage).build()
    Thread.sleep(delay * 1000)
    println("Out of sleep " + request.getInMessage)
    responseObserver.onNext(reply)
    responseObserver.onCompleted()

  }

  override def getDataStream(request: InputMessageRange, responseObserver: StreamObserver[OutputMessage]): Unit = {

  }
}

object BootUp {

  def main(args: Array[String]) {
    println("Starting gRPC Server for SimpleService")
    if (args.length < 2) {
      println("Enter <port> <simulated delay in seconds>")
      return
    }
    val server = new SimpleServer(args(0).toInt, args(1).toInt)
    server.start()
    println("Exiting Server SimpleService")
  }
}