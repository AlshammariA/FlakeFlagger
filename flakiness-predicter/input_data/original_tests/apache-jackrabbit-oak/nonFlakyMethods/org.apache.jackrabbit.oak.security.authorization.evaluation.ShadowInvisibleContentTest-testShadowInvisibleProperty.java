@Test public void testShadowInvisibleProperty() throws Exception {
  setupPermission("/a",testPrincipal,true,PrivilegeConstants.JCR_ALL);
  setupPermission("/a",testPrincipal,false,PrivilegeConstants.REP_READ_PROPERTIES);
  Root testRoot=getTestRoot();
  Tree a=testRoot.getTree("/a");
  assertNull(a.getProperty("aProp"));
  assertFalse(a.hasProperty("aProp"));
  a.setProperty("aProp","aValue1");
  assertNotNull(a.getProperty("aProp"));
  assertTrue(a.hasProperty("aProp"));
  testRoot.commit();
  assertNull(a.getProperty("aProp"));
  assertFalse(a.hasProperty("aProp"));
}
