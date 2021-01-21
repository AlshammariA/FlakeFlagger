@Test public void testRestrictions() throws Exception {
  String[] names=acl.getRestrictionNames();
  assertNotNull(names);
  assertEquals(3,names.length);
  assertArrayEquals(new String[]{REP_GLOB,REP_NT_NAMES,REP_PREFIXES},names);
  assertEquals(PropertyType.STRING,acl.getRestrictionType(names[0]));
  assertEquals(PropertyType.NAME,acl.getRestrictionType(names[1]));
  assertEquals(PropertyType.STRING,acl.getRestrictionType(names[2]));
  Privilege[] writePriv=privilegesFromNames(JCR_WRITE);
  assertTrue(acl.addAccessControlEntry(testPrincipal,writePriv));
  assertEquals(1,acl.getAccessControlEntries().length);
  assertFalse(acl.addAccessControlEntry(testPrincipal,writePriv));
  assertEquals(1,acl.getAccessControlEntries().length);
  assertFalse(acl.addEntry(testPrincipal,writePriv,true));
  assertEquals(1,acl.getAccessControlEntries().length);
  assertTrue(acl.addEntry(testPrincipal,writePriv,false));
  assertEquals(1,acl.getAccessControlEntries().length);
  Map<String,Value> restrictions=Collections.singletonMap(REP_GLOB,getValueFactory().createValue("/.*"));
  assertTrue(acl.addEntry(testPrincipal,writePriv,false,restrictions));
  assertEquals(2,acl.getAccessControlEntries().length);
  assertFalse(acl.addEntry(testPrincipal,writePriv,false,restrictions));
  assertEquals(2,acl.getAccessControlEntries().length);
  assertTrue(acl.addEntry(testPrincipal,writePriv,true,restrictions));
  assertEquals(2,acl.getAccessControlEntries().length);
}
