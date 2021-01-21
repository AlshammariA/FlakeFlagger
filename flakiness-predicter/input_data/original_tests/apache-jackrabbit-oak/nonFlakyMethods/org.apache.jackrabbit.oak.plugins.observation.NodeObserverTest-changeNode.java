@Test public void changeNode(){
  NodeBuilder builder=before.builder();
  builder.getChildNode("m").getChildNode("n").setProperty("p",42);
  nodeObserver.contentChanged(builder.getNodeState(),CommitInfo.EMPTY);
  assertTrue(nodeObserver.added.isEmpty());
  assertTrue(nodeObserver.deleted.isEmpty());
  assertEquals(ImmutableMap.of("/m/n",ImmutableSet.of("p")),nodeObserver.changed);
  assertEquals(ImmutableMap.of("/m/n",ImmutableMap.of("extra","42")),nodeObserver.properties);
}
