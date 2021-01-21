@Test public void testEquals() throws Exception {
  RestrictionProvider rp=getRestrictionProvider();
  ACE ace1=createEntry(testPrincipal,false,null,PrivilegeConstants.JCR_VERSION_MANAGEMENT);
  ACE ace2=createEntry(testPrincipal,testPrivileges,true);
  ACE ace2b=createEntry(testPrincipal,getAggregatedPrivileges(testPrivileges),true);
  JackrabbitAccessControlList acl=createACL(ace1,ace2);
  JackrabbitAccessControlList repoAcl=createACL((String)null,ace1,ace2);
  assertEquals(acl,createACL(ace1,ace2));
  assertEquals(acl,createACL(ace1,ace2b));
  assertEquals(repoAcl,createACL((String)null,ace1,ace2b));
  assertFalse(acl.equals(createACL(ace2,ace1)));
  assertFalse(acl.equals(repoAcl));
  assertFalse(acl.equals(createEmptyACL()));
  assertFalse(acl.equals(createACL("/anotherPath",ace1,ace2)));
  assertFalse(acl.equals(new TestACL("/anotherPath",rp,ace1,ace2)));
  assertFalse(acl.equals(new TestACL("/anotherPath",rp,ace1,ace2)));
  assertFalse(acl.equals(new TestACL("/anotherPath",rp)));
  assertFalse(acl.equals(new TestACL(getTestPath(),rp,ace1,ace2)));
}
