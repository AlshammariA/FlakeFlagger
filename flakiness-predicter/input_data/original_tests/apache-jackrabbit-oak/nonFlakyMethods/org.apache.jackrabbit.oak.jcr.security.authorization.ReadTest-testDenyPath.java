@Test public void testDenyPath() throws Exception {
  try {
    deny(path,readPrivileges);
    testSession.getNode(path);
    fail("nodet should not be accessible");
  }
 catch (  Exception e) {
  }
}
