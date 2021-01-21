@Test public void testMoveUserToOtherGroup() throws Exception {
  User user1=userMgr.createUser(createUserId(),"p");
  User user2=userMgr.createUser(createUserId(),"p");
  Group grp1=userMgr.createGroup(createGroupId());
  Group grp2=userMgr.createGroup(createGroupId());
  grp1.addMember(user1);
  grp1.addMember(user2);
  superuser.save();
  checkDeclaredMembers(grp1,user1.getID(),user2.getID());
  checkDeclaredMembers(grp2);
  checkDeclaredMemberOf(user1,grp1.getID());
  checkDeclaredMemberOf(user2,grp1.getID());
  grp1.removeMember(user1);
  superuser.save();
  checkDeclaredMembers(grp1,user2.getID());
  checkDeclaredMembers(grp2);
  checkDeclaredMemberOf(user1);
  checkDeclaredMemberOf(user2,grp1.getID());
  grp2.addMember(user1);
  superuser.save();
  checkDeclaredMembers(grp1,user2.getID());
  checkDeclaredMembers(grp2,user1.getID());
  checkDeclaredMemberOf(user1,grp2.getID());
  checkDeclaredMemberOf(user2,grp1.getID());
}
