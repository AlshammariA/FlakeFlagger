@Test(expected=NullPointerException.class) public void cannotAcceptNullConfiguration(){
  final WroConfiguration config=null;
  DefaultWroManagerFactory.create(config);
}
