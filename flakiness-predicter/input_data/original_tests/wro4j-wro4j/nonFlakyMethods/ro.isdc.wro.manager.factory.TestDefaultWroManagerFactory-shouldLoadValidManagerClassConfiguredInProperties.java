@Test public void shouldLoadValidManagerClassConfiguredInProperties(){
  final Properties props=propsForWroManagerClassName(NoProcessorsWroManagerFactory.class.getName());
  final DefaultWroManagerFactory victim=new DefaultWroManagerFactory(props);
  assertEquals(NoProcessorsWroManagerFactory.class,victim.getFactory().getClass());
}
