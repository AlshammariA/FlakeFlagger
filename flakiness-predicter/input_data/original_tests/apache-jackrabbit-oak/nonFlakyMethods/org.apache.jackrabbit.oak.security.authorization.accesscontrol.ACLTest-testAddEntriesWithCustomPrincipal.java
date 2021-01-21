@Test public void testAddEntriesWithCustomPrincipal() throws Exception {
  Principal oakPrincipal=new PrincipalImpl("anonymous");
  Principal principal=new Principal(){
    @Override public String getName(){
      return "anonymous";
    }
  }
;
  assertTrue(acl.addAccessControlEntry(oakPrincipal,privilegesFromNames(JCR_READ)));
  assertTrue(acl.addAccessControlEntry(principal,privilegesFromNames(JCR_READ_ACCESS_CONTROL)));
  assertEquals(1,acl.getAccessControlEntries().length);
  assertTrue(acl.addEntry(principal,privilegesFromNames(JCR_READ),false));
  assertEquals(2,acl.getAccessControlEntries().length);
  assertArrayEquals(privilegesFromNames(JCR_READ_ACCESS_CONTROL),acl.getAccessControlEntries()[0].getPrivileges());
}
