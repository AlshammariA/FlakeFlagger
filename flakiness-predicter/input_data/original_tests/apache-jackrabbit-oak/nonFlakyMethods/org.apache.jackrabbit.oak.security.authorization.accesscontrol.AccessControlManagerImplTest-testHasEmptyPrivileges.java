@Test public void testHasEmptyPrivileges() throws Exception {
  assertTrue(acMgr.hasPrivileges(testPath,new Privilege[0]));
}
