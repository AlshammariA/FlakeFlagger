@Test public void testHasGroup(){
  assertFalse(victim.hasGroup("NOT_EXIST"));
  assertTrue(victim.hasGroup("g1"));
}
