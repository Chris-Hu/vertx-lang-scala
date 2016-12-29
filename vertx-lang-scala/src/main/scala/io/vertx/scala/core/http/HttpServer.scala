/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.core.http

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.core.http.{HttpServer => JHttpServer}
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import io.vertx.core.http.{ServerWebSocketStream => JServerWebSocketStream}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.http.{HttpServerRequestStream => JHttpServerRequestStream}

/**
  * An HTTP and WebSockets server.
  * 
  * You receive HTTP requests by providing a [[io.vertx.scala.core.http.HttpServer#requestHandler]]. As requests arrive on the server the handler
  * will be called with the requests.
  * 
  * You receive WebSockets by providing a [[io.vertx.scala.core.http.HttpServer#websocketHandler]]. As WebSocket connections arrive on the server, the
  * WebSocket is passed to the handler.
  */
class HttpServer(private val _asJava: Object) 
    extends Measured {

  def asJava = _asJava
  private var cached_0:HttpServerRequestStream = _
  private var cached_1:ServerWebSocketStream = _

//cached methods
  def requestStream():HttpServerRequestStream = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JHttpServer].requestStream()
      cached_0 = HttpServerRequestStream(tmp)
    }
    cached_0
  }

  def websocketStream():ServerWebSocketStream = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JHttpServer].websocketStream()
      cached_1 = ServerWebSocketStream(tmp)
    }
    cached_1
  }

//fluent methods
  def requestHandler(handler: Handler[HttpServerRequest]):HttpServer = {
    asJava.asInstanceOf[JHttpServer].requestHandler({x: JHttpServerRequest => handler.handle(HttpServerRequest(x))})
    this
  }

  def connectionHandler(handler: Handler[HttpConnection]):HttpServer = {
    asJava.asInstanceOf[JHttpServer].connectionHandler({x: JHttpConnection => handler.handle(HttpConnection(x))})
    this
  }

  def websocketHandler(handler: Handler[ServerWebSocket]):HttpServer = {
    asJava.asInstanceOf[JHttpServer].websocketHandler({x: JServerWebSocket => handler.handle(ServerWebSocket(x))})
    this
  }

  def listen():HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen()
    this
  }

  def listen(port: Int,host: String):HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String])
    this
  }

  def listen(port: Int,host: String,listenHandler: Handler[AsyncResult[HttpServer]]):HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],{x: AsyncResult[JHttpServer] => listenHandler.handle(AsyncResultWrapper[JHttpServer,HttpServer](x, a => HttpServer(a)))})
    this
  }

  def listen(port: Int):HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer])
    this
  }

  def listen(port: Int,listenHandler: Handler[AsyncResult[HttpServer]]):HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer],{x: AsyncResult[JHttpServer] => listenHandler.handle(AsyncResultWrapper[JHttpServer,HttpServer](x, a => HttpServer(a)))})
    this
  }

  def listen(listenHandler: Handler[AsyncResult[HttpServer]]):HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen({x: AsyncResult[JHttpServer] => listenHandler.handle(AsyncResultWrapper[JHttpServer,HttpServer](x, a => HttpServer(a)))})
    this
  }

//default methods
//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.asInstanceOf[JHttpServer].isMetricsEnabled().asInstanceOf[Boolean]
  }

  def close():Unit = {
    asJava.asInstanceOf[JHttpServer].close()
  }

  def close(completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JHttpServer].close({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

  def actualPort():Int = {
    asJava.asInstanceOf[JHttpServer].actualPort().asInstanceOf[Int]
  }

//future methods
  def listenFuture(port: Int,host: String):scala.concurrent.Future[HttpServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServer, HttpServer](x => if (x == null) null.asInstanceOf[HttpServer] else HttpServer(x))
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def listenFuture(port: Int):scala.concurrent.Future[HttpServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServer, HttpServer](x => if (x == null) null.asInstanceOf[HttpServer] else HttpServer(x))
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def listenFuture():scala.concurrent.Future[HttpServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServer, HttpServer](x => if (x == null) null.asInstanceOf[HttpServer] else HttpServer(x))
    asJava.asInstanceOf[JHttpServer].listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def closeFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JHttpServer].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object HttpServer{
    def apply(asJava: Object) = new HttpServer(asJava)  
  //static methods
  }
