@Test public void shouldDetectChangeForUpdatedGroupsOnly(){
  victim.updateHashForGroup("hash1",GROUP1_NAME);
  victim.updateHashForGroup("hash1",GROUP2_NAME);
  victim.reset();
  assertTrue(victim.isChanged(GROUP1_NAME));
  assertTrue(victim.isChanged(GROUP2_NAME));
  victim.updateHashForGroup("hash1",GROUP1_NAME);
  victim.updateHashForGroup("hash1",GROUP2_NAME);
  assertFalse(victim.isChanged(GROUP1_NAME));
  assertFalse(victim.isChanged(GROUP2_NAME));
  assertTrue(victim.isChanged(GROUP3_NAME));
}
