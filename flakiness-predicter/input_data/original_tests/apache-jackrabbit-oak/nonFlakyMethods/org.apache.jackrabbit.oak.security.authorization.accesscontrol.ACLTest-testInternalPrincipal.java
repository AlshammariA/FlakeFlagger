@Test public void testInternalPrincipal() throws RepositoryException {
  Principal internal=new PrincipalImpl("unknown");
  acl.addAccessControlEntry(internal,privilegesFromNames(JCR_READ));
}
