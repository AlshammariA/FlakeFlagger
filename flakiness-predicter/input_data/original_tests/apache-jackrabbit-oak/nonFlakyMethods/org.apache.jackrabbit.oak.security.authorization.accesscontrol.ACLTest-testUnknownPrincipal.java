@Test public void testUnknownPrincipal() throws Exception {
  Principal unknownPrincipal=new InvalidTestPrincipal("unknown");
  try {
    acl.addAccessControlEntry(unknownPrincipal,privilegesFromNames(JCR_READ));
    fail("Adding an ACE with an unknown principal should fail");
  }
 catch (  AccessControlException e) {
  }
}
