@Test public void testModified3() throws Exception {
  Node child=superuser.getNode(path).addNode("child",JcrConstants.NT_UNSTRUCTURED);
  child.addNode("a");
  child.addNode("b");
  superuser.save();
  Node n=testSession.getNode(child.getPath());
  assertFalse(n.isModified());
}
