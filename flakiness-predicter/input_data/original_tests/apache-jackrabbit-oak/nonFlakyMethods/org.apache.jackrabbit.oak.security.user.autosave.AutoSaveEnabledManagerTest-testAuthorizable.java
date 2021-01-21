@Test public void testAuthorizable() throws Exception {
  User u=mgr.createUser("u","u");
  u.setProperty("prop",getValueFactory().createValue("value"));
  assertFalse(root.hasPendingChanges());
  u.setProperty("prop",new Value[]{getValueFactory().createValue(true)});
  assertFalse(root.hasPendingChanges());
  u.removeProperty("prop");
  assertFalse(root.hasPendingChanges());
}
