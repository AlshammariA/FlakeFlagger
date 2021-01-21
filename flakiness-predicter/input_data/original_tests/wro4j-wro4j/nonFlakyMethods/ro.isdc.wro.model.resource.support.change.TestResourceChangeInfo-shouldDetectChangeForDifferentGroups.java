@Test public void shouldDetectChangeForDifferentGroups(){
  victim.updateHashForGroup("hash1",GROUP1_NAME);
  victim.reset();
  assertTrue(victim.isChanged(GROUP1_NAME));
  assertTrue(victim.isCheckRequiredForGroup(GROUP2_NAME));
  assertTrue(victim.isChanged(GROUP2_NAME));
}
