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

package io.vertx.scala.ext.hawkular

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.scala.core.metrics.{MetricsOptions => ExtMetricsOptions}
import io.vertx.ext.hawkular.{VertxHawkularOptions => JVertxHawkularOptions}
import io.vertx.core.http.{HttpClientOptions => JHttpClientOptions}
import io.vertx.core.json.JsonObject
import io.vertx.scala.core.http.HttpClientOptions

/**
  * Vert.x Hawkular monitoring configuration.
  */
class VertxHawkularOptions(private val _asJava: JVertxHawkularOptions) 
    extends ExtMetricsOptions(_asJava) {

  override def asJava = _asJava

  /**
    * Set the options for authentication.
    */
  def setAuthenticationOptions(value: AuthenticationOptions) = {
    asJava.setAuthenticationOptions(value.asJava)
    this
  }
  def getAuthenticationOptions: AuthenticationOptions = {
    AuthenticationOptions(asJava.getAuthenticationOptions())
  }

  /**
    * Set the maximum delay between two consecutive batches (in seconds). To reduce the number of HTTP exchanges, metric
    * data is sent to the Hawkular server in batches. A batch is sent as soon as the number of metrics collected reaches
    * the configured `batchSize`, or after the `batchDelay` expires. Defaults to `1` second.
    */
  def setBatchDelay(value: Int) = {
    asJava.setBatchDelay(value)
    this
  }
  def getBatchDelay: Int = {
    asJava.getBatchDelay().asInstanceOf[Int]
  }

  /**
    * Set the maximum number of metrics in a batch. To reduce the number of HTTP exchanges, metric data is sent to the
    * Hawkular server in batches. A batch is sent as soon as the number of metrics collected reaches the configured
    * `batchSize`, or after the `batchDelay` expires. Defaults to `50`.
    */
  def setBatchSize(value: Int) = {
    asJava.setBatchSize(value)
    this
  }
  def getBatchSize: Int = {
    asJava.getBatchSize().asInstanceOf[Int]
  }

  /**
    * Sets metrics types that are disabled.
    */
  def setDisabledMetricsTypes(value: Set[io.vertx.ext.hawkular.MetricsType]) = {
    asJava.setDisabledMetricsTypes(value.asJava)
    this
  }
  def getDisabledMetricsTypes: scala.collection.mutable.Set[io.vertx.ext.hawkular.MetricsType] = {
    asJava.getDisabledMetricsTypes().asScala.map(x => x)
  }

  /**
    * Set whether metrics will be enabled on the Vert.x instance. Metrics are not enabled by default.
    */
  override def setEnabled(value: Boolean) = {
    asJava.setEnabled(value)
    this
  }
  override def isEnabled: Boolean = {
    asJava.isEnabled().asInstanceOf[Boolean]
  }

  /**
    * Set the Hawkular Metrics service host. Defaults to `localhost`.
    */
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }
  def getHost: String = {
    asJava.getHost().asInstanceOf[String]
  }

  /**
    * Set specific headers to include in HTTP requests.
    */
  def setHttpHeaders(value: io.vertx.core.json.JsonObject) = {
    asJava.setHttpHeaders(value)
    this
  }
  def getHttpHeaders: io.vertx.core.json.JsonObject = {
    asJava.getHttpHeaders()
  }

  /**
    * Set the configuration of the Hawkular Metrics HTTP client.
    */
  def setHttpOptions(value: HttpClientOptions) = {
    asJava.setHttpOptions(value.asJava)
    this
  }
  def getHttpOptions: HttpClientOptions = {
    HttpClientOptions(asJava.getHttpOptions())
  }

  /**
    * Sets a list of <a href="../../../../../../../cheatsheet/MetricTagsMatch.html">MetricTagsMatch</a>.
    */
  def setMetricTagsMatches(value: scala.collection.mutable.Buffer[MetricTagsMatch]) = {
    asJava.setMetricTagsMatches(value.map(_.asJava).asJava)
    this
  }
  def getMetricTagsMatches: scala.collection.mutable.Buffer[MetricTagsMatch] = {
    asJava.getMetricTagsMatches().asScala.map(x => MetricTagsMatch(x))
  }

  /**
    * Sets the metric bridge address on which the application is sending the custom metrics. Application can send
    * metrics to this event bus address. The message is a JSON object specifying at least the `id` and
    * `value` fields.
    * <p/>
    * Don't forget to also enable the bridge with `metricsBridgeEnabled`.
    */
  def setMetricsBridgeAddress(value: String) = {
    asJava.setMetricsBridgeAddress(value)
    this
  }
  def getMetricsBridgeAddress: String = {
    asJava.getMetricsBridgeAddress().asInstanceOf[String]
  }

  /**
    * Sets whether or not the metrics bridge should be enabled. The metrics bridge is disabled by default.
    */
  def setMetricsBridgeEnabled(value: Boolean) = {
    asJava.setMetricsBridgeEnabled(value)
    this
  }
  def isMetricsBridgeEnabled: Boolean = {
    asJava.isMetricsBridgeEnabled().asInstanceOf[Boolean]
  }

  /**
    * Set the Hawkular Metrics service URI. Defaults to `/hawkular/metrics`. This can be useful if you host the
    * Hawkular server behind a proxy and manipulate the default service URI.
    */
  def setMetricsServiceUri(value: String) = {
    asJava.setMetricsServiceUri(value)
    this
  }
  def getMetricsServiceUri: String = {
    asJava.getMetricsServiceUri().asInstanceOf[String]
  }

  /**
    * Set the Hawkular Metrics service port.  Defaults to `8080`.
    */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }
  def getPort: Int = {
    asJava.getPort().asInstanceOf[Int]
  }

  /**
    * Set the metric name prefix. Metric names are not prefixed by default. Prefixing metric names is required to
    * distinguish data sent by different Vert.x instances.
    */
  def setPrefix(value: String) = {
    asJava.setPrefix(value)
    this
  }
  def getPrefix: String = {
    asJava.getPrefix().asInstanceOf[String]
  }

  /**
    * Set the metric collection interval (in seconds). Defaults to `1`.
    */
  def setSchedule(value: Int) = {
    asJava.setSchedule(value)
    this
  }
  def getSchedule: Int = {
    asJava.getSchedule().asInstanceOf[Int]
  }

  /**
    * Set whether Hawkular tenant header should be sent. Defaults to `true`.
    * Must be set to `false` when working with pre-Alpha13 Hawkular servers.
    */
  def setSendTenantHeader(value: Boolean) = {
    asJava.setSendTenantHeader(value)
    this
  }
  def isSendTenantHeader: Boolean = {
    asJava.isSendTenantHeader().asInstanceOf[Boolean]
  }

  /**
    * Set the number of metric names to cache in order to avoid repeated tagging requests.
    */
  def setTaggedMetricsCacheSize(value: Int) = {
    asJava.setTaggedMetricsCacheSize(value)
    this
  }
  def getTaggedMetricsCacheSize: Int = {
    asJava.getTaggedMetricsCacheSize().asInstanceOf[Int]
  }

  /**
    * Set tags applied to all metrics.
    */
  def setTags(value: io.vertx.core.json.JsonObject) = {
    asJava.setTags(value)
    this
  }
  def getTags: io.vertx.core.json.JsonObject = {
    asJava.getTags()
  }

  /**
    * Set the Hawkular tenant. Defaults to `default`.
    */
  def setTenant(value: String) = {
    asJava.setTenant(value)
    this
  }
  def getTenant: String = {
    asJava.getTenant().asInstanceOf[String]
  }
}

object VertxHawkularOptions {
  
  def apply() = {
    new VertxHawkularOptions(new JVertxHawkularOptions(emptyObj()))
  }
  
  def apply(t: JVertxHawkularOptions) = {
    if (t != null) {
      new VertxHawkularOptions(t)
    } else {
      new VertxHawkularOptions(new JVertxHawkularOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): VertxHawkularOptions = {
    if (json != null) {
      new VertxHawkularOptions(new JVertxHawkularOptions(json))
    } else {
      new VertxHawkularOptions(new JVertxHawkularOptions(emptyObj()))
    }
  }
}
