@Test public void shouldBeThreadSafe() throws Exception {
  genericThreadSafeTest(true);
  genericThreadSafeTest(false);
}
