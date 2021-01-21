/** 
 * @since OAK 1.0
 */
@Test public void testEqualAuthorizables() throws Exception {
  Authorizable user=userMgr.getAuthorizable(testUser.getID());
  Authorizable group=userMgr.getAuthorizable(testGroup.getID());
  Map<Authorizable,Authorizable> equalAuthorizables=new HashMap<Authorizable,Authorizable>();
  equalAuthorizables.put(testUser,testUser);
  equalAuthorizables.put(testGroup,testGroup);
  equalAuthorizables.put(user,user);
  equalAuthorizables.put(group,group);
  equalAuthorizables.put(testUser,user);
  equalAuthorizables.put(testGroup,group);
  for (  Map.Entry entry : equalAuthorizables.entrySet()) {
    assertEquals(entry.getKey(),entry.getValue());
    assertEquals(entry.getValue(),entry.getKey());
  }
}
