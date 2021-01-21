@Test public void testGetSupportedPrivilegesIncludingPathConversion() throws Exception {
  List<Privilege> allPrivileges=Arrays.asList(getPrivilegeManager(root).getRegisteredPrivileges());
  List<String> testPaths=new ArrayList<String>();
  testPaths.add('/' + TEST_LOCAL_PREFIX + ":testRoot");
  testPaths.add("/{" + TEST_URI + "}testRoot");
  NameMapper remapped=new LocalNameMapper(root,singletonMap(TEST_LOCAL_PREFIX,TEST_URI));
  AccessControlManager acMgr=getAccessControlManager(new NamePathMapperImpl(remapped));
  for (  String path : testPaths) {
    Privilege[] supported=acMgr.getSupportedPrivileges(path);
    assertNotNull(supported);
    assertEquals(allPrivileges.size(),supported.length);
    assertTrue(allPrivileges.containsAll(Arrays.asList(supported)));
  }
}
