@Test public void testGetPrivilegesFromNullNames(){
  try {
    privilegeManager.getPrivilege(null);
    fail("invalid privilege name (null)");
  }
 catch (  Exception e) {
  }
}
