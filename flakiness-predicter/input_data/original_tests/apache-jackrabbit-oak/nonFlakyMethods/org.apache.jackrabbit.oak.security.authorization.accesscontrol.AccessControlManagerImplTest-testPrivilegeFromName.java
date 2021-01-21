@Test public void testPrivilegeFromName() throws Exception {
  List<Privilege> allPrivileges=Arrays.asList(getPrivilegeManager(root).getRegisteredPrivileges());
  for (  Privilege privilege : allPrivileges) {
    Privilege p=acMgr.privilegeFromName(privilege.getName());
    assertEquals(privilege,p);
  }
}
