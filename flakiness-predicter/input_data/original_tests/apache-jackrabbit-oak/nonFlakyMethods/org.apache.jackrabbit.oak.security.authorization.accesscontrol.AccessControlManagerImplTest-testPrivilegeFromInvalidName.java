@Test public void testPrivilegeFromInvalidName() throws Exception {
  List<String> invalid=new ArrayList<String>();
  invalid.add(null);
  invalid.add("");
  invalid.add("test:read");
  for (  String privilegeName : invalid) {
    try {
      acMgr.privilegeFromName(privilegeName);
      fail("Invalid privilege name " + privilegeName);
    }
 catch (    RepositoryException e) {
    }
  }
}
