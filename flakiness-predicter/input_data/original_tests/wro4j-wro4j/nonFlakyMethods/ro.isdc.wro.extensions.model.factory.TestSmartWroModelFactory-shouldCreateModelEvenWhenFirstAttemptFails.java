@Test public void shouldCreateModelEvenWhenFirstAttemptFails() throws Exception {
  factory=createTestSmartModelFactory();
  Assert.assertNotNull(factory.create());
}
