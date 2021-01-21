@Test public void testShadowInvisibleNode() throws Exception {
  setupPermission("/a",testPrincipal,true,PrivilegeConstants.JCR_ALL);
  setupPermission("/a/b",testPrincipal,false,PrivilegeConstants.JCR_ALL);
  setupPermission("/a/b/c",testPrincipal,true,PrivilegeConstants.JCR_ALL);
  Root testRoot=getTestRoot();
  Tree a=testRoot.getTree("/a");
  assertFalse(a.hasChild("b"));
  Tree b=a.addChild("b");
  assertTrue(a.hasChild("b"));
  assertFalse(b.hasChild("c"));
  try {
    testRoot.commit();
    fail();
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isConstraintViolation());
  }
}
