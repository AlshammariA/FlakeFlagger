@Test public void testGroupMembership(){
  testMembership(PrincipalManager.SEARCH_TYPE_NOT_GROUP);
  testMembership(PrincipalManager.SEARCH_TYPE_GROUP);
  testMembership(PrincipalManager.SEARCH_TYPE_ALL);
}
