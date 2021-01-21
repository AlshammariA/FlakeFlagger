@Test public void testNullPrincipal() throws Exception {
  try {
    acl.addAccessControlEntry(null,privilegesFromNames(JCR_READ));
    fail("Adding an ACE with null principal should fail");
  }
 catch (  AccessControlException e) {
  }
}
