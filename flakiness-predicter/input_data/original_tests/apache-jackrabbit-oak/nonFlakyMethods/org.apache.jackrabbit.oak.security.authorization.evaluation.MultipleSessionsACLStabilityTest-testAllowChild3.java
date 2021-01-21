@Test public void testAllowChild3() throws Exception {
  Tree rootTree1=testRoot1.getTree("/");
  Tree rootTree2=testRoot2.getTree("/");
  assertTrue(rootTree1.hasChild("a"));
  assertTrue(rootTree2.hasChild("a"));
  assertFalse(rootTree1.hasChild("a/bb"));
  assertFalse(rootTree2.hasChild("a/bb"));
  setupPermission(testRoot1,"/a",testPrincipal,false,PrivilegeConstants.JCR_READ);
  assertFalse(rootTree1.hasChild("a"));
  assertTrue(rootTree2.hasChild("a"));
  String uid=testPrincipal.getName();
  ContentSession session3=login(new SimpleCredentials(uid,uid.toCharArray()));
  Tree rootTree3=session3.getLatestRoot().getTree("/");
  assertFalse(rootTree3.hasChild("a"));
}
