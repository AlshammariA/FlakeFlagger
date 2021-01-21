@Test public void testHasChild() throws Exception {
  Tree rootTree=testRoot.getTree("/");
  assertTrue(rootTree.hasChild("a"));
  assertFalse(rootTree.hasChild(AccessControlConstants.REP_POLICY));
  Tree a=rootTree.getChild("a");
  assertTrue(a.hasChild("b"));
  assertFalse(a.hasChild("bb"));
  Tree b=a.getChild("b");
  assertTrue(b.hasChild("c"));
}
