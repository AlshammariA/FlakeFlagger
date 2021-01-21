@Test public void testGetPrivilegesForPrincipalsAccessControlledNodePath() throws Exception {
  Set<Principal> testPrincipals=ImmutableSet.of(testPrincipal);
  Privilege[] expected=new Privilege[0];
  for (  String path : getAcContentPaths()) {
    assertArrayEquals(expected,acMgr.getPrivileges(path,testPrincipals));
  }
}
