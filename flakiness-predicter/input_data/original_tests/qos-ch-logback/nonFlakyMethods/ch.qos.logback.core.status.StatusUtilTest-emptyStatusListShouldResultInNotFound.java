@Test public void emptyStatusListShouldResultInNotFound(){
  assertEquals(-1,statusUtil.timeOfLastReset());
}
