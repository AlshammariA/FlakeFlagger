@Test public void shouldCreateValidObjectWithFactoryMethod(){
  victim=ResourceLintReport.create("path",Arrays.asList("1","2"));
  assertEquals("path",victim.getResourcePath());
  assertEquals(2,victim.getLints().size());
}
