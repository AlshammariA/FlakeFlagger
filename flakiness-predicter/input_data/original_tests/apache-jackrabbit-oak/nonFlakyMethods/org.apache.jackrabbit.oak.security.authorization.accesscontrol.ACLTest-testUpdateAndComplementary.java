@Test public void testUpdateAndComplementary() throws Exception {
  Privilege[] readPriv=privilegesFromNames(JCR_READ);
  Privilege[] writePriv=privilegesFromNames(JCR_WRITE);
  Privilege[] acReadPriv=privilegesFromNames(JCR_READ_ACCESS_CONTROL);
  assertTrue(acl.addEntry(testPrincipal,readPriv,true));
  assertTrue(acl.addEntry(testPrincipal,writePriv,true));
  assertTrue(acl.addEntry(testPrincipal,acReadPriv,true));
  assertEquals(1,acl.size());
  assertTrue(acl.addEntry(testPrincipal,readPriv,false));
  assertEquals(2,acl.size());
  assertACE(acl.getEntries().get(0),true,privilegesFromNames(JCR_WRITE,JCR_READ_ACCESS_CONTROL));
  assertACE(acl.getEntries().get(1),false,readPriv);
}
