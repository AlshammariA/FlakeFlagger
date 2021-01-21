@Test(expected=WroRuntimeException.class) public void shouldFailCreatingModelEvenWhenFirstAttemptFailsAndAutoDetectIsDisabled() throws Exception {
  factory=createTestSmartModelFactory();
  factory.setAutoDetectWroFile(false);
  factory.create();
}
