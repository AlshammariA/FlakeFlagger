@Test public void testSessionGetNode() throws Exception {
  Node nn=superuser.getNode(n.getPath());
  assertTrue(n.isSame(nn));
}
