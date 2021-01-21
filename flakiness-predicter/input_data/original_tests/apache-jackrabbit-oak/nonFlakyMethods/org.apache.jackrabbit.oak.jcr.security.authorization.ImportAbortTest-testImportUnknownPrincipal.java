@Test public void testImportUnknownPrincipal() throws Exception {
  try {
    runImport();
    fail("Import with unknown principal must fail.");
  }
 catch (  AccessControlException e) {
  }
}
