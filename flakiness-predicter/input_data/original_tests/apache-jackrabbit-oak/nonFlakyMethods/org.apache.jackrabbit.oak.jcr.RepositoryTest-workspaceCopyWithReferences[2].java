@Test public void workspaceCopyWithReferences() throws RepositoryException {
  Session session=getAdminSession();
  ValueFactory vf=session.getValueFactory();
  Node root=session.getRootNode();
  Node other=root.addNode("other");
  other.addMixin("mix:referenceable");
  Node src=root.addNode("src");
  Node test=src.addNode("test");
  test.addMixin("mix:referenceable");
  src.setProperty("test",test);
  src.setProperty("other",other);
  src.setProperty("multi",new Value[]{vf.createValue(test),vf.createValue(other)});
  session.save();
  session.getWorkspace().copy("/src","/dest");
  Node dest=root.getNode("dest");
  assertEquals("/dest/test",dest.getProperty("test").getNode().getPath());
  assertEquals("/other",dest.getProperty("other").getNode().getPath());
  Value[] refs=dest.getProperty("multi").getValues();
  assertEquals(2,refs.length);
  Set<String> paths=new HashSet<String>();
  for (  Value v : refs) {
    paths.add(session.getNodeByIdentifier(v.getString()).getPath());
  }
  assertTrue(paths.contains("/other"));
  assertTrue(paths.contains("/dest/test"));
}
