@Test public void ignoreDelete(){
  NodeBuilder builder=before.builder();
  builder.getChildNode("a").getChildNode("b").remove();
  nodeObserver.contentChanged(builder.getNodeState(),CommitInfo.EMPTY);
  assertTrue(nodeObserver.added.isEmpty());
  assertTrue(nodeObserver.deleted.isEmpty());
  assertTrue(nodeObserver.changed.isEmpty());
  assertTrue(nodeObserver.properties.isEmpty());
}
