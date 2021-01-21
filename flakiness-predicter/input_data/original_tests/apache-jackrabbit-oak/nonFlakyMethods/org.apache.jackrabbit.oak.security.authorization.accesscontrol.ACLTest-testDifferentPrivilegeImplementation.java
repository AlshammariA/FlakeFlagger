@Test public void testDifferentPrivilegeImplementation() throws Exception {
  Privilege[] readPriv=privilegesFromNames(JCR_READ);
  acl.addEntry(testPrincipal,readPriv,false);
  assertFalse(acl.addEntry(new PrincipalImpl(testPrincipal.getName()),readPriv,false));
  assertFalse(acl.addEntry(new Principal(){
    public String getName(){
      return testPrincipal.getName();
    }
  }
,readPriv,false));
}
