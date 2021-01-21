@Test public void ignoreAdd(){
  NodeBuilder builder=before.builder();
  builder.getChildNode("a").getChildNode("b").setChildNode("new").setProperty("p","3");
  nodeObserver.contentChanged(builder.getNodeState(),CommitInfo.EMPTY);
  assertTrue(nodeObserver.added.isEmpty());
  assertTrue(nodeObserver.deleted.isEmpty());
  assertTrue(nodeObserver.changed.isEmpty());
  assertTrue(nodeObserver.properties.isEmpty());
}
