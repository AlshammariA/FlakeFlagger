/** 
 * @since OAK 1.0
 */
@Test public void testHashCode() throws Exception {
  Authorizable user=userMgr.getAuthorizable(testUser.getID());
  Authorizable group=userMgr.getAuthorizable(testGroup.getID());
  Map<Authorizable,Authorizable> sameHashCode=new HashMap<Authorizable,Authorizable>();
  sameHashCode.put(testUser,testUser);
  sameHashCode.put(testGroup,testGroup);
  sameHashCode.put(user,user);
  sameHashCode.put(group,group);
  sameHashCode.put(testUser,user);
  sameHashCode.put(testGroup,group);
  for (  Map.Entry entry : sameHashCode.entrySet()) {
    assertEquals(entry.getKey().hashCode(),entry.getValue().hashCode());
  }
  UserManager otherUserManager=getUserConfiguration().getUserManager(root,getNamePathMapper());
  user=otherUserManager.getAuthorizable(testUser.getID());
  group=otherUserManager.getAuthorizable(testGroup.getID());
  Map<Authorizable,Authorizable> notSameHashCode=new HashMap<Authorizable,Authorizable>();
  notSameHashCode.put(testUser,testGroup);
  notSameHashCode.put(user,group);
  notSameHashCode.put(testUser,user);
  notSameHashCode.put(testGroup,group);
  for (  Map.Entry entry : notSameHashCode.entrySet()) {
    assertFalse(entry.getKey().hashCode() == entry.getValue().hashCode());
  }
}
