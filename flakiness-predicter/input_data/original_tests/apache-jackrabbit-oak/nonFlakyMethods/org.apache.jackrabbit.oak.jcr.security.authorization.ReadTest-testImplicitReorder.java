/** 
 * @see <a href="https://issues.apache.org/jira/browse/OAK-878">OAK-878 :
     * IllegalArgumentException while adding/removing permission to user/group</a>
 */
@Test public void testImplicitReorder() throws Exception {
  allow(path,testUser.getPrincipal(),readPrivileges);
  assertEntry(0,true);
  allow(path,getTestGroup().getPrincipal(),readPrivileges);
  assertEntry(0,true);
  deny(path,testUser.getPrincipal(),readPrivileges);
  assertEntry(1,false);
  deny(path,getTestGroup().getPrincipal(),readPrivileges);
  assertEntry(0,false);
  allow(path,testUser.getPrincipal(),readPrivileges);
}
