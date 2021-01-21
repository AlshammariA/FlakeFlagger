@Test public void testReadOnlyIsEveryOne() throws Exception {
  Session s=getHelper().getReadOnlySession();
  try {
    Principal[] pcpls=getPrincipals(getHelper().getReadOnlyCredentials());
    for (    Principal pcpl : pcpls) {
      if (!(pcpl.equals(everyone))) {
        assertTrue(everyone.isMember(pcpl));
      }
    }
  }
  finally {
    s.logout();
  }
}
