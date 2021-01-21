@Test public void testPrivilegeFromUnknownName() throws Exception {
  List<String> invalid=new ArrayList<String>();
  invalid.add("unknownPrivilege");
  invalid.add('{' + NamespaceRegistry.NAMESPACE_JCR + "}unknown");
  for (  String privilegeName : invalid) {
    try {
      acMgr.privilegeFromName(privilegeName);
      fail("Invalid privilege name " + privilegeName);
    }
 catch (    AccessControlException e) {
    }
  }
}
