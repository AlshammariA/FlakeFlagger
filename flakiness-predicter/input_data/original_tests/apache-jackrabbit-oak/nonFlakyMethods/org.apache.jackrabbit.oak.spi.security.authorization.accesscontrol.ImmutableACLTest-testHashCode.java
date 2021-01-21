@Test public void testHashCode() throws Exception {
  RestrictionProvider rp=getRestrictionProvider();
  ACE ace1=createEntry(testPrincipal,privilegesFromNames(PrivilegeConstants.JCR_VERSION_MANAGEMENT),false);
  ACE ace2=createEntry(testPrincipal,testPrivileges,true);
  ACE ace2b=createEntry(testPrincipal,getAggregatedPrivileges(testPrivileges),true);
  JackrabbitAccessControlList acl=createACL(ace1,ace2);
  JackrabbitAccessControlList repoAcl=createACL((String)null,ace1,ace2);
  int hc=acl.hashCode();
  assertTrue(hc == createACL(ace1,ace2).hashCode());
  assertTrue(hc == createACL(ace1,ace2b).hashCode());
  assertTrue(repoAcl.hashCode() == createACL((String)null,ace1,ace2b).hashCode());
  assertFalse(hc == createACL(ace2,ace1).hashCode());
  assertFalse(hc == repoAcl.hashCode());
  assertFalse(hc == createEmptyACL().hashCode());
  assertFalse(hc == createACL("/anotherPath",ace1,ace2).hashCode());
  assertFalse(hc == new TestACL("/anotherPath",rp,ace1,ace2).hashCode());
  assertFalse(hc == new TestACL("/anotherPath",rp,ace1,ace2).hashCode());
  assertFalse(hc == new TestACL("/anotherPath",rp).hashCode());
  assertFalse(hc == new TestACL(getTestPath(),rp,ace1,ace2).hashCode());
}
