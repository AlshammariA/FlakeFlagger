@Test public void shouldNotRequireChangeAfterHashUpdate(){
  victim.updateHashForGroup("hash",GROUP1_NAME);
  assertFalse(victim.isCheckRequiredForGroup(GROUP1_NAME));
}
