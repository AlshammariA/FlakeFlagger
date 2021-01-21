@Test public void testDenyRoot() throws Exception {
  Set<AccessControlEntry> acesBefore=getACEs("/");
  try {
    deny("/",readPrivileges);
    testSession.getRootNode();
    fail("root should not be accessible");
  }
 catch (  Exception e) {
  }
 finally {
    restoreAces("/",acesBefore);
  }
}
