@Test public void testGetChild() throws Exception {
  Tree rootTree=testRoot.getTree("/");
  assertTrue(rootTree.exists());
  Tree a=rootTree.getChild("a");
  assertTrue(a.exists());
  Tree b=a.getChild("b");
  assertTrue(b.exists());
  assertTrue(b.getChild("c").exists());
  assertFalse(a.getChild("bb").exists());
}
