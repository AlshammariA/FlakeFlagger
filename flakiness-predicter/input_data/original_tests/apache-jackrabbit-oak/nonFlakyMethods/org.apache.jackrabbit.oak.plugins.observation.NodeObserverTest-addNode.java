@Test public void addNode(){
  NodeBuilder builder=before.builder();
  builder.getChildNode("m").getChildNode("n").setChildNode("new").setProperty("p","3");
  nodeObserver.contentChanged(builder.getNodeState(),CommitInfo.EMPTY);
  assertEquals(ImmutableMap.of("/m/n/new",ImmutableSet.of("p")),nodeObserver.added);
  assertTrue(nodeObserver.deleted.isEmpty());
  assertTrue(nodeObserver.changed.isEmpty());
  assertTrue(nodeObserver.properties.isEmpty());
}
