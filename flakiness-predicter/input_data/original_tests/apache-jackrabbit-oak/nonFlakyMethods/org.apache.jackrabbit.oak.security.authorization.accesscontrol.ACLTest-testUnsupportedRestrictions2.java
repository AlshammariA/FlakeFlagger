@Test public void testUnsupportedRestrictions2() throws Exception {
  RestrictionProvider rp=new TestRestrictionProvider("restr",Type.NAME,false);
  JackrabbitAccessControlList acl=createACL(getTestPath(),new ArrayList(),namePathMapper,rp);
  try {
    acl.addEntry(testPrincipal,testPrivileges,false,Collections.<String,Value>singletonMap("unsupported",getValueFactory().createValue("value")));
    fail("Unsupported restriction must be detected.");
  }
 catch (  AccessControlException e) {
  }
}
