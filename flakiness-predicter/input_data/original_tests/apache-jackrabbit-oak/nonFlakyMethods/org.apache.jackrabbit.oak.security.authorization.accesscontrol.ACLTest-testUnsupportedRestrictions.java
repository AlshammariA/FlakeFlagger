@Test public void testUnsupportedRestrictions() throws Exception {
  Map<String,Value> restrictions=Collections.singletonMap("unknownRestriction",getValueFactory().createValue("value"));
  try {
    acl.addEntry(testPrincipal,testPrivileges,false,restrictions);
    fail("Invalid restrictions -> AccessControlException expected");
  }
 catch (  AccessControlException e) {
  }
}
