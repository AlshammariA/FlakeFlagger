@Test public void testHasNullPrivileges() throws Exception {
  assertTrue(acMgr.hasPrivileges(testPath,null));
}
