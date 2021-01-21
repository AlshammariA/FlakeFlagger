@Test public void testGetSupportedPrivilegesPropertyPath() throws Exception {
  try {
    acMgr.getSupportedPrivileges("/jcr:primaryType");
    fail("Property path -> PathNotFoundException expected.");
  }
 catch (  PathNotFoundException e) {
  }
}
