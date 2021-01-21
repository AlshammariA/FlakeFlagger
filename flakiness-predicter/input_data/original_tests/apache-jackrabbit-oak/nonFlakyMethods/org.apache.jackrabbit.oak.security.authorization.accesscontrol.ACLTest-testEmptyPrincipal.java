@Test public void testEmptyPrincipal() throws Exception {
  try {
    acl.addAccessControlEntry(new PrincipalImpl(""),privilegesFromNames(JCR_READ));
    fail("Adding an ACE with empty-named principal should fail");
  }
 catch (  AccessControlException e) {
  }
}
