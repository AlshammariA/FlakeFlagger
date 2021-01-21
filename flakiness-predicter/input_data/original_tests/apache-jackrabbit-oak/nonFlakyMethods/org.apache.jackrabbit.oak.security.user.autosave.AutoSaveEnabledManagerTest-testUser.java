@Test public void testUser() throws Exception {
  User u=mgr.createUser("u","u");
  u.disable("disabled");
  assertTrue(u.isDisabled());
  assertFalse(root.hasPendingChanges());
  u.disable(null);
  assertFalse(u.isDisabled());
  assertFalse(root.hasPendingChanges());
  u.changePassword("t");
  assertFalse(root.hasPendingChanges());
  u.changePassword("tt","t");
  assertFalse(root.hasPendingChanges());
}
