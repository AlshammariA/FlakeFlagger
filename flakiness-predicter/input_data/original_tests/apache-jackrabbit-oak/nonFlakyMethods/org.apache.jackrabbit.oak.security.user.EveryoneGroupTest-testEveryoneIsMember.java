@Test public void testEveryoneIsMember() throws Exception {
  assertFalse(everyoneGroup.isMember(everyoneGroup));
}
