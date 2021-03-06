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

package io.vertx.scala.ext.bridge

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.ext.bridge.{PermittedOptions => JPermittedOptions}
import io.vertx.core.json.JsonObject

/**
  * Represents a match to allow for inbound and outbound traffic.
  */
class PermittedOptions(private val _asJava: JPermittedOptions) {

  def asJava = _asJava

  /**
    * The exact address the message is being sent to. If you want to allow messages based on
    * an exact address you use this field.
    */
  def setAddress(value: String) = {
    asJava.setAddress(value)
    this
  }
  def getAddress: String = {
    asJava.getAddress().asInstanceOf[String]
  }

  /**
    * A regular expression that will be matched against the address. If you want to allow messages
    * based on a regular expression you use this field. If the <a href="../../../../../../../cheatsheet/PermittedOptions.html">PermittedOptions</a> value is specified
    * this will be ignored.
    */
  def setAddressRegex(value: String) = {
    asJava.setAddressRegex(value)
    this
  }
  def getAddressRegex: String = {
    asJava.getAddressRegex().asInstanceOf[String]
  }

  /**
    * This allows you to allow messages based on their structure. Any fields in the match must exist in the
    * message with the same values for them to be allowed. This currently only works with JSON messages.
    */
  def setMatch(value: io.vertx.core.json.JsonObject) = {
    asJava.setMatch(value)
    this
  }
  def getMatch: io.vertx.core.json.JsonObject = {
    asJava.getMatch()
  }
}

object PermittedOptions {
  
  def apply() = {
    new PermittedOptions(new JPermittedOptions(emptyObj()))
  }
  
  def apply(t: JPermittedOptions) = {
    if (t != null) {
      new PermittedOptions(t)
    } else {
      new PermittedOptions(new JPermittedOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): PermittedOptions = {
    if (json != null) {
      new PermittedOptions(new JPermittedOptions(json))
    } else {
      new PermittedOptions(new JPermittedOptions(emptyObj()))
    }
  }
}
