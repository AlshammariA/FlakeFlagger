@Test public void shouldDetectChangeAfterNewHashUpdate(){
  victim.updateHashForGroup("hash1",GROUP1_NAME);
  assertTrue(victim.isChanged(GROUP1_NAME));
  victim.updateHashForGroup("hash1",GROUP2_NAME);
  assertTrue(victim.isChanged(GROUP2_NAME));
  assertTrue(victim.isChanged(GROUP1_NAME));
  assertTrue(victim.isChanged(GROUP1_NAME));
}
