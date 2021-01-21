public void testSetMixins() throws RepositoryException {
  Node n=testRootNode.addNode("foo","nt:folder");
  n.addMixin("test:AA");
  n.setProperty("test:propAA","AA");
  n.setProperty("test:propA","A");
  superuser.save();
  ((JackrabbitNode)n).setMixins(new String[]{"test:A"});
  superuser.save();
  assertTrue(n.hasProperty("test:propA"));
  assertFalse(n.hasProperty("test:propAA"));
  ((JackrabbitNode)n).setMixins(new String[]{"test:AA"});
  n.setProperty("test:propAA","AA");
  superuser.save();
  assertTrue(n.hasProperty("test:propA"));
  assertTrue(n.hasProperty("test:propAA"));
  ((JackrabbitNode)n).setMixins(new String[]{"mix:title"});
  n.setProperty("jcr:title","...");
  n.setProperty("jcr:description","blah blah");
  superuser.save();
  assertTrue(n.hasProperty("jcr:title"));
  assertTrue(n.hasProperty("jcr:description"));
  assertFalse(n.hasProperty("test:propA"));
  assertFalse(n.hasProperty("test:propAA"));
  n.remove();
  superuser.save();
}
