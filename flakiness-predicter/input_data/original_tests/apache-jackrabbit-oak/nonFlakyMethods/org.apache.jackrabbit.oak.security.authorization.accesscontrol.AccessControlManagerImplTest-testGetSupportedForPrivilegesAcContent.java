@Test public void testGetSupportedForPrivilegesAcContent() throws Exception {
  List<Privilege> allPrivileges=Arrays.asList(getPrivilegeManager(root).getRegisteredPrivileges());
  for (  String acPath : getAcContentPaths()) {
    Privilege[] supported=acMgr.getSupportedPrivileges(acPath);
    assertNotNull(supported);
    assertEquals(allPrivileges.size(),supported.length);
    assertTrue(allPrivileges.containsAll(Arrays.asList(supported)));
  }
}
