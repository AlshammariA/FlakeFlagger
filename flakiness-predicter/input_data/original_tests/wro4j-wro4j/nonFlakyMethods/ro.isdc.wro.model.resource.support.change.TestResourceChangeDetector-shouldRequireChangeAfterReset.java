@Test public void shouldRequireChangeAfterReset() throws Exception {
  victim.checkChangeForGroup("resource",GROUP1_NAME);
  victim.reset();
  assertFalse(victim.checkChangeForGroup("resource",GROUP1_NAME));
  assertTrue(victim.checkChangeForGroup("resource",GROUP2_NAME));
}
