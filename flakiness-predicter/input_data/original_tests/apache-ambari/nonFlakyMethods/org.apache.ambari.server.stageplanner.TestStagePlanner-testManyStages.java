@Test public void testManyStages(){
  RoleCommandOrder.initialize();
  RoleCommandOrder rco=new RoleCommandOrder();
  RoleGraph rg=new RoleGraph(rco);
  long now=System.currentTimeMillis();
  Stage stage=StageUtils.getATestStage(1,1,"host1");
  stage.addHostRoleExecutionCommand("host11",Role.SECONDARY_NAMENODE,RoleCommand.START,new ServiceComponentHostStartEvent("SECONDARY_NAMENODE","host11",now,new HashMap<String,String>()),"cluster1","HDFS");
  stage.addHostRoleExecutionCommand("host2",Role.HBASE_MASTER,RoleCommand.START,new ServiceComponentHostStartEvent("HBASE_MASTER","host2",now,new HashMap<String,String>()),"cluster1","HBASE");
  stage.addHostRoleExecutionCommand("host3",Role.ZOOKEEPER_SERVER,RoleCommand.START,new ServiceComponentHostStartEvent("ZOOKEEPER_SERVER","host3",now,new HashMap<String,String>()),"cluster1","ZOOKEEPER");
  stage.addHostRoleExecutionCommand("host4",Role.DATANODE,RoleCommand.START,new ServiceComponentHostStartEvent("DATANODE","host4",now,new HashMap<String,String>()),"cluster1","HDFS");
  stage.addHostRoleExecutionCommand("host4",Role.HBASE_REGIONSERVER,RoleCommand.START,new ServiceComponentHostStartEvent("HBASE_REGIONSERVER","host4",now,new HashMap<String,String>()),"cluster1","HBASE");
  stage.addHostRoleExecutionCommand("host4",Role.TASKTRACKER,RoleCommand.START,new ServiceComponentHostStartEvent("TASKTRACKER","host4",now,new HashMap<String,String>()),"cluster1","MAPREDUCE");
  stage.addHostRoleExecutionCommand("host5",Role.JOBTRACKER,RoleCommand.START,new ServiceComponentHostStartEvent("JOBTRACKER","host5",now,new HashMap<String,String>()),"cluster1","MAPREDUCE");
  stage.addHostRoleExecutionCommand("host6",Role.OOZIE_SERVER,RoleCommand.START,new ServiceComponentHostStartEvent("OOZIE_SERVER","host6",now,new HashMap<String,String>()),"cluster1","OOZIE");
  stage.addHostRoleExecutionCommand("host7",Role.WEBHCAT_SERVER,RoleCommand.START,new ServiceComponentHostStartEvent("WEBHCAT_SERVER","host7",now,new HashMap<String,String>()),"cluster1","WEBHCAT");
  stage.addHostRoleExecutionCommand("host8",Role.NAGIOS_SERVER,RoleCommand.START,new ServiceComponentHostStartEvent("NAGIOS_SERVER","host8",now,new HashMap<String,String>()),"cluster1","NAGIOS");
  stage.addHostRoleExecutionCommand("host4",Role.GANGLIA_MONITOR,RoleCommand.START,new ServiceComponentHostStartEvent("GANGLIA_MONITOR","host4",now,new HashMap<String,String>()),"cluster1","GANGLIA");
  stage.addHostRoleExecutionCommand("host9",Role.GANGLIA_SERVER,RoleCommand.START,new ServiceComponentHostStartEvent("GANGLIA_SERVER","host9",now,new HashMap<String,String>()),"cluster1","GANGLIA");
  System.out.println(stage.toString());
  rg.build(stage);
  System.out.println(rg.stringifyGraph());
  List<Stage> outStages=rg.getStages();
  for (  Stage s : outStages) {
    System.out.println(s.toString());
  }
  assertEquals(4,outStages.size());
}
