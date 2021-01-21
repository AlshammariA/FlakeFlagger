@Test public void hiddenChildNode() throws Exception {
  Node test=session.getRootNode().addNode("test","nt:unstructured");
  test.addMixin("mix:versionable");
  test.addNode("child");
  session.save();
  NodeBuilder builder=store.getRoot().builder();
  NodeBuilder testBuilder=builder.getChildNode("test").getChildNode("child");
  testBuilder.child(":hidden").setProperty("property","value");
  store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  session.refresh(false);
  Version v1=vMgr.checkpoint("/test");
  Version v2=vMgr.checkpoint("/test");
  NodeState state=store.getRoot();
  for (  String name : PathUtils.elements(v2.getPath())) {
    state=state.getChildNode(name);
  }
  state=state.getChildNode("jcr:frozenNode").getChildNode("child");
  assertTrue(state.exists());
  assertFalse(state.hasChildNode(":hidden"));
  vMgr.restore(v1,true);
  state=store.getRoot().getChildNode("test").getChildNode("child");
  assertFalse(state.hasChildNode(":hidden"));
}
