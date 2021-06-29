# zk-client
A simple spring based zookeeper client to read and write to zookeeper

**use the below docker commands to setup a running zookeeper server & a web ui to view said zookeeper server's state**

1) **run zookeeper using docker**

    _docker run --rm -d -p 2181:2181 --name=zk-server zookeeper_

2) **run zoo-navigator using docker**

    _docker run --rm -d -p 9000:9000 --name zk-navigator elkozmon/zoonavigator_

3) **create a docker network and connect both containers to the network**

    _docker network create zk-network_
    
    _docker network connect zk-network zk-server_
    
    _docker network connect zk-network zk-navigator_

4) **finally, use zk-server:2181 as the connection string in zoo-navigator ui (running on localhost:9000) to view the zk-instance**
