@Test public void testEveryoneIsDeclaredMember() throws Exception {
  assertFalse(everyoneGroup.isDeclaredMember(everyoneGroup));
}
