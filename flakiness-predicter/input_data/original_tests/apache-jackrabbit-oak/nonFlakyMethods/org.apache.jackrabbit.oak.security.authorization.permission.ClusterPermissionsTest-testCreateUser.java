@Test public void testCreateUser() throws Exception {
  userManager1.createUser("testUser","testUser");
  root1.commit();
  syncClusterNodes();
  root2.refresh();
  assertNotNull("testUser must exist on 2nd cluster node",userManager2.getAuthorizable("testUser"));
}
