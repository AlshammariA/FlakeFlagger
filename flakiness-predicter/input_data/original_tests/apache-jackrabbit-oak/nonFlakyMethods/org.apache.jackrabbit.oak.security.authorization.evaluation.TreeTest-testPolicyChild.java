@Test public void testPolicyChild() throws Exception {
  assertTrue(root.getTree('/' + AccessControlConstants.REP_POLICY).exists());
  Tree rootTree=testRoot.getTree("/");
  assertFalse(rootTree.hasChild(AccessControlConstants.REP_POLICY));
  assertFalse(rootTree.getChild(AccessControlConstants.REP_POLICY).exists());
}
