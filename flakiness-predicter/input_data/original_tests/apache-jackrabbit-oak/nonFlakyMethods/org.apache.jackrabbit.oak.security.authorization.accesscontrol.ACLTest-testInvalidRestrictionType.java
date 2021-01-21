@Test public void testInvalidRestrictionType() throws Exception {
  RestrictionProvider rp=new TestRestrictionProvider("restr",Type.NAME,false);
  JackrabbitAccessControlList acl=createACL(getTestPath(),new ArrayList(),namePathMapper,rp);
  try {
    acl.addEntry(testPrincipal,testPrivileges,false,Collections.<String,Value>singletonMap("restr",getValueFactory().createValue(true)));
    fail("Invalid restriction type.");
  }
 catch (  AccessControlException e) {
  }
}
