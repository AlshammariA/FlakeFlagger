@Test public void testMvRestrictions() throws Exception {
  ValueFactory vf=getValueFactory();
  Value[] vs=new Value[]{vf.createValue(JcrConstants.NT_FILE,PropertyType.NAME),vf.createValue(JcrConstants.NT_FOLDER,PropertyType.NAME)};
  Map<String,Value[]> mvRestrictions=Collections.singletonMap(REP_NT_NAMES,vs);
  Map<String,Value> restrictions=Collections.singletonMap(REP_GLOB,vf.createValue("/.*"));
  assertTrue(acl.addEntry(testPrincipal,testPrivileges,false,restrictions,mvRestrictions));
  assertFalse(acl.addEntry(testPrincipal,testPrivileges,false,restrictions,mvRestrictions));
  assertEquals(1,acl.getAccessControlEntries().length);
  JackrabbitAccessControlEntry ace=(JackrabbitAccessControlEntry)acl.getAccessControlEntries()[0];
  try {
    ace.getRestriction(REP_NT_NAMES);
    fail();
  }
 catch (  ValueFormatException e) {
  }
  Value[] vvs=ace.getRestrictions(REP_NT_NAMES);
  assertArrayEquals(vs,vvs);
}
