@Test public void shouldDetectChangeByDefault(){
  assertTrue(victim.isChanged(GROUP1_NAME));
  assertFalse(victim.isChanged(GROUP1_NAME));
}
