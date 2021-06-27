package com.duobaoyu.cloud.client.config;

import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.netflix.loadbalancer.Server;
import org.springframework.cloud.netflix.ribbon.ZonePreferenceServerListFilter;

import java.util.ArrayList;
import java.util.List;

public class LZoneFilter extends ZonePreferenceServerListFilter {
    @Override
    public List<Server> getFilteredListOfServers(List<Server> servers) {
        List<Server> output = super.getFilteredListOfServers(servers);
        if (this.getZone() != null && output.size() == servers.size()) {
            List<Server> local = new ArrayList<>();
            for (Server server : output) {
                NacosServer nacosServer=(NacosServer)server;
                if (this.getZone().equalsIgnoreCase(nacosServer.getMetadata().get("zone"))) {
                    local.add(server);
                }
            }
            if (!local.isEmpty()) {
                return local;
            }
        }
        return output;    }
}
