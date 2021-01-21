@Test public void testHeartbeatStateCommandsEnqueueing() throws AmbariException, InterruptedException, InvalidStateTransitionException {
  Clusters clusters=injector.getInstance(Clusters.class);
  clusters.addHost(hostname1);
  clusters.getHost(hostname1).setOsType("centos5");
  clusters.getHost(hostname1).persist();
  clusters.addCluster(clusterName);
  Cluster cluster=clusters.getCluster(clusterName);
  cluster.setDesiredStackVersion(new StackId("HDP-0.1"));
  Set<String> hostNames=new HashSet<String>(){
{
      add(hostname1);
    }
  }
;
  clusters.mapHostsToCluster(hostNames,clusterName);
  Service hdfs=cluster.addService(serviceName);
  hdfs.persist();
  hdfs.addServiceComponent(Role.DATANODE.name()).persist();
  hdfs.getServiceComponent(Role.DATANODE.name()).addServiceComponentHost(hostname1).persist();
  hdfs.addServiceComponent(Role.NAMENODE.name()).persist();
  hdfs.getServiceComponent(Role.NAMENODE.name()).addServiceComponentHost(hostname1).persist();
  hdfs.addServiceComponent(Role.SECONDARY_NAMENODE.name()).persist();
  hdfs.getServiceComponent(Role.SECONDARY_NAMENODE.name()).addServiceComponentHost(hostname1).persist();
  ActionQueue aqMock=mock(ActionQueue.class);
  ArgumentCaptor<AgentCommand> commandCaptor=ArgumentCaptor.forClass(AgentCommand.class);
  ActionManager am=mock(ActionManager.class);
  HeartbeatMonitor hm=new HeartbeatMonitor(clusters,aqMock,am,heartbeatMonitorWakeupIntervalMS);
  HeartBeatHandler handler=new HeartBeatHandler(clusters,aqMock,am,injector);
  Register reg=new Register();
  reg.setHostname(hostname1);
  reg.setResponseId(12);
  reg.setTimestamp(System.currentTimeMillis() - 15);
  HostInfo hi=new HostInfo();
  hi.setOS("Centos5");
  reg.setHardwareProfile(hi);
  handler.handleRegistration(reg);
  HeartBeat hb=new HeartBeat();
  hb.setHostname(hostname1);
  hb.setNodeStatus(new HostStatus(HostStatus.Status.HEALTHY,"cool"));
  hb.setTimestamp(System.currentTimeMillis());
  hb.setResponseId(13);
  handler.handleHeartBeat(hb);
  LOG.info("YYY");
  clusters.getHost(hostname1).setLastHeartbeatTime(System.currentTimeMillis() - 15);
  hm.start();
  Thread.sleep(3 * heartbeatMonitorWakeupIntervalMS);
  hm.shutdown();
  hm.join(2 * heartbeatMonitorWakeupIntervalMS);
  if (hm.isAlive()) {
    fail("HeartbeatMonitor should be already stopped");
  }
  verify(aqMock,atLeast(2)).enqueue(eq(hostname1),commandCaptor.capture());
  List<AgentCommand> cmds=commandCaptor.getAllValues();
  assertTrue("HeartbeatMonitor should generate StatusCommands for host1",cmds.size() >= 2);
  for (  AgentCommand command : cmds) {
    assertEquals("HDFS",((StatusCommand)command).getServiceName());
  }
}
