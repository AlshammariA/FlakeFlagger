@Test public void shouldHaveUnknownPathWhenNullPathIsSet(){
  victim.setResourcePath(null);
  assertEquals(ResourceLintReport.UNKNOWN_PATH,victim.getResourcePath());
}
