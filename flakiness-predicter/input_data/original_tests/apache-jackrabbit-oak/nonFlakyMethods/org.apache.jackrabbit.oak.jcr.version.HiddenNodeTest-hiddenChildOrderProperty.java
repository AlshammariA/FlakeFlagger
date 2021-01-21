@Test public void hiddenChildOrderProperty() throws Exception {
  Node test=session.getRootNode().addNode("test","nt:unstructured");
  Node child=test.addNode("child");
  child.addNode("a");
  child.addNode("b");
  child.addNode("c");
  test.addMixin("mix:versionable");
  session.save();
  NodeBuilder testBuilder=store.getRoot().builder().getChildNode("test").getChildNode("child");
  assertTrue(testBuilder.hasProperty(TreeConstants.OAK_CHILD_ORDER));
  session.refresh(false);
  Version v1=vMgr.checkpoint("/test");
  Version v2=vMgr.checkpoint("/test");
  NodeState state=store.getRoot();
  for (  String name : PathUtils.elements(v2.getPath())) {
    state=state.getChildNode(name);
  }
  state=state.getChildNode(VersionConstants.JCR_FROZENNODE).getChildNode("child");
  assertTrue(state.exists());
  assertTrue(state.hasProperty(TreeConstants.OAK_CHILD_ORDER));
  vMgr.restore(v1,true);
  state=store.getRoot().getChildNode("test").getChildNode("child");
  assertTrue(state.hasProperty(TreeConstants.OAK_CHILD_ORDER));
}
