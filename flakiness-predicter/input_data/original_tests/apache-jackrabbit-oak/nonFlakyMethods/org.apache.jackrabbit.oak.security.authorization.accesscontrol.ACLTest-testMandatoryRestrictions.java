@Test public void testMandatoryRestrictions() throws Exception {
  RestrictionProvider rp=new TestRestrictionProvider("mandatory",Type.NAME,true);
  JackrabbitAccessControlList acl=createACL(getTestPath(),new ArrayList(),namePathMapper,rp);
  try {
    acl.addEntry(testPrincipal,testPrivileges,false,Collections.<String,Value>emptyMap());
    fail("Mandatory restriction must be enforced.");
  }
 catch (  AccessControlException e) {
  }
}
