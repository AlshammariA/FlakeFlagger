@Test public void testGlobRestriction4() throws Exception {
  Node a=superuser.getNode(path).addNode("a");
  allow(path,readPrivileges);
  deny(path,readPrivileges,createGlobRestriction("*/anotherpath"));
  String aPath=a.getPath();
  assertTrue(testSession.nodeExists(aPath));
  Node n=testSession.getNode(aPath);
  Node test=testSession.getNode(path);
  assertTrue(test.hasNode("a"));
  Node n2=test.getNode("a");
  assertTrue(n.isSame(n2));
}
