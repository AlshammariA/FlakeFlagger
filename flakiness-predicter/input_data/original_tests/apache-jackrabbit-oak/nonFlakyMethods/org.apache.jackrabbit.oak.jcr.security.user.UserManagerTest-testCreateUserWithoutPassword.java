/** 
 * @since OAK 1.0
 */
@Test public void testCreateUserWithoutPassword() throws Exception {
  try {
    User u=userMgr.createUser(createUserId(),null);
  }
  finally {
    superuser.refresh(false);
  }
}
