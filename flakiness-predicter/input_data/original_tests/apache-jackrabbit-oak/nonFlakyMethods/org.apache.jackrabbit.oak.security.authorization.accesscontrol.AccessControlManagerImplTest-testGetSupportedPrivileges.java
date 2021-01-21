@Test public void testGetSupportedPrivileges() throws Exception {
  List<Privilege> allPrivileges=Arrays.asList(getPrivilegeManager(root).getRegisteredPrivileges());
  List<String> testPaths=new ArrayList<String>();
  testPaths.add(null);
  testPaths.add("/");
  testPaths.add("/jcr:system");
  testPaths.add(testPath);
  for (  String path : testPaths) {
    Privilege[] supported=acMgr.getSupportedPrivileges(path);
    assertNotNull(supported);
    assertEquals(allPrivileges.size(),supported.length);
    assertTrue(allPrivileges.containsAll(Arrays.asList(supported)));
  }
}
