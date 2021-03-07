/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.server.master.dispatch.host.assign;

import org.apache.dolphinscheduler.remote.utils.Host;

import java.util.Objects;

/**
 * host worker
 */
public class HostWorker extends Host {

    /**
     * weight
     */
    private int weight;

    /**
     * worker group
     */
    private String workerGroup;

    public HostWorker(String ip, int port, int weight, String workerGroup) {
        super(ip, port);
        this.weight = weight;
        this.workerGroup = workerGroup;
    }

    public HostWorker(String address, int weight, String workerGroup) {
        super(address);
        this.weight = weight;
        this.workerGroup = workerGroup;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getWorkerGroup() {
        return workerGroup;
    }

    public void setWorkerGroup(String workerGroup) {
        this.workerGroup = workerGroup;
    }

    public static HostWorker of(String address, int weight, String workerGroup) {
        return new HostWorker(address, weight, workerGroup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HostWorker hostWorker = (HostWorker) o;
        return Objects.equals(getAddress(), hostWorker.getAddress())
                && getWeight() == hostWorker.getWeight()
                && Objects.equals(getWorkerGroup(), hostWorker.getWorkerGroup());
    }

    @Override
    public String toString() {
        return "Host{"
                + "workerGroup='" + workerGroup + '\''
                + ", weight=" + weight
                + '}';
    }

}
