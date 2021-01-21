@Test public void deleteNode(){
  NodeBuilder builder=before.builder();
  builder.getChildNode("m").getChildNode("n").getChildNode("o").remove();
  nodeObserver.contentChanged(builder.getNodeState(),CommitInfo.EMPTY);
  assertTrue(nodeObserver.added.isEmpty());
  assertEquals(ImmutableMap.of("/m/n/o",ImmutableSet.of("q")),nodeObserver.deleted);
  assertTrue(nodeObserver.changed.isEmpty());
  assertTrue(nodeObserver.properties.isEmpty());
}
