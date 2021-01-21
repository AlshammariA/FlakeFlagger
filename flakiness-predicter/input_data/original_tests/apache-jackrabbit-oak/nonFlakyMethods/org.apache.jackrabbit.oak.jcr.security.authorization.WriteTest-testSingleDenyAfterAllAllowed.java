@Test public void testSingleDenyAfterAllAllowed() throws Exception {
  Privilege[] allPrivileges=privilegesFromName(Privilege.JCR_ALL);
  allow(path,allPrivileges);
  Privilege[] lockPrivileges=privilegesFromName(Privilege.JCR_LOCK_MANAGEMENT);
  deny(path,lockPrivileges);
  assertFalse(testAcMgr.hasPrivileges(path,allPrivileges));
  assertFalse(testAcMgr.hasPrivileges(path,lockPrivileges));
  List<Privilege> remainingprivs=new ArrayList<Privilege>(Arrays.asList(allPrivileges[0].getAggregatePrivileges()));
  remainingprivs.remove(lockPrivileges[0]);
  assertTrue(testAcMgr.hasPrivileges(path,remainingprivs.toArray(new Privilege[remainingprivs.size()])));
}
