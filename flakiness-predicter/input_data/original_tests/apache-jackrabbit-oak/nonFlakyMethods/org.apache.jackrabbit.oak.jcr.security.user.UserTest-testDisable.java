@Test public void testDisable() throws Exception {
  String reason="readonly user is disabled!";
  user.disable(reason);
  superuser.save();
  assertTrue(user.isDisabled());
  assertEquals(reason,user.getDisabledReason());
}
