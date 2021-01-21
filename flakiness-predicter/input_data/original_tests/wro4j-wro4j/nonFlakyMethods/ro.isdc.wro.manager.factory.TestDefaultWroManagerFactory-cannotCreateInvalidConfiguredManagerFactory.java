@Test(expected=WroRuntimeException.class) public void cannotCreateInvalidConfiguredManagerFactory(){
  final WroConfiguration config=new WroConfiguration();
  config.setWroManagerClassName("invalid.class.name.ManagerFactory");
  victim=DefaultWroManagerFactory.create(config);
}
