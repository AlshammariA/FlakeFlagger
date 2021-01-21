@Test public void testEnabledByDefault() throws Exception {
  assertFalse(user.isDisabled());
  assertNull(user.getDisabledReason());
}
