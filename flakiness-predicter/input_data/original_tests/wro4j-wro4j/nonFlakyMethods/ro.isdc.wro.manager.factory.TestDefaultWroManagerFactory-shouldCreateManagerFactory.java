@Test public void shouldCreateManagerFactory(){
  final WroConfiguration config=new WroConfiguration();
  config.setWroManagerClassName(NoProcessorsWroManagerFactory.class.getName());
  victim=DefaultWroManagerFactory.create(config);
  assertEquals(NoProcessorsWroManagerFactory.class,victim.getFactory().getClass());
}
