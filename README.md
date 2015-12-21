# squick
##Spark Quick-Start project
You can start with the interactive Spark Shell or submit a Spark job for processing

### Quick Start - Spark Shell

* `docker-compose up` - Starts Spark
* `docker exec -it <Put Spark master container id here> bash` - Launches interactive terminal
* `cd /usr/spark` - Changed to bin directory
* `./bin/spark-shell` - Starts the Spark Shell
* Now follow [the instructions on the Spark website](http://spark.apache.org/docs/latest/quick-start.html#interactive-analysis-with-the-spark-shell)

### Quick Start - Spark Job

* `mvn clean package` - Creates the target/uber-squick-1.0-SNAPSHOT.jar
* `docker-compose up` - Starts Spark
* `docker exec -it <Put Spark master container id here> bash` - Launches interactive terminal
* `cd /usr/spark/bin` - Changed to bin directory
* `spark-submit --class org.covolution.quick.App /tmp/data/uber-squick-1.0-SNAPSHOT.jar` - submits and runs the job.

### Cassandra
* The datastax Cassandra Connector is being used.

### License
Copyright (C) 2016 Alfresco Software Limited

This file is part of an unsupported extension to Alfresco.

Alfresco Software Limited licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.