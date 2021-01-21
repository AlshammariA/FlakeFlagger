@Test public void testComplementaryEntry() throws Exception {
  Privilege[] privileges=privilegesFromNames(JCR_READ);
  acl.addEntry(testPrincipal,privileges,true);
  assertTrue(acl.addEntry(testPrincipal,privileges,false));
  assertEquals(1,acl.size());
  assertACE(acl.getEntries().get(0),false,privileges);
}
