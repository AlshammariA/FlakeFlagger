/** 
 * @since OAK 1.0
 */
@Test public void testNotEqualAuthorizables() throws Exception {
  UserManager otherUserManager=getUserConfiguration().getUserManager(root,getNamePathMapper());
  Authorizable user=otherUserManager.getAuthorizable(testUser.getID());
  Authorizable group=otherUserManager.getAuthorizable(testGroup.getID());
  Map<Authorizable,Authorizable> notEqual=new HashMap<Authorizable,Authorizable>();
  notEqual.put(testUser,testGroup);
  notEqual.put(user,group);
  notEqual.put(testUser,user);
  notEqual.put(testGroup,group);
  for (  Map.Entry entry : notEqual.entrySet()) {
    assertFalse(entry.getKey().equals(entry.getValue()));
    assertFalse(entry.getValue().equals(entry.getKey()));
  }
}
