@Test public void testAllowChild() throws Exception {
  Tree rootTree1=testRoot1.getTree("/");
  Tree rootTree2=testRoot2.getTree("/");
  assertFalse(rootTree1.hasChild("a/bb"));
  assertFalse(rootTree2.hasChild("a/bb"));
  setupPermission("/a/bb",testPrincipal,true,PrivilegeConstants.JCR_READ);
  assertFalse(rootTree1.hasChild("a/bb"));
  assertFalse(rootTree2.hasChild("a/bb"));
}
