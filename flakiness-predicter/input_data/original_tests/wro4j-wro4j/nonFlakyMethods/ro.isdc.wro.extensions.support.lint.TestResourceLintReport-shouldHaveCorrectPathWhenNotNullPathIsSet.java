@Test public void shouldHaveCorrectPathWhenNotNullPathIsSet(){
  victim.setResourcePath("path");
  assertEquals("path",victim.getResourcePath());
}
